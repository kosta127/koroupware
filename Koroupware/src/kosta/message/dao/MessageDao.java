package kosta.message.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kosta.etc.ETC;
import kosta.etc.SessionFactory;
import kosta.message.mapper.MessageMapper;
import kosta.message.model.Emp;
import kosta.message.model.Message;
import kosta.message.model.MessageModel;
import kosta.message.model.MessageReceiverModel;

public class MessageDao{
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
	
	public List<MessageModel> selectMessageModelsByEmpId(int emp_no){
		List<MessageModel> messageModelList = null;
		SqlSession session = sessionFactory.openSession();
		
		try{
			messageModelList = session.getMapper(MessageMapper.class).selectMessageModelsByEmpNo(emp_no);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ETC.isNotNull(session)){
				session.close();
			}
		}
		
		return messageModelList;
	}
	
	
	//임시
	public List<MessageReceiverModel> selectMessageReceiverEmpsByEmpId(int emp_no){
		List<MessageReceiverModel> messageReceiverModelList = null;
		SqlSession session = sessionFactory.openSession();
		
		try{
			messageReceiverModelList = 
					session.getMapper(MessageMapper.class).selectMessageReceiverEmpsByEmpId(emp_no);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ETC.isNotNull(session)){
				session.close();
			}
		}
		
		return messageReceiverModelList;
	}
	
	public void commit(SqlSession session, int result){
		if(ETC.isCommit(result)){
			session.commit();
		}else{
			session.rollback();
		}
	}
}
