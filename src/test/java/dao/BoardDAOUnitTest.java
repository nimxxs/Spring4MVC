package dao;

import nimxxs.hello.spring4.dao.BoardDAO;
import nimxxs.hello.spring4.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml",
        "classpath:spring/root-context.xml"})
@WebAppConfiguration
public class BoardDAOUnitTest {

    @Autowired BoardDAO bdao;
    @Test
    public void selectBoard() throws Exception {
        int cpage = 3;
        int snum = (cpage - 1) * 15;
        List<Board> results = bdao.selectBoard(snum);

        assertEquals(results.size(),15);
        System.out.println(results);
    }
    @Test
    public void selectOneBoard() throws Exception {
        String bno = "300";
        Board results = bdao.selectOneBoard(bno);

        assertNotNull(results);
        System.out.println(results);
    }

    @Test
    @Transactional
    public void insertBoard() throws Exception {
        Board bd = new Board(null,"테스트","abc123", null, null, "냉무");

        assertEquals(bdao.insertBoard(bd),1);
    }
}
