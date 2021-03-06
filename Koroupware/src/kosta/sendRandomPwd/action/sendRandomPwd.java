package kosta.sendRandomPwd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.emp.model.Emp;
import kosta.login.service.LoginService;
import kosta.sendRandomPwd.service.sendRandomPwdService;

public class sendRandomPwd implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String new_pwd = request.getParameter("pwd");
		ActionForward forward = new ActionForward();
		sendRandomPwdService pwdservice = sendRandomPwdService.getInstance();
		LoginService service = LoginService.getInstance();
		HttpSession session = request.getSession();
		String find_residentnumber = (String)session.getAttribute("find_residentnumber"); 

		List<Emp> list = service.FindPassword_ListEmpService();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmp_residentnumber().equals(find_residentnumber)){
			System.out.println(find_residentnumber);
			System.out.println(new_pwd);
			
				
				list.get(i).setEmp_residentnumber(find_residentnumber);
				list.get(i).setEmp_password(new_pwd);
				pwdservice.SessionPwdService(list.get(i)); // 이렇게하면 emp객체 형식
				forward.setPath("FindPasswordResult.jsp");
				forward.setRedirect(false);
				break;
			}

			

		}
		return forward;

	}
}