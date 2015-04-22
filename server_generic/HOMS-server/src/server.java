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
        DbDataReturn returnVal2;
        System.out.println("Testing incorrect login....");
        returnVal = database_conn.authenticate(new String[]{"ianeg", "passwesgseord"});
        System.out.println(returnVal.getReturn_code() + " " + returnVal.getReturn_string());
        System.out.println("Testing correct login....");
        returnVal = database_conn.authenticate(new String[]{"ian", "password"});
        System.out.println(returnVal.getReturn_code() + " " + returnVal.getReturn_string());

        //database_conn.addUser(new String[] {"ian", "password"}, "nai", "password", 1, 0, 12453390, "Nai", "Owen");
        //database_conn.modifyUser(new String[] {"ian", "password"}, 55, "nai", "password", 1, 0, 72453390, "Nai", "Owen");

        returnVal = database_conn.addOrder(new String[] {"ian", "password"}, 1);
        System.out.println("ADD ORDER: "+returnVal.getReturn_code() + " " + returnVal.getReturn_string());

        returnVal = database_conn.addOrderItem(new String[]{"ian", "password"}, 1, 1);
        System.out.println("ADD ORDER ITEM: "+returnVal.getReturn_code() + " " + returnVal.getReturn_string());

        returnVal2 = database_conn.getActiveOrderItems(new String[] {"ian", "password"}, 10);
        System.out.println("GET ACTIVE ORDER ITEMS: "+returnVal2.getReturn_code() + " " + returnVal2.getReturn_strings()[2]);
        for(int i = 0; returnVal2.getReturn_strings().length>i; i++) {
            System.out.println(returnVal2.getReturn_strings()[i]);
        }
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

    public String[] addUser(String Uname, String Pword, String username, String password, int isActive, int isAdmin, int EmployeeNumber, String FirstName, String LastName) {

        DbGenericReturn dbResult = database_conn.addUser(new String[] {Uname, Pword}, username, password, isActive, isAdmin, EmployeeNumber, FirstName, LastName);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] modifyUser(String Uname, String Pword, int U_Id, String username, String password, int isActive, int isAdmin, int EmployeeNumber, String firstName, String lastName) { //TODO: CHECK IF USER EXISTS BEFORE ACTION

        DbGenericReturn dbResult = database_conn.modifyUser(new String[] {Uname, Pword}, U_Id, username, password, isActive, isAdmin, EmployeeNumber, firstName, lastName);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] removeUser(String Uname, String Pword, int U_Id) {

        DbGenericReturn dbResult = database_conn.removeUser(new String[] {Uname, Pword}, U_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] addOrder(String Uname, String Pword, int  T_Id) {

        DbGenericReturn dbResult = database_conn.addOrder(new String[] {Uname, Pword}, T_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] modifyOrder(String Uname, String Pword, int O_Id, int T_Id) {

        DbGenericReturn dbResult = database_conn.modifyOrder(new String[] {Uname, Pword}, O_Id, T_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] removeOrder(String Uname, String Pword, int O_Id) {

        DbGenericReturn dbResult = database_conn.removeOrder(new String[] {Uname, Pword}, O_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};

    }

    public String[][] getOrder(String Uname, String Pword, int O_Id) {

        DbDataReturn dbResult = database_conn.getOrder(new String[] {Uname, Pword}, O_Id);
        return new String[][] {{dbResult.getReturn_code()},dbResult.getReturn_strings()};

    }

    public String[][] getNOrders(String Uname, String Pword, int nOrders){

        DbDataReturn dbResult = database_conn.getNOrders(new String[] {Uname, Pword}, nOrders);
        return new String[][] {{dbResult.getReturn_code()},dbResult.getReturn_strings()};
    }

    public String[][] getUserOrders(String Uname, String Pword, int nOrders) {

        DbDataReturn dbResult = database_conn.getUserOrders(new String[] {Uname, Pword}, nOrders);
        return new String[][] {{dbResult.getReturn_code()},dbResult.getReturn_strings()};
    }

    public  String[] getInProgressOrders(String Uname, String Pword, int nOrders) { //TODO: IMPLEMENT WHEN NEEDED
        return new String[] {"-98", "Not yet implemented."};
    }

    public String[] addOrderItem(String Uname, String Pword, int O_Id, int I_Id) {

        DbGenericReturn dbResult = database_conn.addOrderItem(new String[] {Uname, Pword}, O_Id, I_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] modifyOrderItem(String Uname, String Pword, int O_Id, int I_Id, int isActive){

        DbGenericReturn dbResult = database_conn.modifyOrderItem(new String[] {Uname, Pword}, O_Id, I_Id, isActive);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] removeOrderItem(String Uname, String Pword, int O_Id, int I_Id) {

        DbGenericReturn dbResult = database_conn.removeOrderItem(new String[] {Uname, Pword}, O_Id, I_Id);
        return new String[] {dbResult.getReturn_code(), dbResult.getReturn_string()};
    }

    public String[] getOrderItems(String Uname, String Pword, int O_Id) {

        return new String[] {"-98", "Not yet implemented."};
    }

    public String[] getActiveOrderItems(String Uname, String Pword, int nOrders) {
        DbDataReturn dbResult = database_conn.getActiveOrderItems(new String[] {Uname, Pword}, nOrders);

        String[] results = new String[dbResult.getReturn_strings().length+1];
        results[0] = dbResult.getReturn_code();
        System.arraycopy(dbResult.getReturn_strings(), 0, results, 1, dbResult.getReturn_strings().length);

        return results;

    }

    public String[] addItem(String Uname, String Pword, String itemName, String itemDesc, int itemPrice, int itemAvail, int itemVeget, int itemVegan, int itemSpicy) {

        return new String[] {"-98", "Not yet implemented."};
    }
    public String[] modifyItem(String Uname, String Pword, int I_Id, String itemName, String itemDesc, int itemPrice, int itemAvail, int itemVeget, int itemVegan, int itemSpicy) {

        return new String[] {"-98", "Not yet implemented."};
    }
    public String[] removeItem(String Uname, String Pword, int I_Id) {

        return new String[] {"-98", "Not yet implemented."};
    }
    public String[] getItem(String Uname, String Pword, int I_Id) {

        return new String[] {"-98", "Not yet implemented."};
    }
    public String[][] getItems(String Uname, String Pword) {
        DbDataReturn dbResult = database_conn.getItems(new String[] {Uname, Pword});
        return new String[][] {{dbResult.getReturn_code()},dbResult.getReturn_strings()};
    }

    public String[] drop_table_users() {
        return new String[] {"1", resourceBundle.getString("drop_table_users_string")};
    }



}