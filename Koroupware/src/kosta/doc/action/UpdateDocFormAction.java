package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.Doc;

public class UpdateDocFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int doc_no = Integer.parseInt(request.getParameter("doc_no"));
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		request.setAttribute("doc_no", doc_no);
		request.setAttribute("emp_no", emp_no);
		request.setAttribute("doc_box_no", doc_box_no);
		
		forward.setPath("doc/updateDocForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
