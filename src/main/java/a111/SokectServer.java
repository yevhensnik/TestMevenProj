package a111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SokectServer {

    public static void main(String[] args) throws Exception {
        System.out.println("The capitalization server is running.");
        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(9898);
        try {
            while (true) {
                new Capitalizer(listener.accept(), clientNumber++).start();
            }
        } finally {
//            listener.close();
        }
    }

    private static class Capitalizer extends Thread {
        private Socket socket;
        private int clientNumber;

        public Capitalizer(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
            log("New connection with client# " + clientNumber + " at " + socket);
        }

        public void run() {
            try {

            	BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String fromClient = input.readLine();
				System.out.println("fromClient: " + fromClient);
				
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//				out.println("FROM SERVER: " + fromClient + ": severe working good. ");
				System.out.println("Server PrintWriter");
				
				
            } catch (IOException e) {
                log("Error handling client# " + clientNumber + ": " + e);
            } finally {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    log("Couldn't close a socket, what's going on?");
//                }
//                log("Connection with client# " + clientNumber + " closed");
            }
        }

        private void log(String message) {
            System.out.println(message);
        }
    }
}
