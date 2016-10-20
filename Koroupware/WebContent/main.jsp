

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
        <li class="active"><a href="#">Home<span class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
        <li ><a href="listDoc_box.do">문서<span class="pull-right hidden-xs showopacity glyphicon glyphicon-tags"></span></a></li>
        <li ><a href="#">전자결재<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-pencil"></span> </a></li>
        <li ><a href="listCommunity.do">커뮤니티 <span  class="pull-right hidden-xs showopacity glyphicon glyphicon-comment"></span></a>
				<c:forEach var="communityList" items="${communityList }">
					<li class="li-comu">
					<a class="comu-content" href="listCategory.do?community_no=${communityList.community_no }">${communityList.community_name} </a>
					<a class="comu-plus" href="insertCategoryForm.do?community_no=${communityList.community_no}">+</a>
					</li>
				</c:forEach>
				<c:forEach var="categoryList" items="${categoryList }">	
							<ul>
								<li><a href="listBoard.do?category_no=${categoryList.category_no}">${categoryList.category_name}</a></li>
							</ul>
				</c:forEach></li>          
        <li ><a href="#">조직도<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
        <li ><a href="messagePage.do">쪽지<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-send"></span></a></li>  
      </ul>
    </div>
  </div>
</nav>
<div class="main-main">
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
	