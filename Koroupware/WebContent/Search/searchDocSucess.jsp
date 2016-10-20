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
  	<td>문서 번호</td>
  	<td>작성자 이름</td>
  	<td>문서 제목</td>
  	<td>작성일</td>
  </tr>
<c:forEach var="Search" items="${SearchDoc}">
  <tr>  
  <td>${Search.doc_no}</td>
  <td>${Search.emp_name}</td>
  <td> ${Search.doc_title}</td> 
  <td>${Search.doc_con_period}</td>
  </tr>
</c:forEach>
</table>

</body>
</html>