<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		var $myModalLabel;
		var $modalBody;

		function toSmallImgTag(emp_img){
			var head = emp_img.substring(0, emp_img.length - 4);
			var pattern = emp_img.substring(emp_img.length - 4);
				
			return "upload/" + head + "_small" + pattern;
		}
		
		function showOrgChartEmpModelDetailEvent(data){
			var html = "";

			for(var i = 0; i < data.length; i++){
				var e = data[i];
 				if(e.classification == "myEmp"){
 	 				$myModalLabel.html("<span>" + e.dept_name + " - " + e.emp_name +
							e.office_name + " (" + e.position_name + ")<span>");
 	 						
 	 				var imgTag = toSmallImgTag(e.emp_img);
 	 				
 	 				html += "<div>"
 	 	 			html += "<img src='" + imgTag + "'/><br>";
 					html += "<span>아이디 : " + e.emp_id + "</span><br>";
 	 				html += "<span>이메일 : " + e.emp_email + "</span><br>";
 	 				html += "<span>주소 : " + e.emp_address + "</span><br>";
 	 				html += "<span>담당업무 : " + e.dept_work + "</span><br>";
 	 				html += "</div>";
 	 			}else if(e.classification == "superiorEmp"){
 	 	 			html += "<div>";
 	 				html += "<span>직속상관 : <a><span class='hidden'>" + e.emp_no + "</span>" + 
 	 							e.dept_name + " - " + e.emp_name + e.office_name +
 	 							" (" + e.position_name + ")</a></span><br>";
 	 				html += "</div>";
 	 	 		}else if(e.classification == "reporterEmp"){
 	 	 			html += "<div>";
 	 	 			html += "<span>직접보고자 : <a><span class='hidden'>" + e.emp_no + "</span>" +
 	 	 						e.dept_name + " - " + e.emp_name + e.office_name +
 	 	 						" (" + e.position_name + ")</a></span><br>";
 	 				html += "</div>";
 	 	 		}
			}

			$modalBody.html(html);
			$modalBody.find("a").on("click", orgChartClickEvent);
		}

		function orgChartClickEvent(){
			var empNo = $(this).find("span").html();
			
			$.ajax({
				url : "orgChart/ajax/orgChartEmpModelDetailAjax.jsp",
				type : "POST",
				dataType : "json",
				data : "empNo=" + empNo,
				success : showOrgChartEmpModelDetailEvent
			});
		}
		
		$(function(){
			$orgChartModelList = $("div#orgChartModelList");
			$deptCollapse = $orgChartModelList.find(".panel-collapse");
			$myModal = $("div#myModal");
			$myModalLabel = $myModal.find("h4#myModalLabel");
			$modalBody = $myModal.find("div#modalBody");
			
			$.each($deptCollapse, function(index, item){
				$(this).find("a").on("click", orgChartClickEvent);
			});
		});
	</script>
	<style type="text/css">
		
		
	</style>
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
												${orgChartEmp.emp_name}${orgChartEmp.office_name}
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
							<h4 class="modal-title" id="myModalLabel">검색중</h4>
						</div>
						<div class="modal-body" id="modalBody">
							<p>뜨는중</p>
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