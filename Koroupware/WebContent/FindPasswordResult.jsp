<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/nanumgothic.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="./css/login.css" />

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.js"></script>
<title>비밀 번호 결과</title>
<script type="text/javascript">
function backpage() {
	location.href="login.jsp";
}
</script>
</head>
<body>
<div class="body">
	<div class="panel-success panel panel-default">
		<div class="panel-heading">
		<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span>
		</div>
		<div class="success-div">
		<span class="finds-pass1">회원님의 </span><span class="success-id"><%=session.getAttribute("sendemail_to") %></span><br><span class="finds-pass2">로  임시비밀번호를 보냈습니다.</span><br>
		</div>
		<div class="button-div">
		<button class ="find-button btn btn-success" onclick="backpage()">확인</button>
		</div>
		</div>
	</div>
</body>
</html>