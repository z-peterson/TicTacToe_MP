package sample;

import java.io.Serializable;
import java.sql.Time;

public class Game implements Serializable
{
    private Time start_time;
    private Time end_time;
    private String who_created;
    private String player1;
    private String player2;
    private String winner;
    private int game_viewers;
    private int move_log;
    private int gameID;


    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public String getWho_created() {
        return who_created;
    }

    public void setWho_created(String who_created) {
        this.who_created = who_created;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getGame_viewers() {
        return game_viewers;
    }

    public void setGame_viewers(int game_viewers) {
        this.game_viewers = game_viewers;
    }

    public int getMove_log() {
        return move_log;
    }

    public void setMove_log(int move_log) {
        this.move_log = move_log;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
}
