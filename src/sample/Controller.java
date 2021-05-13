package sample;

import Server.Client;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;

public class Controller
{
    // Player turn variable
    public static boolean switchPlayer = true;

    // Default Images for the players
    private Image player1 = new Image(getClass().getResource("/Images/playerX.png").toExternalForm());
    private Image player2 = new Image(getClass().getResource("/Images/playerO.png").toExternalForm());
    // Use of Singleton to make one TicTacToe game and one to carry variables across controllers
    private TicTacToe game = TicTacToe.getInstance();
    private ControllerObserver controller = ControllerObserver.getInstance();
    //Initializes the client according to whether its local host or multiplayer
    Client player = new Client();
    @FXML
    private Player user;
    private MainObserver main_observer = new MainObserver();
    private AI ai = new AI(main_observer);
    // Variable that shows the players current score
    @FXML private Label player1win;
    @FXML private Label player2win;

    // Variable that keep track of wins history
    @FXML private TableView<String> gameHistory = new TableView<>();
    @FXML private TableColumn<String, String> History = new TableColumn<>();

    // Images IDs
    @FXML private ImageView image1;
    @FXML private ImageView image2;
    @FXML private ImageView image3;
    @FXML private ImageView image4;
    @FXML private ImageView image5;
    @FXML private ImageView image6;
    @FXML private ImageView image7;
    @FXML private ImageView image8;
    @FXML private ImageView image9;

    // Variable that checks if the slot is empty
    private boolean empty1 = true;
    private boolean empty2 = true;
    private boolean empty3 = true;
    private boolean empty4 = true;
    private boolean empty5 = true;
    private boolean empty6 = true;
    private boolean empty7 = true;
    private boolean empty8 = true;
    private boolean empty9 = true;


    @FXML void pressBtn1(MouseEvent event) {
        if (empty1) {
            game.checkBox(0, 0, switchPlayer);
            empty1 = printShape(event, image1);
            generalBtn();
        }
    }

    @FXML void pressBtn2(MouseEvent event) {
        if (empty2) {
            game.checkBox(0, 1, switchPlayer);
            empty2 = printShape(event, image2);
            generalBtn();
        }
    }

    @FXML void pressBtn3(MouseEvent event) {
        if (empty3) {
            game.checkBox(0, 2, switchPlayer);
            empty3 = printShape(event, image3);
            generalBtn();
        }
    }

    @FXML void pressBtn4(MouseEvent event) {
        if (empty4) {
            game.checkBox(1, 0, switchPlayer);
            empty4 = printShape(event, image4);
            generalBtn();
        }
    }

    @FXML void pressBtn5(MouseEvent event) {
        if (empty5) {
            game.checkBox(1, 1, switchPlayer);
            empty5 = printShape(event, image5);
            generalBtn();
        }
    }

    @FXML void pressBtn6(MouseEvent event) {
        if (empty6) {
            game.checkBox(1, 2, switchPlayer);
            empty6 = printShape(event, image6);
            generalBtn();
        }
    }

    @FXML void pressBtn7(MouseEvent event) {
        if (empty7) {
            game.checkBox(2, 0, switchPlayer);
            empty7 = printShape(event, image7);
            generalBtn();
        }
    }

    @FXML void pressBtn8(MouseEvent event) {
        if (empty8) {
            game.checkBox(2, 1, switchPlayer);
            empty8 = printShape(event, image8);
            generalBtn();
        }
    }

    @FXML void pressBtn9(MouseEvent event) {
        if (empty9) {
            game.checkBox(2, 2, switchPlayer);
            empty9 = printShape(event, image9);
            generalBtn();
        }
    }

    void generalBtn() {
        if (game.checkWin() != 0) {
            checkScore();
            game.clearBoard();
            clearGame();
        }
        game.printBoard();
        if (!switchPlayer)
            update();
    }
    // Switch the shape of player 1 based on radio selected in menu
    public void switchPlayer1() throws IOException
    {
        Stage playerShape = new Stage();
        playerShape.setTitle("Player Shape");
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/PlayerShapes1.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 550, 130);
        playerShape.setScene(scene);
        playerShape.show();

        playerShape.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                player1 = controller.getPlayerImage1();
            }
        });
    }

    public void switchPlayer2() throws IOException
    {
        Stage playerShape = new Stage();
        playerShape.setTitle("Player Shape");
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/PlayerShapes2.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 550, 130);
        playerShape.setScene(scene);
        playerShape.show();

        playerShape.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                player2 = controller.getPlayerImage2();
            }
        });
    }
    // Resize image of the player shape and place it on the rectangle
    public boolean printShape(MouseEvent event, ImageView image) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (switchPlayer) {
                image.setImage(player1);
                image.setFitHeight(image1.getFitWidth());
                image.setFitHeight(image1.getFitHeight());
                image.setPreserveRatio(false);
                switchPlayer = false;
            } else {
                image.setImage(player2);
                image.setFitHeight(image1.getFitWidth());
                image.setFitHeight(image1.getFitHeight());
                image.setPreserveRatio(false);
                switchPlayer = true;
            }
        }
        return false;
    }
    // Sets the all the images to clear the game board for new game.
    private void clearGame() {
        image1.setImage(null);
        empty1 = true;

        image2.setImage(null);
        empty2 = true;

        image3.setImage(null);
        empty3 = true;

        image4.setImage(null);
        empty4 = true;

        image5.setImage(null);
        empty5 = true;

        image6.setImage(null);
        empty6 = true;

        image7.setImage(null);
        empty7 = true;

        image8.setImage(null);
        empty8 = true;

        image9.setImage(null);
        empty9 = true;
    }
    // Updates current score between the players
    public void checkScore() {
        History.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));
        ObservableList<String> lanes;
        lanes = gameHistory.getItems();
        String screenText;
        String text;
        if (switchPlayer) {
            text = player2win.getText();
            player2win.setText(text + "X");
            screenText = "Player 2 Won";
        } else {
            text = player1win.getText();
            player1win.setText(text + "X");
            screenText = "Player 1 won";
        }
        lanes.add(screenText);
        gameHistory.setItems(lanes);

        Win win = new Win();
        win.winWindow(screenText);
    }

    @FXML public void newGameItemClicked() {
        game.clearBoard();
        clearGame();
    }

    public void CpuTurn(int i, int j) {
        int position = j + (i * 3);            //calculate which button cpu should press
        System.out.println("Position " + position);
        MouseEvent fakeEvent = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 0, true, true, true, true, true, true, true, true, true, true, null);

       /* switch (position) {
            case 0 -> pressBtn1(fakeEvent);
            case 1 -> pressBtn2(fakeEvent);
            case 2 -> pressBtn3(fakeEvent);
            case 3 -> pressBtn4(fakeEvent);
            case 4 -> pressBtn5(fakeEvent);
            case 5 -> pressBtn6(fakeEvent);
            case 6 -> pressBtn7(fakeEvent);
            case 7 -> pressBtn8(fakeEvent);
            case 8 -> pressBtn9(fakeEvent);
        } */
    }

    public void update() {
        int[] coordinates = ai.makeMove();
        CpuTurn(coordinates[0], coordinates[1]);
    }

    public void openHelpMenu(ActionEvent actionEvent) throws IOException { HelpMenu help = new HelpMenu(); }

    @FXML public void closeApp() { Platform.exit(); }

    public void chatWindow()
    {
        player.assignUserName("Player1");
        player.PlayerChat();
    }

    public void openLoginMenu(ActionEvent actionEvent) throws IOException
    {
        Stage playerShape = new Stage();
        playerShape.setTitle("Player Shape");
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/login.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 231, 115);
        playerShape.setScene(scene);
        playerShape.show();

        playerShape.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            @Override
            public void handle(WindowEvent windowEvent) {
            }
        });
    }
}