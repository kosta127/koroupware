package kosta.document.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.document.dao.DocDao;
import kosta.document.model.Doc;

public class ListDocAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		List<Doc> list = dao.listDoc();
		request.setAttribute("list",list);
		forward.setRedirect(false);
		forward.setPath("listDoc.jsp");
		return forward;
	}

}
