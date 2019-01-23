package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/");
		}
		return true;
		// return이 false이면 해당 컨트롤러로 보내지 않는다
		// return이 true여야 컨트롤러로 넘어가서 정상적으로 동작하게 된다
	}
}
