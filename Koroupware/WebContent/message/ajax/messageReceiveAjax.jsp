<%@page import="kosta.emp.model.Emp"%>
<%@page import="kosta.message.model.MessageModel"%>
<%@page import="kosta.message.model.MessageReceiverModel"%>
<%@page import="kosta.message.dao.MessageDao"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="kosta.etc.ETC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String receiverNo = request.getParameter("receiverNo");
	Emp emp = (Emp)session.getAttribute("loginEmp");
	
	if(ETC.isNotNull(emp) && ETC.isNotNull(receiverNo)){
		MessageDao dao = MessageDao.getInstance();
		MessageModel messageModel = new MessageModel();
		
		messageModel.setMessage_sender_no(emp.getEmp_no());
		messageModel.setMessage_receiver_no(Integer.parseInt(receiverNo));
		
		List<MessageModel> list = dao.selectMessageModelsBySenderNoAndReceiverNo(messageModel);
		
		if(!list.isEmpty()){
			String json = JSONArray.fromObject(list).toString();
			out.print(json);
		}else{
			out.print("[{\"fail\":\"fail\"}]");
		}
	}
%>