package kosta.login.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.login.mapper.SignUpMapper;
import kosta.emp.model.Emp;
import kosta.emp.model.Tel;

public class SignUpDao {
	private static SignUpDao dao = new SignUpDao();
	
	public static SignUpDao getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(input);
	}
	

	public int SignUp(Emp emp){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		re = sqlSession.getMapper(SignUpMapper.class).SignUp(emp);
		try {
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re;
	} 
	
	public int TelInsert(Tel tel){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		re = sqlSession.getMapper(SignUpMapper.class).TelInsert(tel);
		try {
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re;
	}
	
	public int selectEmp_no(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();	
		if(sqlSession.getMapper(SignUpMapper.class).selectEmp_no() == null){
			return 0;
		}else{
			return sqlSession.getMapper(SignUpMapper.class).selectEmp_no();
		}
	}
	
	public int selectTel_no(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();	
		if(sqlSession.getMapper(SignUpMapper.class).selectTel_no() == null){
			return 0;
		}else{
			return sqlSession.getMapper(SignUpMapper.class).selectTel_no();
		}
	}
}
