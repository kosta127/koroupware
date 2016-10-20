package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.dao.DocDao;
import kosta.doc.model.DocHis;

public class InsertDocHisProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		int doc_no = Integer.parseInt(request.getParameter("doc_no"));
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		request.setAttribute("doc_no", doc_no);
		request.setAttribute("emp_no", emp_no);
		request.setAttribute("doc_box_no", doc_box_no);
		DocHis doc_his = new DocHis();
		doc_his.setEmp_no(emp_no);
		doc_his.setDoc_no(doc_no);
		doc_his.setDoc_his_reason_change(request.getParameter("doc_his_reason_change"));
		doc_his.setDoc_his_revise(request.getParameter("doc_his_revise"));
		System.out.println(doc_his);
		int re = dao.insertDoc_his(doc_his);
		if(re > 0){
			forward.setPath("listDoc.do");
			forward.setRedirect(false);
		}else {
			forward.setRedirect(false);
			forward.setPath("fail.jsp");
		}
		return forward;
	}

}
