package kosta.doc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.DocBox;
import kosta.emp.model.Emp;


public class ListDocBoxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		HttpSession session = request.getSession();
		
		Emp emp = (Emp)session.getAttribute("emp");
		System.out.println(emp);
		int emp_no = emp.getEmp_no();
		
		List<DocBox> list = dao.listDoc_box(emp_no);
		request.setAttribute("list", list);
		request.setAttribute("emp_no",emp_no);
		forward.setRedirect(false);
		forward.setPath("doc/listDoc_box.jsp");
		
		return forward;
	}

}
