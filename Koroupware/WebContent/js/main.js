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


$(function(){
	$.ajax({
		url: 'communityListAsJSON.do',
		type: 'post',
		dataType: 'json',
		success : successHandler
	});	
	
	function successHandler(data){
		var html = '';
		$.each(data, function(idx, commu){
			html += '<li class="li-comu"><a class="comu-content" href="listCategory.do?community_no='+commu.community_no+'">';
			html += commu.community_name+'</a>';
			html += '<a class="comu-plus" href="insertCategoryForm.do?community_no='+commu.community_no+'">+</a></li>';
		});
		$('#community_list').append(html);
	}
});

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