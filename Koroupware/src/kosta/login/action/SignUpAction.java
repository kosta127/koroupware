package kosta.login.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.emp.model.Emp;
import kosta.emp.model.Tel;
import kosta.login.model.ImageUtil;
import kosta.login.service.SignUpService;

public class SignUpAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		Tel tel = new Tel();
	
		SignUpService service = SignUpService.getInstance();
		System.out.println("dd");
		
		
		
		ActionForward forward = new ActionForward();
		System.out.println("gg");
		int re = 0; 
		int re2 = 0;
		try {
			System.out.println("gg");
			re = service.NewSignUpService(request);
			re2 = service.TelInsertService(tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		if (re > 0 && re2 > 0) {
			forward.setRedirect(false);
			forward.setPath("/signUp/success.jsp");
		} else {
			forward.setRedirect(false);
			forward.setPath("/signUp/signUpForm.jsp");
		}
		return forward;
	}

}
