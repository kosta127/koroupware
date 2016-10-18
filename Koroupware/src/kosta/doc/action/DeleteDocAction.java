package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.doc.dao.DocDao;

public class DeleteDocAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int doc_no = Integer.parseInt(request.getParameter("doc_no"));
		
		
		return forward;
	}

}
