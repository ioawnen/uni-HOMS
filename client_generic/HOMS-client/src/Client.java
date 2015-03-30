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
			server = new XmlRpcClient("http://localhost:38574/RPC2"); //TODO: MAKE THIS CONFIGURABLE

		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
			return null;
		}
		return server;
	}

	public boolean authenticate(String username, String password) {
		XmlRpcClient server = createConnection();

		String[] creds = {username, password};

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


}
