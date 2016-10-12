package kosta.message.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.message.dao.MessageDao;
import kosta.message.model.Emp;
import kosta.message.model.MessageModel;
import kosta.message.model.MessageReceiverModel;

public class MessagePageAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MessageDao dao = MessageDao.getInstance();
		
		//가짜 데이터 (로그인)
		Emp emp = new Emp();

		emp.setEmp_no(1);
		emp.setEmp_id("empId");
		emp.setEmp_name("테스트용");
		emp.setOffice_no(1);
		emp.setPosition_no(1);
		emp.setDept_no(1);
		
		HttpSession session = request.getSession();
		session.setAttribute("emp", emp);
		//
		
		List<MessageModel> messageModelList = dao.selectMessageModelsByEmpId(emp.getEmp_no());
		request.setAttribute("messageModelList", messageModelList);
		
		List<MessageReceiverModel> messageReceiverModelList = 
				dao.selectMessageReceiverEmpsByEmpId(emp.getEmp_no());
		request.setAttribute("messageReceiverModelList", messageReceiverModelList);
		
		forward.setPath("messagePage.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
