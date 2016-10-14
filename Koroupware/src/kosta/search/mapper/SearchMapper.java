package kosta.search.mapper;

import java.util.List;

import kosta.emp.model.Emp;
import kosta.search.model.Search;

public interface SearchMapper {
	//문서, 사원 검색 용
	public List<Emp> InformationEmp(String search_content);

	public List<Search> SearchEmpInfo(String search_name);
}
