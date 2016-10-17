package kosta.community.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.community.model.Reply;
import kosta.community.model.ReplyDao;

public class ReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Reply reply = new Reply();
		ReplyDao dao = ReplyDao.getInstance();
		
		reply.setReply_contents(request.getParameter("reply_contents"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		reply.setBoard_no(board_no);
		reply.setEmp_no(1);	//임시 (로그인 데이터)
		
		int re = dao.insertReply(reply);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("boardDetail.do");
		
		return forward;
	}

}
