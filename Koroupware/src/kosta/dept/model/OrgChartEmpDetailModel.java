package kosta.dept.model;

import java.io.Serializable;
import java.util.Date;

public class OrgChartEmpDetailModel implements Serializable{
	private int emp_no;
	private String emp_name;
	private String emp_email;
	private String emp_id;
	private String emp_address;
	private Date emp_hiredate;
	private String emp_img;
	private int emp_superior;
	private int emp_reporter;
	private String position_name;
	private String office_name;
	private String dept_name;
	private String dept_work;
	private String classification;
	
	public OrgChartEmpDetailModel(){}
	public OrgChartEmpDetailModel(int emp_no, String emp_name, String emp_email, String emp_id, String emp_address,
			Date emp_hiredate, String emp_img, int emp_superior, int emp_reporter, String position_name,
			String office_name, String dept_name, String dept_work, String classification) {
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_id = emp_id;
		this.emp_address = emp_address;
		this.emp_hiredate = emp_hiredate;
		this.emp_img = emp_img;
		this.emp_superior = emp_superior;
		this.emp_reporter = emp_reporter;
		this.position_name = position_name;
		this.office_name = office_name;
		this.dept_name = dept_name;
		this.dept_work = dept_work;
		this.classification = classification;
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
	public String getEmp_email() {
		return emp_email;
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
	public String getEmp_img() {
		return emp_img;
	}
	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
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
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_work() {
		return dept_work;
	}
	public void setDept_work(String dept_work) {
		this.dept_work = dept_work;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	@Override
	public String toString() {
		return "OrgChartEmpDetailModel [emp_no=" + emp_no + ", emp_name=" + emp_name + ", emp_email=" + emp_email
				+ ", emp_id=" + emp_id + ", emp_address=" + emp_address + ", emp_hiredate=" + emp_hiredate
				+ ", emp_img=" + emp_img + ", emp_superior=" + emp_superior + ", emp_reporter=" + emp_reporter
				+ ", position_name=" + position_name + ", office_name=" + office_name + ", dept_name=" + dept_name
				+ ", dept_work=" + dept_work + ", classification=" + classification + "]";
	}
}
