package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DocBoxFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		
		request.setAttribute("emp_no",request.getParameter("emp_no"));
		forward.setRedirect(false);
		forward.setPath("doc_boxForm.jsp");
		return forward;
	}

}
