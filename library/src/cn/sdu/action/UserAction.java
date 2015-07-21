package cn.sdu.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sdu.domain.User;
import cn.sdu.service.impl.user.UserServiceImpl;
import cn.sdu.service.inter.user.UserServiceInter;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private User user;
	@Resource
	private UserServiceInter userServiceInter ;
	private HttpServletRequest request;
	
	public String regist(){
		try {
			userServiceInter.addUser(user);
			user = userServiceInter.check(user);
			request.getSession().setAttribute("userInfo", user);
			return "registok";
		} catch (Exception e) {
			request.getSession().setAttribute("loginmsg", e.getMessage());
			return "error";
		}
		
			
		
	}
	
	public String login(){
		
		System.out.println(user.getUsername());
		user = userServiceInter.check(user); 
		
		if(user != null){
			request.getSession().setAttribute("userInfo", user);
			return "loginok";
		}
			
		else{
			request.setAttribute("loginmsg", "账号或密码错误");
			return "login";
		}
	}
	
	public String loginOut(){
		request.getSession().removeAttribute("userInfo");
		return "loginout";
	}
	
		
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	
	
}
