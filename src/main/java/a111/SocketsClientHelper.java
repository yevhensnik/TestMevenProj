package a111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;


public class SocketsClientHelper {

	private BufferedReader input;
	private PrintWriter output;
	private Socket socket;
	private String outputToServer = "1111";
	private int timeOut = 5000;
	private String responseServer;

	public SocketsClientHelper(String host, int port) throws UnknownHostException, IOException {
		init(host, port);
	}
	
	private void init(String host, int port) throws UnknownHostException, IOException {
		
		connect(host, port);
		InputStream stream = getInputStream();
		
		// Make connection and initialize streams
		input = new BufferedReader(new InputStreamReader(stream));
		output = new PrintWriter(socket.getOutputStream(), true);
		
		output.println(outputToServer);
		try {
			responseServer = input.readLine();
		} catch (SocketTimeoutException e) {
			System.out.println("SocketTimeoutException");
		}
		
		System.out.println(responseServer);
	}

	public void connect(String host, int port){
		try {
			socket = new Socket(host, port);
			socket.setSoTimeout(timeOut);
		} catch (UnknownHostException e) {
			System.out.println("Unknowed host: " + host);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I / O Error creating socket " + host
		               + ":" + port);
			e.printStackTrace();
		}
	}
	public void close(){
		try {
			socket.close();
			System.out.println("Client closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public InputStream getInputStream(){
		InputStream inputStream = null;
		try {
			inputStream = socket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return inputStream;
	}

}