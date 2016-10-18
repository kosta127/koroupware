<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js" ></script>
<script src="js/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
	<br><br>
	
	<table border="1">
		<tr>
			<td>문서종류</td>
			<td>${elec_authDetail.doc_title }</td>
			<td>결재마감일</td>
			<td>${elec_authDetail.elec_auth_enddate }</td>
		</tr>
		<tr>
			<td>문서번호</td>
			<td>${elec_authDetail.elec_auth_no }</td>
			<td>작성일자</td>
			<td>${elec_authDetail.elec_auth_regdate }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${elec_authDetail.emp_name }</td>
			<td>보존년한</td>
			<td>${elec_authDetail.elec_auth_con_period }</td>
		</tr>
	</table>
	<br><br>
	
	<table border="1">
		<tr>
			<td></td>
			<c:forEach var="a" items="${elec_authDetailApproval }">				
				<td>${a.office_name }</td>
			</c:forEach>
		</tr>
		<tr>
			<td>승인</td>
			<c:forEach var="b" items="${elec_authDetailApproval }">
			<td>${b.approval_list_pass }</td>
			</c:forEach>
		</tr>
		<tr>
			<td>참조자</td>
			<td><c:forEach var="d" items="${elec_authDetailReferrer }">
			${d.dept_name}: ${d.emp_name }/ </c:forEach></td>
	</table>
	<br><br>
	
	<h3>상세입력</h3>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${elec_authDetail.elec_auth_title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${elec_authDetail.elec_auth_contents }</td>
	</table>
	<br>
	
	<input type="button" name="print2" value="인쇄">
	<br>
	
	<h3>@결재 진행 상태 및 의견</h3>
	<table border="1">
		<tr>
			<th>분류</th>
			<th>결재자명</th>
			<th>결재일시</th>
			<th>상태</th>
		</tr>
		<c:forEach var="c" items="${elec_authDetailApproval }">
			<tr>
				<td><c:if test="${elec_authDetail.emp_no==c.emp_no }">기안자</c:if>
						<c:if test="${elec_authDetail.emp_no!=c.emp_no }">결재자</c:if>
				</td>
				<td>${c.emp_name }</td>
				<td>${c.approval_list_date }</td>
				<td>${c.approval_list_pass }</td>			
			</tr>
		</c:forEach>		
	</table>
	
</body>
</html>