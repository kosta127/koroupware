<%@page import="kosta.emp.model.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>성공</h1>

<table>
	<tr>
		<td>회원 아이디 : <%=session.getAttribute("search_id")%></td>
		<td>회원 이름 : <%=session.getAttribute("search_name")%></td>
		<td>회원 부서 : <%=session.getAttribute("search_dept")%></td>
		<td>회원 주소 : <%=session.getAttribute("search_address")%></td>
	</tr>
</table>





</body>
</html>