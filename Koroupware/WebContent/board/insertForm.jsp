<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항</h1>
	<form action="insert.do" method="post" enctype="multipart/form-data">
		<table border="1" cellpadding="0" cellspacing="0">
		
		<tr height="30">
			<td width="80">제목</td>
			<td align="left" colspan="3">
				<c:choose>
					<c:when test="${board_no == null }">
						<input type="text" name="board_title" size="50">	
					</c:when>
					<c:otherwise>
						<input type="text" name="board_title" size="50"
									value="[re]: ${board.board_title }">	
					</c:otherwise>
				</c:choose>					
			</td>			
		</tr>		
		<!-- <tr height="30">
			<td width="80">작성자</td>
			<td width="170">
				<input type="text" name="board_name" size="10">
			</td>	
		</tr>
		<tr height="30">		
			<td>파일</td>
			<td colspan="3">
				<input type="file" name="b_fname">	
			</td>
		</tr> -->
		<tr height="30">
			<td colspan="4">
				<textarea rows="10" cols="70" name="board_contents"></textarea>
			</td>			
		</tr>
		<tr height="30">			
			<td colspan="4" align="center">
				<input type="submit" value="글쓰기">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
			</td>			
		</tr>
	</table>
	</form>
</body>
</html>