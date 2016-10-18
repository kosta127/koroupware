package kosta.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;

public class logout implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		session.removeAttribute("emp");
		System.out.println("emp 세션 삭제함");
		forward.setPath("login.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
