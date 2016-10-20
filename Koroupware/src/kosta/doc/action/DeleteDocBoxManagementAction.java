package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.emp.model.Emp;

public class DeleteDocBoxManagementAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		HttpSession session = request.getSession();
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		
		Emp emp = (Emp)session.getAttribute("emp");
		int emp_no = emp.getEmp_no();
		
	
		request.setAttribute("doc_box_no", doc_box_no);
		request.setAttribute("emp_no", emp_no);
		int re1 = dao.deleteDoc_box_management(doc_box_no);
		int re2 = dao.deleteDoc_box(doc_box_no);
		
		forward.setRedirect(false);
		forward.setPath("listDoc_box.do");
		
	
			
		return forward;
	}

}
