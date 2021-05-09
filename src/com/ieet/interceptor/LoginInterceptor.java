package com.ieet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{
	private String[] urls= {"login","userlogin"};
	
	//验证当前访问的url是不是login或�?�userlogin
	public boolean checkUrl(String url) {
		boolean flag=false;
		for(String u:urls) {
			if(url.indexOf(u)>-1) { //如果是不要拦截url
				flag=true; //url是login或�?�userlogin，放�?
				break;
			}
		}
		return flag;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*System.out.println("interceptor");
		//获取当前要访问的url
		String url=request.getRequestURI();
		//判断是否正在登录操作�?
		if(checkUrl(url)) {
			return true; //放行,可以继续
		}else {//否则进行拦截
			//获得当前的session
			HttpSession session=request.getSession();
			//获取当前的登录用户，看看是否为null
			Object o=session.getAttribute("user");
			if(o!=null) {
				return true; //已登录，放行
			}else {
				//未登录，跳转到登录页�?
				request.getRequestDispatcher("login").forward(request, response);
				return true; //继续
			}
	
		}*/
	return true;
	}
}
