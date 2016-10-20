<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/Findform.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>아이디/비밀번호 찾기</title>

</head>
<body>
	<div class="conainer-header">
		<h1>아이디 비밀번호 찾기</h1>
	</div>
	<div class="container-fulid">

		<div class="row1">
			<div class="col-sm-4"">
				<h2>아이디 찾기</h2>
				<form action="FindIdProcess.do" method="post">
					<h3>
						<small>주민번호 :</small> <input type="text"
							name="find_RESIDENTNUMBER">
					</h3>
					<br> <input type="submit" class="btn btn-info" value="아이디 찾기">

				</form>
			</div>
		</div>
		
		<div class="row2">
			<div class="col-sm-4" ">
				<h2>비밀번호 찾기</h2>
				<form action="FindPasswordProcess.do" method="post">
					<h3>
						<small>아이디 :</small> <input type="text" name="find_id">
					</h3>
					<h3>
						<small>주민번호 :</small> <input type="text"
							name="find_RESIDENTNUMBER">
					</h3>
					<br> <input type="submit" class="btn btn-info" value="비밀번호 찾기">
				</form>
			</div>
		</div>

	</div>




</body>
</html>

