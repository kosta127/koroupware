package kosta.elecauth.model;

import java.io.Serializable;

public class Elec_authDetailReferrer implements Serializable{
	private int elec_auth_referrer_no;
	private int elec_auth_no;
	private int emp_no;
	private String emp_name;
	private String dept_name;
	
	public Elec_authDetailReferrer(){}
	public Elec_authDetailReferrer(int elec_auth_referrer_no, int elec_auth_no, int emp_no, String emp_name,
			String dept_name) {
		super();
		this.elec_auth_referrer_no = elec_auth_referrer_no;
		this.elec_auth_no = elec_auth_no;
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.dept_name = dept_name;
	}
	public int getElec_auth_referrer_no() {
		return elec_auth_referrer_no;
	}
	public void setElec_auth_referrer_no(int elec_auth_referrer_no) {
		this.elec_auth_referrer_no = elec_auth_referrer_no;
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
	
	

}
