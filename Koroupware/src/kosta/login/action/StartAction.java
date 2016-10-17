package kosta.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;

public class StartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/signUp/signUpForm.jsp");
		
		return forward;
	}

}
