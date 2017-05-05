package server.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQL {

	public Connection con;
	public Statement st;
	public ResultSet rs;

	public SQL() {
		connectDatabase();
	}

	/**
	 * connects the database with the driver manager
	 */
	public void connectDatabase() {
		try {
			System.out.println("SQL init started");
			Class.forName("com.mysql.jdbc.Driver");

			String host = "dbserver-w10-die.einstein";
			String databaseName = "UhGiYo_INFLK17";
			String userName = "root";
			String password = "w10";

			con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + databaseName, userName, password);
			st = con.createStatement();
			System.out.println("SQL init succeed");
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	/**
	 * checks whether the user exists (login)
	 *
	 * @param username the username of the user
	 * @return whether the user exists or not
	 */
	public boolean userExists(String username) {
		try {
			String query = "SELECT username FROM users";
			rs = st.executeQuery(query);
			while (rs.next()) {
				String un = rs.getString("username");
				if (username.equals(un)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * checks whether the user is banned
	 *
	 * @param username the username of the user
	 * @return whether the user is banned or not
	 */
	public boolean userIsBanned(String username) {
		try {
			String query = "SELECT username FROM users WHERE username = '" + username + "'";
			rs = st.executeQuery(query);
			while (rs.next()) {
				int banned = Integer.parseInt(rs.getString("banned"));
				if (banned == 1 || banned == -1)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * saves the new username in the database (registration)
	 *
	 * @param username the username to be saved
	 */
	public void saveNewUsername(String username) {
		try {
			st.executeUpdate("INSERT INTO users (username) VALUES ('" + username + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Saved");
	}

	/**
	 * changes the login status of the user
	 *
	 * @param loginStatus the value of whether the user is going to be logged in or out
	 * @param username    the username of the user
	 */
	public void changeLoginStatusTo(boolean loginStatus, String username) {
		try {
			st.executeUpdate("UPDATE users SET loginStatus = " + loginStatus + " + WHERE username = " + username + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Saved");
	}

	/**
	 * changes the time of how long the user is banned
	 *
	 * @param username the username of the user that is going to be banned
	 */
	public void changeBannedUntilTo(int bannedUntil, String username) {
		try {
			st.executeUpdate("UPDATE users SET bannedUntil = " + bannedUntil + "WHERE username = " + username + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * checks whether the username is available (registration)
	 *
	 * @param username the username that has been typed in during the registration
	 * @return whether the username is available or not
	 */
	public boolean usernameIsAvailable(String username) {
		try {
			String query = "SELECT username FROM users";
			rs = st.executeQuery(query);
			while (rs.next()) {
				String un = rs.getString("username");
				if (username.equals(un)) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}


	public void bannedTimeIsOver(String username, int bannedUntil) {
		try {
			String query = "SELECT bannedUntil  FROM users WHERE bannedUntil = '" + bannedUntil + ";";
		}
	}
}
