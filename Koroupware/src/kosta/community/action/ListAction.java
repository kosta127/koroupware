package kosta.community.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.community.model.Board;
import kosta.community.model.BoardDao;
import kosta.community.model.BoardModel;
import kosta.community.model.ListModel;
import kosta.community.model.Search;




public class ListAction implements Action {
	public static final int PAGE_SIZE = 5; 
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao dao = BoardDao.getInstance();
		Search search = new Search();
		
		int requestPage = 1;
		String p_requestPage = request.getParameter("pageNum");
		if(p_requestPage != null){
			requestPage = Integer.parseInt(p_requestPage);
		}
		
		HttpSession session = request.getSession();
		
		if(request.getParameter("temp") != null){
			session.removeAttribute("search");
		}
		
		//검색시
		
		if(request.getParameterValues("area") != null){
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%"+request.getParameter("searchKey")+"%");
			session.setAttribute("search", search);
		}else if((Search)session.getAttribute("search") != null){//검색 후 페이징 클릭
			search = (Search)session.getAttribute("search");
		}
		
		int totalCount = dao.countBoard(search);
		int totalPageCount = totalCount / PAGE_SIZE;
		
		if(totalCount%PAGE_SIZE > 0){
			totalPageCount++;
		}
		
		int startPage = requestPage - (requestPage - 1) % 5;
		int endPage = startPage + 4;
		
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		int startRow = (requestPage - 1) * PAGE_SIZE;
		
		/*
		List<Board> list = dao.listBoard(startRow, search);
		ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage);
		System.out.println(listModel);
		request.setAttribute("list", list);
		request.setAttribute("listModel", listModel);
		*/
		
		List<BoardModel> list = dao.listBoardModel(startRow, search);
		ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage);
		System.out.println(listModel);
		request.setAttribute("list", list);
		request.setAttribute("listModel", listModel);
		
		ActionForward forward = new ActionForward();
		
		if(list != null){
			forward.setRedirect(false);
			forward.setPath("list.jsp");
		}else{
			forward.setRedirect(true);
			forward.setPath("insertForm.jsp");
		}
		
		return forward;
	}

}
