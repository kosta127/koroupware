package kosta.search.mapper;

import java.util.List;

import kosta.emp.model.Emp;

public interface SearchMapper {
	//문서, 사원 검색 용
	public List<Emp> InformationEmp();

	public List<Emp> SearchEmpInfo();

}
