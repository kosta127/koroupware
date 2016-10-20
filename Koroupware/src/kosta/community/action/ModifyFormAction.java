package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;



public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int category_no = Integer.parseInt(request.getParameter("category_no"));
		
		request.setAttribute("board_no", board_no);
		request.setAttribute("category_no", category_no);
		
		forward.setRedirect(false);
		forward.setPath("board/modifyForm.jsp");
		
		return forward;
	}

}
