package kosta.search.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.model.Doc;
import kosta.emp.model.Emp;
import kosta.search.dao.SearchDao;
import kosta.search.model.Search;
import kosta.search.service.SearchService;

public class SearchProcess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String search_content = request.getParameter("search_content");
		String keyfield = request.getParameter("keyField");
		SearchService service = SearchService.getInstance();

		List<Emp> emplist = service.ListEmpServivce();
		List<Doc> doclist = service.ListDocService();
		ActionForward forward = new ActionForward();
		if (keyfield.equals("emp_name")) {

			for (int i = 0; i < emplist.size(); i++) {
				List<Search> searchlist = service.SearchNameService(search_content);
				if (emplist.get(i).getEmp_name().equals(search_content)) {
					System.out.println("이름 검색 성공");
					request.setAttribute("Search", searchlist);
					forward.setPath("./Search/searchSuccess.jsp");
					forward.setRedirect(false);
					break;
				} else {
					System.out.println("실패");
					forward.setPath("main.jsp");
					forward.setRedirect(false);
				}

			}

		}
		if (keyfield.equals("document")) {
			for (int i = 0; i < doclist.size(); i++) {
				if (doclist.get(i).getDoc_contents().equals(search_content)) {
					List<Doc> searchDoclist = service.SearchDocService(search_content);
					System.out.println(search_content);
					System.out.println("문서 검색 성공 - 내용과 같은것");
					request.setAttribute("SearchDoc", searchDoclist);
					forward.setPath("./Search/searchDocSucess.jsp");
					forward.setRedirect(false);
					break;
				} else if (doclist.get(i).getDoc_title().equals(search_content)) {
					List<Doc> searchDoclist = service.SearchDocService(search_content);
					System.out.println(search_content);
					System.out.println("문서 검색 성공 - 제목");
					request.setAttribute("SearchDoc", searchDoclist);
					forward.setPath("./Search/searchDocSucess.jsp");
					forward.setRedirect(false);
					break;
				} else if (!doclist.get(i).getDoc_title().equals(search_content)
						&& !doclist.get(i).getDoc_contents().equals(search_content)) {
					for (int j = 0; j < emplist.size(); j++) {
						if (emplist.get(j).getEmp_name().equals(search_content)) {
							List<Doc> searchDoclist = service.SearchDocService(search_content);
							System.out.println("문서 검색 성공 - 작성자");
							request.setAttribute("SearchDoc", searchDoclist);
							forward.setPath("./Search/searchDocSucess.jsp");
							forward.setRedirect(false);
							break;
						}
					}

				} else {

					System.out.println("실패");
					forward.setPath("main.jsp");
					forward.setRedirect(false);
					break;
				}

			}

		}
		return forward;
	}
}