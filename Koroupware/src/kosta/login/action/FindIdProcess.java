package kosta.login.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.emp.model.Emp;
import kosta.login.service.LoginService;



public class FindIdProcess implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		LoginService service = LoginService.getInstance();
		List<Emp> list = service.FindId_ListEmpService();
		String RESIDENTNUMBER = request.getParameter("find_RESIDENTNUMBER");
		System.out.println(RESIDENTNUMBER);
		HttpSession session = request.getSession();
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_residentnumber().equals(RESIDENTNUMBER)){
				System.out.println(list.get(i).getEmp_id());
				session.setAttribute("find_id", list.get(i).getEmp_id());
				forward.setPath("FindIdResult.jsp");
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
