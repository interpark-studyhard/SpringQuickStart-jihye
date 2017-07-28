package com.interpark.sts.board.dao;

import com.interpark.sts.board.BoardVO;
import com.interpark.sts.board.common.JDBCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by 최지혜 on 2017-07-28.
 */
public class BoardDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardDAO.class);

    private final String BOARD_INSERT = "insert into board (seq, title, writer, content) values ((select nvl(max(seq), 0) +1 from board), ?, ?, ?)";
    private final String BOARD_UPDATE = "update board set title = ?, content = ? where 1=1 and seq = ?";
    private final String BOARD_DELETE = "delete board where 1=1 and seq = ?";
    private final String BOARD_GET = "select * from board where seq = ?";
    private final String BOARD_LIST = "select * from board order by sea desc";

    // write
    public void insertBoard(BoardVO vo) {
        LOGGER.info("=== > JDBC 로 insertBoard 기능 처리 .. ");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getWriter());
            stmt.setString(3, vo.getContent());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // update
    public void updateBoard(BoardVO vo) {
        LOGGER.info(" === > JDBC 로 updateBoard () .. ");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

    }

}
