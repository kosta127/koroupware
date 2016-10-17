package kosta.community.model;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.community.mapper.BoardFileMapper;
import kosta.etc.SessionFactory;

public class BoardFileDao {
	
	private static BoardFileDao filedao = new BoardFileDao();
	
	private SqlSessionFactory sqlSessionFactory;
	{
		sqlSessionFactory = SessionFactory.getInstance();
	}
	
	public static BoardFileDao getInstance(){
		return filedao;
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
	
	public int fileInsert(BoardFile boardfile){
		int re=-1;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			re = sqlSession.getMapper(BoardFileMapper.class).insertFile(boardfile);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return re;
	}
	
	public List<BoardFile> fileList(int board_no){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BoardFile> list = null;
		
		try {
			list = sqlSession.getMapper(BoardFileMapper.class).selectListFileByBoardNo(board_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}

}
