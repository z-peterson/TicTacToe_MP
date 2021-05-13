package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static ArrayList<ClientHandler> playerList= new ArrayList<>();

    // counter for clients
    static int counter = 0;

    public static void main(String[] args) throws IOException
    {
        // server is listening on port 1234

        ServerSocket server = new ServerSocket(12345);
        Socket socket;

        // running infinite loop for getting client request
        while (true)
        {
            // Accept the incoming request
            socket = server.accept();

            System.out.println("New client request received : " + socket);

            // obtain input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Creating a new handler for this client...");

            // Create a new handler object for handling this request.
            ClientHandler match = new ClientHandler(socket,"client " + counter, in, out);

            // Create a new Thread with this object.
            Thread t = new Thread(match);

            System.out.println("Adding this client to active client list");

            // add this client to active clients list
            playerList.add(match);

            // start the thread.
            t.start();

            // increment i for new client.
            counter++;
        }
    }
}
