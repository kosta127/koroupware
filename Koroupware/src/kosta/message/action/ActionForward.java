package kosta.message.action;

public class ActionForward {
	private boolean isRedirect = true;	
	private String path = "fail.do";
	
	public ActionForward(){}
	public ActionForward(boolean isRedirect, String path) {
		this.isRedirect = isRedirect;
		this.path = path;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "ActionForward [isRedirect=" + isRedirect + ", path=" + path + "]";
	}
}
