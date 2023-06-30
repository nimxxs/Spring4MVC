package nimxxs.hello.spring4.dao;

import nimxxs.hello.spring4.model.Board;

import java.util.List;

public interface BoardDAO {
    List<Board> selectBoard(int snum);
}
