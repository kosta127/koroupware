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
			<th>문서번호</th>
			<td>${elec_auth.doc_no }</td>
			<th>상신부서</th>
			<td>${elec_auth.dept_no }</td>
		</tr>
		<tr>
			<th>사원번호</th>
			<td>${elec_auth.emp_no }</td>
			<th>관리부서</th>
			<td>${elec_auth.elec_auth_management_dept_no }</td>
	</table>
</body>
</html>