package Question1_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Server extends Thread {

    private Socket currentSocket;

    public Server(Socket socket) {
        this.currentSocket = socket;
    }

    public void run() {
        try {
            DataInputStream inStream = new DataInputStream(currentSocket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(currentSocket.getOutputStream());
            double bmi = 0;
            while(bmi != 0) {
                double weight = inStream.readDouble();
                double height = inStream.readDouble();
                System.out.println("Server received: " + weight + "kg, " + height + "meters");
                bmi = weight / (height * height);
                outStream.writeDouble(bmi);
                outStream.flush();
            }
            inStream.close();
            outStream.close();
            currentSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
