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

		// DAO���擾���āASQL�������s
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
			// �F�؍ς݂Ƃ���
			session.setAttribute("login","OK");

			// �{���̃A�N�Z�X��֔�΂�
			String target = (String)session.getAttribute("target");
			rsp.sendRedirect(target);
		} else {
			// �F�؎��s�A���O�C����ʂ֖߂�
			session.setAttribute("status","Not Auth");
			rsp.sendRedirect("login");
		}
	}
}
