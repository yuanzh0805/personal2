package cn.sdu.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.sdu.domain.User;


public class Test {

	@Resource
	private static SessionFactory sessionFactory;
	@org.junit.Test
	public void test() {
		User user =new User();
		user.setUsername("jia");
		user.setUserpwd("123");
		user.setUsernum(5);
		sessionFactory.getCurrentSession().save(user);
	}
}
