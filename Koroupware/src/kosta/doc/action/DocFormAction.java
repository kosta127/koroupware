package kosta.doc.action;

import java.io.IOException;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.emp.model.Emp;

public class DocFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int doc_box_no = Integer.parseInt(request.getParameter("doc_box_no"));
		request.setAttribute("doc_box_no", doc_box_no);
		
		forward.setRedirect(false);
		forward.setPath("doc/docForm.jsp");
		
		return forward;
	}

}
