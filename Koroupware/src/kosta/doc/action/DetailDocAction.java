package kosta.doc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.Doc;
import kosta.doc.model.DocBox;
import kosta.doc.model.DocFile;

public class DetailDocAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		int doc_no = Integer.parseInt(request.getParameter("doc_no"));
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		DocBox doc_box = dao.selectDoc_box(doc_box_no);
		List<DocFile> list = dao.selectDoc_file(doc_no);
		Doc doc = dao.detailDoc(doc_no);
		String emp_name = dao.selectEmp_name(emp_no);
		request.setAttribute("doc", doc);
		request.setAttribute("list", list);
		request.setAttribute("emp_name", emp_name);
		request.setAttribute("doc_box", doc_box);
		request.setAttribute("doc_box_no", doc_box_no);
		request.setAttribute("emp_no", emp_no);
		request.setAttribute("doc_no", doc_no);
		forward.setRedirect(false);
		forward.setPath("doc/detailDoc.jsp");
		return forward;
	}

}
