<%@page import="net.sf.json.JSONArray"%>
<%@page import="kosta.message.model.MessageReceiverModel"%>
<%@page import="java.util.List"%>
<%@page import="kosta.etc.ETC"%>
<%@page import="kosta.message.dao.MessageDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String emp_no = request.getParameter("emp_no");
	
	if(ETC.isNotNull(emp_no)){
		MessageDao dao = MessageDao.getInstance();
		List<MessageReceiverModel> list = dao.selectMessageReceiverEmpsByEmpId(Integer.parseInt(emp_no));
		
		String json = JSONArray.fromObject(list).toString();
		out.print(json);
	}
%>