package kosta.elecauth.service;

import java.util.List;

import kosta.elecauth.dao.Elec_authDao;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_authPage;

public class Elec_authService2 {
	private static Elec_authService2 service = new Elec_authService2();
	private static Elec_authDao dao;
	
	public static Elec_authService2 getInstance(){
		dao = Elec_authDao.getInstance();
		
		return service;
	}
}
