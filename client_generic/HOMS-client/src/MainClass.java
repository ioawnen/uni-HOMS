/**
 * Created by Ian on 30/03/2015.
 */
public class MainClass {

	public static void main(String[] args) {

		System.out.println("HOMS CLIENT (generic) - v0.1b\n\n" +
				(char)27 + "[31m" +
				"--------------------------------------------\n" +
				"IN DEVELOPMENT. NOT FOR GENERAL CONSUMPTION.\n" +
				"--------------------------------------------\n\n" +
				(char)27 + "[0m");

		Client client = new Client();
		//client.connect("http://localhost:38574/RPC2");
		client.authenticate("ian", "password");
	}
}
