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
			<th>no</th>
			<th>문서함명</th>
			<th>생성일</th>
		</tr>
		<c:forEach var="documentbox" items="${list}">
			<tr>
				<td>${documentbox.doc_box_no }</td>
				<td><a href="listDoc.do?doc_no=${documentbox.doc_no}">${documentbox.doc_box_name }</a></td>
				<td>${documentbox.doc_box_regdate }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>