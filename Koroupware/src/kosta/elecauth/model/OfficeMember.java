package kosta.elecauth.model;

public class OfficeMember {
	private String office_no;
	private String office_name;
	
	public OfficeMember(){}

	public OfficeMember(String office_no, String office_name) {
		super();
		this.office_no = office_no;
		this.office_name = office_name;
	}

	public String getOffice_no() {
		return office_no;
	}

	public void setOffice_no(String office_no) {
		this.office_no = office_no;
	}

	public String getOffice_name() {
		return office_name;
	}

	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	
	
}
