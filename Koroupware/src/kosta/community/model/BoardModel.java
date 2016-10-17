package kosta.community.model;

import java.sql.Timestamp;

public class BoardModel {
	private int board_no; 
	private String board_title;
	private int board_hit;
	private Timestamp board_regdate;
	private String emp_name; 
	private String position_name; 
	private String office_name; 
	private String dept_name;
	
	public BoardModel(){}
	public BoardModel(int board_no, String board_title, int board_hit, Timestamp board_regdate, String emp_name,
			String position_name, String office_name, String dept_name) {
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_hit = board_hit;
		this.board_regdate = board_regdate;
		this.emp_name = emp_name;
		this.position_name = position_name;
		this.office_name = office_name;
		this.dept_name = dept_name;
	}
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public Timestamp getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(Timestamp board_regdate) {
		this.board_regdate = board_regdate;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
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
	
	@Override
	public String toString() {
		return "BoardModel [board_no=" + board_no + ", board_title=" + board_title + ", board_hit=" + board_hit
				+ ", board_regdate=" + board_regdate + ", emp_name=" + emp_name + ", position_name=" + position_name
				+ ", office_name=" + office_name + ", dept_name=" + dept_name + "]";
	}
}
