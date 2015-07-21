package cn.sdu.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sdu.domain.Document;
import cn.sdu.domain.Like;
import cn.sdu.domain.User;
import cn.sdu.service.impl.like.LikeServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class LikeAction extends ActionSupport{
	@Autowired
	private Like like;
	@Autowired
	private Document document;
	@Autowired
	private LikeServiceImpl likeServiceImpl;
	private String id;
	private User user = (User) ServletActionContext.getRequest().
			getSession().getAttribute("userInfo");
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute(){
		document.setDid(Integer.valueOf(id));
		like.setUser(user);
		like.setDocument(document);
		Like newlike =  likeServiceImpl.check(like);
		if(newlike == null)			
			likeServiceImpl.addLike(like);		
		else
			likeServiceImpl.deleLike(newlike);
		return null;
	}

}
