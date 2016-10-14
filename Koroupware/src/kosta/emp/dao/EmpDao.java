package kosta.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.emp.mapper.EmpMapper;
import kosta.emp.model.Emp;
import kosta.emp.model.SearchEmpModel;
import kosta.etc.ETC;
import kosta.etc.SessionFactory;
import kosta.message.mapper.MessageMapper;
import kosta.message.model.MessageReceiverModel;

public class EmpDao{
	private static EmpDao dao;
	private SqlSessionFactory sessionFactory;
	
	{
		sessionFactory = SessionFactory.getInstance();
	}
	
	public static EmpDao getInstance(){
		if(dao == null){
			dao = new EmpDao();
		}

		return dao;
	}
	
	public List<SearchEmpModel> selectSearchEmpModelByKeyword(String keyword){
		List<SearchEmpModel> searchEmpModelList = null;
		SqlSession session = sessionFactory.openSession();
		
		try{
			searchEmpModelList = session.getMapper(EmpMapper.class).selectSearchEmpModelByKeyword(keyword);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ETC.isNotNull(session)){
				session.close();
			}
		}
		
		return searchEmpModelList;
	}
	
	
	public void commit(SqlSession session, int result){
		if(ETC.isCommit(result)){
			session.commit();
		}else{
			session.rollback();
		}
	}
}
