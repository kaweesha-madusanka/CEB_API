package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BillService {
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
	
	public String readBills() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading Bills.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr>"
					+ "<th> ID</th>"
					+ "<th> UID</th>"
					+ "<th> Amount</th>"
					+ "<th> Paid</th>"
					+ "<th> CreatedAt</th></tr>";
					

			String query = "SELECT * from bills";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				
				String id = rs.getString("id");
				String uid = rs.getString("uid"); 
				String amount = rs.getString("amount");
				String paid = rs.getString("paid");
				String created_at = rs.getString("created_at");

				// Add into the html table
				output += "<tr><td>" + id + "</td>";
				output += "<td>" + uid + "</td>";
				output += "<td>" + amount + "</td>";
				output += "<td>" + paid + "</td>";
				output += "<td>" + created_at + "</td>";
			}
			con.close();

			output += "</table>";
		}

		catch (Exception e) {
			output = "Error while reading the Bills.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	// insert method
	public String insertBill(String id,String uid, String amount, String paid, String created_at) {
		Connection con = connect();
		String output = "";
		if (con == null) {
			return "Error while connecting to the database";
		}

		// create a prepared statement
		String query = " INSERT into bills (`id`,`uid`,`amount`,`paid`,`created_at`)"
				+ " values (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, id);
			preparedStmt.setString(2, uid);
			preparedStmt.setString(3, amount);
			preparedStmt.setString(4, paid);
			preparedStmt.setString(5, created_at);

			preparedStmt.execute();
			con.close();
			output = "Inserted Successfully";
		} catch (SQLException e) {
			output = "Error while inserting Bill";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	
	// update method
	public String updateBill(String id,String uid, String amount, String paid, String created_at)

	{
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = " UPDATE bills SET uid = ? , amount = ?, paid = ? , created_at = ? WHERE id = ? ";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, uid);
			preparedStmt.setString(2, amount);
			preparedStmt.setString(3, paid);
			preparedStmt.setString(4, created_at);
			preparedStmt.setString(5, id);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated Successfully";
		} catch (Exception e) {
			output = "Error while updating the Bill info.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	// delete method
	public String deleteBill(String id) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "DELETE from bills WHERE id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, id);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted Successfully";
		} catch (Exception e) {
			output = "Error while deleting the Bill info.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
