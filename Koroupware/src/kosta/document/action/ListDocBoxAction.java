package kosta.document.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.document.dao.DocDao;
import kosta.document.model.DocBox;

public class ListDocBoxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		List<DocBox> list = dao.listDoc_box();
		request.setAttribute("list", list);
		forward.setRedirect(false);
		forward.setPath("listDoc_box.jsp");
		
		return forward;
	}

}
