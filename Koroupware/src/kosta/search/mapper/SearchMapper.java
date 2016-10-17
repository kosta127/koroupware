package kosta.search.mapper;

import java.util.List;

import kosta.emp.model.Emp;
import kosta.search.model.Search;

public interface SearchMapper {
	//문서, 사원 검색 용
	public List<Emp> ListEmp();


	public List<Search> SearchInfo(String search_name);
}
