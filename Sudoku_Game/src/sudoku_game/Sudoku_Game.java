
package sudoku_game;
/**
* Sudoku, is a puzzle game where a partially filled(usually, the filled/unfilled ratio is around 0.28) 9X9 grid is filled
* using logical reasoning under certain constraints.
* Each solvable Sudoku has a unique solution.
*/

/**
* The constraints:
* Each row, column and 3X3 matrix must contain one and only one, mandatory instance of numbers from 1 to 9.
* No spaces can be left blank, and pre - filled entries cannot be altered.
*/


/**
*Code based in Recursion and Backtracking to program a Sudoku Solver
* Objective: Given a partially filled 2-D array, generate a solved Sudoku. If there does
*            not exist a solution, return the same.   
*/

/**
 * Algorithm followed:
Find row, column of an unassigned cell
  If there is none, return true
  For digits from 1 to 9
    a) If there is no conflict for digit at row, col
        assign digit to row, col and recursively try fill in rest of grid
    b) If recursion successful, return true
    c) Else, remove digit and try another
  If all digits have been tried and nothing worked, return false

*/
public class Sudoku_Game {
static int ctr=0;
    static int[][] board = new int[][] 
    { 
            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
    };
    
    
    /** This function is utilized by the function Solve().
     * Checks if a number in a position is valid or not depending on Sudoku Constraints.
    @param board the grid in which we are returning validity
    @param row the row, or horizontal coordinate of the position we are validating the number for.
    @param col the column, or vertical coordinate of the position we are validating the number for.
    @param num the number with which validation is taking place.
    */
    static boolean isValid(int[][] board, int row, int col, int num)
    {
       
    //Checks for row clash
      for(int i = 0; i < board.length; ++i)
        if(board[row][i] == num)  return false;
      
      //checks column clash
      for(int i = 0; i < board.length; ++i)
        if(board[i][col] == num)  return false;  
      
       int sqrtOfN = (int)(Math.sqrt(board.length));
       int rowStart = row - row % sqrtOfN;
       int colStart = col - col % sqrtOfN;
       //checks box clash
       for(int i = rowStart; i < rowStart + sqrtOfN; ++i)
       {
           for(int j = colStart; j < colStart + sqrtOfN; ++j)
               if(board[i][j] == num)   // Returns false if there is another occurence of num 
                   return false;       
       }
       
     //If compiler has reached here, there is no clash, so move is Valid through Constraints.
     return true;
    }
    /**
     * This function recursively solves the Sudoku. Comments have indicated the steps.
     * @param board
     * @param n
     */
    public static boolean Solve(int[][] board, int n)
    {
    
    int row = -1 , col = -1; //co-ordinates of unassigned cell. Changes every time function is called, obviously.
    boolean isEmptyCell = true;
    
    loop1: for(int i = 0; i < n; ++i)
           {
               for(int j = 0; j < n; ++j)
               {
                   if(board[i][j] == 0)
                   {
                    row = i;
                    col = j; //assigning row,col the empty cell co-ords
                   isEmptyCell = false; //Grid is not full.
                   break loop1;
                   }
               }    
               
           } 

    if(isEmptyCell) return true; //checks if grid is full
    //else, follow Algorithm{ a), b), c) }(See header comments)
            for(int num = 1; num <= n; num++)
            {
                if(isValid(board, row, col, num))
                {
                    board[row][col] = num; //assign valid value to empty cell
                    if(Solve(board,n))  //Recursive call of function to fill rest of grid.
                    {    
                        ctr++; //printSol(board);
                        return true; //A solution has been found recursively. End function and proceed to print the Solution.
                    }
                    else
                    {
                        board[row][col] = 0; // Replace it (Backtrack) { Step (c) of Algorithm } [ See header comments of file ].
                                             // Result of backtracking - The loop will then place a different number from 1-9 there and follow the process.
                    }    
                }    
            }    
    return false; //If compiler reaches here, there is no solution for given grid.
    }
    

    public static int[][] giveSol(int[][] board, int n){
    if(Solve(board,n))
    return board;
    else
    return null;
    }
    


    }
    

