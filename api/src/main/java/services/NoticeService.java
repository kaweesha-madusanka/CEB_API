package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NoticeService {
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceb_api", "root", "root");
			// For testing
			System.out.print("Successfully Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public String readNotices() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading Notices.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr>"
					+ "<th> ID</th>"
					+ "<th> Message</th>"
					+ "<th> CreatedAt</th></tr>";
					

			String query = "SELECT * from notices";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				
				String id = rs.getString("id");
				String message = rs.getString("message");
				String created_at = rs.getString("created_at");

				// Add into the html table
				output += "<tr><td>" + id + "</td>";
				output += "<td>" + message + "</td>";
				output += "<td>" + created_at + "</td>";
			}
			con.close();

			output += "</table>";
		}

		catch (Exception e) {
			output = "Error while reading the Notices.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	// insert method
	public String insertNotice(String id,String message, String created_at) {
		Connection con = connect();
		String output = "";
		if (con == null) {
			return "Error while connecting to the database";
		}

		// create a prepared statement
		String query = " INSERT into notices (`id`,`message`,`created_at`)"
				+ " values (?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, id);
			preparedStmt.setString(2, message);
			preparedStmt.setString(3, created_at);

			preparedStmt.execute();
			con.close();
			output = "Inserted Successfully";
		} catch (SQLException e) {
			output = "Error while inserting Notice";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	
	// update method
	public String updateNotice(String id,String message, String created_at)

	{
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = " UPDATE notices SET message = ? , created_at = ? WHERE id = ? ";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, message);
			preparedStmt.setString(2, created_at);
			preparedStmt.setString(3, id);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated Successfully";
		} catch (Exception e) {
			output = "Error while updating the Notice.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	// delete method
	public String deleteNotice(String id) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "DELETE from notices WHERE id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, id);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted Successfully";
		} catch (Exception e) {
			output = "Error while deleting the Notice.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
