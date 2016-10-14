package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.message.action.ActionForward;

public interface Action {
	//Action들의 틀을 잡아준다
	public abstract ActionForward execute(HttpServletRequest request, HttpServletResponse response);
	
}
