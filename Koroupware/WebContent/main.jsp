
<%@page import="kosta.emp.model.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	Emp emp = (Emp) session.getAttribute("emp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인</title>
<script type="text/javascript">
	function logout() {
		location.href = "login.jsp"
	}
	function signUpdate() {
		location.href = "signUpdateForm.jsp"
	}
</script>

</head>
<body>
	<img alt="logo" src="main.gif">
	<h2>${emp.emp_name }</h2>
	<br>
	<c:if test="${emp.emp_img != null }">
		<c:set var="head"
			value="${fun:substring(emp.emp_img, 0, fun:length(emp.emp_img) - 4) }"></c:set>
		<c:set var="pattern" value="${fun:substringAfter(emp.emp_img, head) }"></c:set>
		<img src="upload/${head }_small${pattern}"
			alt="${head }_small${pattern}" />
	</c:if>
	<button onclick="signUpdate()">정보변경</button>
	<button onclick="logout()">로그아웃</button>
	<br>
	
	<ul>
		<li><a>문서</a></li>
		<li><a>결재</a></li>
		<li><a href="listBoard.do">커뮤니티</a></li>
		<li><a>조직도</a></li>
		<li><a href="messagePage.do">쪽지</a></li>
	</ul>
	<br>
	<form action="SearchAction.do" method="get">
		검색을 하시오<input type="text" name="search_content"> <input
			type="submit" value="검색"><br>
	</form>


</body>
</html>