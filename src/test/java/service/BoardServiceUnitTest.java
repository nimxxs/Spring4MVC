package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import nimxxs.hello.spring4.model.Board;
import nimxxs.hello.spring4.model.Member;
import nimxxs.hello.spring4.service.BoardService;
import nimxxs.hello.spring4.service.MemberService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml",
        "classpath:spring/root-context.xml" })
@WebAppConfiguration

public class BoardServiceUnitTest {

    @Autowired BoardService bsrv;

    @Test
    public void readBoard() throws Exception {
        int cpage = 1;
        List<Board> results = bsrv.readBoard(cpage);

        assertEquals(results.size(),15);
        System.out.println(results);
    }
}