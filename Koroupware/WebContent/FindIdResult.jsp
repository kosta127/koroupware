<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>아이디 찾기 결과</title>
<script type="text/javascript">
function backpage() {
	location.href="login.jsp";
}
</script>
</head>
<body>
<h1>아이디 찾기 결과</h1>>
 당신이 찾는 아이디는 <%=session.getAttribute("find_name") %> 입니다.
 <button onclick="backpage()">확인</button>
</body>
</html>