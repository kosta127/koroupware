<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Insert title here</title>

<style type="text/css">
	div.col-md-8{
		margin-top: 10em;
		margin-left: 10em;
	}
</style>
<script type="text/javascript">
	function fn_addDoc(){
		location.href="DocForm.do?emp_no="+${emp_no}+"&doc_box_no="+${doc_box_no};
	}
	function fn_listDocHis(){
		location.href="listDoc_his.do?emp_no="+${emp_no}+"&doc_box_no="+${doc_box_no};
	}
	function fn_detailDoc_box(){
		location.href="detailDoc_box.do?doc_box_no=${doc_box_no}&emp_no=${emp_no}";
	}

</script>
</head>
<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<div class="col-md-8">
			<form action="insertDoc_management.do?doc_box_no=${doc_box_no }&emp_no=${emp_no}" method="post">
		<table border="1" cellpadding="0" cellspacing="0" id="checklist" class="table table-hover">
			<tr height="30">
				<th>선택</th>
				<th>No</th>
				<th>제목</th>
				<th>보존년한</th>
				<th></th>
			</tr>
		
			<c:forEach var="doc" items="${list}">
			<c:if test="${doc.doc_deldate == null }">
			<tr>
				<td><input type="checkbox" name="doc_no" value=${doc.doc_no }></td>
				<td>${doc.doc_no }</td>
				<td><a href="detailDoc.do?doc_no=${doc.doc_no}&doc_box_no=${doc_box_no}&emp_no=${emp_no}">${doc.doc_title }</a></td>
				<td>${doc.doc_con_period }</td>
				<td><a href="deleteDoc.do?doc_no=${doc.doc_no}&doc_box_no=${doc_box_no}&emp_no=${emp_no}">삭제</a></td>
			</tr>
			</c:if>
			
			</c:forEach>
		
			</table>
			<input type="submit" value="문서함에 문서 추가" class="btn btn-default">
			<input type="button" value="문서 추가" class="btn btn-default" onclick="fn_addDoc()">
			<input type="button" value="문서수정이력보기" class="btn btn-default" onclick="fn_listDocHis()">
			<input type="button" value="돌아가기" class="btn btn-default" onclick="fn_detailDoc_box()">
			</form>
			
		</div>
		
	
	
	
</body>
</html> 