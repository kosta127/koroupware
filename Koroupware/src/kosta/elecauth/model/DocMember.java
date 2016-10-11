package kosta.elecauth.model;

public class DocMember {
	private String doc_no;
	private String doc_box_no;
	private String emp_no;
	private String doc_title;
	private String doc_explain;
	private String doc_content;
	private String doc_regdate;
	private String doc_con_period;
	private String doc_deldate;
	
	public DocMember(){}

	public DocMember(String doc_no, String doc_box_no, String emp_no, String doc_title, String doc_explain,
			String doc_content, String doc_regdate, String doc_con_period, String doc_deldate) {
		super();
		this.doc_no = doc_no;
		this.doc_box_no = doc_box_no;
		this.emp_no = emp_no;
		this.doc_title = doc_title;
		this.doc_explain = doc_explain;
		this.doc_content = doc_content;
		this.doc_regdate = doc_regdate;
		this.doc_con_period = doc_con_period;
		this.doc_deldate = doc_deldate;
	}

	public String getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public String getDoc_box_no() {
		return doc_box_no;
	}

	public void setDoc_box_no(String doc_box_no) {
		this.doc_box_no = doc_box_no;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getDoc_title() {
		return doc_title;
	}

	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}

	public String getDoc_explain() {
		return doc_explain;
	}

	public void setDoc_explain(String doc_explain) {
		this.doc_explain = doc_explain;
	}

	public String getDoc_content() {
		return doc_content;
	}

	public void setDoc_content(String doc_content) {
		this.doc_content = doc_content;
	}

	public String getDoc_regdate() {
		return doc_regdate;
	}

	public void setDoc_regdate(String doc_regdate) {
		this.doc_regdate = doc_regdate;
	}

	public String getDoc_con_period() {
		return doc_con_period;
	}

	public void setDoc_con_period(String doc_con_period) {
		this.doc_con_period = doc_con_period;
	}

	public String getDoc_deldate() {
		return doc_deldate;
	}

	public void setDoc_deldate(String doc_deldate) {
		this.doc_deldate = doc_deldate;
	}

	
	
	
}
