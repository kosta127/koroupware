package kosta.message.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		forward.setPath("/fail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
