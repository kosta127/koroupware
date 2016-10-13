package kosta.community.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.community.model.Board;
import kosta.community.model.BoardDao;


public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao dao = BoardDao.getInstance();
		List<Board> list = dao.listBoard();
		
		request.setAttribute("list", list);
		
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
