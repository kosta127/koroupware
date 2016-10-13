package kosta.document.action;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public abstract ActionForward execute(HttpServletRequest request, HttpServletResponse response);
}
