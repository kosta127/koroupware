package kosta.emp.mapper;

import java.util.List;

import kosta.emp.model.Emp;
import kosta.emp.model.SearchEmpModel;

public interface EmpMapper {
	public List<SearchEmpModel> selectSearchEmpModelByKeyword(String keyword);
	
}
