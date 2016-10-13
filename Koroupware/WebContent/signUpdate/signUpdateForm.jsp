<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">
아이디<input type="text" value="<%=session.getAttribute("emp_id")%>" disabled="disabled">
이름<input type="text" value="<%=session.getAttribute("emp_name")%>" disabled="disabled">
비밀번호<input type="password">
비밀번호 확인<input type="password">
</form>
</body>
</html>