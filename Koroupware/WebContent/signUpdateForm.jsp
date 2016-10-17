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
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js"></script> 
<script type="text/javascript">

function cancel() {
	location.href = "main.do";
}
function telAdd() {
	location.href = "telAdd.do?emp_no=" + $('.emp_no').val() + "&tel_type=" + $('.tel_type').val() + "&tel_telephone=" + $('.tel_telephone').val();
}
function telUpdate(tel_no, tel_type, tel_telephone) {
	location.href = "telUpdate.do?&emp_no=" + $('.emp_no').val() + "tel_no=" + tel_no + "&tel_type=" + tel_type + "&tel_telephone=" + tel_telephone;
}
function telDelete(tel_no) {
	location.href = "telDelete.do?tel_no=" + tel_no;
}
</script>
</head>
<body>
	<form action="SignUpdate.do" method="post"
		enctype="multipart/form-data">
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
		사진 <input type="file" name="emp_img" value="${emp.emp_img }"><br>
		아이디<input type="text" value="${emp.emp_id }" disabled="disabled"><br>
		이름<input type="text" value="${emp.emp_name }" name="emp_name"><br>
		비밀번호<input type="password" name="emp_password"><br> 주소<input
			type="text" value="${emp.emp_address}" name="emp_address"><br>
		이메일 <input type="text" value="${emp.emp_email }" name="emp_email"><br>
		<c:forEach var="tels" items="${tel}">
기존번호<input type="text" value="${tels.tel_type }">
			<input type="text" value="${tels.tel_telephone }">
			<button type="button"
				onclick="telUpdate(${tels.tel_no}, ${tels.tel_type}, ${tels.tel_telephone})">수정</button>
			<button type="button" onclick="telDelete(${tels.tel_no})">삭제</button>
			<br>
		</c:forEach>
		추가번호 핸드폰<input type="radio" value="핸드폰" name="tel_type" id="tel_type" class="tel_type"> 일반전화<input
			type="radio" value="일반전화" name="tel_type" id="tel_type" class="tel_type"> <input
			type="text" name="tel_telephone" id="tel_telephone" class="tel_telephone">
			<button type="button" onclick="telAdd()">추가</button><br>
		<c:if test="${emp.emp_elec_auth_img != null }">
			<c:set var="head"
				value="${fun:substring(emp.emp_elec_auth_img, 0, fun:length(emp.emp_elec_auth_img) - 4) }"></c:set>
			<c:set var="pattern"
				value="${fun:substringAfter(emp.emp_elec_auth_img, head) }"></c:set>
			<img src="upload/${head }_small${pattern}"
				alt="${head }_small${pattern}" />
		</c:if>
		<br> 결재서명 <input type="file" name="emp_elec_auth_img"
			value="${emp_elec_auth_img }"><br> <input type="text"
			name="emp_elec_auth_signkey"><br> <input type="submit"
			value="수정">
	</form>
	<button onclick="cancel()">취소</button>
</body>
</html>