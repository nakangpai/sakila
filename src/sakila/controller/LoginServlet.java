package sakila.controller;

import java.io.IOException;



import com.oreilly.servlet.CacheHttpServlet;


@WebService("/LoginServlet")
public class LoginServlet extends CacheHttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSesson session = request.getSession();
		if(session.getAttribute("loginStaff") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request. response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
