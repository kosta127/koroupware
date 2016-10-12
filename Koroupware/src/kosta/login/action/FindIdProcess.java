package kosta.login.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.login.dao.MemberDao;
import kosta.login.model.Member;

public class FindIdProcess implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MemberDao dao = MemberDao.getInstance();
		List<Member> list = dao.FindId_ListMember();
		int num = Integer.parseInt(request.getParameter("find_no"));
		
		HttpSession session = request.getSession();
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_no().equals(request.getParameter("find_no"))){
				session.setAttribute("find_id", list.get(i).getEmp_id());
				forward.setPath("FindIdResult.jsp");
			}
		}
		
		return forward;
	}

}
