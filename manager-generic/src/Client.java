/**
 * Created by Ian on 30/03/2015.
 * Generic client-side code for talking to the server.
 */

import org.apache.xmlrpc.XmlRpcClient;

import java.util.Vector;

public class Client {

	String url;

	private XmlRpcClient createConnection() { //Simple centralised method for standardising server connections. CALL THIS.
			XmlRpcClient server = null;
			try {
				server = new XmlRpcClient(url); //TODO: MAKE THIS CONFIGURABLE

			}
			catch (Exception ex) {
				System.err.println(ex.getMessage());
				return null;
		}
		return server;
	}

	public void setURL(String URL) {
		url = URL;
	}

	private String[] strToArray(String str) {

		str = str.substring(1, str.length()-1);
		return str.split(", ");
	}

	public String[] echo(String testString) {
		//Create a server connection
		XmlRpcClient server = createConnection();

		//Add call parameters
		Vector params = new Vector();
		params.add(testString);

		try {
			Object result = server.execute("server.echo", params);
			String res = result.toString();
			System.out.println(res);

			return new String[] {"1", res};
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] authenticate(String[] creds) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);

		try {
			Object result = server.execute("server.authenticate", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] addUser (String creds[], String username, String password, int isActive, int isAdmin, int EmployeeNumber, String FirstName, String LastName) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(username);
		params.add(password);
		params.add(isActive);
		params.add(isAdmin);
		params.add(EmployeeNumber);
		params.add(FirstName);
		params.add(LastName);

		try {
			Object result = server.execute("server.addUser", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] modifyUser(String creds[], int U_Id, String username, int isActive, int isAdmin, int EmployeeNumber, String FirstName, String LastName) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(U_Id);
		params.add(username);
		params.add(isActive);
		params.add(isAdmin);
		params.add(EmployeeNumber);
		params.add(FirstName);
		params.add(LastName);

		try {
			Object result = server.execute("server.modifyUser", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}
	public String[] modifyUserPassword(String creds[], int U_Id, String password) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(U_Id);
		params.add(password);


		try {
			Object result = server.execute("server.modifyUserPassword", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}


	public String[] removeUser(String creds[], int U_Id) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(U_Id);

		try {
			Object result = server.execute("server.removeUser", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] addOrder(String[] creds, int T_Id) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(T_Id);

		try {
			Object result = server.execute("server.addOrder", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] modifyOrder(String[] creds, int O_Id, int T_Id) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(O_Id);
		params.add(T_Id);

		try {
			Object result = server.execute("server.modifyOrder", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] removeOrder(String[] creds, int O_Id) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(O_Id);

		try {
			Object result = server.execute("server.removeOrder", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] getOrder(String[] creds, int O_Id) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(O_Id);

		try {
			Object result = server.execute("server.getOrder", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] getOrders(String[] creds) {  //TODO: Return as 2d array {{CODE,STR},{ORDER SHIT},{ORDER SHIT}...}
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);


		try {
			Object result = server.execute("server.getOrders", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] getUserOrders(String[] creds, int nOrders) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(nOrders);

		try {
			Object result = server.execute("server.getUserOrders", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] getInProgressOrders(String[] creds, int nOrders) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(nOrders);

		try {
			Object result = server.execute("server.getInProgressOrders", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] addOrderItem(String[] creds, int O_Id, int I_Id) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(O_Id);
		params.add(I_Id);

		try {
			Object result = server.execute("server.addOrderItem", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] modifyOrderItem(String[] creds, int O_Id, int I_Id, int isActive) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(O_Id);
		params.add(I_Id);
		params.add(isActive);

		try {
			Object result = server.execute("server.modifyOrderItem", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] removeOrderItem(String[] creds, int O_Id, int I_Id) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(O_Id);
		params.add(I_Id);

		try {
			Object result = server.execute("server.removeOrderItem", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] getActiveOrderItems(String[] creds, int nOrders) {

		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);
		params.add(nOrders);

		try {
			Object result = server.execute("server.getActiveOrderItems", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }

	}

	public String[] getItems(String[] creds) {

		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);

		try {
			Object result = server.execute("server.getItems", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}

	public String[] getUsers(String[] creds) {

		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds[0]);
		params.add(creds[1]);

		try {
			Object result = server.execute("server.getUsers", params);
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}




	public String[] drop_table_users() { //gg moron
		XmlRpcClient server = createConnection();

		try {
			Object result = server.execute("server.drop_table_users", new Vector());
			String res = result.toString();
			return strToArray(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
	}
}
