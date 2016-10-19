package kosta.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;

public class TelAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("");
		forward.setRedirect(false);
		return forward;
	}

}
