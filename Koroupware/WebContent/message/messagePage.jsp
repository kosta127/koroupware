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
   <!-- 폰트 -->
   <link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
   <link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/nanumgothic.css">
   <!-- 사용자 js -->
   <script type="text/javascript" src="message/js/messagePage.js"></script>
   <!--  -->
   <!-- 사용자 css -->
   <link rel="stylesheet" type="text/css" href="message/css/messagePage.css"/>
   <!--  -->
</head>
<body>
   <div id="container" class="container">
      <header class="row">
         <!-- 맨 위 -->
         <span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span><span class="massage-main">쪽지</span>
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
	               <div class="col-md-10 sendFormMessageBox">
	               		<input type="hidden" name="receiverEmpNo" id="receiverEmpNo"/>
	               		<textarea rows="2" cols="100" name="messageContents"></textarea>
	               </div>
	               <div class="col-md-2">
               			<input type="submit" value="전송" class="submit-button btn btn-primary"/>
				   </div>
               </form>
            </div>
         </section>
         <section class="col-md-4">
            <div>
               <!-- 사원 및 부서 검색 -->
               <h4 class="emp-dept">사원 및 부서(직책,직위) 검색</h4>
               <input type="text" id="searchEmpText" size="40px"/>
            </div>
            <div id="messageReceiverListDiv">
               <!-- 대화 리스트 -->
               <ol id="messageReceiverList">
                  <c:forEach var="messageReceiverModel" items="${messageReceiverModelList}">
                     <li class="list-emp">
                        ${messageReceiverModel.dept_name} - ${messageReceiverModel.emp_name}
                           ${messageReceiverModel.office_name} (${messageReceiverModel.position_name})
                        <span class="hidden" id="receiverEmpNoText">${messageReceiverModel.emp_no}</span>
                     </li>
                  </c:forEach>
               </ol>
            </div>
         </section>
      </section>
   </div>
</body>
</html>