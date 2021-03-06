package kosta.emp.model;

import java.io.Serializable;

public class Tel implements Serializable{
	private int tel_no;
	private int emp_no;
	private String tel_type;
	private String tel_telephone;
	
	public int getTel_no() {
		return tel_no;
	}
	public void setTel_no(int tel_no) {
		this.tel_no = tel_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getTel_type() {
		return tel_type;
	}
	public void setTel_type(String tel_type) {
		this.tel_type = tel_type;
	}
	public String getTel_telephone() {
		return tel_telephone;
	}
	public void setTel_telephone(String tel_telephone) {
		this.tel_telephone = tel_telephone;
	}
	@Override
	public String toString() {
		return "Tel [tel_no=" + tel_no + ", emp_no=" + emp_no + ", tel_type=" + tel_type + ", tel_telephone="
				+ tel_telephone + "]";
	}
}
