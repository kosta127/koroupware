$(function(){
	$('.category span').click(function(){
		$.get('../category/categoryInsertForm.jsp', {'term':$(this).text()},function(data){
			$('#contents').empty();
			$('#contents').html(data);
		});
		
		return false;
	});
});