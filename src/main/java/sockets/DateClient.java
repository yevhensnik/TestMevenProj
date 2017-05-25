package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class DateClient {
	/**
	 * Runs the client as an application. First it displays a dialog box asking
	 * for the IP address or hostname of a host running the date server, then
	 * connects to it and displays the date that it serves.
	 */
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("192.168.1.71", 9898);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.println("Hello from client!! ");
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String answer = input.readLine();
		System.out.println(answer);
		System.exit(0);
	}
}
