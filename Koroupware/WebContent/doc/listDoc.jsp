<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fn_addDoc(){
	location.href="docForm.do?emp_no="+${emp_no}+"&doc_box_no="+${doc_box_no};
}
</script>
</head>
<body>
	<form action="insertDoc_management.do?doc_box_no=${doc_box_no }&emp_no=${emp_no}" method="post">
	<table border="1" cellpadding="0" cellspacing="0" id="checklist">
		<tr height="30">
			<th>선택</th>
			<th>No</th>
			<th>제목</th>
			<th>보존년한</th>
		</tr>
		
		<c:forEach var="doc" items="${list}">
		
			<tr>
				<td><input type="checkbox" name="doc_no" value=${doc.doc_no }></td>
				<td>${doc.doc_no }</td>
				<td><a href="detailDoc.do?doc_no=${doc.doc_no}&doc_box_no=${doc_box_no}">${doc.doc_title }</a></td>
				<td>${doc.doc_con_period }</td>
			</tr>
		</c:forEach>
		
	</table>
			<input type="submit" value="문서함에 문서 추가">
	</form>
	<input type="button" value="문서추가" onclick="fn_addDoc()">
</body>
</html> 