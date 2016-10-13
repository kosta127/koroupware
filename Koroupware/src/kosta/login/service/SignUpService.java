package kosta.login.service;
import kosta.login.dao.SignUpDao;
import kosta.emp.model.Emp;
import kosta.emp.model.Tel;

public class SignUpService {
	private static SignUpDao dao;
	private static SignUpService service = new SignUpService();
	
	public static SignUpService getInstance(){
		dao = SignUpDao.getInstance();
		return service;
	} 
	
	public int NewSignUpService(Emp emp){
		emp.setEmp_no(dao.selectEmp_no() + 1);
		return dao.SignUp(emp);
	}
	
	public int TelInsertService(Tel tel){
		tel.setTel_no(dao.selectTel_no() + 1);
		return dao.TelInsert(tel);
	}
	

}
