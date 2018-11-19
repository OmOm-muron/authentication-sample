import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AfterAuth extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)
		throws ServletException, IOException {
		req.setCharacterEncoding("shift-jis");

		RequestDispatcher rd = req.getRequestDispatcher("/jsp/enter.jsp");
		rd.forward(req,rsp);
	}
}

