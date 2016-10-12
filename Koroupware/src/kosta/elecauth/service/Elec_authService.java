package kosta.elecauth.service;

import java.util.List;

import kosta.elecauth.dao.Elec_authDao;
import kosta.elecauth.model.Elec_auth;

public class Elec_authService {
	private static Elec_authService service=new Elec_authService();
	private static Elec_authDao dao;
	
	public static Elec_authService getInstance(){
		dao=Elec_authDao.getInstance();
		
		return service;
	}
	
	public List<Elec_auth> elec_authList(){
		return dao.elec_authList();
	}
	
}
