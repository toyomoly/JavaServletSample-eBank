package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UserDAO extends SuperDAO {

	public User findByUserId(String userId) {

		String sql = "SELECT user_id, password, user_name, saving FROM account WHERE user_id = ?";

		try (Connection con = super.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, userId);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(
						rs.getString("user_id"),
						rs.getString("password"),
						rs.getString("user_name"),
						rs.getInt("saving"));
			}

		} catch (SQLException e) {
			// DBとの処理で何らかのエラーがあった場合の例外
			e.printStackTrace();
		}

		return null;
	}

}
