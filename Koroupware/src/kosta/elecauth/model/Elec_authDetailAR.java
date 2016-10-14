package kosta.elecauth.model;

import java.io.Serializable;
import java.sql.Date;

public class Elec_authDetailAR implements Serializable{	
	private int elec_auth_no;
	private int emp_no;
	private String approval_list_pass;
	private int approval_list_step ;
	private int elec_auth_referrer_no;
	private String emp_name;
	private String position_name;
	private String office_name;
	
	public Elec_authDetailAR(){}
	public Elec_authDetailAR(int elec_auth_no, int emp_no, String approval_list_pass, int approval_list_step,
			int elec_auth_referrer_no, String emp_name, String position_name, String office_name) {
		super();
		this.elec_auth_no = elec_auth_no;
		this.emp_no = emp_no;
		this.approval_list_pass = approval_list_pass;
		this.approval_list_step = approval_list_step;
		this.elec_auth_referrer_no = elec_auth_referrer_no;
		this.emp_name = emp_name;
		this.setOffice_name(office_name);
		this.setPosition_name(position_name);
	}
	public int getElec_auth_no() {
		return elec_auth_no;
	}
	public void setElec_auth_no(int elec_auth_no) {
		this.elec_auth_no = elec_auth_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getApproval_list_pass() {
		return approval_list_pass;
	}
	public void setApproval_list_pass(String approval_list_pass) {
		this.approval_list_pass = approval_list_pass;
	}
	public int getApproval_list_step() {
		return approval_list_step;
	}
	public void setApproval_list_step(int approval_list_step) {
		this.approval_list_step = approval_list_step;
	}
	public int getElec_auth_referrer_no() {
		return elec_auth_referrer_no;
	}
	public void setElec_auth_referrer_no(int elec_auth_referrer_no) {
		this.elec_auth_referrer_no = elec_auth_referrer_no;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	
	
	
}
