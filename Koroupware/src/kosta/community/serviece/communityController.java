package kosta.community.serviece;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.community.action.Action;
import kosta.community.action.ActionForward;
import kosta.community.action.CommunityAction;
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




@WebServlet("*.do")
public class communityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public communityController() {
        super();
        
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		String requestURI = request.getRequestURI();//경로
		String command = requestURI.substring(requestURI.lastIndexOf("/")+1);
		
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("insertForm.do")){
			action = new InsertFormAction();
			forward = action.execute(request, response);
		}else if(command.equals("insert.do")){
			action = new InsertAction();
			forward = action.execute(request, response);
		}else if(command.equals("listBoard.do")){
			action = new ListAction();
			forward = action.execute(request, response);
		}else if(command.equals("boardDetail.do")){
			action = new DetailAction();
			forward = action.execute(request, response);
		}else if(command.equals("hit.do")){
			action = new HitAction();
			forward = action.execute(request, response);
		}else if(command.equals("modifyForm.do")){
			action = new ModifyFormAction();
			forward = action.execute(request, response);
		}else if(command.equals("modify.do")){
			action = new ModifyAction();
			forward = action.execute(request, response);
		}else if(command.equals("delete.do")){
			action = new DeleteAction();
			forward = action.execute(request, response);
		}else if(command.equals("reply.do")){
			action = new ReplyAction();
			forward = action.execute(request, response);
		}else if(command.equals("deleteReply.do")){
			action = new DeleteReplyAction();
			forward = action.execute(request, response);
		}
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
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
