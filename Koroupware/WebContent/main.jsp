

<%@page import="kosta.emp.model.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
   Emp emp = (Emp) session.getAttribute("emp");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/menu.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   function logout() {
      location.href = "logout.do";
   }
   function signUpdate() {
      location.href = "signUpdateForm.jsp";
   }
   function community_create() {
	      location.href="insertCommunityForm.do?emp_no=${emp.emp_no}";
   }
</script>
<title>Insert title here</title>

</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="main-main">
   <div class="logo">
 <img alt="logo" src="main.jpg" id="logo" class="logo-img img-circle">
 <span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span>
   </div>
   <div class="search">
      <form action="SearchAction.do" method="post">
      <div class="col-xs-2">
      <select name = "keyField" class="form-control select">
       <option value="emp_name">사원</option>
       <option value="document">문서</option>
      </select>
      </div>
     <div class="col-xs-5">
     <input type="text" name="search_content" class="form-control"></div>
     <input type="submit" value="검색" class="btn btn-primary">
      </form>
      </div>
</div>
</body>
</html>
	