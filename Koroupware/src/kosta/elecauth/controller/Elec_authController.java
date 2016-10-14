package kosta.elecauth.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.elecauth.action.Action;
import kosta.elecauth.action.ActionForward;
import kosta.elecauth.action.Elec_authDetailAction;
import kosta.elecauth.action.Elec_authErrorAction;
import kosta.elecauth.action.Elec_authListAction;
import kosta.elecauth.action.Elec_authSubmissionAction;
import kosta.elecauth.action.Elec_authWriteFormAction;
import kosta.elecauth.action.EmpSearchAction;

@WebServlet("*.do")
public class Elec_authController extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	public Elec_authController(){
		super();
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length()+1);
		System.out.println("command => "+command);
		
		ActionForward forward=null;
		Action action=null;
		
		if(command.equals("elec_authList.do")){
			action=new Elec_authListAction();
			forward=action.execute(request, response);
		}else if(command.equals("elec_authDetail.do")){
			action=new Elec_authDetailAction();
			forward=action.execute(request, response);
		}else if (command.equals("elec_authSubmission.do")) {
			action = new Elec_authSubmissionAction();
			forward = action.execute(request, response);
		}else if(command.equals("elec_authWriteForm.do")){
			action = new Elec_authWriteFormAction();
			forward = action.execute(request, response);
		}else if(command.equals("elec_authError.do")){
			action = new Elec_authErrorAction();
			forward = action.execute(request, response);
		}else if(command.equals("empSearch.do")){
			action = new EmpSearchAction();
			forward = action.execute(request, response);
		}
		
		if(forward !=null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getUrl());
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getUrl());
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
	

