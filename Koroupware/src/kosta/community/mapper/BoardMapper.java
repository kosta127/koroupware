package kosta.community.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.community.model.Board;
import kosta.community.model.BoardModel;
import kosta.community.model.Search;

public interface BoardMapper {
	public int insertBoard(Board board);
	public List<Board> listBoard(RowBounds row, Search search);
	public int selectBoardNo();
	public Board detailBoard(int board_no);
	public int ModifyBoard(Board board);
	public int DeleteBoard(int board_no);
	public int updateHit(int board_no);
	public int countBoard(Search search);
	public int selectMaxBoardNo();
	public List<BoardModel> listBoardModel(RowBounds row, Search search);
}
