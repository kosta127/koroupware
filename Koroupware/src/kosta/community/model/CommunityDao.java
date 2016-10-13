package kosta.community.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.community.mapper.CommunityMapper;

public class CommunityDao {
	private static CommunityDao dao = new CommunityDao();
	private SqlSessionFactory sqlSessionFactory;
	
	{
		sqlSessionFactory = SessionFactory.getInstance();
	}
	
	public static CommunityDao getInstance(){
		return dao;
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
