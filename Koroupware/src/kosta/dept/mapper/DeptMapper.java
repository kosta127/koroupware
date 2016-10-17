package kosta.dept.mapper;

import java.util.List;

import kosta.dept.model.Dept;
import kosta.emp.model.Emp;
import kosta.emp.model.SearchEmpModel;

public interface DeptMapper {
	public List<Dept> selectDeptAll();
}
