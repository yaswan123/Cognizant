import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String clientMsg, serverMsg;

            while (true) {
                if (in.ready()) {
                    clientMsg = in.readLine();
                    if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) break;
                    System.out.println("Client: " + clientMsg);
                }

                if (userInput.ready()) {
                    serverMsg = userInput.readLine();
                    out.println(serverMsg);
                    if (serverMsg.equalsIgnoreCase("bye")) break;
                }
            }

            clientSocket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
