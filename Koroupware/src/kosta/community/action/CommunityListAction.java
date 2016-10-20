package kosta.community.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Community;
import kosta.community.model.CommunityDao;
import kosta.emp.model.Emp;

public class CommunityListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		
		CommunityDao dao = CommunityDao.getInstance();
		
		Emp emp = (Emp)session.getAttribute("emp");
		
		int emp_no = emp.getEmp_no();
	
		List<Community> communityList = dao.listCommunity(emp_no);
		request.setAttribute("emp_no", emp_no);
		request.setAttribute("communityList", communityList);
		
		
		if(communityList != null){
			forward.setRedirect(false);
			forward.setPath("main.jsp");
		}else{
			forward.setRedirect(true);
			forward.setPath("insertCommunityForm.do");
		}
		return forward;
	}

}
