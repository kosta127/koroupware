package kosta.community.model;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.community.mapper.CommunityMapper;
import kosta.etc.SessionFactory;

public class CommunityDao {
	private static CommunityDao dao = new CommunityDao();
	private SqlSessionFactory sqlSessionFactory;
	
	{
		sqlSessionFactory = SessionFactory.getInstance();
	}
	
	public static CommunityDao getInstance(){
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
	
	public int insertCommunity(Community community){
		int re = -1;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			re = sqlSession.getMapper(CommunityMapper.class).insertCommunity(community);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return re;
	}
	
	public List<Community> listCommunity(){
		List<Community> list = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			list = sqlSession.getMapper(CommunityMapper.class).listCommunity();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close(); 
		}
		
		return list;
	}
}
