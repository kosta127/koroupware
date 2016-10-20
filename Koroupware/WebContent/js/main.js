function logout() {
	location.href = "logout.do";
}
function signUpdate() {
	location.href = "signUpdateForm.jsp";
}
function community_create() {
	location.href = "insertCommunityForm.do?emp_no=${emp.emp_no}";
}