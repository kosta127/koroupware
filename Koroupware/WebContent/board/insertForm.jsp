<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.structure.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
	  
	<!-- 사용자 css -->
	
	<!--  -->
	
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
	
	<!-- 사용자 js -->
	  
	<script type="text/javascript">
		$(function(){
			CKEDITOR.replace("board_contents");
		});
	
	</script>	
	  <!--  -->
		
	
</head>
<body>
	<form action="insert.do" method="post" enctype="multipart/form-data">
		<table border="1" cellpadding="0" cellspacing="0">
		
			<tr height="30">
				<td align="center">작성자</td>
				<td align="left">
					<input type="hidden" value="${sessionScope.emp.emp_no}" name="emp_no"/>
						${sessionScope.emp.emp_name}</td>
			</tr>
			<tr>
				<td width="80" align="center">제목</td>
				<td align="left" colspan="3">		
					<input type="text" name="board_title" size="80">	
				</td>			
			</tr>
				
		<tr height="30">		
			<td align="center">파일</td>
			<td colspan="3">
				<input type="file" name="board_fname">	
			</td>
		</tr>
		<tr height="30">
			<td colspan="4">
				<textarea rows="10" cols="70" name="board_contents" id="board_contents"></textarea>
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