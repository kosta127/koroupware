/**
 * 
 */

$(function(){
	// CKEDITOR 사용 세팅
	CKEDITOR.replace('elec_auth_contents');	
})

$(function(){
	$('#elec_auth_approval_name').keydown(function(){
		$.ajax({
				url: 'empSearch.do',
				type: 'post',
				dataType: 'json',
				data: $(this).dd,
				success: showSearchResult
		})
	});
	
	function showSearchResult(){
		alert('oh~');
	}
	
})