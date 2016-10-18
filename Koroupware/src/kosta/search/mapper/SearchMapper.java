package kosta.search.mapper;

import java.util.List;

import kosta.doc.model.Doc;
import kosta.emp.model.Emp;
import kosta.search.model.Search;

public interface SearchMapper {
	//문서, 사원 검색 용
	public List<Emp> ListEmp();

	public List<Doc> ListDoc();


	public List<Search> SearchName(String search_content);
	
	public List<Doc> SearchDoc(String search_content);
}
