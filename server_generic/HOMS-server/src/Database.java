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
import java.util.ArrayList;
import java.util.List;

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
            return true;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
    }

    //region OTHER STUFF

    private User getUserData(String username) {

        int uid = -1;
        int isActive = -1;
        int isAdmin = -1;
        int employeeNumber = -1;
        String firstName = null;
        String lastName = null;

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "' LIMIT 1;"); //DO THE QUERY

            uid = rs.getInt("U_Id");
            isActive = rs.getInt("Is_Active");
            isAdmin = rs.getInt("Is_Admin");
            employeeNumber = rs.getInt("Employee_Number");
            firstName = rs.getString("First_Name");
            lastName = rs.getString("Last_Name");


        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return new User(uid, username, null, isActive, isAdmin, employeeNumber, firstName, lastName);
    }


    //endregion


    //TODO: CREATE A UNIFIED AUTHENTICATION METHOD (TAKES USERNAME/PASSWORD, RETURNS TRUE/FALSE OR -2,-1,0,1 ETC.)

    //region AUTHENTICATION

    public DbGenericReturn authenticate(String[] creds) {

        String username = creds[0];
        String password = creds[1];
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "';"); //DO THE QUERY
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) { //This is bad.
                try {
                    rs.close();
                    return new DbGenericReturn("0", "Login Failed");
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            } else { //This is good!
                try {
                    stmt.close();
                    return new DbGenericReturn("1", "Login Confirmed");
                } catch (SQLException sqlEx) {
                    stmt = null;
                }
            }

            return new DbGenericReturn("-1", "Error when attempting to authenticate. Report this to your administrator.");
        }
    }

    //endregion

    //region USER

    public DbGenericReturn addUser(String[] creds, String username, String password, int isActive, int isAdmin, int EmployeeNumber, String FirstName, String LastName) { // TODO: More Validation Maybe!

        //Authenticate user
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {

            try {
                stmt = conn.createStatement();

                stmt.executeUpdate("INSERT INTO users (Username, Password, Is_Active, Is_Admin, Employee_Number, First_Name, Last_Name) " +
                        "VALUES ('" + username + "', '" + password + "', '" + isActive + "', '" + isAdmin + "', '" + EmployeeNumber + "', '" + FirstName + "', '" + LastName + "');"); //DO THE QUERY

                stmt.close();
                return new DbGenericReturn("1", "");
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());

                if (ex.getMessage().startsWith("Duplicate entry") && ex.getMessage().endsWith("for key 'Username'")) {
                    //This is what happens when there is a user with the same username
                    return new DbGenericReturn("-2", ex.getMessage());
                } else if (ex.getMessage().startsWith("Duplicate entry") && ex.getMessage().endsWith("for key 'Employee_Number'")) {
                    //This is what happens when there is a user with the same employee number
                    return new DbGenericReturn("-2", ex.getMessage());
                } else {
                    //This is what happens when anything else happens. Handle the other stray errors better than this.
                    return new DbGenericReturn("-1", ex.getMessage());
                }
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbGenericReturn("-50", auth.getReturn_string()); }
        else if (auth.getReturn_code().equals("-1")) { return new DbGenericReturn("-51", auth.getReturn_string()); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }

    public DbGenericReturn modifyUser(String[] creds, int U_Id, String username, String password, int isActive, int isAdmin, int EmployeeNumber, String firstName, String lastName) { //TODO: CHECK IF USER EXISTS BEFORE ACTION

        //Authenticate user
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE users SET " +
                        "Username='" +          username + "', " +
                        "Password='" +          password + "', " +
                        "Is_Active=" +          isActive + ", " +
                        "Is_Admin=" +           isAdmin + ", " +
                        "Employee_Number=" +    EmployeeNumber + ", " +
                        "First_Name='" +         firstName + "', " +
                        "Last_Name='" +          lastName + "' " +
                        "WHERE U_Id=" +         U_Id + ";");

                stmt.close();
                return new DbGenericReturn("1", "");
            }
            catch(SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());

                return new DbGenericReturn("-1", ex.getMessage() + " " + ex.getSQLState() + " " + ex.getErrorCode());
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbGenericReturn("-50", auth.getReturn_string()); }
        else if (auth.getReturn_code().equals("-1")) { return new DbGenericReturn("-51", auth.getReturn_string()); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }

    public DbGenericReturn removeUser(String[] creds, int U_Id) { //TODO: VERY BASIC! NEEDS VALIDATION!

        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {
            try {
                stmt = conn.createStatement();

                stmt.executeUpdate("DELETE FROM users WHERE U_Id="+U_Id+" LIMIT 1;"); //DO THE QUERY

                stmt.close();
                return new DbGenericReturn("1", "");
            }
            catch(SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());

                return new DbGenericReturn("-1", ex.getMessage() + " " + ex.getSQLState() + " " + ex.getErrorCode());
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbGenericReturn("-50", auth.getReturn_string()); }
        else if (auth.getReturn_code().equals("-1")) { return new DbGenericReturn("-51", auth.getReturn_string()); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }

    //endregion

    //region ORDERS

    public DbGenericReturn addOrder(String[] creds, int  T_Id) { //TODO: VERY BASIC! NEEDS VALIDATION!

        //Authenticate User
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {
            try {

                //Get U_Id
                User userData = getUserData(creds[0]);
                if (userData.getU_Id()==-1 || userData.getLast_Name().equals(null)) { //Checks if the data is valid.
                    return new DbGenericReturn("-30", "Database Error when fetching user ID.");
                }
                int U_Id = userData.getU_Id();

                //Execute Statement
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO orders (U_Id, T_Id) " +
                        "VALUES (" + U_Id + ", " + T_Id + ")"); //DO THE QUERY
                stmt.close();
                //Say it all worked
                return new DbGenericReturn("1", "Order Added");

            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());

                return new DbGenericReturn("-1", ex.getMessage() + " " + ex.getSQLState() + " " + ex.getErrorCode());
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbGenericReturn("-50", auth.getReturn_string()); }
        else if (auth.getReturn_code().equals("-1")) { return new DbGenericReturn("-51", auth.getReturn_string()); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }

    public DbGenericReturn modifyOrder(String[] creds, int O_Id, int T_Id) {

        //Authenticate user
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE orders SET " +
                        "T_Id=" +       T_Id + " " +
                        "WHERE O_Id=" + O_Id + ";");

                stmt.close();
                return new DbGenericReturn("1", "Order Updated");
            }
            catch(SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());

                return new DbGenericReturn("-1", ex.getMessage() + " " + ex.getSQLState() + " " + ex.getErrorCode());
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbGenericReturn("-50", auth.getReturn_string()); }
        else if (auth.getReturn_code().equals("-1")) { return new DbGenericReturn("-51", auth.getReturn_string()); }
        else { return new DbGenericReturn("-99", "Server Error!"); }

    }

    public DbGenericReturn removeOrder(String[] creds, int O_Id) {
        //TODO: IMPLEMENT THIS! (LOW PRIORITY)

        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {
            try {
                stmt = conn.createStatement();

                stmt.executeUpdate("DELETE FROM orders WHERE O_Id="+O_Id+" LIMIT 1;"); //DO THE QUERY

                stmt.close();
                return new DbGenericReturn("1", "Order Removed");
            }
            catch(SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());

                return new DbGenericReturn("-1", ex.getMessage() + " " + ex.getSQLState() + " " + ex.getErrorCode());
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbGenericReturn("-50", auth.getReturn_string()); }
        else if (auth.getReturn_code().equals("-1")) { return new DbGenericReturn("-51", auth.getReturn_string()); }
        else { return new DbGenericReturn("-99", "Server Error!"); }

    }
    public DbDataReturn getOrder(String[] creds, int O_Id) {
        //TODO: IMPLEMENT THIS! (gets specific order based on ID)

        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM orders WHERE O_Id=" + O_Id + " LIMIT 1;"); //DO THE QUERY

                String oid = rs.getString("O_Id");
                String uid = rs.getString("U_Id");
                String tid = rs.getString("T_Id");

                return new DbDataReturn("1", new String[]{oid, uid, tid});
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                return new DbDataReturn("-1", new String[]{"Sql Error!: " + ex});
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbDataReturn("-50", new String[] {auth.getReturn_string()}); }
        else if (auth.getReturn_code().equals("-1")) { return new DbDataReturn("-51", new String[] {auth.getReturn_string()}); }
        else { return new DbDataReturn("-99", new String[] {"Server Error!"}); }

    }
    public DbDataReturn getNOrders(String[] creds, int nOrders) {
        //TODO: IMPLEMENT THIS! (gets large amounts of previous orders)

        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM orders LIMIT " + nOrders + " ORDER BY O_Id DESC;"); //DO THE QUERY

                String[] orderArray = new String[nOrders*3];
                int i = 0;

                while(rs.next()) { //Iterate through orders,

                    String oid = rs.getString("O_Id");
                    String uid = rs.getString("U_Id");
                    String tid = rs.getString("T_Id");

                    orderArray[i+0] = oid;
                    orderArray[i+1] = uid;
                    orderArray[i+2] = tid;

                    i+=3;
                }
                return new DbDataReturn("1", orderArray);
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                return new DbDataReturn("-1", new String[]{"Sql Error!: " + ex});
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbDataReturn("-50", new String[] {auth.getReturn_string()}); }
        else if (auth.getReturn_code().equals("-1")) { return new DbDataReturn("-51", new String[] {auth.getReturn_string()}); }
        else { return new DbDataReturn("-99", new String[] {"Server Error!"}); }
    }

    public DbDataReturn getUserOrders(String[] creds, int nOrders) {
        //TODO: IMPLEMENT THIS! (gets n amount of previous orders)

        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {

            try {
                //Get U_Id
                User userData = getUserData(creds[0]);
                if (userData.getU_Id()==-1 || userData.getLast_Name().equals(null)) { //Checks if the data is valid.
                    return new DbDataReturn("-30", new String[] {"Database Error when fetching user ID."});
                }
                int U_Id = userData.getU_Id();

                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM orders WHERE U_Id=" + U_Id + " LIMIT " + nOrders + " ORDER BY O_Id DESC;"); //DO THE QUERY

                String[] orderArray = new String[nOrders*3];
                int i = 0;

                while(rs.next()) { //Iterate through orders,

                    String oid = rs.getString("O_Id");
                    String uid = rs.getString("U_Id");
                    String tid = rs.getString("T_Id");

                    orderArray[i+0] = oid;
                    orderArray[i+1] = uid;
                    orderArray[i+2] = tid;

                    i+=3;
                }
                return new DbDataReturn("1", orderArray);
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                return new DbDataReturn("-1", new String[]{"Sql Error!: " + ex});
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbDataReturn("-50", new String[] {auth.getReturn_string()}); }
        else if (auth.getReturn_code().equals("-1")) { return new DbDataReturn("-51", new String[] {auth.getReturn_string()}); }
        else { return new DbDataReturn("-99", new String[] {"Server Error!"}); }
    }

    public void getInProgressOrders(String[] creds) {
        //TODO: IMPLEMENT THIS! (WHEN NEEDED)
    }

    public DbGenericReturn addOrderItem(String[] creds, int O_Id, int I_Id) {

        //Authenticate User
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {
            try {

                //Execute Statement
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO order_items (O_Id, I_Id, Is_Active) " +
                        "VALUES (" + O_Id + ", " + I_Id + ")"); //DO THE QUERY
                stmt.close();
                //Say it all worked
                return new DbGenericReturn("1", "Order Item Added");

            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());

                return new DbGenericReturn("-1", ex.getMessage() + " " + ex.getSQLState() + " " + ex.getErrorCode());
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbGenericReturn("-50", auth.getReturn_string()); }
        else if (auth.getReturn_code().equals("-1")) { return new DbGenericReturn("-51", auth.getReturn_string()); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }

    public DbGenericReturn modifyOrderItem(String[] creds, int O_Id, int I_Id, int isActive) {
        //TODO: IMPLEMENT THIS! (modifies item on order)

        //Authenticate user
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE order_items SET " +
                        "I_Id=" +       I_Id + ", " +
                        "Is_Active=" +  isActive + " " +
                        "WHERE O_Id=" + O_Id + " AND I_Id=" + I_Id + ";");

                stmt.close();
                return new DbGenericReturn("1", "Order Updated");
            }
            catch(SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());

                return new DbGenericReturn("-1", ex.getMessage() + " " + ex.getSQLState() + " " + ex.getErrorCode());
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbGenericReturn("-50", auth.getReturn_string()); }
        else if (auth.getReturn_code().equals("-1")) { return new DbGenericReturn("-51", auth.getReturn_string()); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }

    public DbGenericReturn removeOrderItem(String[] creds, int O_Id, int I_Id) {
        //TODO: IMPLEMENT THIS! (removes item on order)

        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {
            try {
                stmt = conn.createStatement();

                stmt.executeUpdate("DELETE FROM order_items WHERE O_Id="+O_Id+" AND I_Id=" + I_Id + " LIMIT 1;"); //DO THE QUERY

                stmt.close();
                return new DbGenericReturn("1", "Order Item Removed");
            }
            catch(SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());

                return new DbGenericReturn("-1", ex.getMessage() + " " + ex.getSQLState() + " " + ex.getErrorCode());
            }
        }
        else if (auth.getReturn_code().equals("0")){ return new DbGenericReturn("-50", auth.getReturn_string()); }
        else if (auth.getReturn_code().equals("-1")) { return new DbGenericReturn("-51", auth.getReturn_string()); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }

    public void getOrderItems(String[] creds, int O_Id) {
        //TODO: IMPLEMENT THIS! (gets items on order)


    }

    //endregion

    //region ITEMS (FOOD AND DRINK ITEMS, NOT ORDER ITEMS)
     public void addItem(String[] creds, String itemName, String itemDesc, int itemPrice, int itemAvail, int itemVeget, int itemVegan, int itemSpicy) {
         //TODO: IMPLEMENT THIS! (adds an item)
     }
    public void modifyItem(String[] creds, int I_Id, String itemName, String itemDesc, int itemPrice, int itemAvail, int itemVeget, int itemVegan, int itemSpicy) {
        //TODO: IMPLEMENT THIS! (modifies item based on ID)
    }
    public void removeItem(String[] creds, int I_Id) {
        //TODO: IMPLEMENT THIS! (removes item based on ID)
    }
    public void getItem(String[] creds, int I_Id) {
        //TODO: IMPLEMENT THIS! (gets item info based on ID)
    }
    public void getItems(String[] creds) {
        //TODO: IMPLEMENT THIS! (returns all items)
    }

}
