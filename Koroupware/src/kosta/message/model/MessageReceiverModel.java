package kosta.message.model;

public class MessageReceiverModel {
	private int emp_no;
	private String emp_name;
	private String emp_id;
	private String dept_name;
	private String office_name;
	private String position_name;
	
	public MessageReceiverModel(){}
	public MessageReceiverModel(int emp_no, String emp_name, String emp_id, String dept_name, String office_name,
			String position_name) {
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.emp_id = emp_id;
		this.dept_name = dept_name;
		this.office_name = office_name;
		this.position_name = position_name;
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
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	
	@Override
	public String toString() {
		return "MessageReceiverModel [emp_no=" + emp_no + ", emp_name=" + emp_name + ", emp_id=" + emp_id
				+ ", dept_name=" + dept_name + ", office_name=" + office_name + ", position_name=" + position_name
				+ "]";
	}
}
