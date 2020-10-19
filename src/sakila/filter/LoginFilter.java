package sakila.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/auth/*")//~값 
public class LoginFilter implements Filter {

    public LoginFilter() {
       
    }

	
	public void destroy() {
		
	}
// 서블릿은 웹브라우저만 필터는 모든 것 처리가능하다. 다형성과 상속 사용 했는데.. 음 .. 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginFilter 실행 : session 검사");
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session.getAttribute("loginStaff") == null) {
			(HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath()+"//LoginServlet");
			return;
		}
			chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}