import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)
		throws ServletException, IOException {
		req.setCharacterEncoding("shift-jis");

		// �F�؎��s�̏ꍇ�A���b�Z�[�W�𑮐��ɓ���A�X�e�[�^�X�����Z�b�g
		HttpSession session = req.getSession(true);
		Object status = session.getAttribute("status");

		String message = "";
		if (status != null) {
			message = "�F�؂Ɏ��s���܂����B\n"
				+ "�ēx���[�U���ƃp�X���[�h����͂��Ă��������B\n";
			req.setAttribute("message",message);

			session.setAttribute("status", null);
		}

		RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
		rd.forward(req,rsp);
	}
}

