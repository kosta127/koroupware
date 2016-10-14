package kosta.elecauth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.elecauth.model.EmpDetail;
import kosta.elecauth.service.Elec_authService;

public class EmpSearchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		Elec_authService service = Elec_authService.getInstance();
		List<EmpDetail> empList = service.searchEmp(request.getParameter("searchKeyword"));
		
		forward.setRedirect(false);
		forward.setUrl("/elec_auth/");
		return forward;
	}

}
