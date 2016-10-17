/**
 * 
 */

$(function(){
	// CKEDITOR 사용 세팅
	CKEDITOR.replace('elec_auth_contents');	
})

$(function(){
	var refSearchList = $('#referrer_search_list');
	var apprSearchList = $('#approval_search_list');
	refSearchList.hide();
	apprSearchList.hide();
	
	var ajaxInfo = {
			url: 'empSearchAsJSON.do',
			type: 'post',
			dataType: 'json'
	};
	
	$('#elec_auth_approval_name').keydown(function(){
		if($(this).val()!=''){
			ajaxInfo.data = {'searchKey' : $(this).val()};
			ajaxInfo.success = showApprSearchResult;
			$.ajax(ajaxInfo);
		}
	});
	$('#elec_auth_referrer_name').keydown(function(){
		if($(this).val()!=''){
			ajaxInfo.data = {'searchKey' : $(this).val()};
			ajaxInfo.success = showReferrerSearchResult;
			$.ajax(ajaxInfo);
		}
	});
	
	function showApprSearchResult(data){
		var searchListHtml = '';
		$.each(data, function(idx, empDetail){
			searchListHtml += '<a class="appr_list"><div class="emp_detail">\n';
			searchListHtml += '<span class="emp_name">'+empDetail.emp_name+'</span>';
			searchListHtml += '<span class="emp_dept">'+empDetail.dept_name+'</span>';
			searchListHtml += '<span class="emp_position">'+empDetail.position_name+' - '
			searchListHtml += empDetail.office_name+'</span><br>';
			searchListHtml += '<span class="emp_contract">'+empDetail.emp_email+'</span>';
			searchListHtml += '<input type="hidden" name="approval_emp_no" value="'+empDetail.emp_no+'">'
			searchListHtml += '</div></a><br>';
		})
		apprSearchList.html(searchListHtml);
		apprSearchList.show();
	}
	
	function showReferrerSearchResult(data){
		var searchListHtml = '';
		$.each(data, function(idx, empDetail){
			searchListHtml += '<a class="ref_list"><div class="emp_detail">\n';
			searchListHtml += '<span class="emp_name">'+empDetail.emp_name+'</span>\n';
			searchListHtml += '<span class="emp_dept">'+empDetail.dept_name+'</span>\n';
			searchListHtml += '<span class="emp_position">'+empDetail.position_name+' - '
			searchListHtml += empDetail.office_name+'</span><br>\n';
			searchListHtml += '<span class="emp_contract">'+empDetail.emp_email+'</span>\n';
			searchListHtml += '<input type="hidden" name="refferer_emp_no" value="'+empDetail.emp_no+'">'
			searchListHtml += '</div><br></a>';
		})
		refSearchList.html(searchListHtml);
		refSearchList.show();
	}
	
	apprSearchList.on('click', '.appr_list', function(){
		$(this).appendTo("#approval_list");		
		apprSearchList.hide();
	});
	refSearchList.on('click', '.ref_list', function(){
		$(this).appendTo("#referrer_list");
		refSearchList.hide();
	});
	
	$("#approval_list").on('click', '.appr_list', function(){
		$(this).remove();
	});
	$("#referrer_list").on('click', '.ref_list', function(){
		$(this).remove();
	});	
})