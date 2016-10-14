package kosta.elecauth.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Elec_authWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setUrl("/elec_auth/elec_auth_write.jsp");
		return forward;
	}

}
