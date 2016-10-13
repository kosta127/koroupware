package kosta.login.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.emp.model.Emp;
import kosta.login.mapper.SignUpMapper;

public class LoginDao {
	private static LoginDao dao = new LoginDao();

	public static LoginDao getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(input);
	}

	

	public List<Emp> ListEmp() {
		// 로그인 용 리스트
	
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			return sqlSession.getMapper(SignUpMapper.class).checkEmp();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
		
	}
	
	public List<Emp> FindId_ListEmp(){
		// 아이디 찾기 용 리스트
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			return sqlSession.getMapper(SignUpMapper.class).FindId_ListEmp();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sqlSession.close();
		}
	}

	public List<Emp> FindPassword_ListEmp() {
		// 비밀번호 찾는 용 
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			return sqlSession.getMapper(SignUpMapper.class).FindPassword_ListEmp();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sqlSession.close();
		}
		
	}


	


}