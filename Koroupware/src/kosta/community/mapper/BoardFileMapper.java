package kosta.community.mapper;

import java.util.List;

import kosta.community.model.BoardFile;

public interface BoardFileMapper {
	public List<BoardFile> selectListFileByBoardNo(int board_no);
	public int insertFile(BoardFile boardfile);
}
