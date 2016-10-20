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
<title>Insert title here</title>

</head>
<body>
	<nav class="navbar navbar-default sidebar" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>      
    </div>
    <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="main.do">Home<span class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
        <li ><a href="listDoc_box.do">문서<span class="pull-right hidden-xs showopacity glyphicon glyphicon-tags"></span></a></li>
        <li ><a href="">전자결재<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-pencil"></span> </a></li>         
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">커뮤니티 <span class="caret"></span><span  class="pull-right hidden-xs showopacity glyphicon glyphicon-comment"></span></a>
          <ul class="dropdown-menu forAnimate" role="menu">
            <li><a href="{{URL::to('createusuario')}}">등산</a></li>
          </ul>
        </li>          
        <li ><a href="#">조직도<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
        <li ><a href="messagePage.do">쪽지<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-send"></span></a></li>  
      </ul>
    </div>
  </div>
  
</nav>
<div class="main-top">
   <span>${emp.emp_name }</span>
   <c:if test="${emp.emp_img != null }">
      <c:set var="head"
         value="${fun:substring(emp.emp_img, 0, fun:length(emp.emp_img) - 4) }"></c:set>
      <c:set var="pattern" value="${fun:substringAfter(emp.emp_img, head) }"></c:set>
      <img src="upload/${head }_small${pattern}"
         alt="${head }_small${pattern}" class="face-img img-circle"/>
   </c:if>
  
   <button onclick="signUpdate()" class="btn btn-success">정보변경</button>
   <button onclick="logout()" class="btn btn-warning">로그아웃</button>
   </div>
  
  
      
</body>
</html>