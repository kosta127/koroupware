<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.structure.min.css" />
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.theme.min.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	<div id="container" class="container">
		<header class="row">
			<h2>조직도</h2>
		</header>
		<section class="row">
			<c:forEach items="${orgChartModelList}" var="orgChartModelList">
				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="panel-title">
								<a data-toggle="collapse" href="#deptCollapse${orgChartModelList.dept.dept_no}"> 
									${orgChartModelList.dept.dept_name}</a>
							</span>
						</div>
						<div id="deptCollapse${orgChartModelList.dept.dept_no}" class="panel-collapse collapse">
							<div class="panel-body">
								<span> 업무 : ${orgChartModelList.dept.dept_work} </span>
								<span> 위치 : ${orgChartModelList.dept.dept_address} </span>
								<span> 연락처 : ${orgChartModelList.dept.dept_telephone} </span>
								<ul>
									<c:forEach items="${orgChartModelList.orgChartEmpList}" var="orgChartEmp">
									<li>
										<a href="#">
											${orgChartEmp.dept_name} - ${orgChartEmp.emp_name}${orgChartEmp.office_name}
												(${orgChartEmp.position_name})
										</a>
									</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</section>
	</div>
</body>
</html>