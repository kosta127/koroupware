package kosta.emp.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Emp implements Serializable{
	private int emp_no;
	private String emp_name;
	private int dept_no;
	private String emp_email;
	private int emp_superior;
	private int emp_reporter;
	private String emp_id;
	private String emp_password;
	private String emp_address;
	private String emp_approvalyn;
	private String emp_residentnumber;
	private Date emp_hiredate;
	private Date emp_resigndate;
	private int position_no;
	private int office_no;
	private String emp_email_sign;
	private String emp_elec_auth_signkey;
	private String emp_img;
	private String emp_elec_auth_img;
	
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
	public int getDept_no() {
		return dept_no;
	}
	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public int getEmp_superior() {
		return emp_superior;
	}
	public void setEmp_superior(int emp_superior) {
		this.emp_superior = emp_superior;
	}
	public int getEmp_reporter() {
		return emp_reporter;
	}
	public void setEmp_reporter(int emp_reporter) {
		this.emp_reporter = emp_reporter;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getEmp_approvalyn() {
		return emp_approvalyn;
	}
	public void setEmp_approvalyn(String emp_approvalyn) {
		this.emp_approvalyn = emp_approvalyn;
	}
	public String getEmp_residentnumber() {
		return emp_residentnumber;
	}
	public void setEmp_residentnumber(String emp_residentnumber) {
		this.emp_residentnumber = emp_residentnumber;
	}
	public Date getEmp_hiredate() {
		return emp_hiredate;
	}
	public void setEmp_hiredate(Date emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}
	public Date getEmp_resigndate() {
		return emp_resigndate;
	}
	public void setEmp_resigndate(Date emp_resigndate) {
		this.emp_resigndate = emp_resigndate;
	}
	public int getPosition_no() {
		return position_no;
	}
	public void setPosition_no(int position_no) {
		this.position_no = position_no;
	}
	public int getOffice_no() {
		return office_no;
	}
	public void setOffice_no(int office_no) {
		this.office_no = office_no;
	}
	public String getEmp_email_sign() {
		return emp_email_sign;
	}
	public void setEmp_email_sign(String emp_email_sign) {
		this.emp_email_sign = emp_email_sign;
	}
	public String getEmp_elec_auth_signkey() {
		return emp_elec_auth_signkey;
	}
	public void setEmp_elec_auth_signkey(String emp_elec_auth_signkey) {
		this.emp_elec_auth_signkey = emp_elec_auth_signkey;
	}
	public String getEmp_img() {
		return emp_img;
	}
	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
	}
	public String getEmp_elec_auth_img() {
		return emp_elec_auth_img;
	}
	public void setEmp_elec_auth_img(String emp_elec_auth_img) {
		this.emp_elec_auth_img = emp_elec_auth_img;
	}
	
	@Override
	public String toString() {
		return "Emp [emp_no=" + emp_no + ", emp_name=" + emp_name + ", dept_no=" + dept_no + ", emp_email=" + emp_email
				+ ", emp_superior=" + emp_superior + ", emp_reporter=" + emp_reporter + ", emp_id=" + emp_id
				+ ", emp_password=" + emp_password + ", emp_address=" + emp_address + ", emp_approvalyn="
				+ emp_approvalyn + ", emp_residentnumber=" + emp_residentnumber + ", emp_hiredate=" + emp_hiredate
				+ ", emp_resigndate=" + emp_resigndate + ", position_no=" + position_no + ", office_no=" + office_no
				+ ", emp_email_sign=" + emp_email_sign + ", emp_elec_auth_signkey=" + emp_elec_auth_signkey
				+ ", emp_img=" + emp_img + ", emp_elec_auth_img=" + emp_elec_auth_img + "]";
	}
}
