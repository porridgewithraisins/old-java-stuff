package connectfour;

import java.util.Scanner;

public class ConnectFour {
    
    static boolean whoseTurn = false; // false => Player1, true => Player2
    static int WINNER;
    
/*    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int column;
        
        do{
            printBoard();
            column = s.nextInt() - 1;
            if (!makeMove(column))
            {
                System.out.println("Column is full or invalid column number.");
                for (int c = 0; c < 7; c++)
                    if(makeMove(c))
                        break;
            }
            whoseTurn = !whoseTurn;
          } while(!gameOver());
        
        printBoard(); 
        WINNER = whoseTurn ? 1 : 2;
        System.out.println("Player " + WINNER + " has won!");
    }*/
    
    int gameOver(int[][] board){
        //Horizontal
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length - 3; col++)
            {
                if (board[row][col] != 0 && board[row][col] == board[row][col+1] &&
                    board[row][col] == board[row][col+2] && board[row][col] == board[row][col+3])
                {
                    return 1;
                }
            }
        }
        //Vertical
        
        for (int col = 0; col < board[0].length; col++)
        {
            for (int row = 0; row < board.length - 3; row++){
                if (board[row][col] != 0 && board[row][col] == board[row+1][col] &&
                    board[row][col] == board[row+2][col] && board[row][col] == board[row+3][col])
                {
                        return 1;
                }
            }
        }
        // First diagonal from top left
        for (int row = 0; row < board.length - 3; row++)
        {
            for (int col = 0; col < board[row].length - 3; col++){
                if (board[row][col] != 0 && board[row][col] == board[row+1][col+1]
                    && board[row][col] == board[row+2][col+2] && board[row][col] ==
                    board[row+3][col+3])
                {
                    return 1;
                }
            }
        }
        //Second diagonal from top right
        for (int row = 0; row < board.length - 3; row++)
        {
            for (int col = 3; col < board[row].length; col++){
                if (board[row][col] != 0 && board[row][col] == board[row+1][col-1]
                    && board[row][col] == board[row+2][col-2] && board[row][col] ==
                    board[row+3][col-3])
                {
                    return 1; // win
                }
            }
        }
        int r = 0;
        for (r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                if (board[r][c] == 0) break;
            }
        }
        if (r != board.length - 1) return 0; // game continues.
        return 2;// draw
    }
    
    boolean makeMove(int c,int[][] board){
        if (c > 7) return false;
        int player = whoseTurn ? 2 : 1;                                              // player number as the boolean flag indicates
        for (int r = board.length - 1; r >= 0 ; r--)
        {
            if(board[r][c] == 0)
            {
                board[r][c] = player;                                           // Finding the first unoccupied position in that column
                return true;                                                    // and placing the number of whosoever's turn it is.
            }
        }
        return false;    
    }



}
