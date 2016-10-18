package kosta.community.mapper;

import java.util.List;

import kosta.community.model.Reply;
import kosta.community.model.ReplyModel;

public interface ReplyMapper {
	public int insertReply(Reply reply);
	public List<ReplyModel> selectReplyModelByBoardNo(int board_no);
	public int deleteReplyByReplyNo(int reply_no);
}
