package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Category;
import kosta.community.model.CategoryDao;


public class CategoryInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		 Category category = new Category();
		
		 int community_no = Integer.parseInt(request.getParameter("community_no"));
		 
		 CategoryDao dao = CategoryDao.getInstance();
		 
		 category.setCategory_name(request.getParameter("category_name"));
		 category.setCommunity_no(community_no);
		 
		 int re = dao.insertCategory(category);
		 
		 ActionForward forward = new ActionForward();
		
		request.setAttribute("community_no", community_no);
		
		if(re>0){
			forward.setRedirect(false);
			forward.setPath("main.do");
		}else{
			forward.setRedirect(true);
			forward.setPath("category/categoryInsertForm.jsp");
		}
		
		
		return forward;
	}

}
