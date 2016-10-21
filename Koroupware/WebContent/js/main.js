
$(function(){
	
})

function logout() {
	location.href = "logout.do";
}

function signUpdate() {
	location.href = "signUpdateForm.jsp";
}
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