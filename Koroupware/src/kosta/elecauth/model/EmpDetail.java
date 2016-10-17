package kosta.elecauth.model;

import java.io.Serializable;

import kosta.emp.model.Emp;

public class EmpDetail extends Emp implements Serializable{
	private String dept_name;
	private String position_name;
	private String office_name;
	
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
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
	@Override
	public String toString() {
		return "EmpDetail [dept_name=" + dept_name + ", position_name=" + position_name + ", office_name=" + office_name
				+ "]";
	}
	
}
