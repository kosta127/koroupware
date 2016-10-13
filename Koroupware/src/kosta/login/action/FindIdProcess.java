package kosta.login.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.emp.model.Emp;
import kosta.login.dao.LoginDao;
import kosta.login.model.Member;

public class FindIdProcess implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		LoginDao dao = LoginDao.getInstance();
		List<Emp> list = dao.FindId_ListEmp();
		int num = Integer.parseInt(request.getParameter("find_no"));
		System.out.println(num);
		HttpSession session = request.getSession();
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_no()== num){
				System.out.println("성공");
				System.out.println(list.get(i).getEmp_id());
				session.setAttribute("find_id", list.get(i).getEmp_id());
				forward.setPath("FindIdResult.jsp");
				forward.setRedirect(false);
				break;
			}else{
				System.out.println("실패");
				forward.setPath("FindAction.jsp");
				forward.setRedirect(false);
			} 
		}
		
		return forward;
	}

}
