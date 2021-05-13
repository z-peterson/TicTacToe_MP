package sample;

import java.util.ArrayList;

public class Accounts
{
    private static Accounts instance = new Accounts();
    private ArrayList<Player> accounts = new ArrayList<>();

    private Accounts() {};

    public static Accounts getInstance()
    {
        return instance;
    }

    public void setAccounts(ArrayList<Player> list_accounts)
    {
        accounts = list_accounts;
    }
}
