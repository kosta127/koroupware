package kosta.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.login.service.SignUpService;

public class TelDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		int tel_no = Integer.parseInt(request.getParameter("tel_no"));
		System.out.println(tel_no);
		SignUpService service = SignUpService.getInstance();
		service.TelDeleteService(tel_no);
		
		ActionForward forward = new ActionForward();
		forward.setPath("signUpdateForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
