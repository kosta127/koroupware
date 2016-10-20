package kosta.menu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Community;
import kosta.community.model.CommunityDao;
import kosta.emp.model.Emp;
import net.sf.json.JSONArray;

public class CommunityListAsJSON implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		CommunityDao dao = CommunityDao.getInstance();
		Emp emp = (Emp)session.getAttribute("emp");
		int emp_no = emp.getEmp_no();
		
		List<Community> communityList = dao.listCommunity(emp_no);		
		if(communityList != null){
			String jsonStr = JSONArray.fromObject(communityList).toString();
			request.setAttribute("communityListAsJSON", jsonStr);
			
			
			forward.setRedirect(false);
			forward.setPath("communityListAsJSON.jsp");
		}else{
			forward.setRedirect(true);
			forward.setPath("insertCommunityForm.do");
		}
		return forward;
	}

}
