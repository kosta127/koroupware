<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<link rel="stylesheet" href="css/elec_auth_list.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/elec_auth_list.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${receive != null}">
			<c:set var="pageUrl" value="elec_authList.do?receive=ok"></c:set>
		</c:when>
		<c:otherwise>
			<c:set var="pageUrl" value="elec_authList.do?"></c:set>
		</c:otherwise>
	</c:choose>
	
	<div class="col-md-3">
	</div>

	<div class="col-md-2">
	<div id="elec_auth_box">
		<h3><a href="elec_authList.do">내가 올린 결재</a></h3>
		<div id="write_list">					
		<!-- <p><a href="elec_authList.do?flag=ing">진행중인 결재</a></p>
			<p><a href="elec_authList.do?flag=done">완료된 결재</a></p>
			<p><a href="elec_authList.do?flag=ret">부결/반려된 결재</a></p> 나중에추가합시다-->
			<p><a href="elec_authList.do?flag=temp">임시저장 결재</a></p>
		</div>
		<h3><a href="elec_authList.do?receive=ok">내가 받은 결재</a></h3>
		<div id="receive_list">			
		<!-- <p><a href="elec_authList.do?receive=ok&flag=wait">결재대기중인 결재</a></p>
			<p><a href="elec_authList.do?receive=ok&flag=ing">진행중인 결재</a></p>
			<p><a href="elec_authList.do?receive=ok&flag=done">완료된 결재</a></p>
			<p><a href="elec_authList.do?receive=ok&flag=ret">부결/반려한 결재</a></p> 나중에추가합시다-->
		</div>	
	</div>
	</div>

	<div class="col-md-7">
	<div class="elec_authList">
			<h3>결재문서 목록</h3>
			<table border="1" class="table table-bordered">
				<thead>
					<tr>
						<th>문서번호</th>
						<th>문서종류</th>
						<th>제목</th>
						<th>관리부서</th>
						<th>기안자</th>
						<th>기안일</th>
						<th>결재 마감일</th>
						<th>결재 단계</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${elec_authList }">
						<tr>
							<td>${i.elec_auth_no }</td>
							<td>${i.doc_title}</td>
							<td><a href="elec_authDetail.do?elec_auth_no=${i.elec_auth_no}">${i.elec_auth_title }</a></td>
							<td>${i.dept_name }</td>
							<td>${i.emp_name }</td>
							<td>${i.elec_auth_regdate }</td>
							<td>${i.elec_auth_enddate }</td>
							<td>${i.approval_list_pass }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table> 
			
			<div class="center">
				<c:if test="${paging.needBefore }">
					<span class="labe"><a href="${pageUrl }&pageNum=${paging.startPage-1 }">이전</a></span>
				</c:if>
				<c:forEach var="i" begin="${paging.startPage }"
					end="${paging.endPage }">
					<c:choose>
						<c:when test="${i==paging.currentPage }">
							<span class="label label-info">${i }</span>
						</c:when>
						<c:otherwise>
							<span class="label"><a href="${pageUrl }&pageNum=${i }">${i }</a></span>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${paging.needAfter }">
					<span class="label"><a href="${pageUrl }&pageNum=${paging.endPage+1 }">다음</a></span>
				</c:if>
			</div>
			<input type="button" id="write" class="btn btn-primary" value="결재작성">
	</div>
	</div>

</body>
</html>