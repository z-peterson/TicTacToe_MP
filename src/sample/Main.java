package sample;

import Database.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application
{
    @Override
    public void start(Stage splash) throws Exception
    {
        DatabaseManager database = DatabaseManager.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/splash.fxml"));
        splash.setScene(new Scene(root, 500, 450));
        splash.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
