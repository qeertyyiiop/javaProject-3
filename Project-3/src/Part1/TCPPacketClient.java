package Part1;

import java.io.*;
import java.net.Socket;

public class TCPPacketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",1024);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        int packetNoCounter = 1;

        while(true){
            System.out.print("Enter the data packet: ");
            String clientMessage = reader.readLine();
            Packet packet = new Packet(packetNoCounter,clientMessage);
            output.write(packet.getSerialNo()+"\n");
            output.flush();

            if(clientMessage.equalsIgnoreCase("CLOSE")){
                output.write("Connection reset");
                output.flush();
                break;
            }else {
                output.write(packet.getData() + "\n");
                output.flush();
                String serverMessage = input.readLine();
                System.out.println("FROM SERVER: " + serverMessage);
            }
        }
    }
}