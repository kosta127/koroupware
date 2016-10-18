package kosta.search.model;

import java.io.Serializable;
import java.sql.Date;

public class Search implements Serializable{
	private String dept_name;
	private String emp_name;
	private String emp_email;
	private String emp_id;
	private String emp_address;
	private Date emp_hiredate;
	
	private int doc_no;
	private String doc_title;
	private String doc_explain;
	private String doc_contents;
	private Date doc_con_period;
	

	public String getEmp_email() {
		return emp_email;
	}
	public int getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
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
	public String getDoc_contents() {
		return doc_contents;
	}
	public void setDoc_contents(String doc_contents) {
		this.doc_contents = doc_contents;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public Date getEmp_hiredate() {
		return emp_hiredate;
	}
	public void setEmp_hiredate(Date emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Date getDoc_con_period() {
		return doc_con_period;
	}
	public void setDoc_con_period(Date doc_con_period) {
		this.doc_con_period = doc_con_period;
	}


}
