<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function board_modify() {
		location.href="modifyForm.do?board_no=${board.board_no}";
	}
	function board_list() {
		location.href="listBoard.do";
	}
</script>
</head>
<body>
	<table border="1">

		<tr>
			<td>제목</td>
			<td>${board.board_title}</td>
		</tr>
		<tr>
			<td>작성날짜</td>
			<td align="center">
				<fmt:formatDate value="${board.board_regdate }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">${board.board_contents }</td>
		</tr>
		
	</table>
	<input type="button" value="수정" onclick="board_modify()">
	<input type="button" value="목록" onclick="board_list()">
</body>
</html>