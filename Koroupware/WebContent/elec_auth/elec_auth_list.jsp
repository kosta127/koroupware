<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js" ></script>
<script src="js/jquery.js"></script>
<title>Insert title here</title>
<style type="text/css">
	.center{
			text-align: center;
		}
</style>
<script type="text/javascript">

	$(function(){
		$('#write').on('click', function(){
			location.href="elec_authWriteForm.do";
		});
	});
</script>
</head>
<body>
<h2>결재</h2>

<table border="1" class="center">
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
		<span class="labe"><a href="elec_authList.do?pageNum=${paging.startPage-1 }">이전</a></span>
	</c:if>
	<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
		<c:choose>
			<c:when test="${i==paging.currentPage }">
				<span class="label label-info">${i }</span>
			</c:when>
			<c:otherwise>
				<span class="label"><a href="elec_authList.do?pageNum=${i }">${i }</a></span>	
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${paging.needAfter }">
		<span class="label"><a href="elec_authList.do?pageNum=${paging.endPage+1 }">다음</a></span>
	</c:if>
</div>
<input type="button"  id="write"  value="결재작성" >

</body>
</html>