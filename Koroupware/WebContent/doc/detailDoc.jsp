<%@page import="kosta.doc.model.FileDownloadHelper"%>
<%@page import="java.net.URLEncoder"%>
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
	<table border="1" cellpadding="0" cellspacing="0">
		<tr height="30">
			<th>제목</th>
			<td>${doc.doc_title }</td>
		</tr>
		<tr height="30">
			<th>작성자</th>
			<td>${emp_name }</td>
		</tr>
		
		<tr height="30">
			<th>설명</th>
			<td>${doc.doc_explain }</td>
		</tr>
		<tr height="30">
			<th>내용</th>
			<td>${doc.doc_contents }</td>
		</tr>
		<tr height="30">
			<th>파일</th>
			<c:forEach var="doc_file" items="${list }">
			<td><a href="doc/downloadDoc.jsp?doc_file_real_name=
					${doc_file.doc_file_real_name}">${doc_file.doc_file_real_name }</a></td>
			</c:forEach>
		</tr>
	</table>
	
	
</body>
</html>