<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
	div.col-md-8{
		margin-top: 10em
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		<table border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		<tr height="30">
			<th>no</th>
			<th>문서함명</th>
			<th>생성일</th>
			<th></th>
		</tr>
		<c:forEach var="doc_box" items="${list}">
			<tr>
				<td>${doc_box.doc_box_no }</td>
				<td><a href="detailDoc_box.do?doc_box_no=${doc_box.doc_box_no}">${doc_box.doc_box_name }</a></td>
				<td>${doc_box.doc_box_regdate }</td>
				<td><a href="deleteDoc_box_management.do?doc_box_no=${doc_box.doc_box_no}">삭제</a></td>
			</tr>
		</c:forEach>
		
	</table>
	<form action="Doc_boxForm.do" method="post">
		<input type="submit" value="문서함 추가" class="btn btn-default">
	</form>
		</div>
		<div class="col-md-2"></div>
	</div>
	
</body>
</html>