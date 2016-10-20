<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/elec_auth_detail.css">
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="printTool/jQuery.print.js"></script>
<script type="text/javascript">
	$(function() {
		$("input#printButton").on('click',function() {
			var nowDate = new Date();
			$("#printable").print({
				//Use Global styles
				globalStyles : false,
				//Add link with attrbute media=print
				mediaPrint : false,
				//Custom stylesheet
				stylesheet : "http://fonts.googleapis.com/css?family=Inconsolata",
				//Print in a hidden iframe
				iframe : false,
				//Don't print this
				noPrintSelector : ".avoid-this",
				//Add this at top
				prepend : "인쇄 미리보기",
				//Add this on bottom
				append : new Date()
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<div id="printable">
		<table class="table table-bordered" id="tabel1" border=1 width=60%>
			<tr>
				<td width=15%>문서종류</td>
				<td width=30%>${elec_authDetail.doc_title }</td>
				<td width=15%>결재마감일</td>
				<td width=30%>${elec_authDetail.elec_auth_enddate }</td>
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
		<br> <br>

		<table class="table table-bordered" id="table2" border=1 width=60%>
			<tr>
				<td width=15%></td>
				<c:forEach var="a" items="${elec_authDetailApproval }">
					<td width=85%>${a.office_name }</td>
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
		<br> <br>

		<h3>상세입력</h3>
		<table class="table table-bordered" id="table3" border=1 width=60%>
			<tr>
				<td width=15%>제목</td>
				<td width=85%>${elec_authDetail.elec_auth_title }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${elec_authDetail.elec_auth_contents }</td>
		</table>
		<br> <br>

		<h3>@결재 진행 상태 및 의견</h3>
		<table class="table table-bordered" id="table4" border=1 width=60%>
			<tr>
				<th width=25%>분류</th>
				<th width=25%>결재자명</th>
				<th width=25%>결재일시</th>
				<th width=25%>상태</th>
			</tr>
			<c:forEach var="c" items="${elec_authDetailApproval }">
				<tr>
					<td><c:if test="${elec_authDetail.emp_no==c.emp_no }">기안자</c:if>
						<c:if test="${elec_authDetail.emp_no!=c.emp_no }">결재자</c:if></td>
					<td>${c.emp_name }</td>
					<td>${c.approval_list_date }</td>
					<td>${c.approval_list_pass }</td>
				</tr>
			</c:forEach>
		</table><br>
	</div>
	<input id="printButton" type="button" class="btn btn-success" name="print2" value="인쇄">
</body>
</html>