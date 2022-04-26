package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UnitService {

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
	
	public String readUnits() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading Units.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr>"
					+ "<th> ID</th>"
					+ "<th> UID</th>"
					+ "<th> Units</th>"
					+ "<th> CreatedAt</th></tr>";
					

			String query = "SELECT * from units";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				
				String id = rs.getString("id");
				String uid = rs.getString("uid"); 
				String units = rs.getString("units");  
				String created_at = rs.getString("created_at");

				// Add into the html table
				output += "<tr><td>" + id + "</td>";
				output += "<td>" + uid + "</td>";
				output += "<td>" + units + "</td>";
				output += "<td>" + created_at + "</td>";
			}
			con.close();

			output += "</table>";
		}

		catch (Exception e) {
			output = "Error while reading the Units.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
		// insert method
			public String insertUnit(String id, String uid, String units, String created_at) {
				Connection con = connect();
				String output = "";
				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement
				String query = " INSERT into units (`id`,`uid`,`units`,`created_at`)"
						+ " values (?, ?, ?, ?)";
				PreparedStatement preparedStmt;
				try {
					preparedStmt = con.prepareStatement(query);
					preparedStmt.setString(1, id);
					preparedStmt.setString(2, uid);
					preparedStmt.setString(3, units);
					preparedStmt.setString(4, created_at);

					preparedStmt.execute();
					con.close();
					output = "Inserted Successfully";
				} catch (SQLException e) {
					output = "Error while inserting Units";
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			
			// update method
			public String updateUnit(String id,String uid, String units, String created_at)

			{
				String output = "";
				try {
					Connection con = connect();
					if (con == null) {
						return "Error while connecting to the database for updating.";
					}
					// create a prepared statement
					String query = " UPDATE units SET uid = ? , units = ? , created_at = ? WHERE id = ? ";

					PreparedStatement preparedStmt = con.prepareStatement(query);
					// binding values
					preparedStmt.setString(1, uid);
					preparedStmt.setString(2, units);
					preparedStmt.setString(3, created_at);
					preparedStmt.setString(4, id);

					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Updated Successfully";
				} catch (Exception e) {
					output = "Error while updating the Unit info.";
					System.err.println(e.getMessage());
				}
				return output;
			}
			
			// delete method
			public String deleteUnit(String id) {
				String output = "";
				try {
					Connection con = connect();
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}
					// create a prepared statement
					String query = "DELETE from units WHERE id=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					// binding values
					preparedStmt.setString(1, id);
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Deleted Successfully";
				} catch (Exception e) {
					output = "Error while deleting the Unit info.";
					System.err.println(e.getMessage());
				}
				return output;
			}
}
