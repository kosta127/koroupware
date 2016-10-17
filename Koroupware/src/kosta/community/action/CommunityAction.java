package kosta.community.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.community.model.Board;
import kosta.community.model.BoardDao;
import kosta.community.model.BoardFile;
import kosta.community.model.BoardFileDao;
import kosta.community.model.ReplyDao;
import kosta.community.model.ReplyModel;

public class CommunityAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		ActionForward forward = new ActionForward();

		forward.setRedirect(true);
		forward.setPath("list.jsp");
		
		return forward;
	}

}
