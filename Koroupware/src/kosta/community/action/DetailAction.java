package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.community.model.Board;
import kosta.community.model.BoardDao;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		BoardDao dao = BoardDao.getInstance();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		Board board = dao.detailBoard(board_no);
		request.setAttribute("board", board);
		ActionForward forward = new ActionForward();
		
		if(board != null){
			forward.setRedirect(false);
			forward.setPath("detailForm.jsp");
		}else{
			forward.setRedirect(true);
			forward.setPath("list.jsp");
		}
		return forward;
	}

}
