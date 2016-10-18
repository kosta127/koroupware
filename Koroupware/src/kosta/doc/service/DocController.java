package kosta.doc.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.doc.action.Action;
import kosta.doc.action.ActionForward;
import kosta.doc.action.DeleteDocAction;
import kosta.doc.action.DeleteDocBoxAction;
import kosta.doc.action.DetailDocBoxAction;
import kosta.doc.action.DetailDocAction;
import kosta.doc.action.DocBoxFormAction;
import kosta.doc.action.DocBoxProcAction;
import kosta.doc.action.DocFormAction;
import kosta.doc.action.DocProcAction;
import kosta.doc.action.InsertDocManagementAction;
import kosta.doc.action.ListDocAction;
import kosta.doc.action.ListDocBoxAction;
import kosta.doc.action.updateDocBoxFormAction;
import kosta.doc.action.updateDocBoxProcAction;



@WebServlet("*.do")
public class DocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DocController() {
        super();
        
    }

	protected void doProcess(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		ActionForward forward = null;
		Action action = null;
		if(command.equals("doc/docForm.do")){
			action = new DocFormAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/docProc.do")){
			action = new DocProcAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/listDoc.do")){
			action = new ListDocAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/detailDoc.do")){
			action = new DetailDocAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/doc_boxForm.do")){
			action = new DocBoxFormAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/doc_boxProc.do")){
			action = new DocBoxProcAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/listDoc_box.do")){
			action = new ListDocBoxAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/detailDoc_box.do")){
			action = new DetailDocBoxAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/insertDoc_management.do")){
			action = new InsertDocManagementAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/updateDoc_box_Form.do")){
			action = new updateDocBoxFormAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/updateDoc_box_Proc.do")){
			action = new updateDocBoxProcAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/deleteDoc.do")){
			action = new DeleteDocAction();
			forward = action.execute(request, response);
		}else if(command.equals("doc/deleteDoc_box.do")){
			action = new DeleteDocBoxAction();
			forward = action.execute(request, response);
		}
		
		
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher =
				request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
