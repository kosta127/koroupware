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
		var $messageReceiverList;
		var $messageReceivers;
		var messageBoxIntervalId;
		var receiverEmpNo;

		function messageReceiverSelect(event){
			alert($(this).find("span").text());
		}
		
		function messageBoxUpdate(){
			if(receiverEmpNo != null){

			}
		}

		$(function(){
			//messageBoxIntervalId = setInterval(messageBoxUpdate, 1000);
			$messageReceiverList = $("ol#messageReceiverList");
			$messageReceivers = $messageReceiverList.find("li");
			$messageReceivers.attr("display", "none");
			$messageReceiverList.on("click", $messageReceivers, messageReceiverSelect);

			
		});
		
	</script>
</head>
<body>
	<div id="messageBox">
		
	</div>
	<form action="messageSend.do" method="POST" id="sendForm">
		<input type="text" name="messageContents"/>
		<input type="submit" value="전송"/>
	</form>
	<ol id="messageReceiverList">
		<c:forEach var="messageReceiverModel" items="${messageReceiverModelList}">
			<li>${messageReceiverModel.dept_name} - ${messageReceiverModel.emp_name}${messageReceiverModel.office_name}
					(${messageReceiverModel.position_name})
			<span>${messageReceiverModel.emp_no}</span></li>
		</c:forEach>
	</ol>
</body>
</html>