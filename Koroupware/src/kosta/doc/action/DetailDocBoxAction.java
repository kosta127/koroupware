package kosta.doc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.Doc;
import kosta.doc.model.DocBox;

public class DetailDocBoxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		if(request.getParameter("doc_no")!=null){
			int doc_no = Integer.parseInt(request.getParameter("doc_no"));
			request.setAttribute("doc_no", doc_no);
			
		}
		
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		DocBox doc_box = dao.selectDoc_box(doc_box_no);
		List<Doc> list = dao.detailDoc_box(doc_box_no);
		request.setAttribute("list", list);
		request.setAttribute("doc_box_no",doc_box_no);
		request.setAttribute("emp_no",emp_no);
		request.setAttribute("doc_box", doc_box);
		forward.setRedirect(false);
		forward.setPath("doc/detailDoc_box.jsp");
		return forward;
	}

}
