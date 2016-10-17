package kosta.mail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.login.action.Action;
import kosta.login.action.ActionForward;
import kosta.sendRandomPwd.action.sendRandomPwd;


@WebServlet("*.mail")
public class sendMailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String requestURI = request.getRequestURI();		
	
	String contextPath = request.getContextPath();
	String command = requestURI.substring(contextPath.length()+1);
	
	
	ActionForward forward = null;
	Action action = null;
	
	if(command.equals("sendRandomPwd.mail")){
		HttpSession session = request.getSession();	
		System.out.println(session.getAttribute("find_no"));
		action = new sendRandomPwd();
		forward = action.execute(request, response);
	}
	
	if(forward != null){
		if(forward.isRedirect()){
			response.sendRedirect(forward.getPath());
		}else{
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
