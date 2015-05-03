package ioawnen.homs_android;

import java.net.URL;


import de.timroes.axmlrpc.XMLRPCClient;


/**
 * Created by Ian on 03/05/2015.
 */
public class Client_Android {

    private XMLRPCClient createConnection() {
        XMLRPCClient server = null;

        try {
            server = new XMLRPCClient(new URL("http://192.168.0.123:38575/RPC2"));

        } catch(Exception ex) {
            // Anything
            System.err.println(ex.getMessage());
        }
        return server;
    }

    private String[] strToArray(String str) {

        str = str.substring(1, str.length()-1);
        return str.split(", ");
    }

    public String[] authenticate(String[] creds) {
        System.out.println("0");
        try {

            System.out.println("1");
            XMLRPCClient server = new XMLRPCClient(new URL("http://192.168.0.123:38575/RPC2"), XMLRPCClient.FLAGS_APACHE_WS);
            System.out.println("2");
            Object result = server.call("server.echo", "fdekrhkrj");





            System.out.println("3");
            System.out.println("RESULT STRING: "+result);
            return new String[] {"penis", "erigjherj"};

        }
        catch (Exception ex) { System.err.println(ex.getMessage()); return new String[] {"-20","Connection Error!"}; }
    }


}
