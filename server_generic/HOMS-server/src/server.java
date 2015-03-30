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

    public void initialise(int port) {


        //Initialise the database connection!
        try {
            database_conn = new Database();
            database_conn.initialise();
        }
        catch(Exception ex) {
            System.err.println(ex);
        }

        //DATABASE TESTS!
        //database_conn.login("chungus", "beep");
        //database_conn.login("ian", "password");
        //database_conn.addUser("nai", "password", 1, 0, 12453390, "Nai", "Owen");
        database_conn.modifyUser(55, "nai", "password", 1, 0, 72453390, "Nai", "Owen");

    }

    public String[] authenticate(String username, String password) {

        //DO CHECK HERE
        System.out.println("Authentication Request");

        DbGenericReturn authResult = database_conn.authenticate(username, password);

        String[] result = {authResult.getReturn_code(), authResult.getReturn_string()};

        return result;

    }

    public String logout(String username, String password) {
        //DO CHECK HERE
        return "-1";
    }

    public String addOrder(String username, String password, String[] order) {
        //DO STUFF HERE
        return "-1";
    }


}