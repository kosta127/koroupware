package kosta.login.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.emp.model.Emp;
import kosta.login.service.SignUpService;

public class SignUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		SignUpService service = SignUpService.getInstance();
		
		
		ActionForward forward = new ActionForward();
		
		int re = 0; 
		int re2 = 0;
		try {
			re = service.EmpUpdateService(request);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		if (re > 0) {
			forward.setRedirect(false);
			forward.setPath("main.jsp");
		}
		
		return forward;
	}

}
