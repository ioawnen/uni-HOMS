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
        // TODO Auto-generated method stub
        System.out.println("BUM");

        //Make Server!
        Server server = new Server();
        server.initialise(24056);

    }

}
