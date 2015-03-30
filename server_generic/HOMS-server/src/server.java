import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is a simple server application. This server receive a string message
 * from the Android mobile phone and show it on the console.
 * Author by Lak J Comspace
 */
public class Server {

    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message;

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



        try {
            serverSocket = new ServerSocket(); // Server socket
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(port));


        } catch (IOException e) {
            System.out.println("Could not listen on port " + port + " " + e);
            return;
        }

        System.out.println("Server started. Listening to the port " + port);

        while (true) {
            try {

                clientSocket = serverSocket.accept(); // accept the client connection
                inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader); // get the client message
                message = bufferedReader.readLine();

                System.out.println(message);
                inputStreamReader.close();
                clientSocket.close();

            } catch (IOException ex) {
                System.out.println("Problem in message reading " + ex);
            }
        }
    }

    public String login(String username, String password) {

        //DO CHECK HERE
        return "-1";
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