package kosta.menu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Category;
import kosta.community.model.CategoryDao;
import net.sf.json.JSONArray;

public class CategoryListAsJSONAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
				
		CategoryDao dao = CategoryDao.getInstance();
		int community_no = Integer.parseInt(request.getParameter("community_no"));
		List<Category> categoryList = dao.listCategory(community_no);
		
		if(categoryList != null){
			String jsonStr = JSONArray.fromObject(categoryList).toString();			
			request.setAttribute("categoryListAsJSON", jsonStr);
			forward.setRedirect(false);
			forward.setPath("categoryListAsJSON.jsp");
		}else{
			//error처리
		}
		
		return forward;
	}

}
