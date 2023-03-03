package gr.aueb.cf.testbed.ch26;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        final int SERVER_PORT = 139;
        final String SERVER_ADDRESS = "127.0.0.1";

        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            BufferedReader input = new BufferedReader((new InputStreamReader(socket.getInputStream())));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner in = new Scanner(System.in);
            System.out.println("Please input a valid filename.txt to download: ");
            String fileName = in.nextLine();
            in.close();
            output.println(fileName);
            output.flush();

            String filePackage = null;
            while ((filePackage = input.readLine()) != null) {
                System.out.println(filePackage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
