package cn.sdu.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Hibernate;

import cn.sdu.domain.Type;
import cn.sdu.service.impl.type.TypeServiceImpl;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class TypeAction extends ActionSupport implements ServletResponseAware{
	private HttpServletResponse response ;
	private String parentId;	
	@Resource
	private Type type;
	@Resource
	private TypeServiceImpl typeServiceImpl;

	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String execute(){
//		if(parentId == null || parentId==""){
//			parentId = "null";   //如果传的父结点为空，则默认赋值为空
//		}
		System.out.println(parentId);
		List<Type> rsList =  typeServiceImpl.getType(parentId);
//		List<Type> newList = new ArrayList<>();
//		System.out.println(parentId);
		
//		for (Type type : rsList) {
//			type.setDocuments(type.getDocuments());
//			newList.add(type);
//		}
		Gson gson = new Gson();
		String json = gson.toJson(rsList);
		System.out.println("json="+json);
		response.setCharacterEncoding("UTF-8");//防止出现中文乱码现象
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

}
