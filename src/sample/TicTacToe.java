package sample;

public class TicTacToe
{
    private static TicTacToe instance = new TicTacToe();

    public static TicTacToe getInstance()
    {
        return instance;
    }

    private TicTacToe(){}

    private final int[][] board = {{0,0,0},
            {0,0,0},
            {0,0,0}};

    public void clearBoard()
    {
        for(int i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 3; ++j)
            {
                board[i][j] = 0;
            }
        }
    }

    //Checks who won and returns int on which player won
    //If player1 returns: 1
    //If player2 returns: -1
    //If neither returns: 0
    public int checkWin()
    {
        if((board[0][0] == 1 && board[0][1] == 1 && board[0][2] ==1) ||
                (board[1][0] == 1 && board[1][1] == 1 && board[1][2] ==1) ||
                (board[2][0] == 1 && board[2][1] == 1 && board[2][2] ==1) ||
                (board[0][0] == 1 && board[1][0] == 1 && board[2][0] ==1) ||
                (board[0][1] == 1 && board[1][1] == 1 && board[2][1] ==1) ||
                (board[0][2] == 1 && board[1][2] == 1 && board[2][2] ==1) ||
                (board[0][0] == 1 && board[1][1] == 1 && board[2][2] ==1) ||
                (board[0][2] == 1 && board[1][1] == 1 && board[2][0] ==1))
        {
//            clearBoard();
            return 10;
        }
        else if((board[0][0] == -1 && board[0][1] == -1 && board[0][2] ==-1) ||
                (board[1][0] == -1 && board[1][1] == -1 && board[1][2] ==-1) ||
                (board[2][0] == -1 && board[2][1] == -1 && board[2][2] ==-1) ||
                (board[0][0] == -1 && board[1][0] == -1 && board[2][0] ==-1) ||
                (board[0][1] == -1 && board[1][1] == -1 && board[2][1] ==-1) ||
                (board[0][2] == -1 && board[1][2] == -1 && board[2][2] ==-1) ||
                (board[0][0] == -1 && board[1][1] == -1 && board[2][2] ==-1) ||
                (board[0][2] == -1 && board[1][1] == -1 && board[2][0] ==-1))
        {
            return -10;
        }
        else
            return 0;
    }

    public void printBoard()
    {
        for(int[] row : board)
        {
            for(int x : row)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public void checkBox(int i, int j, boolean player)
    {
        if(player)
        {
            board[i][j] = 1;
        }
        if(!player)
        {
            board[i][j] = -1;
        }
    }

    //Checks if there are any empty spots left on board
    public boolean isFull() {
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public int[] bestMove(int[][] board) {
        int bestScore = 1000;
        int[] move = new int[2];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = -1;
                    int score = minimax(board, 0, true);
                    board[i][j] = 0;
                    if(score < bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        System.out.println("Row: " + move[0] + " Column: " + move[1]);
        return move;
    }

    //Minimax algorithm will explain in depth.
    //Assumption is that cpu is going first, for now
    public int minimax(int[][] board, int depth, boolean maximizing) {
        //Base case: if game is finished
        if(checkWin() == 10)
            return checkWin()-depth;


        if(checkWin() == -10)
            return checkWin()+depth;

        if(isFull()) {
            return 0;
        }

        if(maximizing) {
            int bestScore = -1000;    //start with smallest int value possible to compare
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    //Check to see if spot is empty
                    if(board[i][j] == 0) {
                        board[i][j] = 1;
                        int score = minimax(board, depth+1, false);     //maximizing boolean becomes false because it's other players turn now
                        board[i][j] = 0;                                                //returns board to original state

                        if(score > bestScore)
                            bestScore = score;
                    }
                }
            }
            //System.out.println("maximizing");
            return bestScore+depth;
        } else {
            int bestScore = 1000;    //start with smallest int value possible to compare
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    //Check to see if spot is empty
                    if(board[i][j] == 0) {
                        board[i][j] = -1;
                        int score = minimax(board, depth+1, true);     //maximizing boolean becomes false because it's other players turn now
                        board[i][j] = 0;                                                //returns board to original state

                        if(score < bestScore)
                            bestScore = score;
                    }
                }
            }
            //System.out.println("minimizing");
            return bestScore-depth;
        }
    }

    public int[][] getBoard()
    {
        return board;
    }

}