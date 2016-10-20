<%@page import="kosta.login.service.SessionService"%>
<%@page import="java.util.List"%>
<%@page import="kosta.emp.model.Tel"%>
<%@page import="kosta.login.dao.SessionDao"%>
<%@page import="kosta.emp.model.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	Emp emp = (Emp) session.getAttribute("emp");
	SessionService service = SessionService.getInstance();
	List<Tel> tel = (List<Tel>) service.empTelService(emp.getEmp_no());
	request.setAttribute("tel", tel);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/signUpdate.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/nanumgothic.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="./js/signUpdate.js"></script>
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js"></script> 
</head>
<body>
	<form action="SignUpdate.do" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
		<input type="hidden" value="${emp.emp_no }" name="emp_no" class="emp_no"> <input
			type="hidden" value="${emp.dept_no }" name="dept_no"> <input
			type="hidden" value="${emp.emp_id }" name="emp_id">
		<c:if test="${emp.emp_img != null }">
			<c:set var="head"
				value="${fun:substring(emp.emp_img, 0, fun:length(emp.emp_img) - 4) }"></c:set>
			<c:set var="pattern"
				value="${fun:substringAfter(emp.emp_img, head) }"></c:set>
			<img src="upload/${head }_small${pattern}"
				alt="${head }_small${pattern}" />
			<br>
		</c:if>
		사진 <input class="form-control" type="file" name="emp_img" value="${emp.emp_img }"><br>
		아이디<input class="form-control" type="text" value="${emp.emp_id }" disabled="disabled"><br>
		이름<input class="form-control" type="text" value="${emp.emp_name }" name="emp_name"><br>
		비밀번호<input  placeholder="비밀번호를 입력해주세요." class="form-control" type="password" name="emp_password"><br> 주소<input
			type="text" value="${emp.emp_address}" name="emp_address"><br>
		이메일 <input class="form-control" type="text" value="${emp.emp_email }" name="emp_email"><br>
		기존번호<br><c:forEach var="tels" items="${tel}" varStatus="status">
		<input class="form-control" type="hidden" value="${tels.tel_no}" id="oldTelNo-${status.index}">
<input class="form-control" type="text" value="${tels.tel_type}" id="oldTelType-${status.index}">
		<input class="form-control" type="text" value="${tels.tel_telephone}" id="oldTelTelephone-${status.index}">
		<button class="btn btn-primary" type="button"
				onclick="telUpdate(${status.index})">수정</button>
			<button class="btn btn-primary" type="button" onclick="telDelete(${tels.tel_no})">삭제</button>
			<br>
		</c:forEach>
		추가번호 핸드폰<br><input type="radio" value="핸드폰" name="tel_type" id="tel_type" class="tel_type"> 일반전화<input
			type="radio" value="일반전화" name="tel_type" id="tel_type" class="tel_type"> <input  placeholder="추가할 전화번호를 입력해주세요." class="form-control" 
			type="text" name="tel_telephone" id="tel_telephone" class="tel_telephone">
			<button class="btn btn-primary" type="button" onclick="telAdd()">추가</button><br>
		<c:if test="${emp.emp_elec_auth_img != null }">
			<c:set var="head"
				value="${fun:substring(emp.emp_elec_auth_img, 0, fun:length(emp.emp_elec_auth_img) - 4) }"></c:set>
			<c:set var="pattern"
				value="${fun:substringAfter(emp.emp_elec_auth_img, head) }"></c:set>
			<img src="upload/${head }_small${pattern}"
				alt="${head }_small${pattern}" />
		</c:if>
		<br> 결재서명 <input  class="form-control"  type="file" name="emp_elec_auth_img"
			value="${emp_elec_auth_img }"><br> 결재사인키 <input  placeholder="결재사인키를 입력해주세요." class="form-control"  type="password"
			name="emp_elec_auth_signkey"><br> <input class="btn btn-primary" type="submit"
			value="수정">
			</div>
	</form>
	<button onclick="cancel()">취소</button>
</body>
</html>