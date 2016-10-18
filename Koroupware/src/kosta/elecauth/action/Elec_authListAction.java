package kosta.elecauth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.elecauth.dao.Elec_authDao;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_authList;
import kosta.elecauth.service.Elec_authService;

public class Elec_authListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward();
		
		String strPageNum=request.getParameter("pageNum");
		int pageNum=(strPageNum!=null)?Integer.parseInt(strPageNum):1;
		
		String empNo=request.getParameter("emp_no");
		int emp_no=Integer.parseInt(empNo);
		
		Elec_authService service=Elec_authService.getInstance();
		List<Elec_authList> elec_authList=service.elec_authList(pageNum, emp_no);
		
		if(elec_authList != null){
			request.setAttribute("elec_authList", elec_authList);
			request.setAttribute("paging", service.elec_authListPage(pageNum));
			forward.setRedirect(false);
			forward.setPath("/elec_auth/elec_auth_list.jsp");
		}else{
			forward.setRedirect(true);
			forward.setPath("error.do");
		}
		return forward;
	}

	
	

}
