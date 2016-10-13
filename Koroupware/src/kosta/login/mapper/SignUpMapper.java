package kosta.login.mapper;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;

public interface SignUpMapper {
	public int SignUp(Emp emp);
	public int TelInsert(Tel tel);
	public Integer selectEmp_no();
	public Integer selectTel_no();
}
