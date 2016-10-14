package kosta.elecauth.model;

public class ElecAuth {
	private String elec_auth_no;
	private String emp_no;
	private String dept_no;
	private String doc_no;
	private String elec_auth_title;
	private String elec_auth_contents;
	private String elec_auth_management_dept;
	private String elec_auth_min_select;
	private String elec_auth_min_reject;
	private String elec_auth_expiration_period;
	private String elec_auth_processing_period;
	private String elec_auth_regdate;
	private String elec_auth_deldate;
	
	public ElecAuth(){}

	public ElecAuth(String elec_auth_no, String emp_no, String dept_no, String doc_no, String elec_auth_title,
			String elec_auth_contents, String elec_auth_management_dept, String elec_auth_min_select,
			String elec_auth_min_reject, String elec_auth_expiration_period, String elec_auth_processing_period,
			String elec_auth_regdate, String elec_auth_deldate) {
		super();
		this.elec_auth_no = elec_auth_no;
		this.emp_no = emp_no;
		this.dept_no = dept_no;
		this.doc_no = doc_no;
		this.elec_auth_title = elec_auth_title;
		this.elec_auth_contents = elec_auth_contents;
		this.elec_auth_management_dept = elec_auth_management_dept;
		this.elec_auth_min_select = elec_auth_min_select;
		this.elec_auth_min_reject = elec_auth_min_reject;
		this.elec_auth_expiration_period = elec_auth_expiration_period;
		this.elec_auth_processing_period = elec_auth_processing_period;
		this.elec_auth_regdate = elec_auth_regdate;
		this.elec_auth_deldate = elec_auth_deldate;
	}

	public String getElec_auth_no() {
		return elec_auth_no;
	}

	public void setElec_auth_no(String elec_auth_no) {
		this.elec_auth_no = elec_auth_no;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public String getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public String getElec_auth_title() {
		return elec_auth_title;
	}

	public void setElec_auth_title(String elec_auth_title) {
		this.elec_auth_title = elec_auth_title;
	}

	public String getElec_auth_contents() {
		return elec_auth_contents;
	}

	public void setElec_auth_contents(String elec_auth_contents) {
		this.elec_auth_contents = elec_auth_contents;
	}

	public String getElec_auth_management_dept() {
		return elec_auth_management_dept;
	}

	public void setElec_auth_management_dept(String elec_auth_management_dept) {
		this.elec_auth_management_dept = elec_auth_management_dept;
	}

	public String getElec_auth_min_select() {
		return elec_auth_min_select;
	}

	public void setElec_auth_min_select(String elec_auth_min_select) {
		this.elec_auth_min_select = elec_auth_min_select;
	}

	public String getElec_auth_min_reject() {
		return elec_auth_min_reject;
	}

	public void setElec_auth_min_reject(String elec_auth_min_reject) {
		this.elec_auth_min_reject = elec_auth_min_reject;
	}

	public String getElec_auth_expiration_period() {
		return elec_auth_expiration_period;
	}

	public void setElec_auth_expiration_period(String elec_auth_expiration_period) {
		this.elec_auth_expiration_period = elec_auth_expiration_period;
	}

	public String getElec_auth_processing_period() {
		return elec_auth_processing_period;
	}

	public void setElec_auth_processing_period(String elec_auth_processing_period) {
		this.elec_auth_processing_period = elec_auth_processing_period;
	}

	public String getElec_auth_regdate() {
		return elec_auth_regdate;
	}

	public void setElec_auth_regdate(String elec_auth_regdate) {
		this.elec_auth_regdate = elec_auth_regdate;
	}

	public String getElec_auth_deldate() {
		return elec_auth_deldate;
	}

	public void setElec_auth_deldate(String elec_auth_deldate) {
		this.elec_auth_deldate = elec_auth_deldate;
	}

	
	
	
}
