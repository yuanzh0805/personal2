package cn.sdu.service.impl.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.sdu.domain.User;
import cn.sdu.service.impl.BaseServiceImpl;
import cn.sdu.service.inter.user.UserServiceInter;

public class UserServiceImpl extends BaseServiceImpl implements UserServiceInter {

	public User check(User user) {
		//System.out.println(user.getUsername());
		List<User> list = getResult("from User where username=? and userpwd=?", new Object[]{user.getUsername(),user.getUserpwd()});
		if(list.size() == 1){
			return  list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void addUser(User user){
			user.setUsernum(0);
			save(user);
			

	}

}
