package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

public class ClientHandler implements Runnable{
    private String name;
    final DataInputStream in;
    final DataOutputStream out;
    Socket socket;
    boolean logIn;

    public ClientHandler(Socket s, String name, DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
        this.name = name;
        this.socket = s;
        this.logIn=true;
    }

    public void run() {
        String received;
        while (true)
        {
            try
            {
                received = in.readUTF();
                System.out.println("Received" + received);
                if(received.equals("logout")){
                    this.logIn=false;
                    this.socket.close();
                    break;
                }
                /*
                StringTokenizer st = new StringTokenizer(received, "#");
                String recipient = st.nextToken();
                String MsgToSend = st.nextToken();
                name=recipient;
                 */

                for (ClientHandler mc : Server.playerList) {
                    mc.out.writeUTF(received);
                }

            } catch (IOException e) {

                e.printStackTrace();
            }

        }
        try
        {
            // closing resources
            this.in.close();
            this.out.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
