package kosta.login.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.SystemUtils;

import kosta.emp.model.Emp;
import kosta.login.dao.LoginDao;
import kosta.login.service.LoginService;


public class FindPasswordProcess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		LoginService service = LoginService.getInstance();
		List<Emp> list = service.FindPassword_ListEmpService();
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("find_no"));
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_id().equals(request.getParameter("find_id")) 
					&& list.get(i).getEmp_no()== num){
				session.setAttribute("find_password", list.get(i).getEmp_password());
				forward.setPath("FindPasswordResult.jsp");
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
