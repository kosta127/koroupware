<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
	div.col-md-8{
		margin-top: 10em;
		margin-left: 10em;
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
	<div class="container">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<form action="insertDoc_hisProc.do?doc_no=${doc_no }&emp_no=${emp_no}&doc_box_no=${doc_box_no}" method="post">
				변경 사유 : <input type="text" name="doc_his_reason_change"><br>
				재개정여부 : <input type="text" name="doc_his_revise"><br>
			<input type="submit" value="수정완료" class="btn btn-default">
			<input type="button" value="돌아가기" onclick="fn_back()" class="btn btn-default">
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
	
</body>
</html>