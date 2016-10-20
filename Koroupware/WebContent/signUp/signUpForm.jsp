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
<style type="text/css">
	.form-control{
		width: 300px;
	}
</style>
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
 <br> 
 <input type="submit" value="가입">
 </form>
 <button onclick="login()">취소</button>
</body>
</html>