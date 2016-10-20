<%@page import="kosta.doc.model.FileDownloadHelper"%>
<%@page import="java.net.URLEncoder"%>
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
<style type="text/css">
	div.col-md-8{
		margin-top: 10em;
		margin-left: 10em;
	}
</style>
<script type="text/javascript">
	function fn_back(){
		history.back(-1);
	}
</script>
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
		<div class="col-md-8">
			<table border="1" cellpadding="0" cellspacing="0" class="table table-hover">
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
			<td><a href="downloadDoc.jsp?doc_file_real_name=${doc_file_real_name}
			&doc_box_no=${doc_box_no}&doc_no=${doc_no}">${doc_file.doc_file_real_name }</a></td>
			
			</c:forEach>
		</tr>
	</table>
	<form action="updateDocForm.do?doc_no=${doc_no }&doc_box_no=${doc_box_no }&emp_no=${emp_no}" method="post">
		<input type="submit" value="수정하기 " class="btn btn-default">
		<input type="button" value="돌아가기" class="btn btn-default" onclick="fn_back()">
	</form>
		</div>
	
	
</body>
</html>