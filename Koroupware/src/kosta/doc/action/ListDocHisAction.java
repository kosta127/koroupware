package kosta.doc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.DocHis;

public class ListDocHisAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		request.setAttribute("emp_no",emp_no);
		request.setAttribute("doc_box_no", doc_box_no);
		List<DocHis> list = dao.listDocHis();
		request.setAttribute("list", list);
		forward.setPath("doc/listDoc_his.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
