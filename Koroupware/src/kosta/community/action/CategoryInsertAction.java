package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Category;
import kosta.community.model.CategoryDao;

public class CategoryInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		 Category category = new Category();
		 CategoryDao dao = CategoryDao.getInstance();
		 
		 category.setCategory_name(request.getParameter("category_name"));
		 
		 int re = dao.insertCategory(category);
		 
		 ActionForward forward = new ActionForward();
		 
		 if(re==1){
			 forward.setRedirect(false);
			 forward.setPath("listCategory.do");
		 }else{
			 forward.setRedirect(true);
			 forward.setPath("category/categoryInsertForm.jsp");
		 }
		return null;
	}

}
