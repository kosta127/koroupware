package kosta.community.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.ReplyDao;

public class DeleteReplyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		
		ReplyDao dao = ReplyDao.getInstance();
		int re = dao.DeleteReplyBoard(reply_no);
		
		request.setAttribute("board_no", board_no);
		
		forward.setRedirect(false);
		forward.setPath("board/boardDetail.do");
		
		return forward;
	}

}
