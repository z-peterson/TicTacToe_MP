//package Session;
//
//import sample.TicTacToe;
//
//import javax.xml.crypto.Data;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//
//public class HandleASession implements Runnable{
//    private Socket player1;
//    private Socket player2;
//    private TicTacToe board;
//    private DataInputStream fromPlayer1;
//    private DataOutputStream toPlayer1;
//    private DataInputStream fromPlayer2;
//    private DataOutputStream toPlayer2;
//    private boolean continueToPlay;
//
//    public HandleASession(Socket player1, Socket player2) {
//        this.player1 = player1;
//        this.player2 = player2;
//    }
//
//    public void run() {
//        try {
//            DataInputStream fromPlayer1 = new DataInputStream(player1.getInputStream());
//            DataOutputStream toPlayer1 = new DataOutputStream(player1.getOutputStream());
//            DataInputStream fromPlayer2 = new DataInputStream(player2.getInputStream());
//            DataOutputStream toPlayer2 = new DataOutputStream(player2.getOutputStream());
//
//            // Send this to player1 so it knows to start
//            toPlayer1.writeInt(1);
//
//            // Continuously serve the players and determine and report the
//            // game status
//            while (true) {
//                // Receive a move from player1
//                int row = fromPlayer1.readInt();
//                int col = fromPlayer1.readInt();
//                // mark move made come back to here later
//
//                if(board.checkWin() == 10) {
//                    toPlayer1.writeInt(10);
//                    toPlayer2.writeInt(10);
//                    sendMove(toPlayer2, row, col);
//                    break;
//                }
//                else if(board.isFull()) {
//                    toPlayer1.writeInt(0);
//                    toPlayer2.writeInt(0);
//                    sendMove(toPlayer2, row, col);
//                    break;
//                }
//                else {
//                    toPlayer2.writeInt(1); // Signals player2 to continue
//                    sendMove(toPlayer2, row, col);
//                }
//
//                //Receive a move from player2
//                row = fromPlayer2.readInt();
//                col = fromPlayer2.readInt();
//                // mark move made come back to here later
//
//                // Check if player2 wins
//                if(board.checkWin() == -10) {
//                    toPlayer1.writeInt(-10);
//                    toPlayer2.writeInt(-10);
//                    sendMove(toPlayer1, row, col);
//                    break
//                }
//            }
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    private void sendMove(DataOutputStream out, int row, int col) throws IOException{
//        out.writeInt(row);
//        out.writeInt(col);
//    }
//
//
//}
