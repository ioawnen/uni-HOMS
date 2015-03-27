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

        try {
            database_conn = new Database();
            database_conn.initialise();
        }
        catch(Exception ex) {
            System.err.println(ex);
        }

        //TESTS!
        database_conn.login("chungus", "beep");
        database_conn.addUser("ian", "password", 1, 1, 1234567890, "Ian", "Owen");



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