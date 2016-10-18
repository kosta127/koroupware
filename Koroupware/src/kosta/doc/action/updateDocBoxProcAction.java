package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.DocBox;

public class updateDocBoxProcAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		DocBox doc_box = dao.selectDoc_box(doc_box_no);
		doc_box.setDoc_box_name(request.getParameter("doc_box_name"));
		
		request.setAttribute("emp_no", emp_no);
		request.setAttribute("doc_box_no", doc_box_no);
		int re = dao.updateDoc_box_name(doc_box);
		if(re>0){
			forward.setRedirect(false);
			forward.setPath("listDoc_box.do");
		}
		return forward;
	}

}
