<%@page import="kosta.message.model.Message"%>
<%@page import="kosta.emp.model.Emp"%>
<%@page import="kosta.message.model.MessageModel"%>
<%@page import="kosta.message.model.MessageReceiverModel"%>
<%@page import="kosta.message.dao.MessageDao"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="kosta.etc.ETC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	Emp loginEmp = (Emp)session.getAttribute("loginEmp");
	MessageDao dao = MessageDao.getInstance();
	
	String receiverEmpNo = request.getParameter("receiverEmpNo");
	String messageContents = request.getParameter("messageContents");
	
	Message message = new Message();
	message.setMessage_contents(messageContents);
	message.setMessage_sender_no(loginEmp.getEmp_no());
	message.setMessage_receiver_no(Integer.parseInt(receiverEmpNo));
	
	int result = dao.insertMessage(message);
%>