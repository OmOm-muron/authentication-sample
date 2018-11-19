import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)
		throws ServletException, IOException {
		req.setCharacterEncoding("shift-jis");

		// 認証失敗の場合、メッセージを属性に入れ、ステータスをリセット
		HttpSession session = req.getSession(true);
		Object status = session.getAttribute("status");

		String message = "";
		if (status != null) {
			message = "認証に失敗しました。\n"
				+ "再度ユーザ名とパスワードを入力してください。\n";
			req.setAttribute("message",message);

			session.setAttribute("status", null);
		}

		RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
		rd.forward(req,rsp);
	}
}

