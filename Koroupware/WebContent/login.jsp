<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script type="text/javascript">
	function signUp() {
		location.href = "MakeAction.do";
	}
	function findUser() {
		location.href = "FindAction.jsp";
	}
</script>
</head>
<<<<<<< HEAD
<body>	
	<div class="body">
	<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span>
	<div class="panel panel-default">
		
		<div class="panel-heading">
			<h1>Login</h1>
		</div>
		<div class="panel-body">
			<form class="login" action="LoginProcessAction.do" method="post">
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user" style="width: auto"></i>
						</span> <input id="txtUsuario" type="text"
							class="form-control" name="emp_id" placeholder="Username" />
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock" style="width: auto"></i>
						</span> <input id="txtSenha" type="password"
							class="form-control" name="emp_password" placeholder="Password" />
					</div>
				</div>
				<input type="submit" class="btn btn-default" style="width: 100%"
					value="ENTER">
			</form><br>
=======
<body>
	<form action="LoginProcessAction.do" method="post">
		아이디 : <input type="text" name="emp_id"><br> 비밀번호 : <input
			type="password" name="emp_password"><br> <input
			type="submit" value="로그인">
	</form>
>>>>>>> refs/remotes/origi/kjy_161019_total

<<<<<<< HEAD
			<div class="searchIdPass">		
					<button onclick="findUser()" class="btn btn-primary">아이디/비밀번호 찾기</button>
					<button onclick="signUp()" class="btn btn-warning">회원 가입</button>
			</div>
		</div>
	</div>
	</div>
	
=======

	<button onclick="signUp()">회원 가입</button>
	<button onclick="findUser()">아이디/비밀번호 찾기</button>
>>>>>>> refs/remotes/origi/kjy_161019_total
</body>
</html>