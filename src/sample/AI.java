package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class AI extends Observer
{
    private TicTacToe game = TicTacToe.getInstance();

    @FXML private ImageView image1;
    @FXML private ImageView image2;
    @FXML private ImageView image3;
    @FXML private ImageView image4;
    @FXML private ImageView image5;
    @FXML private ImageView image6;
    @FXML private ImageView image7;
    @FXML private ImageView image8;
    @FXML private ImageView image9;

    public AI(MainObserver mainObserver) { }

    public int[] makeMove()
    {
        return game.bestMove(game.getBoard());
    }

    @Override
    public void update()
    {
        makeMove();
    }

}