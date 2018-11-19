import java.sql.*;
import java.util.*;
import java.text.*;
import javax.naming.*;
import javax.sql.*;

public class LoginDAO implements AutoCloseable {
	private Connection conn = null;

	public LoginDAO() {
	}

	// DB�ڑ����擾
	public Connection getConnection() throws Exception {
		// NamingException, SQLException���X���[�����
		try {
			if (conn == null || conn.isClosed()) {
				InitialContext initCtx = new InitialContext();
				DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/practice");

				// DB�ڑ��擾
				conn = ds.getConnection();
			}
		} catch (NamingException | SQLException e) {
			// ��O��������conn = null
			e.printStackTrace();
			conn = null;
			throw e;
		}

		return conn;
	}

	// DB�ڑ��ؒf
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	// DB�ڑ��擾�`�N�G�����s�܂ł��s���A���s���ʗL����boolean�ŕԂ�
	public boolean authUser(String user, String password) throws Exception {
		String sql = "SELECT * FROM auth_users WHERE username = ? && password = ?";

		// SQL���Ƀ��[�U���A�p�X���[�h����
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setString(1,user);
		statement.setString(2,password);

		// �N�G�������s
		ResultSet rs = statement.executeQuery();

		// �N�G�����ʂ������true�A�����łȂ����false��Ԃ�
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

	// DB�ڑ��ؒf
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}
