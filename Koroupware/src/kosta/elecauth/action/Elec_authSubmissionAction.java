package kosta.elecauth.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Elec_authSubmissionAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String empNo = request.getParameter("emp_no");
		String sendDept = request.getParameter("elec_auth_send_dept_no");
		String manageDept = request.getParameter("elec_auth_management_dept_no");
		String title = request.getParameter("elec_auth_title");
		String contents = request.getParameter("elec_auth_contents");
		
		
		forward.setUrl("elec_authList.do");
		return forward;
	}

}
