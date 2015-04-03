package ioawnen.homs_android;
/**
 * Created by Ian on 30/03/2015.
 * Generic client-side code for talking to the server.
 */




import org.apache.xmlrpc.XmlRpcClient;
import java.util.Vector;

public class Client {


	private XmlRpcClient createConnection() { //Simple centralised method for standardising server connections. CALL THIS.
		XmlRpcClient server = null;
		try {


			server = new XmlRpcClient("http://192.168.0.123:38575/RPC2"); //TODO: MAKE THIS CONFIGURABLE

		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
			return null;
		}
		return server;
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


	public boolean authenticate(String[] creds) {
		XmlRpcClient server = createConnection();

		Vector params = new Vector();
		params.add(creds);

		try {
			Object result = server.execute("server.authenticate", params);
			String res = result.toString();
			System.out.println(res);
		}
		catch (Exception ex) { System.err.println(ex.getMessage()); return false; }

		return true;
	}

	public String[] addUser (String creds[]) {


		return new String[] {};
	}


}
