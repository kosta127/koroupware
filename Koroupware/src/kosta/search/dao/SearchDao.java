package kosta.search.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.emp.model.Emp;
import kosta.login.dao.LoginDao;
import kosta.login.mapper.SignUpMapper;
import kosta.search.mapper.SearchMapper;

public class SearchDao {
	private static SearchDao dao = new SearchDao();

	public static SearchDao getInstance() {
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
	
	public List<Emp> ListEmp() {
		// 로그인 용 리스트
	
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			return sqlSession.getMapper(SearchMapper.class).InformationEmp();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
		
	}
}
