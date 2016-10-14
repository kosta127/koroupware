package kosta.search.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.emp.model.Emp;
import kosta.login.action.Action;
import kosta.login.action.ActionForward;
import kosta.search.dao.SearchDao;
import kosta.search.model.Search;


public class SearchProcess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String search_name = request.getParameter("search_content");
		SearchDao dao = SearchDao.getInstance();
		List<Search> searchlist = dao.SearchInfo(search_name);
		List<Emp> emplist = dao.ListEmp();
		ActionForward forward = new ActionForward();
		
		
		for(int i=0; i<emplist.size(); i++){
			if(emplist.get(i).getEmp_name().equals(search_name)){
				System.out.println("성공");
				request.setAttribute("Search", searchlist);
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

