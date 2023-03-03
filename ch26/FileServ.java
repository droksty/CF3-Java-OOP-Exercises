package gr.aueb.cf.testbed.ch26;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileServ extends Thread {
    ServerSocket serverSocket;
    final int SERVER_PORT = 139;
    final String SERVER_ADDRESS = "127.0.0.1";
    String filePath = "C:\\tmp\\";

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT), 5);
            System.out.println("File Server is listening..");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected..");

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String inputFilename = input.readLine();
                System.out.println("Client requests file: " + inputFilename);
                File targetFile = new File(filePath + inputFilename);
                if (targetFile.exists()) {
                    output.println("File found. Downloading..");
                    Scanner in = new Scanner(targetFile);
                    while (in.hasNextLine()) {
                        output.println(in.nextLine());
                    }
                } else {
                    output.println("File not found. Please input a valid file name.");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileServ fs = new FileServ();
        fs.start();
    }
}
