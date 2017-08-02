/**
 * 
 */
package com.interpark.sts.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.interpark.sts.board.common.QueryStatement;
import com.interpark.sts.board.dao.BoardDAO;
import com.interpark.sts.board.vo.BoardVO;

/**
 * @author 최지혜
 */
@Repository
public class BoardSpringDAOImpl extends JdbcDaoSupport implements BoardDAO {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setSuperDataSource(DataSource ds) {
		super.setDataSource(ds);
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardSpringDAOImpl.class);
	
	/* (non-Javadoc)
	 * @see com.interpark.sts.board.dao.BoardDAO#insertBoard(com.interpark.sts.board.vo.BoardVO)
	 */
	@Override
	public void insertBoard(BoardVO vo) {
		LOGGER.info(" -- insertBoard -- ");
//		jdbcTemplate.update(QueryStatement.BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		getJdbcTemplate().update(QueryStatement.BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.board.dao.BoardDAO#updateBoard(com.interpark.sts.board.vo.BoardVO)
	 */
	@Override
	public void updateBoard(BoardVO vo) {
		LOGGER.info(" == updateBoard == ");
//		jdbcTemplate.update(QueryStatement.BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		getJdbcTemplate().update(QueryStatement.BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.board.dao.BoardDAO#deleteBoard(com.interpark.sts.board.vo.BoardVO)
	 */
	@Override
	public void deleteBoard(BoardVO vo) {
		LOGGER.info(" -- deleteBoard --- ");
//		jdbcTemplate.update(QueryStatement.BOARD_DELETE, vo.getSeq());
		getJdbcTemplate().update(QueryStatement.BOARD_DELETE, vo.getSeq());
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.board.dao.BoardDAO#getBoard(com.interpark.sts.board.vo.BoardVO)
	 */
	@Override
	public BoardVO getBoard(BoardVO vo) {
		LOGGER.info(" -- getBoard --- ");
		Object[] args = {vo.getSeq()};
//		return jdbcTemplate.queryForObject(QueryStatement.BOARD_GET, args, new BoardRowMapper());
		return getJdbcTemplate().queryForObject(QueryStatement.BOARD_GET, args, new BoardRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.board.dao.BoardDAO#getBoardList(com.interpark.sts.board.vo.BoardVO)
	 */
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		LOGGER.info(" -- boardList --");
//		return jdbcTemplate.query(QueryStatement.BOARD_LIST, new BoardRowMapper());
		return getJdbcTemplate().query(QueryStatement.BOARD_LIST, new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVO> {
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("mapRow!!!");
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}
}
