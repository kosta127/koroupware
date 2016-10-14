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
		<tr>
			<th>직위</th>
			<td>${elec_authDetail.position_name }</td>
		</tr>
		<tr>
			<th>직급</th>
			<td>${elec_authDetail.office_name }</td>
		</tr>
	</table>
	
	<h3>결재</h3>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>직위</th>
			<th>직급</th>
			<th>승인</th>
		</tr>
		<tr>
			<td></td>
		</tr>
			
	</table>
	
	<h3>내용</h3>
	<textarea rows="10" cols="100">${elec_authDetail.elec_auth_contents }</textarea>
	
	
</body>
</html>