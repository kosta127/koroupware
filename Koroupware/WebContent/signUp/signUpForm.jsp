<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../bootstrap/css/custom2.css" rel="stylesheet">
<title>Insert title here</title>

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/nanumgothic.css">
<style type="text/css">
	.form-control{
		width: 300px;
		margin-left: 10em;
	}
</style>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js"></script>
<script type="text/javascript">
function login() {
	location.href = "loginGo.do";
}
</script>
</head>
<body>
 <form action="SignUpAction.do" method="post" enctype="multipart/form-data">
 아이디 <input type="text" name="emp_id" class="form-control"><br>
 비밀번호 <input type="password" name="emp_password" class="form-control"><br>
 이름 <input type="text" name="emp_name" class="form-control"><br>
 주민등록번호 <input type="text" name="emp_residentnumber" class="form-control"><br>
 핸드폰<input type="radio" name="tel_type" value="핸드폰">일반전화<input type="radio" name="tel_type" value="일반전화">번호 <input type="text" name="tel_telephone" class="form-control"><br>
 이메일 <input type="text" name="emp_email"><br>	
 주소 <input type="text" name="emp_address"><br>
 사원이미지 <input type="file" name="emp_img"><br>
 결재사인 <input type="file" name="emp_elec_auth_img"><br>
 결재사인키 <input type="password" name="emp_elec_auth_signkey">
 아이디 <input type="text" name="emp_id" class="form-control" placeholder="아이디를 입력해주세요."><br>
 비밀번호 <input type="password" name="emp_password" class="form-control" placeholder="비밀번호를 입력해주세요."><br>
 이름 <input type="text" name="emp_name" class="form-control" placeholder="이름을 입력해주세요."><br>
 주민등록번호 <input type="text" name="emp_residentnumber" class="form-control" placeholder="주민등록번호를 입력해주세요."><br>
 핸드폰<input type="radio" name="tel_type" value="핸드폰">일반전화<input type="radio" name="tel_type" value="일반전화">번호 <input type="text" name="tel_telephone" class="form-control" placeholder="전화번호를 입력해주세요."><br>
 이메일 <input type="text" name="emp_email" class="form-control" placeholder="이메일을 입력해주세요."><br>	
 주소 <input type="text" name="emp_address" class="form-control" placeholder="주소를 입력해주세요."><br>
 사원이미지 <input type="file" name="emp_img" class="form-control" placeholder="사진를 첨부해주세요."><br>
 결재사인 <input type="file" name="emp_elec_auth_img" class="form-control"><br>
 결재사인키 <input type="password" name="emp_elec_auth_signkey" class="form-control">
 <br> 
 <input type="submit" value="가입">
 </form>
 <button onclick="login()">취소</button>
</body>
</html>