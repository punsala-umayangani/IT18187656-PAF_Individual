package com;

import java.sql.*;

public class Doctor {
	private Connection connect() {

        Connection con = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pafdb", "root", "");

        } catch (Exception e) {

            e.printStackTrace();

        }

        return con;

    }

    public String readDoctors() {

        String output = "";

        try {

            Connection con = connect();

            if (con == null) {

                return "Error while connecting to the database for reading. ";

            }

            // Prepare the html table to be displayed
            output = "<table class='table'>"+ "<tr> <th>Doctor_Name</th ><th >Specialization</th ><th>Address</th><th>Phone_Number</th><th>E-mail_Address</th> " + " <th> Update </th><th> Remove </th></tr> ";
            
            String query = "select * from pafdoc";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // iterate through the rows in the result set
            while (rs.next()) {

                String docid = Integer.toString(rs.getInt("docid"));
                String docname = rs.getString("docname");
                String docSpecial = rs.getString("docSpecial");
                String docAddress = rs.getString("docAddress");
                String docPhone = rs.getString("docPhone");
                String docEmail = rs.getString("docEmail");

                // Add into the html table
                output += "<tr><td><input id='hiddocidUpdate' name = 'hiddocidUpdate' type = 'hidden' value = '" + docid + "'>" + docname + "</td>";
                output += "<td>" + docSpecial + "</td>";
                output += "<td>" + docAddress + "</td>";
                output += "<td>" + docPhone + "</td>";
                output += "<td>" + docEmail + "</td>";

                // buttons
                output += "<td><input name='btnUpdate' type = 'button' value = 'Update' class='btnUpdate btn btn-secondary' ></td > " + "<td><input name='btnRemove' type = 'button' value = 'Remove' class='btnRemove btn btn-danger' data-docid = '" + docid + "'>" + "</td></tr>";

            }

            con.close();

            // Complete the html table
            output += "</table>";

        } catch (Exception e) {

            output = "Error while reading the doctors.";
            System.err.println(e.getMessage());

        }

        return output;

    }

    public String insertDoctor(String docName, String docSpecial, String docAddress,
			String docPhone, String docEmail) {
		String output = "";

        try {

            Connection con = connect();

            if (con == null) {

                return "Error while connecting to the database for inserting.";

            }

            // create a prepared statement
            String query = " insert into pafdoc (docid,docName,docSpecial,docAddress,docPhone,docEmail)" + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            // binding values
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, docName);
            preparedStmt.setString(3, docSpecial);
            preparedStmt.setString(4, docAddress);
            preparedStmt.setString(5, docPhone);
            preparedStmt.setString(6, docEmail);

            // execute the statement
            preparedStmt.execute();
            con.close();
            String newDoctors = readDoctors();
            output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";

        } catch (Exception e) {

            output = "{\"status\":\"error\", \"data\":\"Error while inserting the doctor.\"}";
            System.err.println(e.getMessage());

        }

        return output;
	}

    public String updateDoctor(String hiddocidSave, String docName, String docSpecial, String docAddress,
			String docPhone, String docEmail) {
		String output = "";

        try {

            Connection con = connect();

            if (con == null) {

                return "Error while connecting to the database for updating. ";

            }

            // create a prepared statement
            String query = "UPDATE pafdoc SET docName =?,docSpecial =?,docAddress =?,docPhone =?,docEmail =? WHERE docid =?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            // binding values
            preparedStmt.setString(1, docName);
            preparedStmt.setString(2, docSpecial);
            preparedStmt.setString(3, docAddress);
            preparedStmt.setString(4, docPhone);
            preparedStmt.setString(5, docEmail);
            preparedStmt.setInt(6, Integer.parseInt(hiddocidSave));

            // execute the statement
            preparedStmt.execute();
            con.close();
            String newDoctors = readDoctors();
            output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";

        } catch (Exception e) {

            output = "{\"status\":\"error\", \"data\":\"Error while updating the doctor.\"}";
            System.err.println(e.getMessage());

        }

        return output;

    }


	public String deleteDoctor(String doctorid) {

        String output = "";

        try {

            Connection con = connect();

            if (con == null) {

                return "Error while connecting to the database for deleting. ";

            }

            // create a prepared statement
            String query = "delete from pafdoc where docid=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            // binding values
            preparedStmt.setInt(1, Integer.parseInt(doctorid));

            // execute the statement
            preparedStmt.execute();
            con.close();
            String newDoctors = readDoctors();
            output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";

        } catch (Exception e) {

            output = "{\"status\":\"error\", \"data\":\"Error while deleting the doctor.\"}";
            System.err.println(e.getMessage());

        }

        return output;

    }


}
