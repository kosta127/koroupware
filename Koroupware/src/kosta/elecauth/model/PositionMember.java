package kosta.elecauth.model;

public class PositionMember {
	private String position_no;
	private String position_name;
	
	public PositionMember(){}

	public PositionMember(String position_no, String position_name) {
		super();
		this.position_no = position_no;
		this.position_name = position_name;
	}

	public String getPosition_no() {
		return position_no;
	}

	public void setPosition_no(String position_no) {
		this.position_no = position_no;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	
	
}
