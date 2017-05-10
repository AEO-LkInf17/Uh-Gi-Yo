package server.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	 * @param username the username to be saved
	 */
	public void saveNewUsername(String username) {
		try {
			st.executeUpdate("INSERT INTO users (username) VALUES ('" + username + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * changes the login status of the user
	 * @param loginStatus the value of whether the user is going to be logged in or out
	 * @param username    the username of the user
	 */
	public void changeLoginStatusTo(boolean loginStatus, String username) {
		try {
			st.executeUpdate("UPDATE users SET loginStatus = " + loginStatus + " + WHERE username = " + username + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * changes the time of how long the user is banned
	 * @param username the username of the user that is going to be banned
	 */
	public void changeBannedStatusTo(boolean bannedStatus, String username) {
		try {
			st.executeUpdate("UPDATE users SET bannedUntil = " + bannedStatus + "WHERE username = " + username + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * checks whether the username is available (registration)
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

	/**
	 * returns the current date + time in an array
	 * @return the current date + time
	 */
	public String[] getCurrentDateTime() {
		DateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate.split("");
	}

	/**
	 * returns the current day as a number
	 * @return the current day as a number
	 */
	public int getCurrentDayNumber() {
		if(getCurrentDateTime()[0].equals("0")) return Integer.parseInt(getCurrentDateTime()[1]);
		return Integer.parseInt(getCurrentDateTime()[0] + getCurrentDateTime()[1]);
	}

	/**
	 * returns the current day as a number
	 * @return the current day as a number
	 */
	public int getCurrentMonthNumber() {
		if(getCurrentDateTime()[2].equals("0")) return Integer.parseInt(getCurrentDateTime()[3]);
		return Integer.parseInt(getCurrentDateTime()[2] + getCurrentDateTime()[3]);
	}

	/**
	 * returns the current year
	 * @return the current year
	 */
	public int getCurrentYear() {
		return Integer.parseInt(getCurrentDateTime()[4] + getCurrentDateTime()[5] + getCurrentDateTime()[6] + getCurrentDateTime()[7]);
	}

	/**
	 * returns the current hour
	 * @return the current hour
	 */
	public int getCurrentHour() {
		if(getCurrentDateTime()[8].equals("0")) return Integer.parseInt(getCurrentDateTime()[9]);
		return Integer.parseInt(getCurrentDateTime()[8] + getCurrentDateTime()[9]);
	}

	/**
	 * returns the current minute
	 * @return the current minute
	 */
	public int getCurrentMinute() {
		if(getCurrentDateTime()[10].equals("0")) return Integer.parseInt(getCurrentDateTime()[11]);
		return Integer.parseInt(getCurrentDateTime()[10] + getCurrentDateTime()[11]);
	}

	/**
	 * returns the current second
	 * @return the current second
	 */
	public int getCurrentSecond() {
		if(getCurrentDateTime()[12].equals("0")) return Integer.parseInt(getCurrentDateTime()[13]);
		return Integer.parseInt(getCurrentDateTime()[12] + getCurrentDateTime()[13]);
	}

	/**
	 * returns the date + time until the user is banned in an array
	 * @param username the usernae of the user
	 * @return the date + time until the user is banned
	 */
	public String[] getBannedDateTime(String username) {
		// Code
		return null;
	}

	/**
	 * returns the day until the user is banned as a number
	 * @param username the username of the user
	 * @return day until user is banned as number
	 */
	public int getBannedTimeDayNumber(String username) {
		if(getBannedDateTime(username)[0].equals("0")) return Integer.parseInt(getBannedDateTime(username)[1]);
		return Integer.parseInt(getBannedDateTime(username)[0] + getBannedDateTime(username)[1]);
	}

	/**
	 * returns the month until the user is banned as a number
	 * @param username the username of the user
	 * @return day until user is banned as number
	 */
	public int getBannedTimeMonthNumber(String username) {
		if(getBannedDateTime(username)[2].equals("0")) return Integer.parseInt(getBannedDateTime(username)[3]);
		return Integer.parseInt(getBannedDateTime(username)[2] + getBannedDateTime(username)[3]);
	}

	/**
	 * returns the year until the user is banned
	 * @param username the username of the user
	 * @return year until user is banned
	 */
	public int getBannedTimeYear(String username) {
		return Integer.parseInt(getBannedDateTime(username)[4] + getBannedDateTime(username)[5] + getBannedDateTime(username)[6] + getBannedDateTime(username)[7]);
	}

	/**
	 * returns the hour until the user is banned
	 * @param username the username of the user
	 * @return hour until user is banned
	 */
	public int getBannedTimeHour(String username) {
		if(getBannedDateTime(username)[8].equals("0")) return Integer.parseInt(getBannedDateTime(username)[9]);
		return Integer.parseInt(getBannedDateTime(username)[8] + getBannedDateTime(username)[9]);
	}

	/**
	 * returns the minute until the user is banned
	 * @param username the username of the user
	 * @return minute until user is banned
	 */
	public int getBannedTimeMinute(String username) {
		if(getBannedDateTime(username)[10].equals("0")) return Integer.parseInt(getBannedDateTime(username)[11]);
		return Integer.parseInt(getBannedDateTime(username)[10] + getBannedDateTime(username)[11]);
	}

	/**
	 * return the second until the user is banned
	 * @param username the username of the user
	 * @returny second until user is banned
	 */
	public int getBannedTimeSecond(String username) {
		if(getBannedDateTime(username)[12].equals("0")) return Integer.parseInt(getBannedDateTime(username)[13]);
		return Integer.parseInt(getBannedDateTime(username)[12] + getBannedDateTime(username)[13]);
	}

	/**
	 * checks wether the time until the user is banned is over
	 * @param username the username of the user
	 * @return wether the time until the user is banned is over
	 */
	public boolean bannedTimeIsOver(String username) {
		// Code
		return false;
	}
}
