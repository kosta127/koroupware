<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>문서함명 수정</h1>
	<form action="updateDoc_box_Proc.do?doc_box_no=${doc_box_no }&emp_no=${emp_no}" method="post">
		문서함명 : <input type="text" name="doc_box_name">
		<input type="submit" value="수정">
	</form>
</body>
</html>