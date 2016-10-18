var $sendForm;
var $messageBox;
var $messageReceiverList;
var $messageReceivers;
var $searchEmpText;
var messageBoxIntervalId;
var receiverEmpNo;

function setMessageBox(data) {
	if (data[0].fail) {
		$("div#senderInfo").html(" ");
		$messageBox.html(" ");
	} else {
		$("div#senderInfo").html(
				data[0].receiver_dept_name + " - " + data[0].receiver_name
						+ data[0].receiver_office_name + "("
						+ data[0].receiver_position_name + ")");
		var html = "";

		for (var i = 0; i < data.length; i++) {
			var contents = data[i].message_contents;
			var senddate = data[i].message_senddate;
			var receiverNo = data[i].message_receiver_no;

			if (receiverNo == receiverEmpNo) {
				html += "<div class='myMessage'>" + contents
						+ "<span class='messageSendDate'>" + senddate
						+ "</span></div>";
			} else {
				html += "<div class='receiverMessage'>" + contents
						+ "<span class='messageSendDate'>" + senddate
						+ "</span></div>";
			}
		}

		$messageBox.html(html);
	}
}

function messageReceiverSelect(event) {
	receiverEmpNo = $(this).find("span#receiverEmpNoText").text();
	$("form#sendForm>input#receiverEmpNo").val(receiverEmpNo);
}

function messageBoxUpdate() {
	if (receiverEmpNo != null) {
		$.ajax({
			url : "message/ajax/messageReceiveAjax.jsp",
			type : "POST",
			dataType : "json",
			data : "receiverNo=" + receiverEmpNo,
			success : setMessageBox
		});
	} else {
		$("div#senderInfo").html(" ");
		$messageBox.html(" ");
	}
}

function messageSendEvent(event) {
	var $textarea = $(this).find("textarea");
	var text = $textarea.val();

	$.ajax({
		url : "message/ajax/messageSendAjax.jsp",
		type : "POST",
		data : "receiverEmpNo=" + receiverEmpNo + "&messageContents=" + text
	});

	$textarea.val("");
	$messageBox.scrollTop($messageBox.prop("scrollHeight"));
	event.preventDefault();
}

function searchEmpEvent() {
	var text = $(this).val();

	$.ajax({
		url : "ajax/searchEmpAjax.jsp",
		type : "POST",
		dataType : "json",
		data : "searchKeyword=" + text,
		success : autoCompleteEmpName
	});
}

function autoCompleteEmpName(data) {
	var arr = new Array();

	for (var i = 0; i < data.length; i++) {
		arr[i] = data[i].dept_name + " - " + data[i].emp_name
				+ data[i].office_name + " (" + data[i].position_name + ")";
	}

	$searchEmpText.autocomplete({
		source : arr,
		select : function() {
			for (var i = 0; i < data.length; i++) {
				if (arr[i] == $(this).val()) {
					receiverEmpNo = data[i].emp_no;
					break;
				}
			}
		}
	});
}

function variableInit() {
	messageBoxIntervalId = setInterval(messageBoxUpdate, 1000);
	$messageReceiverList = $("ol#messageReceiverList");
	$messageReceivers = $messageReceiverList.find("li");
	$messageBox = $("div#messageBox");
	$sendForm = $("form#sendForm");
	$searchEmpText = $("input#searchEmpText");
}

function functionInit() {
	$messageReceivers.on("click", $messageReceiverList, messageReceiverSelect);
	$sendForm.on("submit", messageSendEvent);
	$searchEmpText.on("keydown", searchEmpEvent);
}

$(function() {
	variableInit();
	functionInit();
});

/* 
function messageReceiverListUpdate(){
	$.ajax({
		url : "ajax/messageReceiverListAjax.jsp",
		type : "POST",
		dataType : "json",
		success : setMessageReceiverList
	});
}

function setMessageReceiverList(data){
	var html = "";

	for(var i = 0; i < data.length; i++){
		html += "<li>" + data[i].dept_name + " - " + data[i].emp_name +
						data[i].office_name + "(" + data[i].position_name +")" + 
						"<span class='hidden'>" + data[i].emp_no + "</span></li>";
	}
	
	$messageReceiverList.html(html);
}
 */