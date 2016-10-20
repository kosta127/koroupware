package kosta.login.service;

import java.util.List;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;
import kosta.login.dao.SessionDao;

public class SessionService {
	private static SessionDao dao = new SessionDao();
	private static SessionService service = new SessionService();
	
	public static SessionService getInstance() {
		dao = SessionDao.getInstance();
		return service;
	}
	
	public Emp SessionEmpService(String emp_id){
		return dao.sessionEmp(emp_id);
	}
	
	public List<Tel> empTelService(int emp_no){
		return dao.empTel(emp_no);
	}
}
