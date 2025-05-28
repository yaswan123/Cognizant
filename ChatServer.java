import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for client...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        String msg;

        while ((msg = in.readLine()) != null) {
            System.out.println("Client: " + msg);
            System.out.print("Server: ");
            out.println(consoleInput.readLine());
        }

        clientSocket.close();
        serverSocket.close();
    }
}
