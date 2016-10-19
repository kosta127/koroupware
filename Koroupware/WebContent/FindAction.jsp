<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디/비밀번호 찾기</title>
</head>
<body>
	<h1>아이디 찾기</h1>
	<form action="FindIdProcess.do" method="post">
		회원 번호 : <input type="text" name = "find_no">
		<input type="submit" value="아이디 찾기">
	</form>

	<h1> 비밀번호 찾기</h1>
	<form action="FindPasswordProcess.do" method="post">
		아이디 : <input type ="text" name = "find_id">
		회원 번호 : <input type="text" name = "find_no">
		<input type="submit" value="비밀번호 찾기">
	</form>	
</body>
</html>

