<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr height="30">
			<th>No</th>
			<th>제목</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="document" items="${list}">
			<tr>
				<td>${document.doc_no }</td>
				<td><a href="detailDoc.do?doc_no=${document.doc_no}">${document.doc_title }</a></td>
				<td>${document.doc_con_period }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>