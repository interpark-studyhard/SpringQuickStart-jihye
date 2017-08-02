/**
 * 
 */
package com.interpark.sts.board.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.interpark.sts.board.service.UserService;
import com.interpark.sts.board.vo.UserVO;

/**
 * @author 최지혜
 *
 */
public class UserServiceClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceClient.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1. execute Spring container
		AbstractApplicationContext container = new GenericXmlApplicationContext("application-context.xml");
		
		// 2. lookup UserServiceImpl from container
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. test login
		UserVO vo = new UserVO();
		vo.setId("omg");
//		vo.setId("desponia");
		vo.setPassword("1111");
		
		UserVO user = userService.getUser(vo);
		LOGGER.info("user : {}", user);
		if(user != null) {
			LOGGER.info("** {} 님 환영합니다.", user.getName());
		}
		container.close();
	}

}
