<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript">
		var $messageBox = $("#messageBox");
		
		function messageBoxUpdate(){
			$messageBox.
		}

		$(function(){
			var messageBoxIntervalId;
			
			messageBoxIntervalId = setInterval(messageBoxUpdate, 1000);
		});
	</script>
</head>
<body>
	<div id="messageBox">
		<c:forEach var="messageModel" items="${messageModelList}">
			대화내용 : ${messageModel.message_contents}<br>
			보낸 날짜 : ${messageModel.message_senddate} <%-- <fmt:formatDate value="" pattern="yyyy-mm-dd hh:MM:ss"/> --%><br>
			보낸 사람 : ${messageModel.sender_name} 부서:${messageModel.sender_dept_name} 
				직위직책:${messageModel.sender_office_name} ${messageModel.sender_position_name}<br>
			받는 사람 : ${messageModel.receiver_name} 부서:${messageModel.receiver_dept_name} 
				직위직책:${messageModel.receiver_office_name} ${messageModel.receiver_position_name}<br>
			<br><br>
		</c:forEach>
	</div>
	<form action="messageSend.do" method="POST" id="sendForm">
		<input type="text" name="messageContents"/>
		<input type="submit" value="전송"/>
	</form>
	<ol>
		<c:forEach var="messageReceiverModel" items="${messageReceiverModelList}">
			<li><a href="#">${messageReceiverModel.emp_name}</a></li>
		</c:forEach>
	</ol>
</body>
</html>