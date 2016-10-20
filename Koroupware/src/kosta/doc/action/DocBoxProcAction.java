package kosta.doc.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.DocBox;
import kosta.emp.model.Emp;

public class DocBoxProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		
		HttpSession session = request.getSession();
		Emp emp = (Emp)session.getAttribute("emp");
		int emp_no = emp.getEmp_no();
		
		DocBox doc = new DocBox();
		
		doc.setDoc_box_no(dao.selectDoc_box_no()+1);
		doc.setDoc_box_name(request.getParameter("doc_box_name"));
		doc.setEmp_no(emp_no);

		int re = dao.insertDoc_box(doc);
		if(re > 0){
			forward.setRedirect(false);
			forward.setPath("listDoc_box.do");
		}else {
			forward.setRedirect(true);
			forward.setPath("Doc_boxForm.do");
		}
		return forward;
	}

}
