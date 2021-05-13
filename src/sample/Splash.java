package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.InetAddress;

public class Splash
{
    @FXML
    public Button startButton;
    @FXML
    private Button mPlayerBtn;
    @FXML
    private Button lanBtn;

    private ControllerObserver controller = ControllerObserver.getInstance();

    @FXML
    public void pressBtn() throws IOException
    {
        controller.setIp(InetAddress.getByName("localhost"));
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/sample.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Tic Tac Toe");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            @Override
            public void handle(WindowEvent windowEvent) {
            }
        });
    }

    @FXML
    void pressMPlayerBtn() throws Exception
    {
        //this ip address should be the address of the server and should be changed as such
        controller.setIp(InetAddress.getByName("192.168.4.36"));
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/sample.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Tic Tac Toe");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            @Override
            public void handle(WindowEvent windowEvent) {
            }
        });
    }
    @FXML
    void pressLanBtn() throws Exception
    {
        controller.setIp(InetAddress.getByName("localhost"));
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/sample.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Tic Tac Toe");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            @Override
            public void handle(WindowEvent windowEvent) {
            }
        });
    }
}
