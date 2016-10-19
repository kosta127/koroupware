<%@page import="kosta.emp.model.SearchEmpModel"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="kosta.emp.model.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kosta.emp.dao.EmpDao"%>
<%@page import="kosta.etc.ETC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String searchKeyword = request.getParameter("searchKeyword");
	
	if(ETC.isNotNull(searchKeyword)){
		EmpDao dao = EmpDao.getInstance();
		
		searchKeyword = "%" + searchKeyword + "%";
		
		List<SearchEmpModel> searchEmpModelList = dao.selectSearchEmpModelByKeyword(searchKeyword);
		
		if(!searchEmpModelList.isEmpty()){
			String json = JSONArray.fromObject(searchEmpModelList).toString();
			out.print(json);
		}
	}
%>