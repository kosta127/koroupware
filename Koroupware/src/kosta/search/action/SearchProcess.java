package kosta.search.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import kosta.emp.model.Emp;
import kosta.login.action.Action;
import kosta.login.action.ActionForward;
import kosta.search.dao.SearchDao;

public class SearchProcess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		SearchDao dao = SearchDao.getInstance();
		List<Emp> list = dao.ListEmp();
		ActionForward forward  = new ActionForward();
		
		System.out.println(request.getParameter("search_content"));
		
		for(int i =0; i<list.size(); i++){
			if(list.get(i).getEmp_name().equals(request.getParameter("search_content"))){
				System.out.println("통과");
				forward.setPath("./Search/searchSuccess.jsp"); 
				forward.setRedirect(false);
				break;
			}else{
				System.out.println("실패");
			}
		}
		
		return forward;
	}
}

