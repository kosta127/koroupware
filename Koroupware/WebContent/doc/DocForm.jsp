<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/menu.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
	div.col-md-8{
		margin-left: 10em;
		margin-top: 10em;
	}
</style>
<script type="text/javascript">
	function fn_back(){
		history.back(-1);
	}
</script>
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<div class="col-md-8">
		<h1>문서 등록</h1>
		<form action="DocProc.do?emp_no=${emp_no }&doc_box_no=${doc_box_no}" method="post"
		enctype="multipart/form-data">
		문서 제목 : <input type="text" name="doc_title"><br>
		문서 설명 : <input type="text" name="doc_explain"><br>
		문서 내용 : <input type="text" name="doc_contents"><br>
		보존 연한 : <input type="text" name="doc_con_period"><br>
		양식 여부 : <input type="text" name="doc_formYN"><br>
		파일 : <input type="file" name="doc_file_real_name"><br>
		
		<input type="submit" value="등록" class="btn btn-default">
		<input tpye="button" value="돌아가기" onclick="fn_back()" class="btn btn-default">
		</form>
		</div>
	
	
</body>
</html>