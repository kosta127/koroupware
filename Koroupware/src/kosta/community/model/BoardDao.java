package kosta.community.model;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.community.action.ListAction;
import kosta.community.mapper.BoardMapper;
import kosta.etc.SessionFactory;


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
		int re=0;
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
	
	public List<Board> listBoard(int startRow, Search search, int category_no){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Board> list = null;
		int page_size = ListAction.PAGE_SIZE;
		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoard(new RowBounds(startRow, page_size), search, category_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
		return list;
		
	}
	
	public List<BoardModel> listBoardModel(SelectModel selectModel){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardModel> list = null;
		int page_size = ListAction.PAGE_SIZE;
		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoardModel(new RowBounds(selectModel.getStartRow(), page_size),
					selectModel);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
		return list;
		
	}
	
	public int selectBoardNo(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result=sqlSession.getMapper(BoardMapper.class).selectBoardNo();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return result;
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
	
	public int DeleteBoard(int board_no){
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int re = -1;
		
		try {
			re = sqlSession.getMapper(BoardMapper.class).DeleteBoard(board_no);
			
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
	
	public int updateHit(int board_no){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int result = -1;
		
		try {
			result = sqlSession.getMapper(BoardMapper.class).updateHit(board_no);
			
			if(result>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return result;
	}
	
	public int countBoard(SelectModel selectModel){
		int re = -1;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			re = sqlSession.getMapper(BoardMapper.class).countBoard(selectModel);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null) sqlSession.close();
		}
		
		return re;
	}
	
}






















