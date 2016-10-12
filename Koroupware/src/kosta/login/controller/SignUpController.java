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
import kosta.login.action.SignUpAction;
import kosta.login.action.StartAction;


@WebServlet("*.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public SignUpController() {
	        super();   
	    }
	
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	    	String requestURI = request.getRequestURI();
	    	String contextPath = request.getContextPath();
	    	String command = requestURI.substring(contextPath.length() + 1);
	    	System.out.println(command);
	    	ActionForward forward = null;
	    	Action action = null;
	    	
	    	if(command.equals("StartAction.do")){
	    		action = new StartAction();
	    		forward = action.execute(request, response);
	    	}if(command.equals("SignUpAction.do")){
	    		System.out.println("여긴되냐");
	    		action = new SignUpAction();
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
