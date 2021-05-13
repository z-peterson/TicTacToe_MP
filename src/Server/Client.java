package Server;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import sample.ControllerObserver;
import sample.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{
    final static int ServerPort = 12345;
    private ControllerObserver controller = ControllerObserver.getInstance();
    public InetAddress ip = controller.getIp();
    Player tmp = controller.getUser();
    public Socket socket;
    public DataInputStream in;
    public DataOutputStream out;
    public String user;
    final Chat chat = new Chat();

    public void assignUserName(String user) { this.user = user; }
    public String getUserName() { return this.user; }
    public void PlayerChat() {chat.chatWindow();}

    public Client()
    {
        chat.assignPlayer(this);

        try {
            socket = new Socket(ip, ServerPort);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread readMessage = new Thread(() -> {
                while (true) {
                    try {
                        String msg = in.readUTF();
                        chat.addMessage(msg);
                        System.out.println(msg);
                    } catch (IOException e) {
                        e.printStackTrace();

                        break;
                    }
                }
            });

            readMessage.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
