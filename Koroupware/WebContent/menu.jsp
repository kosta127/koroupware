<%@page import="kosta.emp.model.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/menu.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>

 
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

 <!-- 
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
 -->
<script src="js/menu.js"></script>
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
  			<!-- @@@@@@@@@@@@@@@@@@@@@@ -->
	  		<div class="side-menu-container">
		        <ul class="nav navbar-nav">	
		        	<li class="active"><a href="main.do">Home<span class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
			        <li><a href="listDoc_box.do">문서<span class="pull-right hidden-xs showopacity glyphicon glyphicon-tags"></span></a></li>
			        <li><a href="">전자결재<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-pencil"></span> </a></li>         
		            <!-- Dropdown-->
		            <li class="panel panel-default" id="dropdown">
		                <a data-toggle="collapse" href="#dropdown-lvl1">
		                    	커뮤니티<span class="caret"></span><span  class="pull-right hidden-xs showopacity glyphicon glyphicon-comment"></span>
		                </a>
		
		                <!-- Dropdown level 1 start -->
		                <div id="dropdown-lvl1" class="panel-collapse collapse">
		                    <div class="panel-body">
		                        <ul class="nav navbar-nav" id="community_list">
		                           <!-- 여기에 메뉴 들어갈거면 이거 써주기 <li><a href="#">Link</a></li>--> 		                            
		                            <!-- Dropdown level 2 start
		                            
		                            <li class="panel panel-default" id="dropdown">
		                                <a data-toggle="collapse" href="#dropdown-lvl2">
		                                    <span class="glyphicon glyphicon-off"></span> Sub Level <span class="caret"></span>
		                                </a>
		                                <div id="dropdown-lvl2" class="panel-collapse collapse">
		                                    <div class="panel-body">
		                                        <ul class="nav navbar-nav">
		                                            <li><a href="#">Link</a></li>
		                                        </ul>
		                                    </div>
		                                </div>
		                            </li>
		                            Dropdown level 2 end -->
		                        </ul>
		                    </div>
		                </div>
		                <!-- Dropdown level 1 end -->
		            </li>
					<li ><a href="#">조직도<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
			        <li ><a href="messagePage.do">쪽지<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-send"></span></a></li>  
		        </ul>
	    	</div><!-- /.navbar-collapse -->
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