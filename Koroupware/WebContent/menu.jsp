<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/menu.css" />
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
        <li class="dropdown">
          <a href="listBoard.do" class="dropdown-toggle" data-toggle="dropdown">커뮤니티 <span class="caret"></span><span  class="pull-right hidden-xs showopacity glyphicon glyphicon-comment"></span></a>
          <ul class="dropdown-menu forAnimate" role="menu">
            <li><a href="{{URL::to('createusuario')}}">등산</a></li>
            <li class="divider"></li>
            <li><a href="#">여행</a></li>
            <li class="divider"></li>
            <li><a href="#">요리</a></li>
            <li class="divider"></li>
            <li><a href="#">자기개발</a></li>
            <li class="divider"></li>
            <li><a href="#">컴퓨터</a></li>
          </ul>
        </li>          
        <li ><a href="orgChartPage.do">조직도<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
        <li ><a href="messagePage.do">쪽지<span  class="pull-right hidden-xs showopacity glyphicon glyphicon-send"></span></a></li>  
      </ul>
    </div>
  </div>
</nav>
</body>
</html>