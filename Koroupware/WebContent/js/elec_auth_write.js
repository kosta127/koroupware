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
	//문서양식
	$('#docform_div div').hide();
	//문서양식 변경
	$('#docFormList').on('change', function(){
		var str = $('#hidden_docform_div_'+$(this).val()).html();
		CKEDITOR.instances.elec_auth_contents.setData(str)
	})
})

$(function(){
	//결재마감일 달력 
	var $endDate = $('#elec_auth_enddate');
	$endDate.datepicker({minDate : 0,
						dateFormat : 'yy-MM-dd',
						monthNames : ['01', '02', '03', '04', '05', '06', 
							'07', '08', '09', '10', '11', '12'],
						monthNamesShort : ['01', '02', '03', '04', '05', '06', 
								'07', '08', '09', '10', '11', '12'],	
						dayNames: ['일', '월', '화', '수', '목', '금', '토'],
						closeText: '닫기',
				        prevText: '이전달',
				        nextText: '다음달',
				        currentText: '오늘',
				        changeYear: true,
				        changeMonth: true,
				        showButtonPanel: true,
				        showOtherMonths: true,
				        selectOtherMonths: true,
				        showMonthAfterYear: true});
})

$( function() {
	//결재자, 참조자 설정	
	var autoCompleteList = new Array();	
	
	$.ajax({
		url: 'empSearchAsJSON.do',
		type: 'post',
		dataType: 'json',
		success : setAutocompleteList
	});	
	
	function setAutocompleteList(data){		
		$.each(data, function(idx, empDetail){			
			autoCompleteList.push(
				{
					value: empDetail.emp_name,
					label: empDetail.emp_name,
				    emp_no: empDetail.emp_no,
				    dept_name: empDetail.dept_name,
				    position_name: empDetail.position_name,
				    office_name: empDetail.office_name,
				    emp_email: empDetail.emp_email,
				    desc: '<div class="emp_detail">\n<span class="emp_name">'+empDetail.emp_name+'</span>' +
	        		 		'<span class="emp_dept">'+empDetail.dept_name+'</span>' +
	        		 		'<span class="emp_position">'+empDetail.position_name+' ' +
	        		 		empDetail.office_name+'</span><br><span class="emp_contract">'+empDetail.emp_email+'</span></div>'
				}
			);
		})		
	}

	//결재자
	var $approv = $('#elec_auth_approval');
	$approv.autocomplete({
	      minLength: 0,
	      source: autoCompleteList,
	      focus: function( event, ui ) {
	    	  //$approv.val( ui.item.value );
	        return false;
	      },
	      select: function( event, ui ) {
	    	$( '#'+$approv.attr('id')+'_list' ).append('<a class="appr_list">'+ui.item.desc+
	    			'<input type="hidden" name="approval_emp_no" value="'+ui.item.emp_no+'"></a>');
	    	$approv.val('');
	        return false;
	      }
	    })
	    .autocomplete( 'instance' )._renderItem = function( ul, item ) {
	      return $( '<li>' )
	        .append(item.desc)
	        .appendTo( ul );
	    };
	//참조자
    var $referr = $('#elec_auth_referrer');
    $referr.autocomplete({
	      minLength: 0,
	      source: autoCompleteList,
	      focus: function( event, ui ) {
	    	  //$referr.val( ui.item.value );
	        return false;
	      },
	      select: function( event, ui ) {
	    	$( '#'+$referr.attr('id')+'_list' ).append('<a class="ref_list">'+ui.item.desc+
	    			'<input type="hidden" name="referrer_emp_no" value="'+ui.item.emp_no+'"></a>');
	    	$referr.val('');
	        return false;
	      }
	    })
	    .autocomplete( 'instance' )._renderItem = function( ul, item ) {
	      return $( '<li>' )
	        .append(item.desc)
	        .appendTo( ul );
	    };
	
	//목록클릭시 사라지게
    $("#elec_auth_approval_list").on('click', '.appr_list', function(){
		$(this).remove();
	});
	$("#elec_auth_referrer_list").on('click', '.ref_list', function(){
		$(this).remove();
	});
});