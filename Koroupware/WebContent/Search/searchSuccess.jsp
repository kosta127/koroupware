<%@page import="kosta.emp.model.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>성공</h1>


<table border='2' align='center'>
  <tr>
  	<td>이름</td>
  	<td>부서</td>
  	<td>아이디</td>
  	<td>이메일</td>
  	<td>주소</td>
  	<td>입사일</td>
  </tr>
<c:forEach var="Search" items="${Search}">

 

  <tr>  
  <td>${Search.emp_name}</td>
  <td> ${Search.dept_name}</td>
  <td>${Search.emp_id }</td> 
  <td>${Search.emp_email }</td>
  <td>${Search.emp_address }</td>
  <td>${Search.emp_hiredate }</td>
  </tr>
</c:forEach>
</table>

</body>
</html>