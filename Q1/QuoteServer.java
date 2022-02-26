
/**
 * Quote server listening to port 6017.
 *
 */
 
import java.net.*;
import java.io.*;

public class QuoteServer
{
  public static void main(String[] args) {
    try {
      ServerSocket sock = new ServerSocket(6017);
      // listen for connections
      while (true) {
      Socket client = sock.accept();
      PrintWriter pout = new
      PrintWriter(client.getOutputStream(), true);
      // write the Quote to the socket
      String quote = "Code is like humor. When you have to explain it, it's bad.";
      pout.println(quote.toString()); // save quote to the server
      // close the socket and resume
      // listen for connections
      client.close();
      }
    }
    catch (IOException e) {
    System.err.println(e);
    }
  }
}