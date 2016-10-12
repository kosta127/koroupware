package kosta.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kosta.login.action.Action;
import kosta.login.action.ActionForward;
import kosta.login.action.FindIdProcess;
import kosta.login.action.FindPasswordProcess;
import kosta.login.action.LoginProcess;



@WebServlet("*.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String requestURI = request.getRequestURI();		
	
	String contextPath = request.getContextPath();
	String command = requestURI.substring(contextPath.length()+1);
	
	
	ActionForward forward = null;
	Action action = null;
	
	if(command.equals("LoginProcessAction.do")){
		action = new LoginProcess();
		forward = action.execute(request, response);
	}else if(command.equals("FindIdProcess.do")){
		action = new FindIdProcess();
		forward = action.execute(request, response);
	}else if(command.equals("FindPasswordProcess.do")){
		action = new FindPasswordProcess();
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
