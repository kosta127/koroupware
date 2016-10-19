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
		System.out.println(4);
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		
		CommunityDao dao = CommunityDao.getInstance();
		
		Emp emp = (Emp)session.getAttribute("emp");
		int emp_no = emp.getEmp_no();
		System.out.println(emp_no);
		System.out.println(1);
		List<Community> communityList = dao.listCommunity(emp_no);
		request.setAttribute("communityList", communityList);
		
		
		if(communityList != null){
			System.out.println(2);
			request.setAttribute("emp_no", emp_no);
			forward.setRedirect(false);
			forward.setPath("community/communityList.jsp");
		}else{
			System.out.println(3);
			forward.setRedirect(true);
			forward.setPath("community/communityInsertForm.jsp");
		}
		return forward;
	}

}
