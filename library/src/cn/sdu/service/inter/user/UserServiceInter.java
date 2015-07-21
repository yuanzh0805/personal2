package cn.sdu.service.inter.user;

import cn.sdu.domain.User;
import cn.sdu.service.inter.BaseServiceInter;

public interface UserServiceInter extends BaseServiceInter{
	public User check(User user);
	public void addUser(User user);
}
