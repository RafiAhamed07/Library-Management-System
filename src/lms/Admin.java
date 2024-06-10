package lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Admin {
    public static void main(String[] args) {
        // Replace hard-coded IP and port with configurable options
        String serverAddress = "127.0.1.1";
        int serverPort = 2000;

        try (Socket socket = new Socket(serverAddress, serverPort);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the valid username and password to enter our Library Management System");

            System.out.print("Username: ");
            String username = scanner.nextLine();
            oos.writeObject(username);

            System.out.print("Password: ");
            String password = scanner.nextLine();
            oos.writeObject(password);

            int authResult = (int) ois.readObject();
            if (authResult == 1) {
                System.out.println("...............Welcome to Our Library Management System...............");
                System.out.println("If you want to log in, press Y");
                System.out.println("Else press R to register name and id");

                char choice = scanner.next().charAt(0);
                User user = new User();

                if (choice == 'Y' || choice == 'y') {
                    System.out.print("Enter Member name: ");
                    String name = scanner.next();
                    System.out.print("Enter Member id: ");
                    int id = scanner.nextInt();
                    user.Checkuser(name, id);
                } else if (choice == 'R' || choice == 'r') {
                    System.out.print("Enter total user number: ");
                    int numberOfUsers = scanner.nextInt();
                    user.adduser(numberOfUsers);

                } else {
                    System.out.println("Invalid option");
                }
            } else {
                System.out.println("Please enter a valid username and password");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}