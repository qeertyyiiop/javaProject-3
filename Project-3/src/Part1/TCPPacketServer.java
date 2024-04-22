package Part1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPPacketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(1024);
        System.out.println("Opening port...");

        Socket client = socket.accept();
        System.out.println("Connection accepted!");

        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        try {
            if (client.isClosed()) {
                System.out.println("Client disconnected");
                input.close();
                output.close();
                client.close();
                System.out.println("Closing connections - DONE");
            }else {
                while (!client.isClosed()) {
                    String packetSerialNo = input.readLine();
                    String packetData = input.readLine();
                    if (packetSerialNo.equalsIgnoreCase("CLOSE")) {
                        break;
                    } else {
                        System.out.print("Receiving from Clients Packet's serialNo" + packetSerialNo);
                        System.out.print(" and packet's Data is " + packetData.toUpperCase());
                        System.out.println();

                        output.write("Packet serialNo" + packetSerialNo + " is received" + "\n");
                        output.flush();
                    }
                }
            }
        }catch (NullPointerException e){
            e.getMessage();
        }
    }
}