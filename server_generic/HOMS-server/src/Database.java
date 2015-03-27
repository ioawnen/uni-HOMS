/**
 * DATABASE MANAGEMENT CLASS
 */

/**
 * @author Ian
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;

public class Database {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    //THIS IS BAD. VERY BAD. THE WORST.
    String dbUsername = "root";
    String dbPassword = "8123993ba";

    //Initialises the connection to the MySQL database
    public boolean initialise() {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/homs_db?"+"user="+dbUsername+"&password="+dbPassword);

            // Do something with the Connection
            return true;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
    }

    public void login(String username, String password){

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'"); //DO THE QUERY
        }
        catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        finally {
            if (rs != null) { //This is bad.
                try {
                    System.err.println("BOO");
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }
            else { //This is good!
                try {

                    System.err.println("YAY");
                    stmt.close();
                } catch (SQLException sqlEx) {

                stmt = null;
            }
        }

    } //What the hell do you think it does?

    public void addUser(String username, String password, int isActive, int isAdmin, int EmployeeNumber, String FirstName, String LastName) { // TODO Make the query!

        try {
            stmt = conn.createStatement();

            stmt.executeUpdate("INSERT INTO users (Username, Password, Is_Active, Is_Admin, Employee_Number, First_Name, Last_Name) " +
                    "VALUES ('"+username+"', '"+password+"', '"+isActive+"', '"+isAdmin+"', '"+EmployeeNumber+"', '"+FirstName+"', '"+LastName+"')"); //DO THE QUERY
        }
        catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        finally {
            if (stmt != null) { //This is bad.
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }
            else { //This is good!
                try {

                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }

    }


}
