package kosta.document.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.document.dao.DocDao;
import kosta.document.model.Doc;

public class DetailDocBoxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		Doc document = new Doc();
		document = dao.detailDoc(Integer.parseInt(request.getParameter("doc_no")));
		request.setAttribute("document", document);
		
		forward.setRedirect(false);
		forward.setPath("detailDoc.jsp");
		return forward;
	}

}
