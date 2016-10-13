package kosta.community.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.community.model.Board;
import kosta.community.model.BoardDao;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		Board board = new Board();
		ActionForward forward = new ActionForward();
		
		String uploadPath = request.getRealPath("upload");
		int max_size = 1024 * 1024 * 20;
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, uploadPath, max_size, "UTF-8", new DefaultFileRenamePolicy());
			board.setBoard_title(mpr.getParameter("board_title"));
			board.setBoard_contents(mpr.getParameter("board_contents"));
			/*board.setBoard_hit(Integer.parseInt(request.getParameter("hit")));*/
			/*board.setEmp_no(Integer.parseInt(request.getParameter("emp_no")));*/
			
			BoardDao dao = BoardDao.getInstance();
			int re = dao.insertBoard(board);
			
			if(re==1){
				forward.setRedirect(true);
				forward.setPath("listBoard.do");
			}else{
				forward.setRedirect(true);
				forward.setPath("insertForm.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return forward;
	}

}
