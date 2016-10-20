package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;


public class InsertFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int category_no = Integer.parseInt(request.getParameter("category_no"));
		request.setAttribute("category_no", category_no);
		
		forward.setRedirect(false);
		forward.setPath("board/insertForm.jsp");
		
		return forward;
	}

}
