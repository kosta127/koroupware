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
import kosta.login.action.LoginGoAction;
import kosta.login.action.LoginProcess;
import kosta.login.action.MainAction;
import kosta.login.action.SignUpAction;
import kosta.login.action.SignUpdateAction;
import kosta.login.action.StartAction;
import kosta.login.action.TelAddAction;
import kosta.login.action.TelDeleteAction;
import kosta.login.action.TelUpdateAction;
import kosta.search.action.SearchProcess;



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
	}else if(command.equals("MakeAction.do")){
		action = new StartAction();
		forward = action.execute(request, response);
	}else if(command.equals("SignUpAction.do")){
		action = new SignUpAction();
		forward = action.execute(request, response);
	}else if(command.equals("SignUpdate.do")){
		System.out.println("업데이트 시작");
		action = new SignUpdateAction();
		forward = action.execute(request, response);
	}else if(command.equals("loginGo.do")){
		action = new LoginGoAction();
		forward = action.execute(request, response);
	}else if(command.equals("main.do")){
		action = new MainAction();
		forward = action.execute(request, response);
	}else if(command.equals("telDelete.do")){
		System.out.println("전화번호 삭제");
		action = new TelDeleteAction();
		forward = action.execute(request, response);
	}else if(command.equals("SearchAction.do")){
		action = new SearchProcess();
		forward = action.execute(request, response);
	}else if(command.equals("telAdd.do")){
		System.out.println("전화번호 추가");
		action = new TelAddAction();
		forward = action.execute(request, response);
	}else if(command.equals("telUpdate.do")){
		System.out.println("전화번호수정");
		action = new TelUpdateAction();
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
