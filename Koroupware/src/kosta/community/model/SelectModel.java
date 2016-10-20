package kosta.community.model;

public class SelectModel {
	private int startRow;
	private Search search;
	private int category_no;
	
	public SelectModel(){}
	public SelectModel(int startRow, Search search, int category_no) {
		this.startRow = startRow;
		this.search = search;
		this.category_no = category_no;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	
	@Override
	public String toString() {
		return "SelectModel [startRow=" + startRow + ", search=" + search + ", category_no=" + category_no + "]";
	}
}
