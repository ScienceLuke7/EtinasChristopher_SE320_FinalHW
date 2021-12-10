package Question1_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Random;

public class Client {
    final static int MAX_WEIGHT_KG = 100;
    final static int MAX_HEIGHT_M = 3;
    
    
    public static void main(String[] args) {
        double bmi = 0;
        Random random = new Random();
        double weight = random.nextDouble() * MAX_WEIGHT_KG;
        double height = random.nextDouble() * MAX_HEIGHT_M;

        try {
            Socket socket = new Socket("127.0.0.1", 6000);
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            while(bmi != 0){
                outStream.writeDouble(weight);
                outStream.writeDouble(height);
                outStream.flush();
                bmi = inStream.readDouble();
                System.out.println("BMI is: " + bmi);
            }
            outStream.close();
            outStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}