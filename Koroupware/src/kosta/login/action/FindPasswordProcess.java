package kosta.login.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.emp.model.Emp;
import kosta.login.service.LoginService;



public class FindPasswordProcess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		LoginService service = LoginService.getInstance();
		List<Emp> list = service.FindPassword_ListEmpService();
		HttpSession session = request.getSession();
		String residentnumber = request.getParameter("find_RESIDENTNUMBER");
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_id().equals(request.getParameter("find_id")) 
					&& list.get(i).getEmp_residentnumber().equals(residentnumber)){
				session.setAttribute("find_residentnumber", list.get(i).getEmp_residentnumber());
				session.setAttribute("sendemail_to", list.get(i).getEmp_email());
				forward.setPath("sendRandomPwdMail.do");
				forward.setRedirect(false);
				break;
			}else{
				forward.setPath("FindAction.jsp");
				forward.setRedirect(false);
			}
		}
		
		
		return forward;
	}

}
