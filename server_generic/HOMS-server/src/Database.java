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

    //TODO: CREATE A UNIFIED AUTHENTICATION METHOD (TAKES USERNAME/PASSWORD, RETURNS TRUE/FALSE OR -2,-1,0,1 ETC.)

    //region AUTHENTICATION

    public void login(String username, String password) {

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'"); //DO THE QUERY
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) { //This is bad.
                try {
                    System.err.println("BOO");
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            } else { //This is good!
                try {

                    System.err.println("YAY");
                    stmt.close();
                } catch (SQLException sqlEx) {

                    stmt = null;
                }
            }

        }
    }//What the hell do you think it does?

    //endregion

    //region USER

    public void addUser(String username, String password, int isActive, int isAdmin, int EmployeeNumber, String FirstName, String LastName) { // TODO: Validation!

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

    public void modifyUser(int U_Id, String username, String password, int isActive, int isAdmin, int EmployeeNumber, String FirstName, String LastName) {
        //TODO: IMPLEMENT THIS! (modify user based on ID)
        System.err.println("NOT IMPLEMENTED!");
    }
    //endregion

    //region ORDERS

    public void addOrder() {
        //TODO: IMPLEMENT THIS! (add new order)
    }
    public void modifyOrder() {
        //TODO: IMPLEMENT THIS! (modify order based on ID)
    }

    public void removeOrder() {
        //TODO: IMPLEMENT THIS! (LOW PRIORITY)
    }
    public void getOrder() {
        //TODO: IMPLEMENT THIS! (gets specific order based on ID)
    }
    public void getNOrders(int nOrders) {
        //TODO: IMPLEMENT THIS! (gets large amounts of previous orders)
    }
    public void getInProgressOrders() {
        //TODO: IMPLEMENT THIS! (WHEN NEEDED)
    }

    public void addOrderItem() {
        //TODO: IMPLEMENT THIS! (Adds item to order)
    }
    public void modifyOrderItem() {
        //TODO: IMPLEMENT THIS! (modifies item on order)
    }
    public void removeOrderItem() {
        //TODO: IMPLEMENT THIS! (removes item on order)
    }
    public void getOrderItems() {
        //TODO: IMPLEMENT THIS! (gets items on order)
    }
    //endregion

    //region ITEMS (FOOD AND DRINK ITEMS, NOT ORDER ITEMS)
     public void addItem() {
         //TODO: IMPLEMENT THIS! (adds an item)
     }
    public void modifyItem() {
        //TODO: IMPLEMENT THIS! (modifies item based on ID)
    }
    public void removeItem() {
        //TODO: IMPLEMENT THIS! (removes item based on ID)
    }
    public void getItem() {
        //TODO: IMPLEMENT THIS! (gets item info based on ID)
    }
    public void getItems() {
        //TODO: IMPLEMENT THIS! (returns all items)
    }

}
