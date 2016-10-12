package kosta.message.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.etc.ETC;
import kosta.message.dao.MessageDao;
import kosta.message.model.Message;

public class MessageSendAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MessageDao dao = MessageDao.getInstance();
		
		String messageContents = request.getParameter("messageContents");
		
		Message message = new Message();
		message.setMessage_contents(messageContents);
		message.setMessage_sender_no(1);	//로그인 한 사람 (보내는 사람)
		message.setMessage_receiver_no(2);	//받는 사람
		
		int result = dao.insertMessage(message);
		
		if(ETC.isCommit(result)){
			forward.setPath("messagePage.do");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
