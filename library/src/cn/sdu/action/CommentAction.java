package cn.sdu.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sdu.domain.Comment;
import cn.sdu.domain.Document;
import cn.sdu.domain.User;
import cn.sdu.service.impl.comment.CommentServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport implements ServletRequestAware{
	@Autowired
	private Comment comment;
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@Autowired
	private Document document;
	
	private HttpServletRequest request;
	private User user = (User) ServletActionContext.getRequest().
			getSession().getAttribute("userInfo");
	private String id;
	private String comm;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public String showComment(){
		List<Comment> list = commentServiceImpl.findByDid(id);
		request.setAttribute("commentList", list);
		return "ok";
		
	}
	
	public String addComment(){
		document.setDid(Integer.valueOf(id));
		comment.setDocument(document);
		comment.setContent(comm);
		comment.setUser(user);
		comment.setComtime(new Date());
		commentServiceImpl.addComment(comment);
		return "ok";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
}
