package kosta.login.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;
import kosta.login.service.SignUpService;
import kosta.login.service.SignUpdateService;

public class SignUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		Tel tel = new Tel();
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		SignUpService service = SignUpService.getInstance();
		System.out.println("서비스 성공");
		
		ActionForward forward = new ActionForward();
		System.out.println("액션 포워드 성공");
		int re = 0; 
		int re2 = 0;
		try {
			System.out.println("성공");
			re = service.EmpUpdateService(request);
			re2 = service.TelInsertService(tel);
			System.out.println("정보수정");
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		if (re > 0 && re2 > 0) {
			forward.setRedirect(false);
			forward.setPath("main.jsp");
		}
		
		return forward;
	}

}
