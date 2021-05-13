package sample;

import Database.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.PageLayout;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class CreateAccount
{
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField firstname;
    @FXML private TextField lastname;

    private String user;
    private String pass;
    private String first;
    private String last;
    DatabaseManager database = DatabaseManager.getInstance();

    public void setUsername()
    {
        user = username.getText();
    }

    public void setPassword()
    {
        pass = password.getText();
    }

    public void setFirstName()
    {
        first = firstname.getText();
    }

    public void setLastName()
    {
        last = lastname.getText();
    }

    public void create_new_account(ActionEvent actionEvent) throws SQLException
    {
        setUsername();
        setPassword();
        setFirstName();
        setLastName();
        Player player = new Player(user,pass,first,last);
        System.out.println(player.getUsername());
        database.add_user(player);
    }
}
