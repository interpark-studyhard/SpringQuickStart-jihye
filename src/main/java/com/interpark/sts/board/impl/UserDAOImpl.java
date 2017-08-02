/**
 * 
 */
package com.interpark.sts.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.interpark.sts.board.common.JDBCUtil;
import com.interpark.sts.board.dao.UserDAO;
import com.interpark.sts.board.vo.UserVO;

/**
 * @author 최지혜
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from users where id=? and password=?";
	
	/* (non-Javadoc)
	 * @see com.interpark.sts.board.dao.UserDAO#getUser(com.interpark.sts.board.vo.UserVO)
	 */
	@Override
	public UserVO getUser(UserVO vo) {
		UserVO userVO = null;
		try {
			LOGGER.info("=== > getUser() .... start ");
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			LOGGER.info("\nQuery : \n {}", rs.getStatement());
			
			if(rs.next()) {
				userVO = new UserVO();
				
				userVO.setId(rs.getString("ID"));
				userVO.setName(rs.getString("NAME"));
				userVO.setPassword(rs.getString("PASSWORD"));
				userVO.setRole(rs.getString("ROLE"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return userVO;
	}

}
