package kosta.dept.mapper;

import java.util.List;

import kosta.dept.model.Dept;
import kosta.dept.model.OrgChartEmpDetailModel;
import kosta.dept.model.OrgChartEmpModel;
import kosta.dept.model.OrgChartModel;
import kosta.emp.model.Emp;
import kosta.emp.model.SearchEmpModel;

public interface DeptMapper {
	public List<Dept> selectDeptAll();
	public List<OrgChartEmpModel> selectOrgChartEmpModelByDeptNo(int dept_no);
	public OrgChartEmpDetailModel selectOrgChartEmpDetailModelByEmpNo(int emp_no);
}