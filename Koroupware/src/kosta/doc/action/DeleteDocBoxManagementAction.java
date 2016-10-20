package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;

public class DeleteDocBoxManagementAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		
	
		request.setAttribute("doc_box_no", doc_box_no);
		request.setAttribute("emp_no", emp_no);
		int re1 = dao.deleteDoc_box_management(doc_box_no);
		int re2 = dao.deleteDoc_box(doc_box_no);
		if(re1 > 0){
			if(re2 > 0){
				forward.setPath("listDoc_box.do");
				forward.setRedirect(false);
			}
		}
		
		return forward;
	}

}
