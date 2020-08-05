package MMT.TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Socket clientSocket = new Socket(InetAddress.getLocalHost().getHostName(), 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            String sentence = inFromUser.readLine();
            System.out.println("Sending request to server... ");
            outToServer.writeBytes(sentence + '\n');

            if (sentence.equalsIgnoreCase("exit")) {
                inFromUser.close();
                outToServer.close();
                clientSocket.close();
                break;
            }

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);

        }
    }
}
