package kosta.elecauth.service;

import java.util.List;

import kosta.doc.model.Doc;
import kosta.elecauth.dao.Elec_authDao;
import kosta.elecauth.model.Approval_list;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_authDetail;
import kosta.elecauth.model.Elec_authDetailApproval;
import kosta.elecauth.model.Elec_authDetailReferrer;
import kosta.elecauth.model.Elec_authList;
import kosta.elecauth.model.Elec_authPage;
import kosta.elecauth.model.Elec_auth_referrer;
import kosta.elecauth.model.EmpDetail;

public class Elec_authService {
	private static Elec_authService service=new Elec_authService();
	private static Elec_authDao dao;
	
	public static Elec_authService getInstance(){
		dao=Elec_authDao.getInstance();
		
		return service;
	}
	
	public List<Elec_authList> elec_authList(int pageNum, int emp_no){
		int startRow=(pageNum-1)*dao.LIST_SIZE;
		return dao.elec_authList(startRow, emp_no);
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
	
	public List<Elec_authDetailApproval> elec_authDetailApproval(int elec_auth_no){
		return dao.elec_authDetailApproval(elec_auth_no);
	}
	
	public List<Elec_authDetailReferrer> elec_authDetailReferrer(int elec_auth_no){
		return dao.elec_authDetailReferrer(elec_auth_no);
	}
	
	public boolean insertElecAuth(Elec_auth ea, 
			List<Approval_list> approvals, List<Elec_auth_referrer> referrers ){
		int elecAuthNO = dao.getNextElecAuthNo();
		ea.setElec_auth_no(elecAuthNO);
		for(Approval_list l : approvals) l.setElec_auth_no(elecAuthNO);
		for(Elec_auth_referrer ref : referrers) ref.setElec_auth_no(elecAuthNO);
		return dao.insertElecAuth(ea, approvals, referrers);
	}
	
	public List<EmpDetail> searchEmp(String keyword){
		return dao.searchEmp(keyword);
	}
	
	public List<Doc> getDocFormList(){
		return dao.getDocFormList();
	}
}
