package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.seivice.IUserService;
import com.lagou.seivice.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {
	@Test
	public void test1(){
		//1.使用spring相关API获得Bean实例, 借助上下文对象可以获取IOC容器中的bean对象，这一句就创建了bean对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		//磁盘路径对象
		FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("E:\\englishi\\applicationContext.xml");

		//2.传bean id
		//IUserDao userDao = (IUserDao)applicationContext.getBean("userDao");

		//根据类型注入
//		IUserDao userDao = (IUserDao)applicationContext.getBean(IUserDao.class);

		//重载2  (如果匹配到很多实例就会报错) 需要指定getBean(“userDao2”,IUserDao.class)
		IUserDao userDao = (IUserDao)applicationContext.getBean("userDao",IUserDao.class);

//		IUserDao userDao1 = (IUserDao) fileSystemXmlApplicationContext.getBean("userDao");

		userDao.save();
		System.out.println("---------------------------");
		//userDao.save();
	}

	@Test
	public void test2(){

		//核心接口，不会创建bean对象存到容器中
		BeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//getBean的时候才存到真正的Bean对象, 它门创建bean对象的 时机不一样
		IUserDao userDao = (IUserDao)xmlBeanFactory.getBean("userDao");
		userDao.save();

	}

	/*
	  测试scope属性：singleton效果
   */
	@Test
	public void test3(){


		ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserDao userDao = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

		IUserDao userDao2 = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

		System.out.println(userDao);

		System.out.println(userDao2);

	}

	/*
	   测试scope属性：prototype效果
	*/
	@Test
	public void test4(){

		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserDao userDao = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

		IUserDao userDao2 = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

		System.out.println(userDao);

		System.out.println(userDao2);

		classPathXmlApplicationContext.close();

	}

	@Test
	public void test5(){
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService userService = (IUserService) classPathXmlApplicationContext.getBean("userService");
		userService.save();

	}

}
