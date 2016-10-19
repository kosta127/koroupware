package kosta.doc.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kosta.action.Action;
import kosta.action.ActionForward;

public class DocFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		request.setAttribute("emp_no", emp_no);
		request.setAttribute("doc_box_no", doc_box_no);
		
		forward.setPath("doc/DocForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
