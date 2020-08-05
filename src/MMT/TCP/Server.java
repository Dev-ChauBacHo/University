package MMT.TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] argv) throws Exception {
        String clientSentence = "";
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            System.out.println("Waiting for Client...");
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            System.out.println("Receiving request...");
            clientSentence = inFromClient.readLine();
            System.out.println("Received: " + clientSentence);
            if (clientSentence.equalsIgnoreCase("exit")) break;

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);

            inFromClient.close();
            outToClient.close();
            connectionSocket.close();
        }
        welcomeSocket.close();
    }
}
