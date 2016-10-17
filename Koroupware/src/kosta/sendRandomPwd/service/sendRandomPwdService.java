package kosta.sendRandomPwd.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import kosta.emp.model.Emp;
import kosta.sendRandomPwd.dao.sendRandomPwdDao;

public class sendRandomPwdService {
	private static sendRandomPwdDao dao = new sendRandomPwdDao();
	private static sendRandomPwdService service  = new sendRandomPwdService();
	
	public static sendRandomPwdService getInstance(){
		dao = sendRandomPwdDao.getInstance();
		return service;
	}





	public int SessionPwdService(Emp list) {
		return dao.changpwd(list);
		
	}
	

}
