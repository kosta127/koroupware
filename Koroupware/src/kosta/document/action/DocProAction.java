package kosta.document.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.document.dao.DocDao;
import kosta.document.model.Doc;

public class DocProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		Doc document = new Doc();
		
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		Date date= null;
		try {
			date = format.parse(request.getParameter("doc_con_period"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		document.setDoc_no(dao.selectDoc_no()+1);
		document.setDoc_con_period(date);
		document.setDoc_title(request.getParameter("doc_title"));
		document.setDoc_explain(request.getParameter("doc_explain"));
		document.setDoc_content(request.getParameter("doc_content"));
		
		
		int re = dao.insertDoc(document);
		if(re > 0) {
			forward.setRedirect(true);
			forward.setPath("listDoc.do");
		}else {
			forward.setRedirect(true);
			forward.setPath("docForm.do");
		}
		
		
		
		return forward;
	}

}
