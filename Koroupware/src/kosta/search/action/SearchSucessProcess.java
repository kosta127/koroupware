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
		
		
		}
		return null;
	}

}
