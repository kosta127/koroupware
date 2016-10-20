package kosta.search.service;

import java.util.List;

import kosta.doc.model.Doc;
import kosta.emp.model.Emp;
import kosta.search.dao.SearchDao;
import kosta.search.model.Search;

public class SearchService {   
	public static SearchDao dao = new SearchDao();
	public static SearchService service = new SearchService();
	
	public static SearchService getInstance(){
	   dao = SearchDao.getInstance();
	   return service;
	}
	
	public List<Emp> ListEmpServivce() {
		// 이름으로 전체 검사
		return dao.ListEmp();
	}
	
	

	
	public List<Doc> ListDocService(){
		return dao.ListDoc();
	}

	public List<Search> SearchNameService(String search_content) {
		return dao.SearchName("%"+search_content+"%");
	}
	
	public List<Doc> SearchDocService(String search_content){
		
		return dao.SearchDoc("%"+search_content+"%");
	}

	public List<Doc> SearchDocEmpNameService(String search_content) {
		// TODO Auto-generated method stub
		return dao.SearchDocEmpName("%"+search_content+"%");
	}
}
