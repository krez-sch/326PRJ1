
/**
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */
import java.net.*;
import java.io.*;

public class EchoClient
{
    public static void main(String[] args) {
        String lineUser, lineServer;
        boolean stayRunning = true;
        
        try {
            // Console application for reading user input
            Console console = System.console();
            
            // Read and send chats while the client is active
            while (stayRunning) {
                //make connection to socket
                Socket sock = new Socket("127.0.0.1", 6017);
                
                // Get input from the server
                InputStream in = sock.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                // Send output to the server
                PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
                
                // Read the chat from the user and send it to the server
                lineUser = console.readLine("\nClient: ");
                pout.println(lineUser);
                
                System.out.println("Server:");
                // read the chat from the server 
                while ((lineServer = br.readLine()) != null){
                    System.out.println(lineServer);
                }
                
                // close the socket connection
                sock.close();
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
