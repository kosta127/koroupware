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
		location.href="DocForm.do?emp_no="+${emp_no}+"&doc_box_no="+${doc_box_no};
	}
	function fn_listDocHis(){
		location.href="listDoc_his.do?emp_no="+${emp_no}+"&doc_box_no="+${doc_box_no};
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
			<input type="submit" value="문서함에 문서 추가">
			<input type="button" value="문서 추가" onclick="fn_addDoc()">
			<input type="button" value="문서수정이력보기" onclick="fn_listDocHis()">
	</form>
	
	
</body>
</html> 