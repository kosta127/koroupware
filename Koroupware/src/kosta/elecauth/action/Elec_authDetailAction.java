package kosta.elecauth.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.service.Elec_authService;

public class Elec_authDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		Boolean isOk = false;
		String elec_no=request.getParameter("elec_auth_no");
		if(elec_no!=null){
			int elec_auth_no=Integer.parseInt(elec_no);
			Elec_authService service=Elec_authService.getInstance();
			Elec_auth elec_auth=service.elec_authDetail(elec_auth_no);
			
			request.setAttribute("elec_authDetail", elec_auth);
			forward.setRedirect(false);
			forward.setUrl("/elec_auth/elec_auth_detail.jsp");
			isOk=true;
		}
		if(!isOk){
			forward.setRedirect(false);
			forward.setUrl("error.do");
		}
		return forward;
	}

}
