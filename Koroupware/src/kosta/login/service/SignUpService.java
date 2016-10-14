package kosta.login.service;
import kosta.login.dao.SignUpDao;
import kosta.login.model.ImageUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;

public class SignUpService {
	private static SignUpDao dao;
	private static SignUpService service = new SignUpService();
	private static int tel_emp_no;

	public static SignUpService getInstance() {
		dao = SignUpDao.getInstance();
		return service;
	}

	public int NewSignUpService(Emp emp) {
		tel_emp_no = dao.selectEmp_no() + 1;
		emp.setEmp_no(tel_emp_no);
		return dao.SignUp(emp);
	}

	public int TelInsertService(Tel tel) {
		tel.setTel_no(dao.selectTel_no() + 1);
		tel.setEmp_no(tel_emp_no);
		return dao.TelInsert(tel);
	}
	
	public int EmpUpdateService(Emp emp){
		return dao.empUpdate(emp);
	}
	
	
}
