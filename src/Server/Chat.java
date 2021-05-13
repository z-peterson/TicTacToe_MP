package Server;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import sample.Controller;
import sample.ControllerObserver;
import sample.Player;

import java.io.IOException;


public class Chat {
    @FXML public TextArea messages;
    @FXML public TextField input;
    public static Client player;
    public static Chat controller;
    private ControllerObserver controller2 = ControllerObserver.getInstance();

    public void assignPlayer(Client player) {
        Chat.player = player;
    }

    public void chatWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/Chat.fxml"));
            Parent root = loader.load();
            controller = loader.getController();

            Stage chatWindow = new Stage();
            chatWindow.setTitle("Chat");
            chatWindow.setScene(new Scene(root));
            chatWindow.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void addMessage(String msg) {
        controller.messages.setText(controller.messages.getText() + msg + "\n");
    }

    @FXML
    public void send()
    {
        Player tmp = controller2.getUser();
        String name;
        if(tmp!=null)
            name = tmp.getUsername();
        else
            name = "Anonymous";
        player.sendMessage(name + " : " + input.getText());
        input.setText("");
    }
}
