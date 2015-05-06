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

		String[] results = null;
		String[] creds = new String[]{"ian", "********"};


		System.out.println("Authenticate Test");
		results = client.authenticate(creds);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Authenticate Test");
		results = client.authenticate(creds);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Add User Test");
		results = client.addUser(creds, "TestUser", "Pass", 1, 1, 1234, "test", "user");
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Modify User Test");
		results = client.modifyUser(creds, 2, "NewUserName", "NewPassword", 1, 1, 1234, "new", "name");
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Remove User Test");
		results = client.removeUser(creds, 2);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Add Order Test");
		results = client.addOrder(creds, 1);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Modify Order Test");
		results = client.modifyOrder(creds, 1, 1);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Remove Order Test - NOT USED");
		/*
		results = client.removeOrder(creds, 1);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }
		*/

		System.out.println("Get Order Test");
		results = client.getOrder(creds, 2);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Get Orders Test");
		results = client.getOrders(creds);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Get User Orders Test - NOT USED");
		/*
		results = client.getUserOrders(creds, 5);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }
		*/

		System.out.println("Get In Progress Orders Test");
		results = client.getInProgressOrders(creds, 1);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Add Order Item Test");
		results = client.addOrderItem(creds, 1, 1);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Modify Order Item Test");
		results = client.modifyOrderItem(creds, 1, 1, 1);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Remove Order Item Test - NOT USED");
		/*
		results = client.authenticate(creds);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }
		*/

		System.out.println("Get Active Order Items Test");
		results = client.getActiveOrderItems(creds, 10);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Get Items Test");
		results = client.getItems(creds);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }

		System.out.println("Get Users Test");
		results = client.authenticate(creds);
		if(results[0].equals("1")) { System.out.println("\tPASSED"); }
		else { System.out.println("\tFAILED - "+results[1]); }
	}
}
