package sakila.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/auth/*")//~�� 
public class LoginFilter implements Filter {

    public LoginFilter() {
       
    }

	
	public void destroy() {
		
	}
// ������ ���������� ���ʹ� ��� �� ó�������ϴ�. �������� ��� ��� �ߴµ�.. �� .. 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginFilter ���� : session �˻�");
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