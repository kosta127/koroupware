<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <form action="SignUpAction.do" method="post">
 아이디 <input type="text" name="emp_id"><br>
 비밀번호 <input type="password" name="emp_password"><br>
 이름 <input type="text" name="emp_name"><br>
 주민등록번호 <input type="text" name="emp_residentnumber"><br>
 전화번호 <input type="text" name="tel_telephone"><br>
 이메일 <input type="text" name="emp_email"><br>	
 주소 <input type="text" name="emp_address"><br>
 사원이미지 <input type="file" name="emp_img"><br>
 결재사인 <input type="file" name="emp_elec_auth_img"><br> 
 <input type="submit" value="가입">
 </form>
 <button onclick="">취소</button>
</body>
</html>