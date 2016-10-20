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
		var $orgChartModelList;
		var $deptCollapse;
		var $myModal;
		var $modalBody;
		
		function aaaa(data){
			var html = "";

			for(var i = 0; i < data.length; i++){
				alert(data[i].classification);
 				if(data[i].classification == "myEmp"){

 					
 	 				html += "<span>이름 : " + data[i].emp_name + "</span>";
 	 				html += "<span>이메일 : " + data[i].emp_email + "</span>";
 	 				html += "<span>아이디 : " + data[i].emp_id + "</span>";
 	 				html += "<span>주소 : " + data[i].emp_address + "</span>";
 	 				html += "<span>입사일 : " + data[i].emp_hiredate + "</span>";
 	 				html += "<span>이름 : " + data[i].emp_name + "</span>";
 	 				html += "<span>사진 : " + data[i].emp_img + "</span>";
 	 				html += "<span>직속상관 : " + data[i].emp_superior + "</span>";
 	 				html += "<span>직접보고자 : " + data[i].emp_reporter + "</span>";
 	 				html += "<span>직책 : " + data[i].position_name + "</span>";
 	 				html += "<span>직위 : " + data[i].office_name + "</span>";
 	 				html += "<span>부서 : " + data[i].dept_name + "</span>";
 	 				html += "<span>업무 : " + data[i].dept_work + "</span>";
 	 			}
				/* 
 	 			else if(data.classification.equals("superiorEmp")){
 	 	 			
 	 	 		}else if(data.classification.equals("reporterEmp")){
 	 	 	 		
 	 	 		}
 	 	 		 */
			}

			$modalBody.html(html);
		}
		
		$(function(){
			$orgChartModelList = $("div#orgChartModelList");
			$deptCollapse = $orgChartModelList.find(".panel-collapse");
			$myModal = $("div#myModal");
			$modalBody = $myModal.find($("div#modalBody"));
			
			$.each($deptCollapse, function(index, item){
				var empNo = $(this).find("a").find("span").html();
				
				$(this).find("a").on("click", function(){
					$.ajax({
						url : "orgChart/ajax/orgChartEmpModelDetailAjax.jsp",
						type : "POST",
						dataType : "json",
						data : "empNo=" + empNo,
						success : aaaa
					});
				});
			});
		});
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
					<div id="orgChartModelList" class="panel panel-default">
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
										<a href="#myModal" data-toggle="modal" id="orgChartEmpButton">
											<span class="hidden">${orgChartEmp.emp_no}</span>
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
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">모달 제목</h4>
						</div>
						<div class="modal-body" id="modalBody">
							<p>여기는 내용이 들어 가는 곳</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						</div>
					</div>
					<!-- 모달 콘텐츠 -->
				</div>
				<!-- 모달 다이얼로그 -->
			</div>
			<!-- 모달 전체 윈도우 -->
		</section>
	</div>
</body>
</html>