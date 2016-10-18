<%@page import="kosta.etc.ETC"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="kosta.message.dao.MessageDao"%>
<%@page import="kosta.message.model.MessageReceiverModel"%>
<%@page import="java.util.List"%>
<%@page import="kosta.emp.model.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	MessageDao dao = MessageDao.getInstance(); 
	Emp emp = (Emp)session.getAttribute("emp");
	
	if(ETC.isNotNull(emp)){
		List<MessageReceiverModel> messageReceiverModelList = 
				dao.selectMessageReceiverEmpsByEmpId(emp.getEmp_no());
		
		if(!messageReceiverModelList.isEmpty()){
			String json = JSONArray.fromObject(messageReceiverModelList).toString();
			out.print(json);
		}
	}
%>