package kosta.search.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kosta.login.action.Action;
import kosta.login.action.ActionForward;
import kosta.search.action.SearchProcess;
import kosta.search.action.SearchSucessProcess;



@WebServlet("*.go")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+1);
    	
    	ActionForward forward = null;
    	Action action = null;
    	
    	if(command.equals("SearchAction.go")){
    		action = new SearchProcess();
    		forward = action.execute(request, response);
    	}else if(command.equals("searchSuccess.go")){
    		action = new SearchSucessProcess();
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
