package kosta.community.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReplyModel implements Serializable{
	private int reply_no;
	private String reply_contents;
	private Timestamp reply_regdate;
	private String emp_name;
	private int board_no;
	
	public ReplyModel(){}
	public ReplyModel(int reply_no, String reply_contents, Timestamp reply_regdate, String emp_name, int board_no) {
		this.reply_no = reply_no;
		this.reply_contents = reply_contents;
		this.reply_regdate = reply_regdate;
		this.emp_name = emp_name;
		this.board_no = board_no;
	}

	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_contents() {
		return reply_contents;
	}
	public void setReply_contents(String reply_contents) {
		this.reply_contents = reply_contents;
	}
	public Timestamp getReply_regdate() {
		return reply_regdate;
	}
	public void setReply_regdate(Timestamp reply_regdate) {
		this.reply_regdate = reply_regdate;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	@Override
	public String toString() {
		return "ReplyModel [reply_no=" + reply_no + ", reply_contents=" + reply_contents + ", reply_regdate="
				+ reply_regdate + ", emp_name=" + emp_name + ", board_no=" + board_no + "]";
	}
	
	
}
