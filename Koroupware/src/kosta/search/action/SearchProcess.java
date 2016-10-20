package kosta.search.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.model.Doc;
import kosta.emp.model.Emp;
import kosta.search.model.Search;
import kosta.search.service.SearchService;

public class SearchProcess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		String search_content = request.getParameter("search_content");
		String keyfield = request.getParameter("keyField");
		SearchService service = SearchService.getInstance();
		System.out.println(keyfield);
		List<Emp> emplist = service.ListEmpServivce();
		List<Doc> doclist = service.ListDocService();

		if (keyfield.equals("emp_name")) {
			for (int i = 0; i < emplist.size(); i++) {
				System.out.println("이름 검색 성공");
				List<Search> searchlist = service.SearchNameService(search_content);
				request.setAttribute("Search", searchlist);
				forward.setPath("./Search/searchSuccess.jsp");
				forward.setRedirect(false);
				break;
			}

		}
		if (keyfield.equals("document")) {
			for (int i = 0; i < doclist.size(); i++) {
				List<Doc> searchDoclist = service.SearchDocService(search_content);
				System.out.println(search_content);
				System.out.println("문서 검색 성공 - 내용과 같은것");
				request.setAttribute("SearchDoc", searchDoclist);
				forward.setPath("./Search/searchDocSucess.jsp");
				forward.setRedirect(false);
				System.out.println("여기 까지 됫음");
				break;

			}
			

		}
		return forward;
	}
}