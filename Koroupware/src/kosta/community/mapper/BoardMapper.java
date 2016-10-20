package kosta.community.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.community.model.Board;
import kosta.community.model.BoardModel;
import kosta.community.model.Search;
import kosta.community.model.SelectModel;

public interface BoardMapper {
	public int insertBoard(Board board);
	public List<Board> listBoard(RowBounds row, Search search, int category_no);
	public int selectBoardNo();
	public Board detailBoard(int board_no);
	public int ModifyBoard(Board board);
	public int DeleteBoard(int board_no);
	public int updateHit(int board_no);
	public int countBoard(SelectModel selectModel);
	public int selectMaxBoardNo();
	public List<BoardModel> listBoardModel(RowBounds row,SelectModel selectModel);
}
