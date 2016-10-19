package kosta.community.model;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.community.mapper.CategoryMapper;
import kosta.etc.SessionFactory;

public class CategoryDao {
	
	private static CategoryDao dao = new CategoryDao();
	private SqlSessionFactory sqlSessionFactory;
	
	{
		sqlSessionFactory = SessionFactory.getInstance();
	}
	
	public static CategoryDao getInstance(){
		return dao;
	}
	
	public Connection getConnection(){
		DataSource ds = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");//데이터 소스 객체를 얻기 위함
			return ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertCategory(Category category){
		int re = -1;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			re = sqlSession.getMapper(CategoryMapper.class).insertCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return re;
	}
	
	public List<Community> listCategory(int community_no){
		List<Community> list = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			list = sqlSession.getMapper(CategoryMapper.class).listCategory(community_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close(); 
		}
		
		return list;
	}

}
