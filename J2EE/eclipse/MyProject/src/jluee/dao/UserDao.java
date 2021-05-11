package jluee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import jluee.entity.User;

public class UserDao extends BaseDao {

	public User userSelect(String userName) {
		String sql = "Select passWord,idendity from j2ee where userName= '" + userName + "'";
		if (conn == null) {
			return null;
		}
		try {
			User user = new User();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				user.setUserName(userName);
				user.setPassWord(rs.getString(1));
				user.setIdendity(rs.getString(2));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
