<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.structure.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/boardList.css"/>
	  
	<!-- 사용자 css -->
	
	<!--  -->
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>
<body>
	<div class="totalList">
		<div class="row">
			<div class="col-md-2"></div>
				<div class="col-md-8">
					<a href="insertForm.do?category_no=${category_no}">글쓰기</a>
					<table border="1">
						<tr height="30">
							<td width="50" align="center">NO</td>
							<td width="300" align="center">제목</td>
							<td width="250" align="center">작성자</td>
							<td width="100" align="center">접근범위</td>
							<td width="150" align="center">등록일</td>
							<td width="100" align="center">조회수</td>
						</tr>
						<c:forEach var="board" items="${listModel.list}">
						<tr height="100">
							<td align="center">${board.board_no}</td>
							<%-- <td>${emp_name}</td> --%>
							<td align="center"><a href="boardDetail.do?board_no=${board.board_no}&category_no=${category_no}">${board.board_title }</a></td>
							<td align="center">${board.dept_name} - ${board.emp_name}${board.office_name}
				                           (${board.position_name})</td>
							<td align="center">접근범위</td>
							<td align="center">
								<fmt:formatDate value="${board.board_regdate }" pattern="yyyy-MM-dd"/>
							</td>
							<td align="center">${board.board_hit}</td>
						</tr>
						</c:forEach>
					</table>
					
					<!-- 페이징 처리 -->
					<!-- 현재 페이지, 페이지당 글 수, 총 글 갯수, 총 페이지 수, 시작 페이지, 마지막 페이지 -->
					<!-- 이전페이지 -->
					<c:if test="${listModel.startPage > 5}">
						<a href="listBoard.do?pageNum=${listModel.startPage - 5}&category_no=${category_no}">[이전]</a>
					</c:if>
					
					<!-- 페이지 목록 -->
					<c:forEach var="pageNo" begin="${listModel.startPage}" end="${listModel.endPage}">
						<c:choose>
							<c:when test="${pageNo==listModel.requestPage}">
								<b>[${pageNo}]</b>
							</c:when>
							<c:otherwise>
								<a href="listBoard.do?pageNum=${pageNo}&category_no=${category_no}">[${pageNo}]</a>
							</c:otherwise>
						</c:choose>
						
						
					</c:forEach>
					
					<!-- 이후페이지 -->
					<c:if test="${listModel.endPage < listModel.totalPageCount}">
						<a href="listBoard.do?pageNum=${listModel.startPage + 5}&category_no=${category_no}">[이후]</a>
					</c:if>
					
					<form action="listBoard.do?category_no=${category_no}" method="post">
						<input type="hidden" name="temp" value="temp"></input><!-- 검색을 통해 내가 접근했다는 것을 알려주는거뿐 -->
						<input type="checkbox" name="area" value="board_title">제목</input>
						<input type="checkbox" name="area" value="board_no">번호</input>
						<input type="text" name="searchKey" size="10"></input>
						<input type="submit" value="검색" class="btn btn-default">
					</form>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>
</html>