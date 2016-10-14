
<%@page import="kosta.emp.model.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%Emp emp = (Emp)session.getAttribute("emp");
    %>
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
	location.href="signUpdateForm.jsp"
}
function setting() {
	location.href=""
}
</script>

</head>
<body>
<img alt="logo" src="main.gif">
<h2>${emp.emp_name }</h2><br>
<button onclick="signUpdate()">정보변경</button>
<button onclick="setting()">설정</button>
<button onclick="logout()">로그아웃</button><br>

<p>문서</p>
<p>결재</p>
<p>커뮤니티</p>
<p>조직도</p><br>
검색<input type="text" name="search">
</body>
</html>