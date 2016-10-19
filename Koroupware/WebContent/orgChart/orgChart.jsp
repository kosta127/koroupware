<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.structure.min.css" />
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui.theme.min.css" />
	<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css" />
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
	
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	<div id="container" class="container">
		<header class="row">
			<h2>조직도</h2>
		</header>
		<section class="row">
			<c:forEach items="${deptList}" var="dept">
				${dept}
				
				<div class="panel-group" id="dept${dept_no}">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="panel-title">
								<a data-toggle="collapse" data-parent="#dept${dept_no}"
									href="#deptCollapse${dept_no}"> 여기를 클릭해 보세요. #1 </a>
							</span>
						</div>
						<div id="deptCollapse${dept_no}" class="panel-collapse collapse">
							<div class="panel-body">
								내용
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<div class="panel-group" id="accordion">
				<div class="panel panel-default">
					<div class="panel-heading">
						<span class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne"> 여기를 클릭해 보세요. #1 </a>
						</span>
					</div>
					<div id="collapseOne" class="panel-collapse collapse">
						<div class="panel-body">
							내용
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>