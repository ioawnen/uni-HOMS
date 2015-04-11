/**
 * SERVER APPLICATION START POINT
 */

import org.apache.xmlrpc.WebServer;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * @author Ian
 */
public class MainClass {

    public static WebServer webserver = null;
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("strings", Locale.ENGLISH);

    public static void main(String[] args) {

        System.out.println("HOMS SERVER (generic) - "+resourceBundle.getString("version")+"\n\n" +
                (char)27 + "[31m" +
                "--------------------------------------------\n" +
                "IN DEVELOPMENT. NOT FOR GENERAL CONSUMPTION.\n" +
                "--------------------------------------------\n\n" +
                (char)27 + "[0m");

        //Make Server!
        Server server = new Server();
        server.initialise();

        try {
            webserver = new WebServer(38575);
            webserver.addHandler("server", server); //Make your client-side calls using 'server.method'
            webserver.start();

            System.out.println((char) 27 + "[32m" + "Server Started!" +
                    (char)27 + "[0m");

        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
