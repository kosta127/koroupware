/**
 * 
 */

$(function() {
	//결재작성버튼
	$('#write').on('click', function() {
		location.href = "elec_authWriteForm.do"; 
	});
});

$( function() {
	//결재함 메뉴
   /* $( "#elec_auth_box" ).accordion({
      collapsible: true
    });*/
  } );

$(function(){
	// 결재함 active 바꾸기	
	function Request(){
		 var requestParam ="";
		 this.getParameter = function(param){
			 var url = unescape(location.href); //현재 주소를 decoding
			 var paramArr = (url.substring(url.indexOf("?")+1,url.length)).split("&"); 
			 for(var i = 0 ; i < paramArr.length ; i++){
				 var temp = paramArr[i].split("="); //파라미터 변수명을 담음
				 if(temp[0].toUpperCase() == param.toUpperCase()){
					 requestParam = paramArr[i].split("=")[1]; 
					 break;
				 }
			 }
			 return requestParam;
		 }
	}
	
	var isReceive = new Request().getParameter("receive")!='';
	var flag = new Request().getParameter("flag");


	if(flag==''){
		//$('#'+((isReceive)?'receive':'write')+'_list li').first().addClass('active');
	}else{
		$('#'+((isReceive)?'receive':'write')+'_list li a').each(function(idx, atag){
			if($(atag).attr('href').indexOf(flag)>0){
				$(atag).parent().addClass('active');
			}
		})
	}
})