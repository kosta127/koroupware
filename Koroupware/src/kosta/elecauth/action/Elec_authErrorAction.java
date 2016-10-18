package kosta.elecauth.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;

public class Elec_authErrorAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath("/elec_auth/elec_auth_error.jsp");
		return forward;
	}

}
