package com.interpark.sts.board.impl;

import com.interpark.sts.board.common.JDBCUtil;
import com.interpark.sts.board.dao.BoardDAO;
import com.interpark.sts.board.vo.BoardVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 최지혜 on 2017-07-28.
 */
@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardDAOImpl.class);

    private final String BOARD_INSERT = "insert into board (seq, title, writer, content) values ((select nvl(max(seq), 0) +1 from board), ?, ?, ?)";
    private final String BOARD_UPDATE = "update board set title = ?, content = ? where 1=1 and seq = ?";
    private final String BOARD_DELETE = "delete board where 1=1 and seq = ?";
    private final String BOARD_GET = "select * from board where seq = ?";
    private final String BOARD_LIST = "select * from board order by seq desc";

    // write
    @Override
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
    @Override
    public void updateBoard(BoardVO vo) {
        LOGGER.info(" === > JDBC 로 updateBoard () .. ");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getContent());
            stmt.setInt(3, vo.getSeq());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // delete
    @Override
    public void deleteBoard(BoardVO vo) {
        try {
            LOGGER.info("=== > JDBC 로 deleteBoard () ;....");
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // get board detail
    @Override
    public BoardVO getBoard(BoardVO vo) {
        LOGGER.info("==== > JDBC 로 getBoard detail ...");
        BoardVO boardVO = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, vo.getSeq());
            rs = stmt.executeQuery();
            if(rs.next()) {
                boardVO = new BoardVO();
                boardVO.setSeq(rs.getInt("SEQ"));
                boardVO.setTitle(rs.getString("TITLE"));
                boardVO.setWriter(rs.getString("WRITER"));
                boardVO.setContent(rs.getString("CONTENT"));
                boardVO.setRegDate(rs.getDate("REGDATE"));
                boardVO.setCnt(rs.getInt("CNT"));
            }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return boardVO;
    }

    // get board list
    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        LOGGER.info("==== > JDBC 로 getBoard List ...");
        List<BoardVO> boardList = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            LOGGER.info("Query  : \n "+BOARD_LIST);
            rs = stmt.executeQuery();

            while (rs.next()) {
                BoardVO boardVO = new BoardVO();
                boardVO.setSeq(rs.getInt("SEQ"));
                boardVO.setTitle(rs.getString("TITLE"));
                boardVO.setWriter(rs.getString("WRITER"));
                boardVO.setContent(rs.getString("CONTENT"));
                boardVO.setRegDate(rs.getDate("REGDATE"));
                boardVO.setCnt(rs.getInt("CNT"));
                boardList.add(boardVO);
            }
        } catch (Exception e) {
    		e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return boardList;
    }
}
