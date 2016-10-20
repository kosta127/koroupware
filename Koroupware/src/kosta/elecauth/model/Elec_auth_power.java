package kosta.elecauth.model;

import java.io.Serializable;

public class Elec_auth_power implements Serializable{
	private String elec_auth_power;
	private int elec_auth_no;
	private int emp_no;
	
	public Elec_auth_power(){}
	
	public Elec_auth_power(String elec_auth_power, int elec_auth_no, int emp_no) {
		super();
		this.elec_auth_power = elec_auth_power;
		this.elec_auth_no = elec_auth_no;
		this.emp_no = emp_no;
	}

	public String getElec_auth_power() {
		return elec_auth_power;
	}

	public void setElec_auth_power(String elec_auth_power) {
		this.elec_auth_power = elec_auth_power;
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
