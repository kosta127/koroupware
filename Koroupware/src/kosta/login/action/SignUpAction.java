package kosta.login.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;
import kosta.login.service.SignUpService;

public class SignUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		Emp emp = new Emp();
		Tel tel = new Tel();
	
		SignUpService service = SignUpService.getInstance();
		emp.setEmp_id(request.getParameter("emp_id"));
		emp.setEmp_password(request.getParameter("emp_password"));
		emp.setEmp_name(request.getParameter("emp_name"));
		emp.setEmp_residentnumber(request.getParameter("emp_residentnumber"));
		emp.setEmp_email(request.getParameter("emp_email"));
		emp.setEmp_address(request.getParameter("emp_address"));
		emp.setEmp_img(request.getParameter("emp_img"));
		emp.setEmp_elec_auth_img(request.getParameter("emp_elec_auth_img"));
		tel.setTel_type(request.getParameter("tel_type"));
		tel.setTel_telephone(request.getParameter("tel_telephone"));
		ActionForward forward = new ActionForward();
		
		int re = 0; 
		int re2 = 0;
		try {
			
			re = service.NewSignUpService(emp);
			re2 = service.TelInsertService(tel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (re > 0 && re2 > 0) {
			forward.setRedirect(false);
			forward.setPath("/signUp/success.jsp");
		} else {
			forward.setRedirect(false);
			forward.setPath("/signUp/signUpForm.jsp");
		}
		return forward;
	}

}
