package nimxxs.hello.spring4.dao;

import nimxxs.hello.spring4.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository("bdao")
public class BoardDAOImpl implements BoardDAO {

    @Value("#{sql['selectBoard']}") private String selectSQL;

    @Autowired JdbcTemplate jdbcTemplate;
    @Override
    public List<Board> selectBoard(int snum) {
        Object[] params = new Object[] {snum};
        RowMapper<Board> mapper = new SelectBoardMapper();

        return jdbcTemplate.query(selectSQL,params,mapper);
    }

    private class SelectBoardMapper implements RowMapper<Board> {

        @Override
        public Board mapRow(ResultSet rs, int num) throws SQLException {
            Board bd = new Board(rs.getString(1),
                    rs.getString(2),rs.getString(3),
                    rs.getString(4),rs.getString(5),
                    null);

            return bd;
        }
    }
}
