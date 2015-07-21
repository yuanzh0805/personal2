package cn.sdu.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.sdu.action.AdminAction;
import cn.sdu.domain.Admin;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 用户权限拦截器，在struts.xml中配置
 * @author 雪精灵
 *
 */
public class AdminAuthorityInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 2914081148619842225L;
	private AdminAction adminAction;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
//		String method = invocation.getProxy().getMethod();
		String actionName=invocation.getInvocationContext().getName();
		Admin admin =(Admin)request.getSession().getAttribute("admin");
		
		//获取项目路径
		String contextPath=request.getSession().getServletContext().getContextPath();
		//获取当前路径
		String uri = request.getRequestURI();
		//当前相对项目的路径
		String actionUrl=uri.replace(contextPath, "");
		if (actionName.equals("loginAdmin")) {
			return invocation.invoke();
		}
		
		if(admin==null){
			//request.setAttribute("msg",AhCustomException.getExcMessage(ExcCode.Unlogined));
			return Action.LOGIN;
		}
		
		return invocation.invoke();
		
	}
	public AdminAction getAdminAction() {
		return adminAction;
	}
	public void setAdminAction(AdminAction adminAction) {
		this.adminAction = adminAction;
	}
	

}
