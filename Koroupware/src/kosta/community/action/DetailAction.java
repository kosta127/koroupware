package kosta.community.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.community.model.Board;
import kosta.community.model.BoardDao;
import kosta.community.model.BoardFile;
import kosta.community.model.BoardFileDao;
import kosta.community.model.ReplyDao;
import kosta.community.model.ReplyModel;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ReplyDao replyDao = ReplyDao.getInstance();
		BoardDao dao = BoardDao.getInstance();
		BoardFileDao filedao = BoardFileDao.getInstance();
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		Board board = dao.detailBoard(board_no);
		
		List<ReplyModel> replyList = replyDao.selectReplyModelByBoardNo(board_no);
		request.setAttribute("replyList", replyList);
		
		request.setAttribute("board", board);
		List<BoardFile> fileList = filedao.fileList(board.getBoard_no());
		request.setAttribute("boardFileList", fileList);
		
		
		ActionForward forward = new ActionForward();
		
		if(board != null){
			forward.setRedirect(false);
			forward.setPath("hit.do");
		}else{
			forward.setRedirect(true);
			forward.setPath("board/list.jsp");
		}
		
		return forward;
	}

}
