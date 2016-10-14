<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.structure.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
	
	<!-- 사용자 css -->
	<link rel="stylesheet" type="text/css" href="css/messagePage.css"/>
	<!--  -->
	
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	
	<!-- 사용자 js -->
	<script type="text/javascript" src="js/messagePage.js"></script>
	<!--  -->
	<style type="text/css">
		
	</style>
	
	<script type="text/javascript">
		

		/* 
		function messageReceiverListUpdate(){
			$.ajax({
				url : "ajax/messageReceiverListAjax.jsp",
				type : "POST",
				dataType : "json",
				success : setMessageReceiverList
			});
		}
		
		function setMessageReceiverList(data){
			var html = "";

			for(var i = 0; i < data.length; i++){
				html += "<li>" + data[i].dept_name + " - " + data[i].emp_name +
								data[i].office_name + "(" + data[i].position_name +")" + 
								"<span class='hidden'>" + data[i].emp_no + "</span></li>";
			}
			
			$messageReceiverList.html(html);
		}
		 */
	</script>
</head>
<body>
	<div id="container" class="container">
		<header class="row">
			<!-- 맨 위 -->
			<h2>쪽지</h2>
			<div id="senderInfo" class="messageReceiver">
			<!-- 수신자 정보 -->
			</div>
		</header>
		<section class="row">
			<section class="col-md-8">
				<!-- 채팅내용 -->
				<div id="messageBox" class="row">
					<!-- 채팅 대화창 -->
				</div>
				<div class="row">
					<!-- 채팅 입력창 -->
					
					<form id="sendForm">
						<input type="hidden" name="receiverEmpNo" id="receiverEmpNo"/>
						<textarea rows="1" cols="100" name="messageContents"></textarea>
						<input type="submit" value="전송"/>
					</form>
				</div>
			</section>
			<section class="col-md-4">
				<div>
					<!-- 사원 및 부서 검색 -->
					<h4>사원 및 부서(직책,직위) 검색</h4>
					<input type="text" id="searchEmpText" size="40px"/>
				</div>
				<div id="messageReceiverListDiv">
					<!-- 대화 리스트 -->
					<ol id="messageReceiverList">
						<c:forEach var="messageReceiverModel" items="${messageReceiverModelList}">
							<li>${messageReceiverModel.dept_name} - ${messageReceiverModel.emp_name}${messageReceiverModel.office_name}
									(${messageReceiverModel.position_name})
							<span class="hidden" id="receiverEmpNoText">${messageReceiverModel.emp_no}</span></li>
						</c:forEach>
					</ol>
				</div>
			</section>
		</section>
	</div>
</body>
</html>