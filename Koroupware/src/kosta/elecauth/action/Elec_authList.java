package kosta.elecauth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.elecauth.dao.Elec_authDao;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.service.Elec_authService;

public class Elec_authList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward();
		
		Elec_authService service=Elec_authService.getInstance();
		List<Elec_auth> elec_authList=service.elec_authList();
		
		if(elec_authList != null){
			request.setAttribute("elec_authList", elec_authList);
			forward.setRedirect(false);
			forward.setUrl("/elec_auth_jdbc/elec_auth_main.jsp");
		}else{
			forward.setRedirect(true);
			forward.setUrl("error.do");
		}
		return forward;
	}

	
	

}
