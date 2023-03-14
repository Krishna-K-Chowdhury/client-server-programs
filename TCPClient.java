import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class TCPClient {
    public static void main(String[] args) throws Exception {
        String sentence;
        String modifiedSentence;

        BufferedReader inFormUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("127.0.0.1", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Enter your message: ");
        sentence = inFormUser.readLine();

        while (!(sentence.equals(""))){
            outToServer.writeBytes(sentence+"\n");
            modifiedSentence = inFromServer.readLine();
            System.out.println(modifiedSentence);
            System.out.println("Enter your message: ");
            sentence = inFormUser.readLine();
        }

        clientSocket.close();
    }
}