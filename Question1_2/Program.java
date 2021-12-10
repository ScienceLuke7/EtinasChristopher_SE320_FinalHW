package Question1_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Program {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Server Started");
            Socket socket = serverSocket.accept();
            while(true) {
                Server server = new Server(socket);
                server.start();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        

    }

}
