<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/menu.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<style type="text/css">
	div.col-md-8{
		margin-top: 10em;
		margin-left: 10em;
	}
</style>
<body>
		<jsp:include page="../menu.jsp"></jsp:include>
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
		

	
</body>
</html>