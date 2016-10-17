<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>CSS MenuMaker</title>
	<link rel="stylesheet" href="../css/community.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"
		type="text/javascript"></script>
	<script src="../js/script.js"></script>
	<script src="../js/community.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.structure.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
	  
	<!-- 사용자 css -->
	
	<!--  -->
	
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
	
	<style type="text/css">
		#cssmenu{
			float: left;
		}
		#contents{
			float: left;
		}
	</style>
</head>
<body>
<div id='cssmenu'>
		<ul>
			<li class="community"><a href='#'><span>업무 공지 사항</span></a>
				<ul>
					<li class='category' id='create'><a href='#'><span>개발부 공지</span></a></li>
					<li class='category' id='work'><a href='#'><span>영업부 공지</span></a></li>
					<li class='category' id='manage'><a href='#'><span>경영부 공지</span></a></li>
					<li class='category' id='sale'><a href='#'><span>판매부 공지</span></a></li>
					<li class='category' id='leader'><a href='#'><span>총무부 공지</span></a></li>
				</ul></li>
			<li class="community"><a href='#'><span>개발부서 놀이터</span></a>
				<ul>
					<li class='category'><a href='#'><span>유용한 유틸</span></a></li>
					<li class='category'><a href='#'><span>읽어보면 좋은 자료</span></a></li>
					<li class='category'><a href='#'><span>칭찬합시다</span></a></li>
				</ul></li>
			<li class="community"><a href='#'><span>산악동호회</span></a>
				<ul>
					<li class='category'><a href='#'><span>사진</span></a></li>
					<li class='category'><a href='#'><span>정기모임</span></a></li>
				</ul>
			</li>
			<li class="community"><a href='#'><span>영화공유</span></a>
				<ul>
					<li class='category'><a href='#'><span>국내영화</span></a></li>
					<li class='category'><a href='#'><span>해외영화</span></a></li>
				</ul>
			</li>
			<li class="community"><a href='#'><span>영어스터디</span></a>
				<ul>
					<li class='category'><a href='#'><span>오늘의단어</span></a></li>
					<li class='category'><a href='#'><span>해석해주세요</span></a></li>
				</ul>
			</li>		
		</ul>
	</div>
	
	<div id="contents">
		
	</div>
</body>
</html>