package kosta.community.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Category;
import kosta.community.model.CategoryDao;

public class CategoryListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		CategoryDao dao = CategoryDao.getInstance();
		
		int community_no = Integer.parseInt(request.getParameter("community_no"));
		System.out.println(community_no);
		List<Category> categoryList = dao.listCategory(community_no);
		
		request.setAttribute("community_no", community_no);
		request.setAttribute("categoryList", categoryList);
		
		if(categoryList != null){
			forward.setRedirect(false);
			forward.setPath("main.jsp");
		}else{
			forward.setRedirect(true);
			forward.setPath("insertCategoryForm.do");
		}
		return forward;
	}

}
