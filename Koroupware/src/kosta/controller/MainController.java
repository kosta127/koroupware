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
import kosta.community.action.CategoryInsertAction;
import kosta.community.action.CategoryInsertFormAction;
import kosta.community.action.CategoryListAction;
import kosta.community.action.CommunityInsertAction;
import kosta.community.action.CommunityInsertFormAction;
import kosta.community.action.CommunityListAction;
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
import kosta.doc.action.DeleteDocAction;
import kosta.doc.action.DeleteDocBoxManagementAction;
import kosta.doc.action.DeleteDocManagementAction;
import kosta.doc.action.DetailDocAction;
import kosta.doc.action.DetailDocBoxAction;
import kosta.doc.action.DocBoxFormAction;
import kosta.doc.action.DocBoxProcAction;
import kosta.doc.action.DocFormAction;
import kosta.doc.action.DocProcAction;
import kosta.doc.action.InsertDocHisProcAction;
import kosta.doc.action.InsertDocHisProcAction;
import kosta.doc.action.InsertDocManagementAction;
import kosta.doc.action.ListDocAction;
import kosta.doc.action.ListDocBoxAction;
import kosta.doc.action.ListDocHisAction;
import kosta.doc.action.UpdateDocFormAction;
import kosta.doc.action.UpdateDocProcAction;
import kosta.doc.action.UpdateDocProcAction;
import kosta.doc.action.UpdateDocBoxFormAction;
import kosta.doc.action.UpdateDocBoxProcAction;
import kosta.elecauth.action.Elec_authDetailAction;
import kosta.elecauth.action.Elec_authErrorAction;
import kosta.elecauth.action.Elec_authListAction;
import kosta.elecauth.action.Elec_authSubmissionAction;
import kosta.elecauth.action.Elec_authWriteFormAction;
import kosta.elecauth.action.EmpSearchAsJSONAction;
import kosta.etc.ETC;
import kosta.login.action.FindIdProcess;
import kosta.login.action.FindPasswordProcess;
import kosta.login.action.LoginGoAction;
import kosta.login.action.LoginProcess;
import kosta.login.action.LogoutAction;
import kosta.login.action.MainAction;
import kosta.login.action.SignUpAction;
import kosta.login.action.SignUpdateAction;
import kosta.login.action.StartAction;
import kosta.login.action.TelAddAction;
import kosta.login.action.TelDeleteAction;
import kosta.login.action.TelUpdateAction;
import kosta.message.action.FailAction;
import kosta.message.action.MessagePageAction;
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
			case "insertCommunityForm.do":
	            action = new CommunityInsertFormAction();
	            break;
	        case "insertCommunity.do":
	            action = new CommunityInsertAction();
	            break;
	        case "listCommunity.do":
	            action = new CommunityListAction();
	            break;
	        case "insertCategoryForm.do":
	            action = new CategoryInsertFormAction();
	            break;
	        case "insertCategory.do":
	            action = new CategoryInsertAction();
	            break;
	        case "listCategory.do":
	            action = new CategoryListAction();
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
			case "SearchAction.do":
				action = new SearchProcess();
				break;
			case "DocForm.do":
				System.out.println("ddddd");
				action = new DocFormAction();
				break;
			case "DocProc.do":
				action = new DocProcAction();
				break;
			case "listDoc.do":
				action = new ListDocAction();
				break;
			case "detailDoc.do":
				action = new DetailDocAction();
				break;
			case "Doc_boxForm.do":
				action = new DocBoxFormAction();
				break;
			case "Doc_boxProc.do":
				action = new DocBoxProcAction();
				break;
			case "listDoc_box.do":
				action = new ListDocBoxAction();
				break;
			case "detailDoc_box.do":
				action = new DetailDocBoxAction();
				break;
			case "insertDoc_management.do":
				action = new InsertDocManagementAction();
				break;
			case "updateDoc_boxForm.do":
				action = new UpdateDocBoxFormAction();
				break;
			case "updateDoc_boxProc.do":
				action = new UpdateDocBoxProcAction();
				break;
			case "deleteDoc.do":
				action = new DeleteDocAction();
				break;
			case "deleteDoc_box_management.do":
				action = new DeleteDocBoxManagementAction();
				break;
			case "deleteDoc_management.do":
				action = new DeleteDocManagementAction();
				break;
			case "insertDoc_his.do":
				action = new InsertDocHisProcAction();
				break;
			case "updateDocForm.do":
				action = new UpdateDocFormAction();
				break;
			case "updateDocProc.do":
				action = new UpdateDocProcAction();
				break;
			case "insertDoc_hisProc.do":
				action = new InsertDocHisProcAction();
				break;
			case "listDoc_his.do":
				action = new ListDocHisAction();
				break;
			case "elec_authList.do":
				action=new Elec_authListAction();
				break;
			case "elec_authDetail.do":
				action=new Elec_authDetailAction();
				break;
			case "elec_authSubmission.do":
				action = new Elec_authSubmissionAction();
				break;
			case "elec_authWriteForm.do":
				action = new Elec_authWriteFormAction();
				break;
			case "elec_authError.do":
				action = new Elec_authErrorAction();
				break;
			case "empSearchAsJSON.do":
				action = new EmpSearchAsJSONAction();
				break;
			case "telUpdate.do":
				action = new TelUpdateAction();
				break;
			case "logout.do":
				action = new LogoutAction();
				break;
			default:
				System.out.println("dd");
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
				System.out.println("ActionForward媛� NULL");
			}
		}else{
			System.out.println("Action�씠 NULL");
		}
	}
}
