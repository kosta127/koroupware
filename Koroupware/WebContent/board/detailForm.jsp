<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<link rel="stylesheet" type="text/css" href="../css/boardDetail.css"/>
	<!--  -->
	
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
	
	<!-- 사용자 js -->
	<script type="text/javascript">
		function board_modify() {
			location.href="modifyForm.do?board_no=${board.board_no}";
		}
		function board_list() {
			location.href="listBoard.do";
		}
		function board_delete() {
			location.href="delete.do?board_no=${board.board_no}";
		}
		function show_reply() {
			$("div#replyDiv").toggle();
		}
		function reply_delete(param){
			location.href="deleteReply.do?reply_no="+param+"&board_no=${board.board_no}";
		}
	</script>
<!-- <style>
.btn{
	background-color: #00A5FF;
	color: white;
	
}
</style> -->
</head>
<body>
<h1>글 상세보기</h1>
	<table border="1">
		<tr height="30">
			<td align="center">번호</td>
			<td>${board.board_no }</td>
		</tr>
		<tr height="30">
			<td align="center">제목</td>
			<td>${board.board_title}</td>
		</tr>
		<tr height="30">
			<td align="center">파일</td>
			<td>
				<c:forEach items="${boardFileList}" var="boardfile">
					<a href="download.jsp?board_file_real_name=${boardfile.board_file_real_name}">${boardfile.board_file_real_name}</a>
				</c:forEach>
			</td>
		</tr>
		<tr height="30">
			<td align="center">작성날짜</td>
			<td>
				<fmt:formatDate value="${board.board_regdate }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr height="30">
			<td colspan="2">${board.board_contents }</td>
		</tr>
		
	</table>
	<input type="button" class="btn btn-default" value="댓글" onclick="show_reply()">
	<input type="button" class="btn btn-default" value="수정" onclick="board_modify()">
	<input type="button" class="btn btn-default" value="목록" onclick="board_list()">
	<input type="button" class="btn btn-default" value="삭제" onclick="board_delete()">
	
	<br><br>
	
	<div id="replyDiv">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr height="30">
				<td width="250" align="center">작성자</td>
				<td align="center">내용</td>
				<td width="150" align="center">등록일</td>
				<td align="center"></td>
			</tr>
		<c:forEach var="replyModel" items="${replyList }">
			<input type="hidden" value="${replyModel.reply_no}" name="reply_no">
			<tr height="30">
				<td>${replyModel.emp_name}</td>
				<td class="reply_contents">${replyModel.reply_contents}</td>
				<td>${replyModel.reply_regdate}</td>	
				<td>
					<input type="button" value="삭제" class="btn btn-default" onclick="reply_delete(${replyModel.reply_no})">
				</td>	
			</tr>
		</c:forEach>
		</table>
	</div>
	<form action="reply.do" method="post">
			<input type="hidden" name="board_no" value="${board.board_no }">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr height="10">
					<td align="center">작성자</td>
					<td>
						<textarea cols="40" rows="1" name="reply_contents"></textarea>
					</td>
					<td colspan="4">
						<input type="submit" class="btn btn-default" value="등록">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>