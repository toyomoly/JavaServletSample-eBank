package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SuperDAO {

	protected SuperDAO() {
		// JDBCドライバの読み込み
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException {
		// URL、ユーザ名、パスワードの設定
		String url = "jdbc:postgresql:e_bank";
		String user = "user";
		String pass = "password";
		return DriverManager.getConnection(url, user, pass);
	}

}
