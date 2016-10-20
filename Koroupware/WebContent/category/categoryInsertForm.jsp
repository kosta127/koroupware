<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
	<script type="text/javascript" src="../js/community.js"></script>
</head>
<body>

	<form action="insertCategory.do?community_no=${community_no }" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr height="10">
					<td align="center">카테고리 명:</td>
					<td>
						<textarea cols="40" rows="1" name="category_name"></textarea>
					</td>
					<td colspan="4">
						<input type="submit" value="생성">
					</td>
				</tr>
			</table>					
	</form>
</body>
</html>
























