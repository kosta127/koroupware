package kosta.elecauth.model;

import java.io.Serializable;

public class Elec_auth_referrer implements Serializable{
	private int elec_auth_referrer_no;
	private int elec_auth_no;
	private int emp_no;
	
	public Elec_auth_referrer(){}
	
	public Elec_auth_referrer(int elec_auth_referrer_no, int elec_auth_no, int emp_no) {
		super();
		this.elec_auth_referrer_no = elec_auth_referrer_no;
		this.elec_auth_no = elec_auth_no;
		this.emp_no = emp_no;
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
	
}
