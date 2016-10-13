<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta httpa-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function signUp(){ 
	location.href = "MakeAction.do";
}
function findUser(){
	location.href = "FindAction.jsp";
}
</script>
</head>
<body>
<form action="LoginProcessAction.do" method="post">
	아이디 : <input type="text" name="emp_id"><br>
	비밀번호 : <input type="password" name="emp_password"><br>
	<input type = "submit" value="로그인">
</form>


<button onclick="signUp()" >회원 가입</button>
<button onclick="findUser()">아이디/비밀번호 찾기</button>
</body>
</html>