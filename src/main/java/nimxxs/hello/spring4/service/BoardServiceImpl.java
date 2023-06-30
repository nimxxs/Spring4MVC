package nimxxs.hello.spring4.service;

import nimxxs.hello.spring4.dao.BoardDAO;
import nimxxs.hello.spring4.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bsrv")
public class BoardServiceImpl implements BoardService {

    @Autowired BoardDAO bdao;

    @Override
    public List<Board> readBoard(int cpg) {
        int snum = (cpg-1) *15;

        return bdao.selectBoard(snum);
    }
}