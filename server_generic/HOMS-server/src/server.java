import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.xmlrpc.WebServer;

import javax.xml.crypto.Data;

/**
 * This is a simple server application. This server receive a string message
 * from the Android mobile phone and show it on the console.
 * Author by Lak J Comspace
 */
public class Server {

    private static Database database_conn;

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
        DbGenericReturn returnVal;

        returnVal = database_conn.authenticate(new String[]{"ianeg", "passwesgseord"});
        System.out.println(returnVal.getReturn_code() + " " + returnVal.getReturn_string());
        returnVal = database_conn.authenticate(new String[]{"ian", "password"});
        System.out.println(returnVal.getReturn_code() + " " + returnVal.getReturn_string());

        //database_conn.addUser(new String[] {"ian", "password"}, "nai", "password", 1, 0, 12453390, "Nai", "Owen");
        //database_conn.modifyUser(new String[] {"ian", "password"}, 55, "nai", "password", 1, 0, 72453390, "Nai", "Owen");

    }

    public String[] echo(String testString) {
        return new String[] {"1", "ECHO: "+testString};
    }

    public String[] authenticate(String username, String password) {

        //DO CHECK HERE
        System.out.println("Authentication Request");

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





}