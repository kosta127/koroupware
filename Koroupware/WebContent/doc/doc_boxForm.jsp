<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="doc_boxProc.do" method="post">
		<input type="hidden" name="emp_no" value="${emp_no }">
		문서함명 : <input type="text" name="doc_box_name">&nbsp;&nbsp;&nbsp;
		<input type="submit" value="생성">
	</form>
</body>
</html>