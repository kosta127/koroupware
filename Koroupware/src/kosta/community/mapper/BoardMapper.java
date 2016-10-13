package kosta.community.mapper;

import java.util.List;
import kosta.community.model.Board;

public interface BoardMapper {
	public int insertBoard(Board board);
	public List<Board> listBoard();
	public Board selectBoardNo(int board_no);
	public Board detailBoard(int board_no);
	public int ModifyBoard(Board board);
}
