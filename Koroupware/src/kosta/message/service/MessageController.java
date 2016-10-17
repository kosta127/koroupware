package kosta.message.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.dept.action.OrgChartPageAction;
import kosta.etc.ETC;
import kosta.message.action.ActionForward;
import kosta.message.action.FailAction;
import kosta.message.action.MessagePageAction;
import kosta.message.action.MessagePageTempAction;
import kosta.message.action.MessageSendAction;


@WebServlet("*.do")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageController() {
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException{
    	String command = getRequestPath(request);
    	Action action = null;
    	
    	switch (command) {
	    	case "messagePage.do":
				action = new MessagePageAction();
				break;
	    	case "messagePageTemp.do":
				action = new MessagePageTempAction();
				break;
			case "messageSend.do":
				action = new MessageSendAction();
				break;
			case "orgChartPage.do":
				action = new OrgChartPageAction();
				break;
			case "fail.do":
				action = new FailAction();
				break;
			default:
				System.out.println("없는 요청");
				break;
		}
    	
    	actionForward(request, response, action);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public String getRequestPath(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String requestPath = requestURI.substring(requestURI.lastIndexOf("/") + 1);
		
		System.out.println(requestPath);
		
		return requestPath;
	}

	public void actionForward(HttpServletRequest request, HttpServletResponse response, Action action) 
			throws ServletException, IOException{
		if(ETC.isNotNull(action)){
			ActionForward forward = action.execute(request, response);
			
			if(ETC.isNotNull(forward)){
				if(forward.isRedirect()){
					response.sendRedirect(forward.getPath());
				}else{
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
			}else{
				System.out.println("ActionForward가 NULL");
			}
		}else{
			System.out.println("Action이 NULL");
		}
	}
}