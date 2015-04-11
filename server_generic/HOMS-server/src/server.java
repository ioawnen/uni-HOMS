import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.xmlrpc.WebServer;

import javax.xml.crypto.Data;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This is a simple server application. This server receive a string message
 * from the Android mobile phone and show it on the console.
 * Author by Lak J Comspace
 *
 *
 * HOW TO SEND DATA AS ARRAYS:
 *
 * Simple Response array style:
 *      String[] {return_code, return_string}
 *
 * Response with data:
 *      String[][] {{return_code}, return_array}
 *  -or-
 *      String[][] {{return_code},{return_string1, return_string2, return_string3}}
 *
 *  DON'T JUST RETURN A SINGLE VALUE WHERE POSSIBLE! RETURN AN EXPLANATION THAT CAN BE DISPLAYED/USED!
 */
public class Server {

    private static Database database_conn;
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("strings", Locale.ENGLISH);

    public void initialise() {


        //Initialise the database connection!
        try {
            database_conn = new Database();
            database_conn.initialise();
        }
        catch(Exception ex) {
            System.err.println(ex);
        }

        //DATABASE TESTS!
        System.err.println("BEGINNING TESTS");
        DbGenericReturn returnVal;
        System.out.println("Testing incorrect login....");
        returnVal = database_conn.authenticate(new String[]{"ianeg", "passwesgseord"});
        System.out.println(returnVal.getReturn_code() + " " + returnVal.getReturn_string());
        System.out.println("Testing correct login....");
        returnVal = database_conn.authenticate(new String[]{"ian", "password"});
        System.out.println(returnVal.getReturn_code() + " " + returnVal.getReturn_string());

        //database_conn.addUser(new String[] {"ian", "password"}, "nai", "password", 1, 0, 12453390, "Nai", "Owen");
        //database_conn.modifyUser(new String[] {"ian", "password"}, 55, "nai", "password", 1, 0, 72453390, "Nai", "Owen");


        System.err.println("TESTS OVER\n");

    }

    public String[] echo(String testString) {
        return new String[] {"1", "ECHO: "+testString};
    }

    public String[] authenticate(String username, String password) {

        //DO CHECK HERE
        System.out.println("Client Authentication Request");

        DbGenericReturn authResult = database_conn.authenticate(new String[] {username, password});

        String[] result = {authResult.getReturn_code(), authResult.getReturn_string()};

        return result;
    }

    public String[] addUser(String[] creds, String username, String password, int isActive, int isAdmin, int EmployeeNumber, String FirstName, String LastName) {

        DbGenericReturn dbResult = database_conn.addUser(creds, username, password, isActive, isAdmin, EmployeeNumber, FirstName, LastName);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] modifyUser(String[] creds, int U_Id, String username, String password, int isActive, int isAdmin, int EmployeeNumber, String firstName, String lastName) { //TODO: CHECK IF USER EXISTS BEFORE ACTION

        DbGenericReturn dbResult = database_conn.modifyUser(creds, U_Id, username, password, isActive, isAdmin, EmployeeNumber, firstName, lastName);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] removeUser(String[] creds, int U_Id) {

        DbGenericReturn dbResult = database_conn.removeUser(creds, U_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] addOrder(String[] creds, int  T_Id) {

        DbGenericReturn dbResult = database_conn.addOrder(creds, T_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] modifyOrder(String[] creds, int O_Id, int T_Id) {

        DbGenericReturn dbResult = database_conn.modifyOrder(creds, O_Id, T_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] removeOrder(String[] creds, int O_Id) {

        DbGenericReturn dbResult = database_conn.removeOrder(creds, O_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};

    }

    public String[][] getOrder(String[] creds, int O_Id) {

        DbDataReturn dbResult = database_conn.getOrder(creds, O_Id);
        return new String[][] {{dbResult.getReturn_code()},dbResult.getReturn_strings()};

    }

    public String[][] getNOrders(String[] creds, int nOrders){

        DbDataReturn dbResult = database_conn.getNOrders(creds, nOrders);
        return new String[][] {{dbResult.getReturn_code()},dbResult.getReturn_strings()};
    }

    public String[][] getUserOrders(String[] creds, int nOrders) {

        DbDataReturn dbResult = database_conn.getUserOrders(creds, nOrders);
        return new String[][] {{dbResult.getReturn_code()},dbResult.getReturn_strings()};
    }

    public  String[] getInProgressOrders(String[] creds, int nOrders) { //TODO: IMPLEMENT WHEN NEEDED
        return new String[] {"-98", "Not yet implemented."};
    }

    public String[] addOrderItem(String[] creds, int O_Id, int I_Id) {

        DbGenericReturn dbResult = database_conn.addOrderItem(creds, O_Id, I_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] modifyOrderItem(String[] creds, int O_Id, int I_Id, int isActive){

        DbGenericReturn dbResult = database_conn.modifyOrderItem(creds, O_Id, I_Id, isActive);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] removeOrderItem(String[] creds, int O_Id, int I_Id) {

        DbGenericReturn dbResult = database_conn.removeOrderItem(creds, O_Id, I_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] getOrderItems(String[] creds, int O_Id) {

        return new String[] {"-98", "Not yet implemented."};
    }

    public String[] addItem(String[] creds, String itemName, String itemDesc, int itemPrice, int itemAvail, int itemVeget, int itemVegan, int itemSpicy) {

        return new String[] {"-98", "Not yet implemented."};
    }
    public String[] modifyItem(String[] creds, int I_Id, String itemName, String itemDesc, int itemPrice, int itemAvail, int itemVeget, int itemVegan, int itemSpicy) {

        return new String[] {"-98", "Not yet implemented."};
    }
    public String[] removeItem(String[] creds, int I_Id) {

        return new String[] {"-98", "Not yet implemented."};
    }
    public String[] getItem(String[] creds, int I_Id) {

        return new String[] {"-98", "Not yet implemented."};
    }
    public String[] getItems(String[] creds) {

        return new String[] {"-98", "Not yet implemented."};
    }

    public String[] drop_table_users() {
        return new String[] {"1", resourceBundle.getString("drop_table_users_string")};
    }



}