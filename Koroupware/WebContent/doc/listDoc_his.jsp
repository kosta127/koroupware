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
	<h1>문서 수정 이력</h1>
	<c:forEach var="doc_his" items="${list }">
	<table border="1" cellpadding="0" cellspacing="0">
			<tr height="30">
				<th>문서수정이력번호</th>
				<td>${doc_his.doc_his_no }</td> 
			</tr>
			<tr height="30">
				<th>변경사유</th>
				<td>${doc_his.doc_his_reason_change }</td> 
			</tr>
			<tr height="30">
				<th>문서수정일</th>
				<td>${doc_his.doc_his_moddate }</td> 
			</tr>
			<tr height="30">
				<th>재개정구분</th>
				<td>${doc_his.doc_his_revise }</td> 
			</tr>
			<br><br>
	</table>
	</c:forEach>
	<form action="listDoc.do?emp_no=${emp_no }&doc_box_no=${doc_box_no}" method="post">
		<input type="submit" value="돌아가기">
	</form>
</body>
</html>