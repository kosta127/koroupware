package kosta.elecauth.model;

public class DeptMember {
	private String dept_no;
	private String dept_name;
	private String dept_work;
	private String dept_address;
	private String dept_telephone;
	
	public DeptMember(){}

	public DeptMember(String dept_no, String dept_name, String dept_work, String dept_address, String dept_telephone) {
		super();
		this.dept_no = dept_no;
		this.dept_name = dept_name;
		this.dept_work = dept_work;
		this.dept_address = dept_address;
		this.dept_telephone = dept_telephone;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
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

	public String getDept_address() {
		return dept_address;
	}

	public void setDept_address(String dept_address) {
		this.dept_address = dept_address;
	}

	public String getDept_telephone() {
		return dept_telephone;
	}

	public void setDept_telephone(String dept_telephone) {
		this.dept_telephone = dept_telephone;
	}
	
	
}
