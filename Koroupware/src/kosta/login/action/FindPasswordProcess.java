package kosta.login.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.SystemUtils;

import kosta.login.dao.MemberDao;
import kosta.login.model.Member;

public class FindPasswordProcess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MemberDao dao = MemberDao.getInstance();
		List<Member> list = dao.FindPassword_ListMember();
		HttpSession session = request.getSession();
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_id().equals(request.getParameter("find_id")) 
					&& list.get(i).getEmp_no().equals(request.getParameter("find_no"))){
				session.setAttribute("find_password", list.get(i).getEmp_password());
				forward.setPath("FindPasswordResult.jsp");
				forward.setRedirect(false);
			}else{
				System.out.println("실패");
			}
		}
		
		
		return forward;
	}

}
