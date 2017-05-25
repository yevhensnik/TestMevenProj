package sockets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketsClientHelper {

	private BufferedReader input;
	private PrintWriter output;
	private Socket socket;
	private int timeOut;
	private String responseServer;
	
	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public SocketsClientHelper(String host, int port, int timeOut) throws UnknownHostException, IOException {
		connect(host, port, timeOut);
	}

	public SocketsClientHelper(String host, int port) throws UnknownHostException, IOException {
		this.timeOut = 5000;

		connect(host, port, timeOut);
	}

	private void connect(String host, int port, int timeOut) {
		try {
			socket = new Socket(host, port);
			socket.setSoTimeout(timeOut);
		} catch (UnknownHostException e) {
			LOGGER.log(Level.WARNING, "Unknowed host: " + host);
			e.printStackTrace();
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, "I / O Error creating socket " + host + ":" + port);
			e.printStackTrace();
		}
	}

	public String makeCall(String text) throws IOException {
		InputStream inputStream = getInputStream();
		
		// Make connection and initialize streams
		input = new BufferedReader(new InputStreamReader(inputStream));
		output = new PrintWriter(socket.getOutputStream(), true);

		output.println(text);
		try {
			responseServer = input.readLine();
		} catch (SocketTimeoutException e) {
			LOGGER.log(Level.WARNING, "time is out");
		}

		System.out.println(responseServer);
		close();
		return responseServer;
	}

	private InputStream getInputStream() {
		InputStream inputStream = null;
		try {
			inputStream = socket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return inputStream;
	}

	private void close() {
		try {
			socket.close();
			System.out.println("Client closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}