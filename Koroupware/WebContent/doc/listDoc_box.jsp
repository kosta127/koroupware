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
			<th></th>
		</tr>
		<c:forEach var="doc_box" items="${list}">
			<tr>
				<td>${doc_box.doc_box_no }</td>
				<td><a href="detailDoc_box.do?doc_box_no=${doc_box.doc_box_no}&emp_no=${emp_no}">${doc_box.doc_box_name }</a></td>
				<td>${doc_box.doc_box_regdate }</td>
				<td><a href="deleteDoc_box.do?emp_no=${emp_no }&doc_box_no=${doc_box.doc_box_no}">삭제</a></td>
			</tr>
		</c:forEach>
		
	</table>
	<form action="doc_boxForm.do" method="post">
		<input type="hidden" name="emp_no" value="${emp_no }">
		<input type="submit" value="문서함 추가">
	</form>
</body>
</html>