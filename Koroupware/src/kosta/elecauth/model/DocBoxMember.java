package kosta.elecauth.model;

public class DocBoxMember {
	private String doc_box_no;
	private String doc_box_name;
	private String doc_box_regdate;
	private String emp_no;
	
	public DocBoxMember(){}

	public DocBoxMember(String doc_box_no, String doc_box_name, String doc_box_regdate, String emp_no) {
		super();
		this.doc_box_no = doc_box_no;
		this.doc_box_name = doc_box_name;
		this.doc_box_regdate = doc_box_regdate;
		this.emp_no = emp_no;
	}

	public String getDoc_box_no() {
		return doc_box_no;
	}

	public void setDoc_box_no(String doc_box_no) {
		this.doc_box_no = doc_box_no;
	}

	public String getDoc_box_name() {
		return doc_box_name;
	}

	public void setDoc_box_name(String doc_box_name) {
		this.doc_box_name = doc_box_name;
	}

	public String getDoc_box_regdate() {
		return doc_box_regdate;
	}

	public void setDoc_box_regdate(String doc_box_regdate) {
		this.doc_box_regdate = doc_box_regdate;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	
	
}
