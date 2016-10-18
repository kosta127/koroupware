package kosta.dept.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.dept.mapper.DeptMapper;
import kosta.dept.model.Dept;
import kosta.dept.model.OrgChartEmpModel;
import kosta.dept.model.OrgChartModel;
import kosta.emp.dao.EmpDao;
import kosta.emp.mapper.EmpMapper;
import kosta.etc.ETC;
import kosta.etc.SessionFactory;

public class DeptDao {
	private static DeptDao dao;
	private SqlSessionFactory sessionFactory;
	
	{
		sessionFactory = SessionFactory.getInstance();
	}
	
	public static DeptDao getInstance(){
		if(dao == null){
			dao = new DeptDao();
		}

		return dao;
	}

	public List<Dept> selectDeptAll(){
		List<Dept> list = null;
		SqlSession session = sessionFactory.openSession();
		
		try{
			list = session.getMapper(DeptMapper.class).selectDeptAll();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ETC.isNotNull(session)){
				session.close();
			}
		}
		
		return list;
	}
	
	public List<OrgChartEmpModel> selectOrgChartEmpModelByDeptNo(int dept_no){
		List<OrgChartEmpModel> list = null;
		SqlSession session = sessionFactory.openSession();
		
		try{
			list = session.getMapper(DeptMapper.class).selectOrgChartEmpModelByDeptNo(dept_no);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ETC.isNotNull(session)){
				session.close();
			}
		}
		
		return list;
	}
}
