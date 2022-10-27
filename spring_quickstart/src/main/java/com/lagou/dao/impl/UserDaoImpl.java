package com.lagou.dao.impl;

import com.lagou.dao.IUserDao;

public class UserDaoImpl implements IUserDao {
	private String userName;
	private Integer age;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	//	public void init(){
//		System.out.println("初始化方法执行了。。。。。");
//	}
//
//	public void destory(){
//		System.out.println("销毁方法执行了。。。。。。");
//	}

	public void save() {
		System.out.println("userName---"+userName);
		System.out.println("age---"+age);
		System.out.println("被调用了");
	}


}
