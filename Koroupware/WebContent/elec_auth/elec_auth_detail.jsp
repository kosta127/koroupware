<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>문서제목</th>
			<td>${elec_authDetail.doc_title }</td>
			<th>상신부서</th>
			<td>${elec_authDetail.dept_name }</td>
		</tr>
		<tr>
			<th>사원이름</th>
			<td>${elec_authDetail.emp_name }</td>
			<th>관리부서</th>
			<td>${elec_authDetail.dept_name }</td>
		<tr>
	</table>
	<h3>결재선</h3>
	<table border="1">
		<tr>
			<td>직위</td>
			<td>${elec_authDetail.position_name }</td>
		</tr>
		<tr>
			<td>직급</td>
			<td>${elec_authDetail.office_name }</td>
		</tr>
	</table>
	
	
</body>
</html>