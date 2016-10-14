<%@page import="kosta.login.service.SessionService"%>
<%@page import="java.util.List"%>
<%@page import="kosta.emp.model.Tel"%>
<%@page import="kosta.login.dao.SessionDao"%>
<%@page import="kosta.emp.model.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
      Emp emp = (Emp)session.getAttribute("emp");
      System.out.println(emp.getEmp_no());
      SessionService service = SessionService.getInstance();
      List<Tel> tel = (List<Tel>)service.empTelService(emp.getEmp_no());
      request.setAttribute("tel", tel);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function telDelete() {
	location.href = "telDelete.do";
}
function telAdd() {
	location.href = "telAdd.do";
}
</script>
</head>
<body>
<form action="SignUpdate.do" method="post">
<input type = "hidden" value="${emp.emp_no }" name="emp_no" >
<input type = "hidden" value="${emp.dept_no }" name = "dept_no">
<input type = "hidden" value="${emp.emp_id }" name="emp_id">
사진 <input type="file" name="emp_img"><br>
아이디<input type="text" value="${emp.emp_id }" disabled="disabled"><br>
이름<input type="text" value="${emp.emp_name }"><br>
비밀번호<input type="password" name="emp_password"><br>
주소<input type="text" value="${emp.emp_address}" name="emp_address"><br>
<c:forEach var="tels" items="${tel}">
<input type="hidden" value="${tels.tel_type }">
<input type="hidden" value="${tels.tel_telephone }">
기존번호<input type="text" value="${tels.tel_type }" disabled="disabled">
<input type="text" value="${tels.tel_telephone }" disabled="disabled"><button onclick="telDelete()">삭제</button><br>
</c:forEach>
추가번호 핸드폰<input type="radio" value="핸드폰" name="tel_type">
일반전화<input type="radio" value="일반전화" name="tel_type"><br>
<input type="text" name="tel_telephone"><button onclick="telAdd()">추가</button>
<br>
결재서명 <input type="file" name="emp_elec_auth_img"><br> 
<input type="submit" value="수정">
</form>
</body>
</html>