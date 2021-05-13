package sample;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ChangePlayerShape2
{
    private ControllerObserver controller = ControllerObserver.getInstance();

    public void Img1press(MouseEvent event) throws IOException
    {
        Image image = new Image(getClass().getResource("/Images/playerO.png").toExternalForm());
        controller.setPlayerImage2(image);
    }

    public void Img2press(MouseEvent event)
    {
        Image image = new Image(getClass().getResource("/Images/playerSquare.png").toExternalForm());
        controller.setPlayerImage2(image);
    }

    public void Img3press(MouseEvent event)
    {
        Image image = new Image(getClass().getResource("/Images/playerStar.png").toExternalForm());
        controller.setPlayerImage2(image);
    }

    public void Img4press(MouseEvent event)
    {
        Image image = new Image(getClass().getResource("/Images/playerTriangle.png").toExternalForm());
        controller.setPlayerImage2(image);
    }

    public void Img5press(MouseEvent event)
    {
        Image image = new Image(getClass().getResource("/Images/playerX.png").toExternalForm());
        controller.setPlayerImage2(image);
    }
}