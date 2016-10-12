package kosta.elecauth.model;

import java.io.Serializable;
import java.sql.Date;

public class Elec_auth implements Serializable {
	private String elec_auth_no;
	private String emp_no;
	private String doc_no;
	private String elec_auth_send_dept_no;
	private String elec_auth_title;
	private String elec_auth_contents;
	private String elec_auth_management_dept_no;
	private String elec_auth_min_select;
	private String elec_auth_min_reject;
	private Date elec_auth_expiration_period;
	private Date elec_auth_processing_period;
	private Date elec_auth_regdate;
	private Date elec_auth_deldate;

	public Elec_auth() {
	}

	public Elec_auth(String elec_auth_no, String emp_no, String doc_no, String elec_auth_send_dept_no,
			String elec_auth_title, String elec_auth_contents, String elec_auth_management_dept_no,
			String elec_auth_min_select, String elec_auth_min_reject, Date elec_auth_expiration_period,
			Date elec_auth_processing_period, Date elec_auth_regdate, Date elec_auth_deldate) {
		super();
		this.elec_auth_no = elec_auth_no;
		this.emp_no = emp_no;
		this.doc_no = doc_no;
		this.elec_auth_send_dept_no = elec_auth_send_dept_no;
		this.elec_auth_title = elec_auth_title;
		this.elec_auth_contents = elec_auth_contents;
		this.elec_auth_management_dept_no = elec_auth_management_dept_no;
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

	public String getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public String getElec_auth_send_dept_no() {
		return elec_auth_send_dept_no;
	}

	public void setElec_auth_send_dept_no(String elec_auth_send_dept_no) {
		this.elec_auth_send_dept_no = elec_auth_send_dept_no;
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

	public String getElec_auth_management_dept_no() {
		return elec_auth_management_dept_no;
	}

	public void setElec_auth_management_dept_no(String elec_auth_management_dept_no) {
		this.elec_auth_management_dept_no = elec_auth_management_dept_no;
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

	public Date getElec_auth_expiration_period() {
		return elec_auth_expiration_period;
	}

	public void setElec_auth_expiration_period(Date elec_auth_expiration_period) {
		this.elec_auth_expiration_period = elec_auth_expiration_period;
	}

	public Date getElec_auth_processing_period() {
		return elec_auth_processing_period;
	}

	public void setElec_auth_processing_period(Date elec_auth_processing_period) {
		this.elec_auth_processing_period = elec_auth_processing_period;
	}

	public Date getElec_auth_regdate() {
		return elec_auth_regdate;
	}

	public void setElec_auth_regdate(Date elec_auth_regdate) {
		this.elec_auth_regdate = elec_auth_regdate;
	}

	public Date getElec_auth_deldate() {
		return elec_auth_deldate;
	}

	public void setElec_auth_deldate(Date elec_auth_deldate) {
		this.elec_auth_deldate = elec_auth_deldate;
	}

	

}