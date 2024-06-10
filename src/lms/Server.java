package lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server starting...");
        try (ServerSocket serverSocket = new ServerSocket(2000)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                     ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                    System.out.println("Connection accepted");

                    // Reading username and password from the client
                    String username = (String) ois.readObject();
                    String password = (String) ois.readObject();

                    // Checking credentials
                    if ("admin".equals(username) && "202467".equals(password)) {
                        System.out.println("Admin logged in");
                        oos.writeObject(1); // Authentication successful
                    } else {
                        System.out.println("Invalid login attempt");
                        oos.writeObject(0); // Authentication failed
                    }
                } catch (Exception e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
