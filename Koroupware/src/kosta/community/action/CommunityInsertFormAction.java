package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;

public class CommunityInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		
		forward.setRedirect(false);
		forward.setPath("community/communityInsertForm.jsp");
		
		return forward;
	}

}
