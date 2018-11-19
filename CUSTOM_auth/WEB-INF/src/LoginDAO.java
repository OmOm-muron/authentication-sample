import java.sql.*;
import java.util.*;
import java.text.*;
import javax.naming.*;
import javax.sql.*;

public class LoginDAO implements AutoCloseable {
	private Connection conn = null;

	public LoginDAO() {
	}

	// DB接続を取得
	public Connection getConnection() throws Exception {
		// NamingException, SQLExceptionがスローされる
		try {
			if (conn == null || conn.isClosed()) {
				InitialContext initCtx = new InitialContext();
				DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/practice");

				// DB接続取得
				conn = ds.getConnection();
			}
		} catch (NamingException | SQLException e) {
			// 例外発生時はconn = null
			e.printStackTrace();
			conn = null;
			throw e;
		}

		return conn;
	}

	// DB接続切断
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	// DB接続取得～クエリ実行までを行い、実行結果有無をbooleanで返す
	public boolean authUser(String user, String password) throws Exception {
		String sql = "SELECT * FROM auth_users WHERE username = ? && password = ?";

		// SQL文にユーザ名、パスワードを代入
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setString(1,user);
		statement.setString(2,password);

		// クエリを実行
		ResultSet rs = statement.executeQuery();

		// クエリ結果があればtrue、そうでなければfalseを返す
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

	// DB接続切断
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
