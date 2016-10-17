package kosta.search.service;

import java.util.List;

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

public List<Search> SearchInfoService(String search_name){
	return dao.SearchInfo(search_name);
}





}
