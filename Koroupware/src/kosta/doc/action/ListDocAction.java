package kosta.doc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.Doc;
import kosta.emp.model.Emp;

public class ListDocAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		HttpSession session = request.getSession();
		Emp emp = (Emp)session.getAttribute("emp");
		
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		int emp_no = emp.getEmp_no();
		
		List<Doc> list = dao.listDoc();
		
		request.setAttribute("list",list);
		request.setAttribute("doc_box_no", doc_box_no);
		request.setAttribute("emp_no", emp_no);
		
		forward.setRedirect(false);
		forward.setPath("doc/listDoc.jsp");
		
		return forward;
	}

}
