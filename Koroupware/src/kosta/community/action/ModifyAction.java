package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Board;
import kosta.community.model.BoardDao;

public class ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		BoardDao dao = BoardDao.getInstance();
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int category_no = Integer.parseInt(request.getParameter("category_no"));
		request.setAttribute("category_no", category_no);
		
		Board board = dao.detailBoard(board_no);
		board.setBoard_title(request.getParameter("board_title"));
		board.setBoard_contents(request.getParameter("board_contents"));
		
		int result = dao.ModifyBoard(board);
		
		if(result == 1){
			forward.setRedirect(false);
			forward.setPath("listBoard.do");
		}else{
			forward.setRedirect(true);
			forward.setPath("board/modifyForm.jsp");
		}
		return forward;
	}

}
