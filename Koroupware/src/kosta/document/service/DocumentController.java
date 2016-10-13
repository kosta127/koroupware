package kosta.document.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.document.action.Action;
import kosta.document.action.ActionForward;
import kosta.document.action.DetailDocBoxAction;
import kosta.document.action.DetailDocAction;
import kosta.document.action.DocBoxFormAction;
import kosta.document.action.DocBoxProcAction;
import kosta.document.action.DocFormAction;
import kosta.document.action.DocProAction;
import kosta.document.action.ListDocAction;
import kosta.document.action.ListDocBoxAction;



@WebServlet("*.do")
public class DocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DocumentController() {
        super();
        
    }

	protected void doProcess(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		ActionForward forward = null;
		Action action = null;
		if(command.equals("document/docForm.do")){
			action = new DocFormAction();
			forward = action.execute(request, response);
		}else if(command.equals("document/docProc.do")){
			action = new DocProAction();
			forward = action.execute(request, response);
		}else if(command.equals("document/listDoc.do")){
			action = new ListDocAction();
			forward = action.execute(request, response);
		}/*else if(command.equals("document/detailDocument.do")){
			action = new DetailDocumentAction();
			forward = action.execute(request, response);
		}*/else if(command.equals("document/doc_boxForm.do")){
			action = new DocBoxFormAction();
			forward = action.execute(request, response);
		}else if(command.equals("document/doc_boxProc.do")){
			action = new DocBoxProcAction();
			forward = action.execute(request, response);
		}else if(command.equals("document/listDoc_box.do")){
			action = new ListDocBoxAction();
			forward = action.execute(request, response);
		}else if(command.equals("document.detailDoc_box.do")){
			action = new DetailDocBoxAction();
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
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
