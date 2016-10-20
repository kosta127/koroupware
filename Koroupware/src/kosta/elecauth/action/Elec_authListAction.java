package kosta.elecauth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.elecauth.dao.Elec_authDao;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_authList;
import kosta.elecauth.service.Elec_authService;
import kosta.emp.model.Emp;

public class Elec_authListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward();
		
		String strPageNum=request.getParameter("pageNum");
		int pageNum=(strPageNum!=null)?Integer.parseInt(strPageNum):1;
		
		HttpSession session = request.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		if(emp == null){ //회원정보 없으면 로그인 페이지로
			forward.setRedirect(true);
			forward.setPath(request.getContextPath()+"/login.jsp");
			return forward;
		}
		
		int emp_no = emp.getEmp_no(); 
		
		String rFlag = request.getParameter("receive");
		String flag = request.getParameter("flag");
		if(flag==null) flag = "";
		
		Elec_authService service=Elec_authService.getInstance();
		List<Elec_authList> elec_authList = 
				service.elec_authList(pageNum, emp_no, (rFlag!=null)?true:false, flag);
		  
		if(elec_authList != null){
			request.setAttribute("receive", rFlag);
			request.setAttribute("elec_authList", elec_authList);
			request.setAttribute("paging", 
					service.elec_authListPage(pageNum, emp_no, (rFlag!=null)?true:false, flag));
			forward.setRedirect(false); 
			forward.setPath("/elec_auth/elec_auth_list.jsp");
		}else{
			forward.setRedirect(true);
			forward.setPath("error.do");
		}
		return forward;
	}

	
	

}
