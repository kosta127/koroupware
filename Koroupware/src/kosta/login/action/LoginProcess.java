package kosta.login.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.login.dao.MemberDao;
import kosta.login.model.Member;

public class LoginProcess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MemberDao dao = MemberDao.getInstance();
		Member member = new Member(); 
		List<Member> list = dao.ListMember();
		
		HttpSession session = request.getSession();
		
		
		// 1 세렉트 전체 문
		// 2. 거기에서 
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_id().equals(request.getParameter("emp_id"))
					&&list.get(i).getEmp_password().equals(request.getParameter("emp_password"))){
				
				String id =request.getParameter("emp_id");
				
				session.setAttribute("emp_id", id);
				System.out.println("성공");
				forward.setPath("main.jsp");
				forward.setRedirect(false);
				break;
			}else{
				System.out.println("실패");
				forward.setPath("login.jsp");
				forward.setRedirect(false);
			}
		}
		

		return forward;
	}

}
