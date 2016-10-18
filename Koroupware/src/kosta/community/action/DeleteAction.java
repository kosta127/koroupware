package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.BoardDao;

public class DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		BoardDao dao = BoardDao.getInstance();
		int re = dao.DeleteBoard(board_no);
		
		request.setAttribute("board_no", board_no);
		
		forward.setRedirect(false);
		forward.setPath("board/listBoard.do");
		
		
		return forward;
	}

}
