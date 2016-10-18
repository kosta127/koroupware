package kosta.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.doc.dao.DocDao;

public class DeleteDocBoxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		
	
		request.setAttribute("doc_box_no", doc_box_no);
		request.setAttribute("emp_no", emp_no);
		int re1 = dao.deleteDoc_management(doc_box_no);
		int re2 = dao.deleteDoc_box(doc_box_no);
		if(re1 > 0){
			System.out.println("1");
			if(re2 > 0){
				System.out.println("2");
				forward.setPath("listDoc_box.do");
				forward.setRedirect(false);
			}
		}
		
		return forward;
	}

}
