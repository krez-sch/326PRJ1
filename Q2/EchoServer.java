
/**
* An echo server listening on port 6007. This server reads from the client
* and echoes back the result.
*/

import java.net.*;
import java.io.*;

public class EchoServer
{
    public static void main(String[] args) {
        boolean stayRunning = true;
    	String line;
        
    	try {
            ServerSocket sock = new ServerSocket(6017);
        	
            System.out.println("Listening for connections on port 6017...");
            
            while (stayRunning) {
            	// listen for connections
                Socket client = sock.accept();
                System.out.println("New socket.");
                
                // Get input from the client
                InputStream in = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                // Read output from the client
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                
            	// read the chat from the client 
                while ((line = br.readLine()) != null){
                	System.out.println("Received: " + line);
                	line = line.replaceAll("client", "!temp!").replaceAll("Client", "!Temp!");
                	line = line.replaceAll("server", "client").replaceAll("Server", "Client");
                	line = line.replaceAll("!temp!", "server").replaceAll("!Temp!", "Server");
                	System.out.println("Sent: " + line);
                    pout.println(line);
                }
                
                // close the socket and resume listening for connections
                client.close();
            }
            
            sock.close();
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
