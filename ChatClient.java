import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        String msg;

        while (true) {
            System.out.print("Client: ");
            out.println(consoleInput.readLine());
            msg = in.readLine();
            System.out.println("Server: " + msg);
        }
    }
}
