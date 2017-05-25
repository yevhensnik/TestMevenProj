package sockets;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {
	public static void main(String[] args) throws UnknownHostException, IOException {
		SocketsClientHelper socketsClientHelper = new SocketsClientHelper("localhost", 9898);
		socketsClientHelper.makeCall("Bla bla bla");
	}

}
