<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript">
	</script>
</head>
<body>
	<div id="chat"></div>
	<form action="messageSend.do" method="POST" id="sendForm">
		<input type="text" name="messageContents"/>
		<input type="submit" value="전송"/>
	</form>
	<ol>
		<li>1</li>
		<li>2</li>
		<li>3</li>
	</ol>

</body>
</html>