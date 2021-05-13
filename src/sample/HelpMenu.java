package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelpMenu
{
    public HelpMenu() throws IOException
    {
        Stage HelpMenu = new Stage();
        HelpMenu.setTitle("Help Menu");
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/HelpMenu.fxml"));
        Scene scene = new Scene(root, 550, 550);
        HelpMenu.setScene(scene);
        HelpMenu.show();
    }
}