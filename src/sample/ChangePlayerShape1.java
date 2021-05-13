package sample;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class ChangePlayerShape1 {
    private ControllerObserver controller = ControllerObserver.getInstance();

    public ChangePlayerShape1() {
    }

    public void Img1press(MouseEvent event) throws IOException {
        Image image = new Image(this.getClass().getResource("/Images/playerO.png").toExternalForm());
        this.controller.setPlayerImage1(image);
    }

    public void Img2press(MouseEvent event) {
        Image image = new Image(this.getClass().getResource("/Images/playerSquare.png").toExternalForm());
        this.controller.setPlayerImage1(image);
    }

    public void Img3press(MouseEvent event) {
        Image image = new Image(this.getClass().getResource("/Images/playerStar.png").toExternalForm());
        this.controller.setPlayerImage1(image);
    }

    public void Img4press(MouseEvent event) {
        Image image = new Image(this.getClass().getResource("/Images/playerTriangle.png").toExternalForm());
        this.controller.setPlayerImage1(image);
    }

    public void Img5press(MouseEvent event) {
        Image image = new Image(this.getClass().getResource("/Images/playerX.png").toExternalForm());
        this.controller.setPlayerImage1(image);
    }
}