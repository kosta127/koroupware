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
<h2>결재</h2>

<table border="1">
	<thead>
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>내용</th>
			<th>등록일</th>
			<th>비고</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="i" items="${elec_authList }"> 
			<tr>
				<td>${i.elec_auth_no }</td>
				<td>${i.elec_auth_title }</td>
				<td>${i.elec_auth_contents }</td>
				<td>${i.elec_auth_regdate }</td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<input type="button" value="결재작성">

</body>
</html>