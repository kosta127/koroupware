<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../ckeditor/ckeditor.js"></script>
<script src="../js/elecauthWrite.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>결재작성</h1>
		<form action="elec_authSubmission.do" method="post">
			안건 작성자 
			<input type="hidden" name="emp_no" id="emp_no" value="${4 }">
			<br>
			상신 부서 <input type="text" name="send_dept_name" id="send_dept_name"><input type="button" value="검색">
			<input type="hidden" name="elec_auth_send_dept_no" id="elec_auth_send_dept_no">
			<br>
			관리 부서 <input type="text" name="management_dept_name" id="management_dept_name"><input type="button" value="검색">
			<input type="hidden" name="elec_auth_management_dept_no" id="elec_auth_management_dept_no">
			<br>
			문서 양식 선택
			<br><input type="button" value="선택">
			<br>
			안건 제목 <input type="text" name="elec_auth_title" id="elec_auth_title">
			<br>
			<textarea name="elec_auth_contents" id="elec_auth_contents"></textarea>
			<br>
			<ul>
				<li><a href="#">기본 정보</a></li>
				<li><a href="#">결재 서류 정보</a></li>
				<li><a href="#">결재선 정보</a></li>
				<li><a href="#">참조자 정보</a></li>
			</ul>
			<br>
			<input type="button" value="임시저장">
			<input type="submit" value="제출">
			<input type="button" value="취소">
		</form>		
	</div>
</body>
</html>