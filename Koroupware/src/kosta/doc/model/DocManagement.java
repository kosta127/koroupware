package kosta.doc.model;

import java.io.Serializable;

public class DocManagement implements Serializable{
	private int doc_manage_no;
	private int doc_no;
	private int doc_box_no;
	public int getDoc_manage_no() {
		return doc_manage_no;
	}
	public void setDoc_manage_no(int doc_manage_no) {
		this.doc_manage_no = doc_manage_no;
	}
	public int getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}
	public int getDoc_box_no() {
		return doc_box_no;
	}
	public void setDoc_box_no(int doc_box_no) {
		this.doc_box_no = doc_box_no;
	}
	
	
}
