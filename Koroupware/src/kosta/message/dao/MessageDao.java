package kosta.message.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.etc.ETC;
import kosta.etc.SessionFactory;
import kosta.message.mapper.MessageMapper;
import kosta.message.model.Message;

public class MessageDao {
	private static MessageDao dao;
	private SqlSessionFactory sessionFactory;
	
	{
		sessionFactory = SessionFactory.getInstance();
	}
	
	public static MessageDao getInstance(){
		if(dao == null){
			dao = new MessageDao();
		}

		return dao;
	}
	
	public int insertMessage(Message message){
		int result = -1;
		SqlSession session = sessionFactory.openSession();
		
		try{
			result = session.getMapper(MessageMapper.class).insertMessage(message);
			commit(session, result);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ETC.isNotNull(session)){
				session.close();
			}
		}
		
		return result;
	}
	
	public void commit(SqlSession session, int result){
		if(ETC.isCommit(result)){
			session.commit();
		}else{
			session.rollback();
		}
	}
}
