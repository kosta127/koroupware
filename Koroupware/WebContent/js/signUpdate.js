function cancel() {
	location.href = "main.do";
}
function telAdd() {
	location.href = "telAdd.do?emp_no=" + $('.emp_no').val() + "&tel_type=" + $('.tel_type').val() + "&tel_telephone=" + $('.tel_telephone').val();
}

function telDelete(tel_no) {
	location.href = "telDelete.do?tel_no=" + tel_no;
}

function telUpdate(index){
	location.href = "telUpdate.do?emp_no=" + $('.emp_no').val() + "&tel_no=" + $("#oldTelNo-"+index).val() + "&tel_type=" + $("#oldTelType-"+index).val() + "&tel_telephone=" + $("#oldTelTelephone-"+index).val();
}
