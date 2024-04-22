package Part2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1024);

        System.out.println("Request sent successfully");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintStream printStream = new PrintStream(socket.getOutputStream());

        while(true){
            System.out.print("Server: ");

            String serverMessage = bufferedReader.readLine();

            System.out.println(serverMessage);

            System.out.print("Client: ");

            String clientMessage = reader.readLine();

            printStream.println(clientMessage);
            printStream.flush();
        }
    }
}
