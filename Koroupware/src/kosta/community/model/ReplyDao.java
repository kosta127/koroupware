package kosta.community.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.community.mapper.ReplyMapper;
import kosta.community.model.ReplyDao;
import kosta.etc.SessionFactory;

public class ReplyDao {
	private static ReplyDao dao = new ReplyDao();
	private SqlSessionFactory sqlSessionFactory; 
	
	{
		sqlSessionFactory = SessionFactory.getInstance();
	}
	
	public static ReplyDao getInstance(){
		return dao;
	}
	
	public int insertReply(Reply reply){
		int re=-1;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			re=sqlSession.getMapper(ReplyMapper.class).insertReply(reply);
			
			if(re>0){
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
	
	public List<ReplyModel> selectReplyModelByBoardNo(int board_no){
		List<ReplyModel> list = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			list=sqlSession.getMapper(ReplyMapper.class).selectReplyModelByBoardNo(board_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
	
	public int DeleteReplyBoard(int reply_no){
		int re = -1;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			re=sqlSession.getMapper(ReplyMapper.class).deleteReplyByReplyNo(reply_no);
			
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
