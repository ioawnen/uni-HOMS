/**
 * DATABASE MANAGEMENT CLASS
 */

/**
 * @author Ian
 */

import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Database {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    private static ResourceBundle R = ResourceBundle.getBundle("strings", Locale.ENGLISH);

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
            rs = stmt.executeQuery("SELECT * FROM users WHERE Username='" + username + "' LIMIT 1;"); //DO THE QUERY
            rs.first();

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
    private boolean isAdmin(String username) {
        if (getUserData(username).getIs_Admin() == 1) {
            return true;
        }
        else return false;
    }
    private boolean isActive(String username) {
        if (getUserData(username).getIs_Active() == 1) {
            return true;
        }
        else return false;
    }

    //endregion


    //TODO: CREATE A UNIFIED AUTHENTICATION METHOD (TAKES USERNAME/PASSWORD, RETURNS TRUE/FALSE OR -2,-1,0,1 ETC.)

    //region AUTHENTICATION

    public DbGenericReturn authenticate(String [] creds) { //MAYBE THIS WILL WORK BETTER!
        String username = creds[0];
        String password = creds[1];

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "';"); //DO THE QUERY

            if (rs.next()) {
                rs.first();
                String q_username = rs.getString("username");
                String q_password = rs.getString("password");

                if (q_username.equals(username) && q_password.equals(password)) {
                    return new DbGenericReturn("1", "Login Successful");
                }
            }
            else {
                return new DbGenericReturn("0", "Incorrect login credentials. Please try again.");
            }
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return new DbGenericReturn("-1", "Error when attempting to authenticate. Report this to your administrator.");
    }

    //endregion

    //region USER

    public DbGenericReturn addUser(String[] creds, String username, String password, int isActive, int isAdmin, int EmployeeNumber, String FirstName, String LastName) { // TODO: More Validation Maybe!

        //Authenticate user
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1") && isAdmin(creds[0]) && isActive(creds[0])) {

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
        else if (isAdmin(creds[0])) { return new DbGenericReturn("-52", R.getString("err-52") ); }
        else if (isActive(creds[0])) { return new DbGenericReturn("-53", R.getString("err-53") ); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }

    public DbGenericReturn modifyUser(String[] creds, int U_Id, String username,  int isActive, int isAdmin, int EmployeeNumber, String firstName, String lastName) { //TODO: CHECK IF USER EXISTS BEFORE ACTION

        //Authenticate user
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1") && isAdmin(creds[0]) && isActive(creds[0])) {
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE users SET " +
                        "Username='" +          username + "', " +
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
        else if (isAdmin(creds[0])) { return new DbGenericReturn("-52", R.getString("err-52") ); }
        else if (isActive(creds[0])) { return new DbGenericReturn("-53", R.getString("err-53") ); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }
    public DbGenericReturn modifyUserPassword(String[] creds, int U_Id, String password) { //TODO: CHECK IF USER EXISTS BEFORE ACTION

        //Authenticate user
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1") && isAdmin(creds[0]) && isActive(creds[0])) {
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE users SET " +
                        "Password='" +          password + "' " +
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
        else if (isAdmin(creds[0])) { return new DbGenericReturn("-52", R.getString("err-52") ); }
        else if (isActive(creds[0])) { return new DbGenericReturn("-53", R.getString("err-53") ); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }

    public DbGenericReturn removeUser(String[] creds, int U_Id) { //TODO: VERY BASIC! NEEDS VALIDATION!

        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1") && isAdmin(creds[0]) && isActive(creds[0])) {
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
        else if (isAdmin(creds[0])) { return new DbGenericReturn("-52", R.getString("err-52") ); }
        else if (isActive(creds[0])) { return new DbGenericReturn("-53", R.getString("err-53") ); }
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
                System.out.println("USER ID = "+userData.getU_Id());
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
                rs.first();
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
    public DbDataReturn getOrders(String[] creds) {
        //TODO: IMPLEMENT THIS! (gets large amounts of previous orders)

        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM orders ORDER BY O_Id DESC;"); //DO THE QUERY

                List<String> orders = new ArrayList<>();

                while(rs.next()) { //Iterate through orders,
                    String oid = rs.getString("O_Id");
                    String uid = rs.getString("U_Id");
                    String tid = rs.getString("T_Id");

                    orders.add(oid);
                    orders.add(uid);
                    orders.add(tid);
                }
                return new DbDataReturn("1", orders.toArray(new String[orders.size()]));
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
                rs = stmt.executeQuery("SELECT * FROM orders WHERE U_Id=" + U_Id + " LIMIT " + nOrders + ";"); //DO THE QUERY

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
                if(orderArray.length==0) {
                    return new DbDataReturn("0", new String[]{"No orders to return"});
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
                        "VALUES (" + O_Id + ", " + I_Id + ", 1);"); //DO THE QUERY
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

    public DbDataReturn getOrderItems(String[] creds) {
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM order_items;"); //DO THE QUERY

                List<String> orderItems = new ArrayList<>();
                while(rs.next()) { //Iterate through orders,

                    String oid = rs.getString("O_Id");
                    String iid = rs.getString("I_Id");
                    java.sql.Timestamp date = rs.getTimestamp("Time_Added");
                    String isActive = rs.getString("Is_Active");

                    orderItems.add(oid);
                    orderItems.add(iid);
                    orderItems.add(String.format("%1$TD %1$TT", date));
                    orderItems.add(isActive);
                }
                return new DbDataReturn("1", orderItems.toArray(new String[orderItems.size()]));
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

    public DbDataReturn getActiveOrderItems(String[] creds, int nOrders) {
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM order_items WHERE Is_Active=1;"); //DO THE QUERY

                String[] orderArray = new String[nOrders*4];

                List<String> orderItems = new ArrayList<>();
                while(rs.next()) { //Iterate through orders,

                    String oid = rs.getString("O_Id");
                    String iid = rs.getString("I_Id");
                    java.sql.Timestamp date = rs.getTimestamp("Time_Added");
                    String isActive = rs.getString("Is_Active");



                    orderItems.add(oid);
                    orderItems.add(iid);
                    orderItems.add(String.format("%1$TD %1$TT", date));
                    orderItems.add(isActive);
                }
                return new DbDataReturn("1", orderItems.toArray(new String[orderItems.size()]));
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


    //endregion

    //region ITEMS (FOOD AND DRINK ITEMS, NOT ORDER ITEMS)
     public DbGenericReturn addItem(String[] creds, String itemName, String itemDesc, int itemPrice, int itemAvail, int itemVeget, int itemVegan, int itemSpicy) {
         //TODO: IMPLEMENT THIS! (adds an item)
         //Authenticate user
         DbGenericReturn auth = authenticate(creds);
         if (auth.getReturn_code().equals("1") && isAdmin(creds[0]) && isActive(creds[0])) {

             try {
                 stmt = conn.createStatement();

                 stmt.executeUpdate("INSERT INTO items (Item_Name, Item_Description, Item_Price, Item_Available, Item_Is_Vegetarian, Item_Is_Vegan, Item_Is_Spicy) " +
                         "VALUES ('" + itemName + "', '" + itemDesc + "', " + itemPrice + ", " + itemAvail + ", " + itemVeget + ", " + itemVegan + ", " + itemSpicy + ");"); //DO THE QUERY

                 stmt.close();
                 return new DbGenericReturn("1", "Item Added");
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
         else if (isAdmin(creds[0])) { return new DbGenericReturn("-52", R.getString("err-52") ); }
         else if (isActive(creds[0])) { return new DbGenericReturn("-53", R.getString("err-53") ); }
         else { return new DbGenericReturn("-99", "Server Error!"); }

     }
    public DbGenericReturn modifyItem(String[] creds, int I_Id, String itemName, String itemDesc, int itemPrice, int itemAvail, int itemVeget, int itemVegan, int itemSpicy) {
        //TODO: IMPLEMENT THIS! (modifies item based on ID)
        //Authenticate user
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1") && isAdmin(creds[0]) && isActive(creds[0])) {
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE users SET " +
                        "Item_Name='" +         itemName + "', " +
                        "Item_Description='" +  itemDesc + "', " +
                        "Item_Price=" +         itemPrice + ", " +
                        "Item_Available=" +     itemAvail + ", " +
                        "Item_Is_Vegetarian=" +    itemVeget + ", " +
                        "Item_Is_Vegan=" +         itemVegan + ", " +
                        "Item_Is_Spicy=" +          itemSpicy + " " +
                        "WHERE I_Id=" +         I_Id + ";");

                stmt.close();
                return new DbGenericReturn("1", "Item Modified");
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
        else if (isAdmin(creds[0])) { return new DbGenericReturn("-52", R.getString("err-52") ); }
        else if (isActive(creds[0])) { return new DbGenericReturn("-53", R.getString("err-53") ); }
        else { return new DbGenericReturn("-99", "Server Error!"); }
    }
    public DbGenericReturn removeItem(String[] creds, int I_Id) {
        //TODO: IMPLEMENT THIS! (removes item based on ID)
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {
            try {
                stmt = conn.createStatement();

                stmt.executeUpdate("DELETE FROM items WHERE I_Id="+I_Id+" LIMIT 1;"); //DO THE QUERY

                stmt.close();
                return new DbGenericReturn("1", "Item Removed");
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
    public void getItem(String[] creds, int I_Id) {
        //TODO: IMPLEMENT THIS! (gets item info based on ID)
        //This is looking more and more redundant the more I work on getItems.
    }
    public DbDataReturn getItems(String[] creds) {
        //TODO: IMPLEMENT THIS! (returns all items)
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM items;"); //DO THE QUERY

                List<String> items = new ArrayList<>();

                while(rs.next()) { //Iterate through orders,

                    String iid = rs.getString("I_Id");
                    String itemName = rs.getString("Item_Name");
                    String itemDescs = rs.getString("Item_Description");
                    String itemPrice = rs.getString("Item_Price");
                    String itemAval = rs.getString("Item_Available");
                    String itemVeget = rs.getString("Item_Is_Vegetarian");
                    String itemVegan = rs.getString("Item_Is_Vegan");
                    String itemSpicy = rs.getString("Item_Is_Spicy");

                    items.add(iid);
                    items.add(itemName);
                    items.add(itemDescs);
                    items.add(itemPrice);
                    items.add(itemAval);
                    items.add(itemVeget);
                    items.add(itemVegan);
                    items.add(itemSpicy);
                }
                String[] results = items.toArray(new String[items.size()]);
                for(int i = 0; results.length<i; i++) {
                    System.out.println(results[i]);
                }
                return new DbDataReturn("1", items.toArray(new String[items.size()]));

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

    public DbDataReturn getManagementData(String[] creds) { //This is a hack if i've ever seen one.

        int income24H = 0; //
        int income7D = 0; //
        int income28D = 0; //
        int incomeAve24H = 0; //TODO: LOW PRIORITY MAKE THIS WORK
        int incomeTotal = 0; //
        int orderItems24H = 0; //
        int orderItems7D = 0; //
        int orderItems28D = 0; //
        int orderItemsTotal = 0; //
        int orderItemsInProgress = 0; //

        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1") && isAdmin(creds[0]) && isActive(creds[0])) {


            //GET A LIST OF ALL ITEMS AND THEIR DATA
            String[] results = getItems(creds).getReturn_strings(); //Get the array of items from getItems.
            System.out.println("resultssize = "+results.length);
            List<Item> items = new ArrayList<>(); //THIS LIST IS THE IMPORTANT ONE

            for(int i = 0; results.length>i; i=i+8) { //Populate that array
                items.add(new Item(results[i],results[i+1],results[i+2],results[i+3],results[i+4],results[i+5],results[i+6],results[i+7]));
                System.out.println("ITEM! "+results[i]+" "+results[i+1]+" "+results[i+2]+" "+results[i+3]+" "+results[i+4]+" "+results[i+5]+" "+results[i+6]+" "+results[i+7]);
            }

            //GET A LIST OF ALL ORDER ITEMS
            String[] orderItemsResult = getOrderItems(creds).getReturn_strings();
            System.out.println("order item size = "+results.length);
            List<OrderItem> orderItems = new ArrayList<>(); //THIS LIST IS THE IMPORTANT ONE

            for(int i = 0; orderItemsResult.length>i; i=i+4) { //Populate that array
                orderItems.add(new OrderItem(orderItemsResult[i],orderItemsResult[i+1],orderItemsResult[i+2],orderItemsResult[i+3]));
                System.out.println("ORDER ITEM! "+orderItemsResult[i]+" "+orderItemsResult[i+1]+" "+orderItemsResult[i+2]+" "+orderItemsResult[i+3]);
            }
            System.out.println("SIZE"+orderItems.size());

            //Put the order items with their corresponding items in a convoluted 2d array.
            Object[][] orderItemsAndItems = new Object[orderItems.size()][2];
            int i = 0;
            for(OrderItem tempOrderItem : orderItems) {
                orderItemsAndItems[i][0] = tempOrderItem;

                for(Item tempItem : items) {
                    if(tempItem.getI_Id().equals(tempOrderItem.getI_Id())) {
                        orderItemsAndItems[i][1] = tempItem;
                        break;
                    }
                }
                i++;
            }


            //INCOME AND ORDER ITEMS
            //Check if the order items are within specific time frames and count the profits.

            for(Object[] tempArray : orderItemsAndItems) {
                OrderItem orderItem = OrderItem.class.cast(tempArray[0]); //Get the current orderItem from the array
                Item item = Item.class.cast(tempArray[1]); //And get it's corresponding item too.
                Date now = new Date(); //Get the time right now
                boolean inProCou = false;

                incomeTotal += Integer.parseInt(item.getItem_Price()); //Add all of the orders for the total.
                orderItemsTotal++; //Total count of all order items

                if(orderItem.getIs_Active().equals("1")) { //If order is in progress right now
                    orderItemsInProgress++; //Add it to the count
                }


                try {
                    //Convert time String to Date object
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
                    Date orderTime = sdf.parse(orderItem.getTime());

                    long minsSinceOrder = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - orderTime.getTime()); //get The mins since the order was added.
                    System.out.println("TIME OF ORDER "+orderTime.toString()+" TIME NOW "+now.toString());
                    System.out.println("HOURS SINCE ORDER "+minsSinceOrder);


                    if(minsSinceOrder<1440) { //If the order was placed in the last 24 hours
                        income24H += Integer.parseInt(item.getItem_Price());
                        orderItems24H++;
                    }
                    if(minsSinceOrder<10080) { //If the order was placed in the last 7 days
                        income7D += Integer.parseInt(item.getItem_Price());
                        orderItems7D++;
                    }
                    if(minsSinceOrder<40320) { //If the order was placed in the last 28 days
                        income28D += Integer.parseInt(item.getItem_Price());
                        orderItems28D++;
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            //ORDERS
            //TODO: ADD ORDER TIMESTAMPS!


            return new DbDataReturn("1", new String[] {
                    Integer.toString(income24H),
                    Integer.toString(income7D),
                    Integer.toString(income28D),
                    Integer.toString(incomeAve24H),
                    Integer.toString(orderItems24H),
                    Integer.toString(orderItems7D),
                    Integer.toString(orderItems28D),
                    Integer.toString(orderItemsTotal),
                    Integer.toString(orderItemsInProgress),
            });

        }
        else if (auth.getReturn_code().equals("0")){ return new DbDataReturn("-50", new String[] {auth.getReturn_string()}); }
        else if (auth.getReturn_code().equals("-1")) { return new DbDataReturn("-51", new String[] {auth.getReturn_string()}); }
        else { return new DbDataReturn("-99", new String[] {"Server Error!"}); }

    }

    public DbDataReturn getUsers(String[] creds) {
        //TODO: IMPLEMENT THIS! (returns all items)
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1") && isAdmin(creds[0]) && isActive(creds[0])) {

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM users;"); //DO THE QUERY

                List<String> users = new ArrayList<>();

                while(rs.next()) { //Iterate through orders,

                    String uid = rs.getString("U_Id");
                    String username = rs.getString("Username");
                    //String password = rs.getString("Password"); //BAD!
                    String isActive = rs.getString("Is_Active");
                    String isAdmin = rs.getString("Is_Admin");
                    String employeeNumber = rs.getString("Employee_Number");
                    String firstName = rs.getString("First_Name");
                    String lastName = rs.getString("Last_Name");



                    users.add(uid);
                    users.add(username);
                    //users.add(password); //BAD!
                    users.add(isActive);
                    users.add(isAdmin);
                    users.add(employeeNumber);
                    users.add(firstName);
                    users.add(lastName);

                }
                String[] results = users.toArray(new String[users.size()]);
                for(int i = 0; results.length<i; i++) {
                    System.out.println(results[i]);
                }
                return new DbDataReturn("1", users.toArray(new String[users.size()]));

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

    public DbDataReturn getTables(String[] creds) {
        //TODO: IMPLEMENT THIS! (returns all tables)
        DbGenericReturn auth = authenticate(creds);
        if (auth.getReturn_code().equals("1")) {

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM tables;"); //DO THE QUERY

                List<String> items = new ArrayList<>();

                while(rs.next()) { //Iterate through orders,

                    String tid = rs.getString("T_Id");
                    String tableNo = rs.getString("Table_Number");
                    String tableDesc = rs.getString("Table_Description");
                    String tableAvail = rs.getString("Table_Available");
                    String tableSeats = rs.getString("Table_Seats");


                    items.add(tid);
                    items.add(tableNo);
                    items.add(tableDesc);
                    items.add(tableAvail);
                    items.add(tableSeats);
                }
                String[] results = items.toArray(new String[items.size()]);
                for(int i = 0; results.length<i; i++) {
                    System.out.println(results[i]);
                }
                return new DbDataReturn("1", items.toArray(new String[items.size()]));

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

}
