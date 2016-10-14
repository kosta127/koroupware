package kosta.search.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.emp.model.Emp;
import kosta.login.action.Action;
import kosta.login.action.ActionForward;
import kosta.search.dao.SearchDao;

public class SearchSucessProcess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		SearchDao dao = SearchDao.getInstance();
		List<Emp> list = dao.ListSearchEmp();
		int search_no = Integer.parseInt((String)session.getAttribute("search_no"));
		ActionForward forward = null;
		
		for(int i =0; i<list.size(); i++){
			if(list.get(i).getEmp_no()==search_no){
				System.out.println("통과");
				session.setAttribute("search_id", list.get(i).getEmp_no());
				session.setAttribute("search_name", list.get(i).getEmp_name());
				session.setAttribute("search_dept", list.get(i).getDept_no());
				session.setAttribute("search_address", list.get(i).getEmp_address());
				System.out.println(list.get(i).getEmp_name());
				forward.setPath("searchSuccess.jsp");
				forward.setRedirect(false);
				break;
				
			}else{
				System.out.println("실패");
				forward.setPath("./Search/searchfaill.jsp");
				forward.setRedirect(false);
			}
		}
		return forward;
	}

}
