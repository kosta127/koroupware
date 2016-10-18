<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
	<form action="modify.do" method="post">
	<input type="hidden" name="board_no" value="${board_no}">
		<table border="1">
			<tr height="30">
				<td width="80">제목</td>
				<td align="left" colspan="3">
					<input type="text" name="board_title" size="20">			
				</td>			
			</tr>		
			<tr height="30">			
				<td colspan="4">
					<textarea rows="10" cols="70" name="board_contents"></textarea>
				</td>			
			</tr>
		</table>
		<input type="submit" value="수정완료">
	</form>
</body>
</html>