package Database;

import sample.Accounts;
import sample.Game;
import sample.Player;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager
{
    public static Connection connection;
    static DatabaseManager instance = null;
    private Player player = new Player();
    private Game game = new Game();
    Accounts accounts = Accounts.getInstance();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Game> games = new ArrayList<>();

    private DatabaseManager() {};

    static public DatabaseManager getInstance()
    {
        if(instance == null)
        {
            instance = new DatabaseManager();
            String url = "jdbc:sqlite:C:/SQLite/TicTacToe.db";
            try
            {
                connection = DriverManager.getConnection(url);
                instance.setUsers();
                instance.setGames();
                System.out.println("Connected");
            }
            catch (SQLException e)
            {
                System.out.println("Failed connection");
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void setUsers()
    {
        String sql = "SELECT * FROM players";
        try(Statement statement = connection.createStatement())
        {
            ResultSet result = statement.executeQuery(sql);
            while(result.next())
            {
                player.setUsername(result.getString("username"));
                player.setPassword(result.getString("password"));
                player.setFirstName(result.getString("firstname"));
                player.setLastName(result.getString("lastname"));
                player.setLosses(result.getInt("Loss"));
                player.setWins(result.getInt("Wins"));
                player.setTies(result.getInt("Ties"));
                players.add(player);
            }
            result.close();
            accounts.setAccounts(players);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public void add_user(Player player) throws SQLException
    {
        System.out.println(player.getUsername());
        String sql = "INSERT INTO players (username, password, firstname, lastname, Ties, Loss, Wins) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,player.getUsername());
        statement.setString(2,player.getLastName());
        statement.setString(3,player.getFirstName());
        statement.setString(4, player.getLastName());
        statement.setInt(5, player.getTies());
        statement.setInt(6, player.getLosses());
        statement.setInt(7, player.getWins());
        statement.executeUpdate();
    }

    public void setGames()
    {
        String sql = "SELECT * FROM games";
        try(Statement statement = connection.createStatement())
        {
            ResultSet result = statement.executeQuery(sql);
            while(result.next())
            {
                //game.setStart_time(result.getString("start_time"));
                //game.setEnd_time(result.getString("end_time"));
                game.setWho_created(result.getString("player_created"));
                game.setPlayer1(result.getString("player1"));
                game.setPlayer2(result.getString("player2"));
                //game.setGame_viewers(result.getInt("game_viewers"));
                //game.setMove_log(result.getInt("move_log"));
                game.setWinner(result.getString("gameID"));
                games.add(game);
            }
            result.close();
            accounts.setAccounts(players);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Game> getGames()
    {
        return games;
    }

    public void add_game(Game game) throws SQLException
    {
        String sql = "INSERT INTO games (start_time, end_time, player_created, player1, player2, game_viewers, move_log, winner, gameID) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setTime(1, game.getStart_time());
        statement.setTime(2, game.getEnd_time());
        statement.setString(3,game.getWho_created());
        statement.setString(4,game.getPlayer1());
        statement.setString(5,game.getPlayer2());
        statement.setInt(6,game.getGame_viewers());
        statement.setInt(7,game.getMove_log());
        statement.setString(8,game.getWinner());
        statement.setInt(9,game.getGameID());
        statement.executeUpdate();
    }
}
