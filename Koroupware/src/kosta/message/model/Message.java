package kosta.message.model;

import java.sql.Date;

public class Message {
	private int message_no;
	private String message_contents;
	private Date message_senddate;
	private Date message_deldate;
	private int message_sender_no;
	private int message_receiver_no;
	
	public Message(){}
	public Message(int message_no, String message_contents, Date message_senddate, Date message_deldate,
			int message_sender_no, int message_receiver_no) {
		this.message_no = message_no;
		this.message_contents = message_contents;
		this.message_senddate = message_senddate;
		this.message_deldate = message_deldate;
		this.message_sender_no = message_sender_no;
		this.message_receiver_no = message_receiver_no;
	}
	
	public int getMessage_no() {
		return message_no;
	}
	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}
	public String getMessage_contents() {
		return message_contents;
	}
	public void setMessage_contents(String message_contents) {
		this.message_contents = message_contents;
	}
	public Date getMessage_senddate() {
		return message_senddate;
	}
	public void setMessage_senddate(Date message_senddate) {
		this.message_senddate = message_senddate;
	}
	public Date getMessage_deldate() {
		return message_deldate;
	}
	public void setMessage_deldate(Date message_deldate) {
		this.message_deldate = message_deldate;
	}
	public int getMessage_sender_no() {
		return message_sender_no;
	}
	public void setMessage_sender_no(int message_sender_no) {
		this.message_sender_no = message_sender_no;
	}
	public int getMessage_receiver_no() {
		return message_receiver_no;
	}
	public void setMessage_receiver_no(int message_receiver_no) {
		this.message_receiver_no = message_receiver_no;
	}
	
	@Override
	public String toString() {
		return "Message [message_no=" + message_no + ", message_contents=" + message_contents + ", message_senddate="
				+ message_senddate + ", message_deldate=" + message_deldate + ", message_sender_no=" + message_sender_no
				+ ", message_receiver_no=" + message_receiver_no + "]";
	}
}
