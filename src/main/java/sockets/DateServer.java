package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	/**
	 * Runs the server.
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(9090);

		try {
			while (true) {
				Socket socket = listener.accept();
				System.out.println("socket = listener.accept();");
				try {
					BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String fromClient = input.readLine();
					System.out.println("fromClient: " + fromClient);
					
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(fromClient + ": severe working good. ");
					System.out.println("Server PrintWriter");
				} finally {
					System.out.println("Server socket.close();");
					socket.close();
					
				}
			}
		} finally {
			System.out.println("Server listener.close();");
			listener.close();
		}
	}
}
