package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.DocManagement;

public class DeleteDocManagementAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int doc_no = Integer.parseInt(request.getParameter("doc_no"));
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		
		request.setAttribute("doc_no", doc_no);
		request.setAttribute("doc_box_no", doc_box_no);
		request.setAttribute("emp_no", emp_no);
		DocManagement doc_management = new DocManagement();
		doc_management.setDoc_box_no(doc_box_no);
		doc_management.setDoc_no(doc_no);
		System.out.println(doc_management.getDoc_box_no());
		System.out.println(doc_management.getDoc_box_no());
		int re = dao.deleteDoc_management(doc_management);
	
		if(re > 0){
				forward.setPath("detailDoc_box.do");
				forward.setRedirect(false);
		}else {
			forward.setRedirect(false);
			forward.setPath("fail.jsp");
		}
		return forward;
	}

}
