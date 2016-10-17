package kosta.login.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;
import kosta.login.mapper.SignUpMapper;

public class SessionDao {
	private static SessionDao dao = new SessionDao();

	public static SessionDao getInstance() {
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
	
	public Emp sessionEmp(String emp_id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{ 
			return sqlSession.getMapper(SignUpMapper.class).sessionEmp(emp_id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
			
	}
	
	public List<Tel> empTel(int emp_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Tel> tel = null;
		try {
			return sqlSession.getMapper(SignUpMapper.class).empTel(emp_no);
		} catch (Exception e) {
			e.printStackTrace();
			return tel;
		}finally{
			sqlSession.close();
		}
	}
}
