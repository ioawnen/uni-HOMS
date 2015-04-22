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
		System.out.println(client.authenticate(new String[]{"ian", "password"})[1]);
		//client.echo("beep");
		System.out.println(client.drop_table_users()[1]);

		String[] data =client.addOrderItem(new String[]{"ian", "password"}, 1, 1);
		System.out.println("DATA: "+data[0]+data[1]);

		String[] data3 = client.getActiveOrderItems(new String[] {"ian", "password"},10);
		System.out.println("DATA3: "+data3[0]+" "+data3[3]);

		for(int i = 0; data3.length>i; i++) {
			System.out.println(data3[i]);
		}
	}
}
