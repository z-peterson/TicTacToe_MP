package sample;

import java.io.Serializable;

public class Player implements Serializable
{
    String username;
    String password;
    String firstName;
    String lastName;
    int wins;
    int losses;
    int ties;

    public Player(){}

    public Player(String username, String password, String firstName, String lastName, int wins, int losses, int ties) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public Player(String name, String pass, String first, String last)
    {
        username = name;
        password = pass;
        firstName = first;
        lastName = last;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
