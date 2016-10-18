package kosta.doc.model;

import java.io.Serializable;

public class DocFile implements Serializable{
	private int doc_file_no;
	private int doc_no;
	private String doc_file_real_name;
	private String doc_file_save_name;
	private int doc_file_size;
	
	public int getDoc_file_no() {
		return doc_file_no;
	}
	public void setDoc_file_no(int doc_file_no) {
		this.doc_file_no = doc_file_no;
	}
	public int getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}
	public String getDoc_file_real_name() {
		return doc_file_real_name;
	}
	public void setDoc_file_real_name(String doc_file_real_name) {
		this.doc_file_real_name = doc_file_real_name;
	}
	public String getDoc_file_save_name() {
		return doc_file_save_name;
	}
	public void setDoc_file_save_name(String doc_file_save_name) {
		this.doc_file_save_name = doc_file_save_name;
	}
	public int getDoc_file_size() {
		return doc_file_size;
	}
	public void setDoc_file_size(int doc_file_size) {
		this.doc_file_size = doc_file_size;
	}
	@Override
	public String toString() {
		return "DocFile [doc_file_no=" + doc_file_no + ", doc_no=" + doc_no + ", doc_file_real_name="
				+ doc_file_real_name + ", doc_file_save_name=" + doc_file_save_name + ", doc_file_size=" + doc_file_size
				+ "]";
	}
	
	
}
