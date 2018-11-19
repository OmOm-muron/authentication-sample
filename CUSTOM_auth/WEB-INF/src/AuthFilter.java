import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.Filter.*;
import javax.servlet.FilterChain;

public class AuthFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain) {
		try {
			String target = ((HttpServletRequest)req).getRequestURI().toString();

			HttpSession session = ((HttpServletRequest)req).getSession(false);

			if (session == null) {
				session = ((HttpServletRequest)req).getSession(true);
				session.setAttribute("target",target);

				((HttpServletResponse)rsp).sendRedirect("login");
				return;
			} else {
				Object loginCheck = session.getAttribute("login");
				if (loginCheck == null) {
					session.setAttribute("target",target);
					((HttpServletResponse)rsp).sendRedirect("login");
					return;
				}
			}
			
			chain.doFilter(req,rsp);
		} catch (ServletException se) {
		} catch (IOException e) {
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}
}

