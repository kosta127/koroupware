<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/elec_auth_write.css" rel="stylesheet">
<script src="ckeditor/ckeditor.js"></script>
<script src="js/jquery.js"></script>
<script src="js/elec_auth_write.js"></script>
<!-- <script>alert(window.location.pathname);location.href="js/elec_auth_write.js"</script> -->
<title>Insert title here</title>
</head>
<body>
<c:forEach var="doc" items="${docFormList}">
<c:if test="${doc.doc_no == 4 }"><c:out value="${ doc.doc_contents}" /></c:if></c:forEach>
	<div>
		<h1>결재작성</h1>
		<form id="elec_auth_form" action="elec_authSubmission.do" method="post">
			<div id="emp_div">
				안건 작성자 
				<input type="hidden" name="emp_no" id="emp_no" value="${4 }">
			</div>
			<div id="manage_dept_div">
			관리 부서 <input type="text" name="management_dept_name" id="management_dept_name" value="${'히히' }" readonly="readonly">
			<input type="hidden" name="elec_auth_management_dept_no" id="elec_auth_management_dept_no" value="${1 }">
			</div>
			<div id="docform_div">
				문서 양식 선택
				<select id="docFormList" name="doc_no">
					<option value="" disabled="disabled" selected="selected">양식을 선택하세요</option>
					<c:forEach var="doc" items="${docFormList }">
						<option value="${doc.doc_no }">${doc.doc_title }</option>
					</c:forEach>
				</select>
			</div>
			<div id="enddate_div">
				결재 마감일  <input type="date" name="elec_auth_enddate" id="elec_auth_enddate" required="required">
			</div>
			<div id="conperiod_div">
			보존년한 <input type="date" name="elec_auth_con_period" id="elec_auth_con_period" required="required">
			</div>
			<div id="title_div">
			안건 제목 <input type="text" name="elec_auth_title" id="elec_auth_title" required="required">
			</div>
			<div id="contents_div">
			<textarea name="elec_auth_contents" id="elec_auth_contents" required="required"></textarea>
			</div>
			<div id="approval_div">
				결재자 <input type="text" name="elec_auth_approval_name" id="elec_auth_approval_name">
				<br>
				결재자 검색 결과<br>
				<div id="approval_search_list">
				</div>
				결재자 목록<br>
				<div id="approval_list">
				</div>
			</div>
			<div id="referrer_div">
				참조자 <input type="text" name="elec_auth_referrer_name" id="elec_auth_referrer_name">
				<br>
				참조자 검색 결과<br>
				<div id="referrer_search_list">
				</div>
				참조자 목록<br>
				<div id="referrer_list">			
				</div>
			</div>
			<div id="btn_div">
				<input type="button" value="임시저장" id="elec_auth_temp_save">
				<input type="submit" value="제출">
				<input type="button" value="취소" id="elec_auth_cancel">
			</div>
		</form>		
	</div>
</body>
</html>