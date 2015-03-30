/**
 * SERVER APPLICATION START POINT
 */


/**
 * @author Ian
 */
public class MainClass {


    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("HOMS SERVER - v0.1a\n\n" +
                (char)27 + "[31m" +
                "--------------------------------------------\n" +
                "IN DEVELOPMENT. NOT FOR GENERAL CONSUMPTION.\n" +
                "--------------------------------------------\n\n" +
                (char)27 + "[0m");

        //Make Server!
        Server server = new Server();
        server.initialise(24056);

    }

}
