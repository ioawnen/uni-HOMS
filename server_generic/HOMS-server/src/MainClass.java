/**
 * SERVER APPLICATION START POINT
 */


import org.apache.xmlrpc.WebServer;

/**
 * @author Ian
 */
public class MainClass {

    public static WebServer webserver = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("HOMS SERVER (generic) - v0.1b\n\n" +
                (char)27 + "[31m" +
                "--------------------------------------------\n" +
                "IN DEVELOPMENT. NOT FOR GENERAL CONSUMPTION.\n" +
                "--------------------------------------------\n\n" +
                (char)27 + "[0m");

        //Make Server!
        Server server = new Server();
        server.initialise(0);

        try {
            webserver = new WebServer(38575);
            webserver.addHandler("server", server);
            webserver.start();


        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

}