<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/elec_auth_write.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<script src="ckeditor/ckeditor.js"></script>
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/validation/jquery.validate.min.js"></script>
<script src="js/validation/additional-methods.min.js"></script>
<script src="js/validation/messages_ko.min.js"></script>
<script src="js/elec_auth_write.js"></script>
<!-- <script>alert(window.location.pathname);location.href="js/elec_auth_write.js"</script> -->
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>결재작성</h1>
		<form id="elec_auth_form" action="elec_authSubmission.do" method="post">
			<div id="emp_div">
				안건 작성자 ${empDetail.emp_name }
				<input type="hidden" name="emp_no" id="emp_no" value="${empDetail.emp_no }">
			</div>
			<div id="manage_dept_div">
			관리 부서 <input type="text" name="management_dept_name" id="management_dept_name" value="${empDetail.dept_name }" readonly="readonly">
			<input type="hidden" name="elec_auth_management_dept_no" id="elec_auth_management_dept_no" value="${empDetail.dept_no }">
			</div>
			<div id="docform_div">
				문서 양식 선택
				<select id="docFormList" name="doc_no">
					<option value="" disabled="disabled" selected="selected">양식을 선택하세요</option>
					<c:forEach var="doc" items="${docFormList }">
						<option value="${doc.doc_no }">${doc.doc_title }</option>						
					</c:forEach>
				</select>
				<c:forEach var="doc" items="${docFormList }">
					<div id="hidden_docform_div_${doc.doc_no }">${doc.doc_contents }</div>
				</c:forEach>
			</div>
			<div id="enddate_div">
				결재 마감일  <input type="text" name="elec_auth_enddate" id="elec_auth_enddate" readonly="readonly">
			</div>
			<div id="conperiod_div">
				보존년한 
				<select name="elec_auth_con_period" id="elec_auth_con_period">
					<c:forEach var="i" begin="1" end="10">
						<option value="${i }">${i }년</option>
					</c:forEach>
				</select>
			</div>
			<div id="title_div">
			안건 제목 <input type="text" name="elec_auth_title" id="elec_auth_title">
			</div>
			<div id="contents_div">
			<textarea name="elec_auth_contents" id="elec_auth_contents"></textarea>
			</div>
			<div id="approval_div">
				결재자 <input type="text" name="elec_auth_approval" id="elec_auth_approval">
				<br>
				결재자 목록<br>
				<div id="elec_auth_approval_list">
				</div>
			</div>
			<div id="referrer_div">
				참조자 <input type="text" name="elec_auth_referrer" id="elec_auth_referrer">
				<br>
				참조자 목록<br>
				<div id="elec_auth_referrer_list">			
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