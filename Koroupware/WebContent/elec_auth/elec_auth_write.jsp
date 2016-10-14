<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="ckeditor/ckeditor.js"></script>
<script src="js/jquery.js"></script>
<script src="js/elec_auth_write.js"></script>
<!-- <script>alert(window.location.pathname);location.href="js/elec_auth_write.js"</script> -->
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>결재작성</h1>
		<form action="elec_authSubmission.do" method="post">
			안건 작성자 
			<input type="hidden" name="emp_no" id="emp_no" value="${4 }">
			<br>
			관리 부서 <input type="text" name="management_dept_name" id="management_dept_name"><input type="button" value="검색">
			<input type="hidden" name="elec_auth_management_dept_no" id="elec_auth_management_dept_no">
			<br>
			문서 양식 선택
			<br><input type="button" value="선택">
			<br>
			결재 마감일  <input type="date" name="elec_auth_processing_period" id="elec_auth_processing_period">
			<br>
			보존년한 <input type="date" name="elec_auth_con_period" id="elec_auth_con_period">
			<br>
			안건 제목 <input type="text" name="elec_auth_title" id="elec_auth_title">
			<br>
			<textarea name="elec_auth_contents" id="elec_auth_contents"></textarea>
			<br>
			결재자 <input type="text" name="elec_auth_approval_name" id="elec_auth_approval_name">
			<br>
			<div id="approval_list">			
			</div>
			<br>
			참조자 <input type="text" name="elec_auth_referrer_name" id="elec_auth_referrer_name">
			<br>
			<div id="refferer_list">
			
			</div>
			<br>
			<input type="button" value="임시저장" id="elec_auth_temp_save">
			<input type="submit" value="제출">
			<input type="button" value="취소" id="elec_auth_cancel">
		</form>		
	</div>
</body>
</html>