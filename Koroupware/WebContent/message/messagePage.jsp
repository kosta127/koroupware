<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.structure.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	
	<!-- 사용자 js -->
	<!-- <script type="text/javascript" src="js/messagePage.js"></script> -->
	<!--  -->
	<!-- 사용자 css -->
	<!-- <link rel="stylesheet" type="text/css" href="css/messagePage.css"/> -->
	<!--  -->
	
	<style type="text/css">
		.myMessage{
			font-size:22px;
			text-align:right;
		}
		
		.receiverMessage{
			font-size:22px;
			text-align:left;
		}
			
		.messageSendDate{
			font-size:10px;
		}
		
		.messageReceiver{
			font-size:30px;
			font-weight:bold;
			text-align:center;
		}
		
		div#messageBox{
			overflow:scroll;
			width: 780px;
			height: 400px;
		}
		
		div#messageReceiverListDiv{
			margin-top:20px;
			overflow:scroll;
			width: 280px;
			height: 310px;
		}
	</style>
	<script type="text/javascript">
		var $sendForm;
		var $messageBox;
		var $messageReceiverList;
		var $messageReceivers;	
		var $searchEmpText;
		var messageBoxIntervalId;
		var receiverEmpNo;
	
		function setMessageBox(data){
			if(data[0].fail){
				$("div#senderInfo").html(" ");
				$messageBox.html(" ");
			}else{
				$("div#senderInfo").html(data[0].receiver_dept_name + " - " + 
						data[0].receiver_name + data[0].receiver_office_name +
						"(" + data[0].receiver_position_name + ")");
				var html = "";
				
				for(var i = 0; i < data.length; i++){
					var contents = data[i].message_contents;
					var senddate = data[i].message_senddate;
					var receiverNo = data[i].message_receiver_no;
	
					if(receiverNo == receiverEmpNo){
						html += "<div class='myMessage'>" + contents + "<span class='messageSendDate'>" + senddate + "</span></div>";
					}else{
						html += "<div class='receiverMessage'>" + contents + "<span class='messageSendDate'>" + senddate + "</span></div>";
					}
				}
	
				$messageBox.html(html);
			}
		}
	
		function messageReceiverSelect(event){
			receiverEmpNo = $(this).find("span#receiverEmpNoText").text();
			$("form#sendForm>input#receiverEmpNo").val(receiverEmpNo);
		}
	
		function messageBoxUpdate(){
			if(receiverEmpNo != null){
				$.ajax({
					url : "message/ajax/messageReceiveAjax.jsp",
					type : "POST",
					dataType : "json",
					data : "receiverNo=" + receiverEmpNo,
					success : setMessageBox
				});
			}else{
				$("div#senderInfo").html(" ");
				$messageBox.html(" ");
			}
		}
	
		function messageSendEvent(event){
			var $textarea =  $(this).find("textarea");
			var text = $textarea.val();
			
			$.ajax({
				url : "message/ajax/messageSendAjax.jsp",
				type : "POST",
				data : "receiverEmpNo=" + receiverEmpNo + "&messageContents=" + text
			});
	
			$textarea.val("");
			$messageBox.scrollTop($messageBox.prop("scrollHeight"));
			event.preventDefault();
		}
	
		function searchEmpEvent(){
			var text = $(this).val();
			
			$.ajax({
				url : "ajax/searchEmpAjax.jsp",
				type : "POST",
				dataType : "json",
				data : "searchKeyword=" + text,
				success : autoCompleteEmpName
			});
		}
	
		function autoCompleteEmpName(data){
			var arr = new Array();
			
			for(var i = 0; i < data.length; i++){
				arr[i] = data[i].dept_name + " - " + data[i].emp_name + data[i].office_name + " (" + data[i].position_name + ")";
			}
			
			$searchEmpText.autocomplete({
				source : arr,
				select : function(){
					for(var i = 0; i < data.length; i++){
						if(arr[i] == $(this).val()){
							receiverEmpNo = data[i].emp_no;
							break;
						}
					}
				}
			});
		}
	
		function variableInit(){
			messageBoxIntervalId = setInterval(messageBoxUpdate, 1000);
			$messageReceiverList = $("ol#messageReceiverList");
			$messageReceivers = $messageReceiverList.find("li");
			$messageBox = $("div#messageBox");
			$sendForm = $("form#sendForm");
			$searchEmpText = $("input#searchEmpText");
		}
	
		function functionInit(){
			$messageReceivers.on("click", $messageReceiverList, messageReceiverSelect);
			$sendForm.on("submit", messageSendEvent);
			$searchEmpText.on("keydown", searchEmpEvent);
		}
	
		$(function(){
			variableInit();
			functionInit();
		});

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