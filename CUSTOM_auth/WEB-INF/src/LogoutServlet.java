import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)
		throws ServletException, IOException {
		req.setCharacterEncoding("shift-jis");

		HttpSession session = req.getSession(true);
		session.invalidate();

		String message = "���O�A�E�g���܂����B";
		req.setAttribute("message",message);

		RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
		rd.forward(req,rsp);
	}
}

