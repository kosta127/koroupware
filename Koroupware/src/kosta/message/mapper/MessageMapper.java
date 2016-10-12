package kosta.message.mapper;

import java.util.List;

import kosta.message.model.Message;
import kosta.message.model.MessageModel;
import kosta.message.model.MessageReceiverModel;

public interface MessageMapper {
	public int insertMessage(Message message);
	public List<MessageModel> selectMessageModelsByEmpNo(int emp_no);
	public List<MessageReceiverModel> selectMessageReceiverEmpsByEmpId(int emp_no);
	
}
