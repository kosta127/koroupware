package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.DocManagement;
import kosta.emp.model.Emp;

public class InsertDocManagementAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		DocManagement docmanagement = new DocManagement();
		HttpSession session = request.getSession();
		Emp emp = (Emp)session.getAttribute("emp");
		
		docmanagement.setDoc_management_no(dao.selectDoc_management_no()+1);
		docmanagement.setDoc_box_no(Integer.parseInt(request.getParameter("doc_box_no")));
		docmanagement.setDoc_no(Integer.parseInt(request.getParameter("doc_no")));
		int emp_no = emp.getEmp_no();
		
		int re = dao.insertDoc_management(docmanagement);
		if(re > 0){
			request.setAttribute("emp_no", emp_no);
			forward.setRedirect(false);
			forward.setPath("detailDoc_box.do");
		}else {
			forward.setRedirect(false);
			forward.setPath("fail.jsp");
		}
		
		return forward;
	}

}
