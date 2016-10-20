package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;

public class CategoryInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int community_no = Integer.parseInt(request.getParameter("community_no"));
		request.setAttribute("community_no", community_no);
		
		forward.setRedirect(false);
		forward.setPath("category/categoryInsertForm.jsp");
		
		return forward;
	}

}
