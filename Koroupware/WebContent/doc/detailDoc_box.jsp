<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_listDoc(){
		location.href="listDoc.do?doc_box_no="+${doc_box_no}+"&emp_no="+${emp_no};
	}
</script>
</head>
<body>
	<a href="updateDoc_boxForm.do?doc_box_no=${doc_box.doc_box_no}&emp_no=${emp_no }">${doc_box.doc_box_name}</a>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr height="30">
			<th>글제목</th>
			<th>보존년한</th>
			<th></th>
		</tr>
		<c:forEach var="doc" items="${list }">
			<tr height="30">
				<td><a href="detailDoc.do?doc_no=${doc.doc_no}&doc_box_no=${doc_box_no}&emp_no=${emp_no}">${doc.doc_title }</a></td>
				<td>${doc.doc_con_period }</td>
				<td><a href="deleteDoc_management.do?doc_no=${doc.doc_no }&emp_no=${emp_no}&doc_box_no=${doc_box_no}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="button" value="문서함에 문서 추가" onclick="fn_listDoc()">
</body>
</html>