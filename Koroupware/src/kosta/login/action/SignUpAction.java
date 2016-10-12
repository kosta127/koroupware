package kosta.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;
import kosta.login.service.SignUpService;

public class SignUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		Emp emp = new Emp();
		Tel tel = new Tel();
		System.out.println("여긴되냐");
	
		SignUpService service = SignUpService.getInstance();
		emp.setEmp_id(request.getParameter("emp_id"));
		emp.setEmp_password(request.getParameter("emp_password"));
		emp.setEmp_name(request.getParameter("emp_name"));
		emp.setEmp_residentnumber(request.getParameter("emp_residentnumber"));
		emp.setEmp_email(request.getParameter("emp_email"));
		emp.setEmp_address(request.getParameter("emp_address"));
		emp.setEmp_img(request.getParameter("emp_img"));
		emp.setEmp_elec_auth_img(request.getParameter("emp_elec_auth_img"));
		int re = service.NewSignUpService(emp);
		
		ActionForward forward = new ActionForward();
		if(re == 1){
		forward.setRedirect(true);
		forward.setPath("/signUp/main.jsp");
		}else{
		forward.setRedirect(true);
		forward.setPath("/signUp/signUpForm.jsp");	
		}
		return forward;
	}

}
