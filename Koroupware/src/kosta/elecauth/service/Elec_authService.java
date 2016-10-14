package kosta.elecauth.service;

import java.util.List;

import kosta.elecauth.dao.Elec_authDao;
import kosta.elecauth.model.Approval_list;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_authDetail;
import kosta.elecauth.model.Elec_authDetailAR;
import kosta.elecauth.model.Elec_authPage;
import kosta.elecauth.model.Elec_auth_referrer;

public class Elec_authService {
	private static Elec_authService service=new Elec_authService();
	private static Elec_authDao dao;
	
	public static Elec_authService getInstance(){
		dao=Elec_authDao.getInstance();
		
		return service;
	}
	
	public List<Elec_auth> elec_authList(int pageNum){
		int startRow=(pageNum-1)*dao.LIST_SIZE;
		return dao.elec_authList(startRow);
	}
	
	public Elec_authPage elec_authListPage(int currentPage){
		int pageNumber=10;
		int totCount=dao.getTotalCount();
		int totalPage = totCount/dao.LIST_SIZE + ((totCount%dao.LIST_SIZE>0)?1:0);
		int startPage = (currentPage<=pageNumber)?1:((currentPage/pageNumber)*pageNumber)+1;
		int endPage = (totalPage<(startPage+pageNumber)-1)?totalPage:(startPage+pageNumber)-1;
		return new Elec_authPage(totalPage, startPage, endPage, currentPage,
						startPage>pageNumber, endPage<totalPage);
	}
	
	public Elec_authDetail elec_authDetail(int elec_auth_no){
		return dao.elec_authDetail(elec_auth_no);
	}
	
	public Elec_authDetailAR elec_authDetailAR(int elec_auth_no){
		return dao.elec_authDetailAR(elec_auth_no);
	}
	
	public boolean insertElecAuth(Elec_auth ea, 
			List<Approval_list> approvals, List<Elec_auth_referrer> referrers ){
		return dao.insertElecAuth(ea, approvals, referrers);
	}
}