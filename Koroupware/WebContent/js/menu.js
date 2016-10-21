$(function(){
	//원래잇던거
	function logout() {
      location.href = "logout.do";
   }
   function signUpdate() {
      location.href = "signUpdateForm.jsp";
   }
   function community_create() {
	      location.href="insertCommunityForm.do?emp_no=${emp.emp_no}";
   }
})


var community_nos = new Array();
$(function(){
	//커뮤니티 리스트 만들기
	$.ajax({
		url: 'communityListAsJSON.do',
		type: 'post',
		dataType: 'json',
		success : setCommunityList
	});	
	
	function setCommunityList(data){
		var html = '';
		$.each(data, function(idx, commu){
			html += '<li class="panel panel-default" id="dropdown"> \n';
			html += '<a data-toggle="collapse" href="#dropdown-'+commu.community_no+'"> \n';
            html += '<span class="glyphicon glyphicon-off"></span>'+commu.community_name+'<span class="caret"></span></a> \n';
            html += '<div id="dropdown-'+commu.community_no+'" class="panel-collapse collapse"> \n';
            html += '<div class="panel-body"> \n';
            html += '<ul class="nav navbar-nav" id="category_list_'+commu.community_no+'"> \n';
            //html += '<li><a href="#">'+'카테고리 필요함니다'+'</a></li>';
            html += '</ul>';
            html += '</div></div></li>'
            community_nos.push(commu.community_no); //커뮤니티 번호를 저장해놓는다
			
            console.log('pushed community_nos => '+ commu.community_no)
			// 커뮤니티 추가 어케넣음
			//html += '<li class="li-comu">\n<a class="comu-content">\n';
			//html += commu.community_name+'</a>';
			//html += '<a class="comu-plus" href="insertCategoryForm.do?community_no='+commu.community_no+'">+</a></li>';		
		});
		$('#community_list').append(html);
		
		//카테고리 리스트 만들기
		for(var i=0; i<community_nos.length; i++){
			console.log('community_nos => '+ community_nos[i])
			$.ajax({
				url: 'categoryListAsJSON.do',
				type: 'post',
				data: {'community_no' : community_nos[i]},
				dataType: 'json',
				success : setCategoryList
			});	
		}	
	}
	
	function setCategoryList(data){
		var commu_no = 0;
		var html = '';
		$.each(data, function(idx, cate){
			commu_no = cate.community_no;
			html += '<li><a href="listBoard.do?category_no='+cate.category_no+'">'+cate.category_name+'</a></li>';
		})		
		$('#category_list_'+commu_no).append(html);
	}
});


/*
$(function(){
	//카테고리 리스트 만들기
	
	console.log('community_nos.length => '+community_nos.length)
	for(var i in community_nos){
		$.ajax({
			url: 'categoryListAsJSON.do',
			type: 'post',
			data: {'community_no' : i},
			dataType: 'json',
			success : setCategoryList
		});	
	}
	
	function setCategoryList(data){
		var commu_no = 0;
		var html = '';
		$.each(data, function(idx, cate){
			commu_no = cate.community_no;
			html += '<li><a href="listBoard.do?category_no='+cate.category_no+'">'+cate.category_name+'</a></li>';
		})		
		$('#category_list_'+commu_no).append(html);
	}
})
*/
/*
</li>
</c:forEach>
<c:forEach var="categoryList" items="${categoryList }">	
			<ul>
				<li><a href="listBoard.do?category_no=${categoryList.category_no}">${categoryList.category_name}</a></li>
			</ul>
</c:forEach></li>
빼먹지말기
*/
