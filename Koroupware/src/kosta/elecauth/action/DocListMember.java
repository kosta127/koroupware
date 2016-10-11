package kosta.elecauth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.elecauth.dao.DocMemberDao;
import kosta.elecauth.model.DocMember;

public class DocListMember implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		DocMemberDao dao=DocMemberDao.getInstance();
		return null; 
	}
	

}
