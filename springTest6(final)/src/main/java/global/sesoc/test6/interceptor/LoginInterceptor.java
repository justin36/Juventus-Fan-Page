package global.sesoc.test6.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 여기서 첫 시작은 어떻게 되더라
		
		HttpSession session = request.getSession();
		
		String loginId = (String) session.getAttribute("loginId");
		
		if (loginId == null) {
			String url = request.getContextPath() + "/";
			response.sendRedirect(url);
			
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
	
	
}