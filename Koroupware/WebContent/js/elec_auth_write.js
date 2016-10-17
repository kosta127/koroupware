/**
 * 
 */

$(function(){
	// CKEDITOR 사용 세팅
	CKEDITOR.replace('elec_auth_contents');	
})

$(function(){
	//임시저장
	var $value = $('#elec_auth_temp_save');
	
	$value.on('click',function(){
		var form = $('#elec_auth_form');
		form.attr('action', 'elec_authSubmission.do?tempYN=Y');
		form.submit();
	});
})

$(function(){
	//문서양식 변경
	$('#docFormList').on('change', function(){
		var str = '<c:forEach var="doc" items="${docFormList}">\n'+
		'<c:if test="${doc.doc_no = '+ $(this).val() +' }">'+
		'<c:out value="${ doc.doc_contents}" />'+
		'</c:if></c:forEach>';
		console.log(str)
		CKEDITOR.instances.elec_auth_contents.setData(str)
	})
})

$(function(){
	//결재자, 참조자 설정
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
		apprSearchList.html("");
		apprSearchList.hide();
	});
	refSearchList.on('click', '.ref_list', function(){
		$(this).appendTo("#referrer_list");
		refSearchList.html("");
		refSearchList.hide();
	});
	
	$("#approval_list").on('click', '.appr_list', function(){
		$(this).remove();
	});
	$("#referrer_list").on('click', '.ref_list', function(){
		$(this).remove();
	});	
})