package kosta.document.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.document.dao.DocDao;
import kosta.document.model.DocBox;

public class DocBoxProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		DocBox documentbox = new DocBox();
		
		documentbox.setDoc_box_no(dao.selectDoc_box_no()+1);
		documentbox.setDoc_box_name(request.getParameter("doc_box_name"));
		int re = dao.insertDoc_box(documentbox);
		if(re > 0){
			forward.setRedirect(true);
			forward.setPath("listDoc_box.do");
		}else {
			forward.setRedirect(true);
			forward.setPath("doc_boxForm.do");
		}
		return forward;
	}

}
