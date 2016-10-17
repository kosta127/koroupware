package kosta.community.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.BoardDao;

public class HitAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getInstance();
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int re = dao.updateHit(board_no);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("board/detailForm.jsp");
		return forward;
	}

}
