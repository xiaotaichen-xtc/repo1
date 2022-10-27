package com.lagou.seivice.impl;

import com.lagou.dao.IUserDao;
import com.lagou.seivice.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements IUserService {

	private IUserDao iUserDao;

//	public UserServiceImpl(IUserDao iUserDao) {
//		this.iUserDao = iUserDao;
//	}


	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	@Override
	public void save() {
		//调用dao层的save方法
//		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		IUserDao userDao = (IUserDao)classPathXmlApplicationContext.getBean("userDao");
//		userDao.save();

		iUserDao.save();
	}
}
