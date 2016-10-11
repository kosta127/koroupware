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
		<form action="" method="post">
			안건 작성자 
			<br>
			상신 부서 <input type="text"><input type="button" value="검색">
			<br>
			관리 부서 <input type="text"><input type="button" value="검색">
			<br>
			관리 번호 <input type="text">
			<br>
			안건 제목 <input type="text">
			<br>
			업무 영역 <input type="text">
			<br>
			업무 유형 <input type="text">
			<br>
			<textarea id="me"></textarea>
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