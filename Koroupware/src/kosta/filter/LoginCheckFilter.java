package kosta.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kosta.controller.MainController;
import kosta.etc.ETC;

@WebFilter("*.do")
public class LoginCheckFilter implements Filter {
    public LoginCheckFilter() {
    }

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String requestPath = getRequestPath(httpRequest);
		
		if(ETC.isLoginNeedCeck(requestPath)){
			HttpSession session = httpRequest.getSession();
			
			if(session.getAttribute("emp") == null){
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginGo.do");
		        dispatcher.forward(request, response);
		        return;
			}
		}
		
		chain.doFilter(request, response);
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public String getRequestPath(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String requestPath = requestURI.substring(requestURI.lastIndexOf("/") + 1);
		
		System.out.println(requestPath);
		
		return requestPath;
	}
}
