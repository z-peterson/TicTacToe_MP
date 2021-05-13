package sample;

import javafx.scene.image.Image;

import java.net.InetAddress;

public class ControllerObserver
{

    private Image playerImage1;//= new Image("Pics/player0.png");
    private Image playerImage2; //= new Image("Pics/playerX.png");
    private InetAddress ip = null;
    private Player player;

    private static ControllerObserver instance = new ControllerObserver();

    private ControllerObserver() {}

    public static ControllerObserver getInstance()
    {
        return instance;
    }

    public Image getPlayerImage1()
    {
        return playerImage1;
    }

    public Image getPlayerImage2()
    {
        return playerImage2;
    }

    public InetAddress getIp(){return ip;}

    public Player getUser(){return player;}

    public void setPlayerImage1(Image image)
    {
       playerImage1 = image;
    }

    public void setPlayerImage2(Image image) { playerImage2 = image; }

    public void setIp(InetAddress ipaddress) {ip = ipaddress; }

    public void setPlayer(Player user) {player = user;}
}