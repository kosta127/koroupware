package kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.action.DeleteAction;
import kosta.community.action.DeleteReplyAction;
import kosta.community.action.DetailAction;
import kosta.community.action.HitAction;
import kosta.community.action.InsertAction;
import kosta.community.action.InsertFormAction;
import kosta.community.action.ListAction;
import kosta.community.action.ModifyAction;
import kosta.community.action.ModifyFormAction;
import kosta.community.action.ReplyAction;
import kosta.dept.action.OrgChartPageAction;
import kosta.etc.ETC;
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
import kosta.message.action.FailAction;
import kosta.message.action.MessagePageAction;
import kosta.message.action.MessagePageTempAction;
import kosta.message.action.MessageSendAction;
import kosta.search.action.SearchProcess;

@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException{
    	System.out.println(123);
    	
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
			case "insertForm.do":
				action = new InsertFormAction();
				break;
			case "insert.do":
				action = new InsertAction();
				break;
			case "listBoard.do":
				action = new ListAction();
				break;
			case "boardDetail.do":
				action = new DetailAction();
				break;
			case "hit.do":
				action = new HitAction();
				break;
			case "modifyForm.do":
				action = new ModifyFormAction();
				break;
			case "modify.do":
				action = new ModifyAction();
				break;
			case "delete.do":
				action = new DeleteAction();
				break;
			case "reply.do":
				action = new ReplyAction();
				break;
			case "deleteReply.do":
				action = new DeleteReplyAction();
				break;
			case "LoginProcessAction.do":
				action = new LoginProcess();
				break;
			case "FindIdProcess.do":
				action = new FindIdProcess();
				break;
			case "FindPasswordProcess.do":
				action = new FindPasswordProcess();
				break;
			case "MakeAction.do":
				action = new StartAction();
				break;
			case "SignUpAction.do":
				action = new SignUpAction();
				break;
			case "SignUpdate.do":
				action = new SignUpdateAction();
				break;
			case "telDelete.do":
				action = new TelDeleteAction();
				break;
			case "telAdd.do":
				action = new TelAddAction();
				break;
			case "loginGo.do":
				action = new LoginGoAction();
				break;
			case "main.do":
				action = new MainAction();
				break;
			case "SearchAction.go":
				action = new SearchProcess();
				break;
			default:
				System.out.println("없는 요청");
				break;
		}
    	
    	actionForward(request, response, action);
    }

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
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
