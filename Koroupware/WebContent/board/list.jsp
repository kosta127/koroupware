<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>공지사항</h3>
	<a href="insert.do">글쓰기</a>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.board_no}</td>
			<td><a href="boardDetail.do?board_no=${board.board_no }">${board.board_title }</a></td>
			<td align="center">
				<fmt:formatDate value="${board.board_regdate }" pattern="yyyy-MM-dd"/>
			</td>
			<td>${board.board_hit }</td>
		</tr>
		</c:forEach>
	</table>
	
	<!-- 페이징 처리 -->
	<!-- 현재 페이지, 페이지당 글 수, 총 글 갯수, 총 페이지 수, 시작 페이지, 마지막 페이지 -->
	<!-- 이전페이지 -->
	<%-- <c:if test="${listModel.startPage > 5}">
		<a href="list.do?pageNum=${listModel.startPage - 5}">[이전]</a>
	</c:if>
	
	<!-- 페이지 목록 -->
	<c:forEach var="pageNo" begin="${listModel.startPage}" end="${listModel.endPage}">
		<c:choose>
			<c:when test="${pageNo==listModel.requestPage}">
				<b>[${pageNo}]</b>
			</c:when>
			<c:otherwise>
				<a href="list.do?pageNum=${pageNo}">[${pageNo}]</a>
			</c:otherwise>
		</c:choose>
		
		
	</c:forEach>
	
	<!-- 이후페이지 -->
	<c:if test="${listModel.endPage < listModel.totalPageCount}">
		<a href="list.do?pageNum=${listModel.startPage + 5}">[이후]</a>
	</c:if>
	
	<form action="list.do" method="post">
		<input type="hidden" name="temp" value="temp"></input><!-- 검색을 통해 내가 접근했다는 것을 알려주는거뿐 -->
		<input type="checkbox" name="area" value="board_title">제목</input>
		<input type="checkbox" name="area" value="board_no">번호</input>
		<input type="text" name="searchKey" size="10"></input>
		<input type="submit" value="검색">
	</form> --%>
</body>
</html>