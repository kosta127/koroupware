package kosta.community.model;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import kosta.community.mapper.BoardMapper;


public class BoardDao {
	
	private static BoardDao dao = new BoardDao();
	
	private SqlSessionFactory sqlSessionFactory;
	
	{
		sqlSessionFactory = SessionFactory.getInstance();
	}
	
	public static BoardDao getInstance(){
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
	
	public int insertBoard(Board board){
		int re=-1;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			re = sqlSession.getMapper(BoardMapper.class).insertBoard(board);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
		return re;
	}
	
	public List<Board> listBoard(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Board> list = null;
		
		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
		return list;
		
	}
	
	public Board selectBoardNo(int board_no){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Board board = null;
		
		try {
			board=sqlSession.getMapper(BoardMapper.class).selectBoardNo(board_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return board;
	}
	
	public Board detailBoard(int board_no){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Board board = null;
		
		try {
			board = sqlSession.getMapper(BoardMapper.class).detailBoard(board_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return board;
		
	}
	
	public int ModifyBoard(Board board){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int re = -1;
		
		try {
			re = sqlSession.getMapper(BoardMapper.class).ModifyBoard(board);
			
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
	
	
}






















