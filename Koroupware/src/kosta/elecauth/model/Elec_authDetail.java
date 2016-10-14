package kosta.elecauth.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Elec_authDetail implements Serializable{
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
	
	private String doc_title;
	private String emp_name;
	private String dept_name;
	private String position_no;
	private String position_name;
	private String office_no;
	private String office_name;
	
	public Elec_authDetail(){}	

	public Elec_authDetail(String elec_auth_no, String emp_no, String doc_no, String elec_auth_send_dept_no,
			String elec_auth_title, String elec_auth_contents, String elec_auth_management_dept_no,
			String elec_auth_min_select, String elec_auth_min_reject, Date elec_auth_expiration_period,
			Date elec_auth_processing_period, Date elec_auth_regdate, Date elec_auth_deldate, String doc_title,
			String emp_name, String dept_name, String position_no, String position_name, String office_no,
			String office_name) {
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
		this.doc_title = doc_title;
		this.emp_name = emp_name;
		this.dept_name = dept_name;
		this.position_no = position_no;
		this.position_name = position_name;
		this.office_no = office_no;
		this.office_name = office_name;
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

	public String getDoc_title() {
		return doc_title;
	}

	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getPosition_no() {
		return position_no;
	}

	public void setPosition_no(String position_no) {
		this.position_no = position_no;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getOffice_no() {
		return office_no;
	}

	public void setOffice_no(String office_no) {
		this.office_no = office_no;
	}

	public String getOffice_name() {
		return office_name;
	}

	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	
	
}
