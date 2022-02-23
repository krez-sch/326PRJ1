package Q1;

/**
 * Modified DateClient so that it requests a quote
 * from the quote server.
 */
 
import java.net.*;
import java.io.*;

public class QuoteClient
{
	public static void main(String[] args) {
		try {
			//make connection to socket
			Socket sock = new Socket("127.0.0.1",6017);
			InputStream in = sock.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			// read the date from the socket (need to change to get quote)
			String line;
			while ((line = br.readLine()) != null){
				System.out.println(line);
			}
			// close the socket connection
			sock.close();
		}
		catch (IOException e) {
		System.err.println(e);
		}
	}
}