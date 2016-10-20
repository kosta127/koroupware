package kosta.community.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Board;
import kosta.community.model.BoardDao;
import kosta.community.model.BoardFile;
import kosta.community.model.BoardFileDao;
import kosta.emp.model.Emp;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		Board board = new Board();
		BoardFile boardfile = new BoardFile();
		HttpSession session = request.getSession();
		Emp emp = (Emp)session.getAttribute("emp");
		
		ActionForward forward = new ActionForward();
		
		BoardFileDao filedao = BoardFileDao.getInstance();
		
		String uploadPath = request.getRealPath("upload");
		int max_size = 1024 * 1024 * 20;
		int category_no = 0;
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, uploadPath, max_size, "UTF-8", new DefaultFileRenamePolicy());
			
			category_no = Integer.parseInt(mpr.getParameter("category_no"));
			board.setBoard_title(mpr.getParameter("board_title"));
			board.setBoard_contents(mpr.getParameter("board_contents"));
			board.setEmp_no(emp.getEmp_no());
			board.setCategory_no(category_no);
			/*board.setEmp_no(1);	//임시 (로그인)*/
			
			BoardDao dao = BoardDao.getInstance();
			int re = dao.insertBoard(board);
			
			//파일업로드
			if(mpr.getFilesystemName("board_fname") != null){
				//파일이름의 중복을 막기위해 해줌
				String board_file_real_name = mpr.getFilesystemName("board_fname");
				UUID uid = UUID.randomUUID();
				String board_file_save_name = uid.toString() + "_" + board_file_real_name;
				boardfile.setBoard_file_real_name(board_file_real_name);
				boardfile.setBoard_file_save_name(board_file_save_name);
				int board_no = dao.selectBoardNo();
				boardfile.setBoard_no(board_no);
				
				//원본파일이미지 => 파일객체화(파일이름, 경로 필요)
				String imagePath = uploadPath + "\\" + board_file_real_name;
				File src = new File(imagePath);
				
			}else{
				boardfile.setBoard_file_real_name("");
			}
			
			if(re>0){
				request.setAttribute("category_no", category_no);
				
				forward.setRedirect(false);
				forward.setPath("listBoard.do");
				
				filedao.fileInsert(boardfile);
			}else{
				forward.setRedirect(true);
				forward.setPath("board/insertForm.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return forward;
	}

}
