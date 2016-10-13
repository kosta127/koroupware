package kosta.elecauth.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.service.Elec_authService;

public class Elec_authSubmissionAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String empNo = request.getParameter("emp_no");
		String sendDept = request.getParameter("elec_auth_send_dept_no");
		String manageDept = request.getParameter("elec_auth_management_dept_no");
		String title = request.getParameter("elec_auth_title");
		String contents = request.getParameter("elec_auth_contents");
		
		Elec_auth ea = new Elec_auth();
		
		Elec_authService service = Elec_authService.getInstance();
		//boolean res = service.insertElecAuth(ea, approvals, referrers);
		
		forward.setUrl("elec_authList.do");
		return forward;
	}

}
