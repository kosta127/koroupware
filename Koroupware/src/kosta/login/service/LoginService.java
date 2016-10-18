package kosta.login.service;

import java.util.List;

import kosta.emp.model.Emp;
import kosta.login.dao.LoginDao;

public class LoginService {
	public static LoginDao dao = new LoginDao();
	public static LoginService service = new LoginService();
	
	public static LoginService getInstance(){
		dao = LoginDao.getInstance();
		return service;
	}
	
	public List<Emp> ListEmpServivce(){
		return dao.ListEmp();
	}
	
	public List<Emp> FindId_ListEmpService(){
		return dao.FindId_ListEmp();
	}
	
	public List<Emp> FindPassword_ListEmpService(){
		return dao.FindPassword_ListEmp();
	}
}
