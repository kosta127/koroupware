package kosta.login.mapper;

import java.util.List;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;

public interface SignUpMapper {
	public int SignUp(Emp emp);
	public int TelInsert(Tel tel);
	public Integer selectEmp_no();
	public Integer selectTel_no();
	public Emp sessionEmp(String emp_id);
	public List<Tel> empTel(int emp_no);
	public int empUpdate(Emp emp);
	//로그인,  아이디/비밀번호 찾기
	public List<Emp> FindId_ListEmp();
	public List<Emp> FindPassword_ListEmp();
	public List<Emp> checkEmp();
}
 