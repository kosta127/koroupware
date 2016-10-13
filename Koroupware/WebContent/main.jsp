<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인</title>
<script type="text/javascript">
function logout() {
	location.href="login.jsp"
}
function signUpdate(){
	location.href="../signUpdate/signUpdateForm.jsp"
}
</script>

</head>
<body>
<h1><%=session.getAttribute("emp_id")%></h1>
<button onclick="signUpdate()">정보변경</button>
<button onclick="logout()">로그아웃</button>

</body>
</html>