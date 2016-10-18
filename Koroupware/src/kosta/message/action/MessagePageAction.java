package kosta.message.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.emp.model.Emp;
import kosta.message.dao.MessageDao;
import kosta.message.model.MessageModel;
import kosta.message.model.MessageReceiverModel;

public class MessagePageAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MessageDao dao = MessageDao.getInstance();
		/*
		//가짜 데이터 (로그인)
		Emp emp = new Emp();

		emp.setEmp_no(1);
		emp.setEmp_id("empId");
		emp.setEmp_name("테스트용");
		emp.setOffice_no(1);
		emp.setPosition_no(1);
		emp.setDept_no(1);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginEmp", emp);
		//
		*/
		HttpSession session = request.getSession();
		Emp emp = (Emp)session.getAttribute("emp");
		
		List<MessageReceiverModel> messageReceiverModelList = 
				dao.selectMessageReceiverEmpsByEmpId(emp.getEmp_no());
		request.setAttribute("messageReceiverModelList", messageReceiverModelList);
		
		forward.setPath("message/messagePage.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}
