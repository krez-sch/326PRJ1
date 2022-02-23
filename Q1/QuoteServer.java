package Q1;
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
      // write the Date to the socket
      pout.println(new java.util.Date().toString()); // change to quote
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