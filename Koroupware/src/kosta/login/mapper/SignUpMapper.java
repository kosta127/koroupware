package kosta.login.mapper;

import java.util.List;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;

public interface SignUpMapper {
	public int SignUp(Emp emp);
	public int TelInsert(Tel tel);
	public Integer selectEmp_no();
	public Integer selectTel_no();

	//로그인,  아이디/비밀번호 찾기
	public List<Emp> FindId_ListEmp();
	public List<Emp> FindPassword_ListEmp();
	public List<Emp> checkEmp();
}
