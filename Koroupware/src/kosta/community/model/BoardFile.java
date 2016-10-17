package kosta.community.model;

public class BoardFile {
	
	private int board_file_no;
	private String board_file_save_name;
	private String board_file_real_name;
	private int board_file_size;
	private int board_no;
	
	public int getBoard_file_no() {
		return board_file_no;
	}
	public void setBoard_file_no(int board_file_no) {
		this.board_file_no = board_file_no;
	}
	public String getBoard_file_save_name() {
		return board_file_save_name;
	}
	public void setBoard_file_save_name(String board_file_save_name) {
		this.board_file_save_name = board_file_save_name;
	}
	public String getBoard_file_real_name() {
		return board_file_real_name;
	}
	public void setBoard_file_real_name(String board_file_real_name) {
		this.board_file_real_name = board_file_real_name;
	}
	public int getBoard_file_size() {
		return board_file_size;
	}
	public void setBoard_file_size(int board_file_size) {
		this.board_file_size = board_file_size;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	@Override
	public String toString() {
		return "BoardFile [board_file_no=" + board_file_no + ", board_file_save_name=" + board_file_save_name
				+ ", board_file_real_name=" + board_file_real_name + ", board_file_size=" + board_file_size
				+ ", board_no=" + board_no + "]";
	}

}
