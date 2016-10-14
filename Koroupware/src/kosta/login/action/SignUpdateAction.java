package kosta.login.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.emp.model.Emp;
import kosta.login.service.SignUpService;

public class SignUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		Emp emp = new Emp();
		
		SignUpService service = SignUpService.getInstance();
		
		System.out.println(request.getParameter("emp_id")+request.getParameter("emp_no"));
		emp.setEmp_no(Integer.parseInt(request.getParameter("emp_no")));
		emp.setDept_no(Integer.parseInt(request.getParameter("dept_no")));
		emp.setEmp_id(request.getParameter("emp_id"));
		emp.setEmp_password(request.getParameter("emp_password"));
		emp.setEmp_name(request.getParameter("emp_name"));
		emp.setEmp_email(request.getParameter("emp_email"));
		emp.setEmp_address(request.getParameter("emp_address"));
		emp.setEmp_img(request.getParameter("emp_img"));
		emp.setEmp_elec_auth_img(request.getParameter("emp_elec_auth_img"));
		
		ActionForward forward = new ActionForward();
		
		int re = 0; 
		try {
			re = service.EmpUpdateService(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		if (re > 0) {
			forward.setRedirect(false);
			forward.setPath("main.jsp");
		}
		
		return forward;
	}

}
