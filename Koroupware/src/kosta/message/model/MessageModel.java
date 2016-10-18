package kosta.message.model;


public class MessageModel {
	private int message_no;
	private String message_contents;
	private String message_senddate;
	private int message_sender_no;
	private String sender_name;
	private String sender_id;
	private String sender_dept_name;
	private String sender_office_name;
	private String sender_position_name;
	private int message_receiver_no;
	private String receiver_name;
	private String receiver_id;
	private String receiver_dept_name;
	private String receiver_office_name;
	private String receiver_position_name;
	
	public MessageModel(){}
	public MessageModel(int message_no, String message_contents, String message_senddate, int message_sender_no,
			String sender_name, String sender_id, String sender_dept_name, String sender_office_name,
			String sender_position_name, int message_receiver_no, String receiver_name, String receiver_id,
			String receiver_dept_name, String receiver_office_name, String receiver_position_name) {
		this.message_no = message_no;
		this.message_contents = message_contents;
		this.message_senddate = message_senddate;
		this.message_sender_no = message_sender_no;
		this.sender_name = sender_name;
		this.sender_id = sender_id;
		this.sender_dept_name = sender_dept_name;
		this.sender_office_name = sender_office_name;
		this.sender_position_name = sender_position_name;
		this.message_receiver_no = message_receiver_no;
		this.receiver_name = receiver_name;
		this.receiver_id = receiver_id;
		this.receiver_dept_name = receiver_dept_name;
		this.receiver_office_name = receiver_office_name;
		this.receiver_position_name = receiver_position_name;
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
	public String getMessage_senddate() {
		return message_senddate;
	}
	public void setMessage_senddate(String message_senddate) {
		this.message_senddate = message_senddate;
	}
	public int getMessage_sender_no() {
		return message_sender_no;
	}
	public void setMessage_sender_no(int message_sender_no) {
		this.message_sender_no = message_sender_no;
	}
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getSender_dept_name() {
		return sender_dept_name;
	}
	public void setSender_dept_name(String sender_dept_name) {
		this.sender_dept_name = sender_dept_name;
	}
	public String getSender_office_name() {
		return sender_office_name;
	}
	public void setSender_office_name(String sender_office_name) {
		this.sender_office_name = sender_office_name;
	}
	public String getSender_position_name() {
		return sender_position_name;
	}
	public void setSender_position_name(String sender_position_name) {
		this.sender_position_name = sender_position_name;
	}
	public int getMessage_receiver_no() {
		return message_receiver_no;
	}
	public void setMessage_receiver_no(int message_receiver_no) {
		this.message_receiver_no = message_receiver_no;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getReceiver_dept_name() {
		return receiver_dept_name;
	}
	public void setReceiver_dept_name(String receiver_dept_name) {
		this.receiver_dept_name = receiver_dept_name;
	}
	public String getReceiver_office_name() {
		return receiver_office_name;
	}
	public void setReceiver_office_name(String receiver_office_name) {
		this.receiver_office_name = receiver_office_name;
	}
	public String getReceiver_position_name() {
		return receiver_position_name;
	}
	public void setReceiver_position_name(String receiver_position_name) {
		this.receiver_position_name = receiver_position_name;
	}
	
	@Override
	public String toString() {
		return "MessageModel [message_no=" + message_no + ", message_contents=" + message_contents
				+ ", message_senddate=" + message_senddate + ", message_sender_no=" + message_sender_no
				+ ", sender_name=" + sender_name + ", sender_id=" + sender_id + ", sender_dept_name=" + sender_dept_name
				+ ", sender_office_name=" + sender_office_name + ", sender_position_name=" + sender_position_name
				+ ", message_receiver_no=" + message_receiver_no + ", receiver_name=" + receiver_name + ", receiver_id="
				+ receiver_id + ", receiver_dept_name=" + receiver_dept_name + ", receiver_office_name="
				+ receiver_office_name + ", receiver_position_name=" + receiver_position_name + "]";
	}
}
