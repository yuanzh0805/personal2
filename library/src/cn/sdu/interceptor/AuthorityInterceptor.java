package cn.sdu.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import cn.sdu.action.UserAction;
import cn.sdu.domain.User;

/**
 * 用户权限拦截器，在struts.xml中配置
 * @author 雪精灵
 *
 */
public class AuthorityInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 2914081148619842225L;
	private UserAction UserAction;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
//		String method = invocation.getProxy().getMethod();
		String actionName=invocation.getInvocationContext().getName();
		User user =(User)request.getSession().getAttribute("userInfo");
		
		//获取项目路径
		String contextPath=request.getSession().getServletContext().getContextPath();
		//获取当前路径
		String uri = request.getRequestURI();
		//当前相对项目的路径
		String actionUrl=uri.replace(contextPath, "");
		if (actionName.equals("login")||actionName.equals("regist")) {
			return invocation.invoke();
		}
		
		if(user == null){
			//request.setAttribute("msg",AhCustomException.getExcMessage(ExcCode.Unlogined));
			return Action.LOGIN;
		}
		
		return invocation.invoke();
		
	}
	public UserAction getUserAction() {
		return UserAction;
	}
	public void setUserAction(UserAction UserAction) {
		this.UserAction = UserAction;
	}

}
