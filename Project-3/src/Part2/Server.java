package Part2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1024);

        System.out.println("Waiting for client request");

        Socket socket = serverSocket.accept();

        System.out.println("New client is pop up!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintStream printStream = new PrintStream(socket.getOutputStream());

        while(true){
            System.out.print("Server: ");

            String serverMessage = reader.readLine();

            printStream.println(serverMessage);
            printStream.flush();

            System.out.print("Client: ");

            String clientMessage = bufferedReader.readLine();

            System.out.println(clientMessage);
        }
    }
}
