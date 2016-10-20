package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Community;
import kosta.community.model.CommunityDao;
import kosta.emp.model.Emp;

public class CommunityInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		Community community = new Community();
		CommunityDao dao = CommunityDao.getInstance();
		
		Emp emp = (Emp)session.getAttribute("emp");
		int emp_no = emp.getEmp_no();
		
		community.setCommunity_name(request.getParameter("community_name"));
		community.setEmp_no(emp_no);
		int re= dao.insertCommunity(community);
		
		
		request.setAttribute("emp_no", emp_no);
		forward.setRedirect(false);
		forward.setPath("main.do");
		
		
		return forward;
	}

}
