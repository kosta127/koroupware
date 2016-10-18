<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀 번호 결과</title>
<script type="text/javascript">
function backpage() {
	location.href="login.jsp";
}
</script>
</head>
<body>
<h1>비밀 번호 결과</h1>
회원님의 이메일<%=session.getAttribute("sendemail_to") %>로  임시비밀번호를 보냈습니다.
<button onclick="backpage()">확인</button>
</body>
</html>