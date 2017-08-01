/**
 * 
 */
package com.interpark.sts.board.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interpark.sts.board.dao.UserDAO;
import com.interpark.sts.board.service.UserService;
import com.interpark.sts.board.vo.UserVO;

/**
 * @author 최지혜
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDAO userDAO;
	
	/* (non-Javadoc)
	 * @see com.interpark.sts.board.service.UserService#getUser(com.interpark.sts.board.vo.UserVO)
	 */
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	public void setUserDao(UserDAO userDao) {
		this.userDAO = userDao;
	}

}
