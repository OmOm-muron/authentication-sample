import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse rsp) 
		throws ServletException, IOException {
		req.setCharacterEncoding("shift-jis");

		String user = req.getParameter("user");
		String password = req.getParameter("password");

		HttpSession session = req.getSession(true);

		// DAOを取得して、SQL文を実行
		boolean check = false;
		LoginDAO dao = new LoginDAO();
		try {
			check = dao.authUser(user, password);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.closeConnection();
		}
		if (check) {
			// 認証済みとする
			session.setAttribute("login","OK");

			// 本来のアクセス先へ飛ばす
			String target = (String)session.getAttribute("target");
			rsp.sendRedirect(target);
		} else {
			// 認証失敗、ログイン画面へ戻す
			session.setAttribute("status","Not Auth");
			rsp.sendRedirect("login");
		}
	}
}
