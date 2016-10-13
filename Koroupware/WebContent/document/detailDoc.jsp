<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr height="30">
			<th>제목</th>
			<td>${document.doc_title }</td>
		</tr>
		<tr height="30">
			<th>작성자</th>
			<td>${document.emp_name }</td>
		</tr>
		<tr height="30">
			<th>설명</th>
			<td>${document.doc_explain }</td>
		</tr>
		<tr height="30">
			<th>내용</th>
			<td>${document.doc_content }</td>
		</tr>
	</table>
</body>
</html>