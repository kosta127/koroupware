package kosta.doc.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.Doc;

public class UpdateDocProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int doc_no = Integer.parseInt(request.getParameter("doc_no"));
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		System.out.println(doc_no);
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		Date date= null;
		try {
			date = format.parse(request.getParameter("doc_con_period"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		request.setAttribute("doc_no", doc_no);
		request.setAttribute("emp_no", emp_no);
		request.setAttribute("doc_box_no", doc_box_no);
		Doc doc = dao.detailDoc(doc_no);
		doc.setDoc_no(doc_no);
		doc.setDoc_title(request.getParameter("doc_title"));
		doc.setDoc_con_period(date);
		doc.setDoc_explain(request.getParameter("doc_explain"));
		doc.setDoc_contents(request.getParameter("doc_contents"));
		doc.setDoc_formYN(request.getParameter("doc_formYN"));
		System.out.println(doc);
		int re = dao.updateDoc(doc);
		if(re>0){
			forward.setPath("doc/insertDoc_hisForm.jsp");
			forward.setRedirect(false);
		}else {
			forward.setRedirect(false);
			forward.setPath("fail.jsp");
		}
		return forward;
	}

}
