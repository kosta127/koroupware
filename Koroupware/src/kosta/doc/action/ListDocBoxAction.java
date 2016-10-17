package kosta.doc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.doc.dao.DocDao;
import kosta.doc.model.DocBox;


public class ListDocBoxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		
		List<DocBox> list = dao.listDoc_box(emp_no);
		request.setAttribute("list", list);
		request.setAttribute("emp_no",emp_no);
		forward.setRedirect(false);
		forward.setPath("listDoc_box.jsp");
		
		return forward;
	}

}
