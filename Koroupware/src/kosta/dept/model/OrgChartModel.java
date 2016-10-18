package kosta.dept.model;

import java.util.List;

import kosta.emp.model.Emp;

public class OrgChartModel {
	private Dept dept;
	private List<OrgChartEmpModel> orgChartEmpList;
	
	public OrgChartModel(){}
	public OrgChartModel(Dept dept, List<OrgChartEmpModel> orgChartEmpList) {
		this.dept = dept;
		this.orgChartEmpList = orgChartEmpList;
	}
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public List<OrgChartEmpModel> getOrgChartEmpList() {
		return orgChartEmpList;
	}
	public void setOrgChartEmpList(List<OrgChartEmpModel> orgChartEmpList) {
		this.orgChartEmpList = orgChartEmpList;
	}
	
	@Override
	public String toString() {
		return "OrgChartModel [dept=" + dept + ", orgChartEmpList=" + orgChartEmpList + "]";
	}
}
