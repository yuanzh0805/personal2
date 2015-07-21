package cn.sdu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sdu.domain.Document;
import cn.sdu.service.impl.biaodoc.BiaodocServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class BiaodocAction extends ActionSupport implements ServletRequestAware{
	@Autowired
	private BiaodocServiceImpl biaodocServiceImpl;
	private String id;
	private HttpServletRequest request;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String execute(){
		List<Document> list =(List<Document>) biaodocServiceImpl.listById(Integer.valueOf(id));
		if(list == null)
			return "ok";
		else {
			request.setAttribute("documentList", list);
			return "ok";
		}
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
}
