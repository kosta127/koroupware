package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//Action들의 틀을 잡아준다
	public abstract ActionForward execute(HttpServletRequest request, HttpServletResponse response);
	
}
