package kosta.login.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.login.mapper.LoginMapper;
import kosta.login.model.Member;

public class MemberDao {
	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
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

	

	public List<Member> ListMember() {
		// 로그인 용 리스트
	
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			return sqlSession.getMapper(LoginMapper.class).checkMember();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
		
	}
	
	public List<Member> FindId_ListMember(){
		// 아이디 찾기 용 리스트
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			return sqlSession.getMapper(LoginMapper.class).FindId_ListMember();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sqlSession.close();
		}
	}

	public List<Member> FindPassword_ListMember() {
		// 비밀번호 찾는 용 
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			return sqlSession.getMapper(LoginMapper.class).FindPassword_ListMember();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sqlSession.close();
		}
		
	}
	


}