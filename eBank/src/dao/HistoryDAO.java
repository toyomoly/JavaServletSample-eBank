package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.History;

public class HistoryDAO extends SuperDAO {

	public List<History> findByUserId(String userId) {

		List<History> result = new ArrayList<>();

		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT user_id, status, price, created_at");
		sbSql.append(" FROM history WHERE user_id = ?");
		sbSql.append(" ORDER BY id DESC");

		try (Connection con = super.getConnection();
				PreparedStatement stmt = con.prepareStatement(sbSql.toString())) {

			stmt.setString(1, userId);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(new History(
						rs.getString("user_id"),
						rs.getInt("status"),
						rs.getInt("price"),
						rs.getTimestamp("created_at").toLocalDateTime()));
			}

		} catch (SQLException e) {
			// DBとの処理で何らかのエラーがあった場合の例外
			e.printStackTrace();
		}

		return result;
	}

}
