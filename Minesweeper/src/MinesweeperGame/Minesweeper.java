
package MinesweeperGame;


//Following is the implementation of Minesweeper.



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Minesweeper extends JFrame implements ActionListener, MouseListener{
    
    
    JFrame frame = new JFrame();                //Main window
    JButton reset = new JButton("Reset");       //Reset Button as a side. Functions as a new game trigger.
    JButton giveUp = new JButton("Give Up");    //Similarly, give up button. Functions as a show all cells and lost game trigger
    JPanel ButtonPanel = new JPanel();          //Panel for above two buttons
    Container grid = new Container();           //Container for grid
    int[][] counts;                             //integer array to store counts of each cell. Used as a back-end for comparisons.
    JButton[][] buttons;                        //Buttons array to use as a interface for the game.
    int size,diff;                              //contructor variables. size = no of rows/cols... diff = difficulty to be streamed from user.
    final int MINE = 10;                        //constant for determining whether a number in counts[][] is a mine or not.
    
    /**
    @param size determines the size of the board
    */
    
    // We have a frame with the generic border layout. Within it is a board with grid layout.
    public Minesweeper(int size){
     super("Minesweeper");                          //title of window
     
     this.size = size;   
     counts = new int[size][size];
     buttons = new JButton[size][size];  
                      
     frame.setSize(900,900);                        //sets size of window
     frame.setLayout(new BorderLayout());           //sets layout of window
     frame.add(ButtonPanel,BorderLayout.SOUTH);     //positions the button panel (New game, etc)
     reset.addActionListener(this);                 
     giveUp.addActionListener(this);                //adds actionListeners to both buttons.
             

     grid.setLayout(new GridLayout(size,size));     //sets grid layout to container(the board)
     for(int a = 0; a < buttons.length; a++)
     {
         for(int b = 0; b < buttons[0].length; b++) //buttons[0] to consider the case of rectangular board.
         {
             buttons[a][b] = new JButton();             //declares buttons in the array
             buttons[a][b].addActionListener(this);     //adds actionlisteners to them
             buttons[a][b].setBackground(Color.white);
             buttons[a][b].setForeground(Color.black);
             grid.add(buttons[a][b]);                   //adds button to container
         }
     }
     
     ButtonPanel.add(reset);                        
     ButtonPanel.add(giveUp);       // adding buttons to the panel.
     
     frame.add(grid,BorderLayout.CENTER);   //adding filled grid to container
     createMines(size);                     //calling function to start the game by filling mines.
     
     frame.setLocationRelativeTo(null);      
     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);     //Setting basic things which make the frame visible and movable.
     frame.setVisible(true);
     
    }
    /**
     * Function to check whether user has lost the game ( i.e clicked a mine).
     * @param m indicated whether the function has been called when user clicks a mine( m=1)
     * or when he clicks the give up button.(m = any other integer). There are much better ways to tell the function what has happened.
     * Shows a dialog box which tells the user that they have lost the game.
     */
    public void takeTheL(int m){
    
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                if(buttons[x][y].isEnabled())
                {
                    if(counts[x][y] != MINE)
                    {
                        buttons[x][y].setText(""+ counts[x][y]);
                        buttons[x][y].setEnabled(false);
                    }

                    else
                    {
                        buttons[x][y].setEnabled(false);
                        buttons[x][y].setIcon(new ImageIcon("C:\\Users\\Bhaskar\\Desktop\\images.jpeg"));
                    }
                }
            }
        }
    JOptionPane.showMessageDialog(null, m==1? "You clicked a mine!":"You Gave Up",
                                 "Game Over", JOptionPane.ERROR_MESSAGE);
    } 
    /**
     * Function to check whether user has won or not
     * It performs this by checking whether a cell that is NOT a mine
     * remains to be clicked by the user.
     * (Works because, when a user clicks a mine,a line is written to disable corresponding button).
     * Function prints a pop-up message congratulating user on victory.
     */
    
    public void takeTheW() {
       boolean won = true;
       for(int i = 0; i < size; i++)
       {
           for(int j = 0; j < size; j++)
           {
               if(counts[i][j] != MINE && buttons[i][j].isEnabled())
               {
                   won = false;
               }
           }
       }
       if(won) 
       {
            JOptionPane.showMessageDialog(null,"You have won!", "Congratulations!",
                                          JOptionPane.INFORMATION_MESSAGE);
            for (int x = 0; x < size; x++)
            {
                for (int y = 0; y < size; y++)
                {
                    if(buttons[x][y].isEnabled())
                        buttons[x][y].setIcon(new ImageIcon("C:\\Users\\Bhaskar\\Desktop\\images.jpeg"));
                }
            }
       }   
    }
    
    /**
     * Method which listens, and acts upon the user's actions on the buttons.
     * Function retrieves the event source(i.e the button that was clicked).
     * Then it calls appropriate functions.
     * @param ae variable name of action event
     */
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == reset)              //resets grid
        {
            for(int x = 0; x < size; x++)
            {
                for(int y = 0; y < size; y++)
                {
                    buttons[x][y].setEnabled(true);
                    buttons[x][y].setBackground(Color.white);
                    buttons[x][y].setText("");
                    buttons[x][y].setIcon(new ImageIcon());
                }
            }
            createMines(30);  //triggers a new game.
        }
        
        else if(ae.getSource() == giveUp)  //user has given up. trigger takeTheL( m!= 1).
        {
                   takeTheL(0);
        }
        
        else // click was on a cell
        {
                for(int x = 0; x < size; x++)
                {
                    for( int y = 0; y < size; y++)
                    {
                        if(ae.getSource() == buttons[x][y])
                        {
                            switch (counts[x][y]) {
                                case MINE:
                                    takeTheL(1);                                    //user clicked on a mine
                                    break;
                                case 0:
                                    buttons[x][y].setText(counts[x][y] +"");
                                    buttons[x][y].setEnabled(false);
                                    buttons[x][y].setBackground(Color.green);
                                    ArrayList<Integer> clear = new ArrayList<>();    //If count = 0, domino effect is called,( refer pre-function comments)
                                    clear.add(x*100+y);
                                    dominoEffect(clear);
                                    takeTheW(); //checks win every move
                                    break;
                                default:
                                    buttons[x][y].setText(""+counts[x][y]);
                                    buttons[x][y].setEnabled(false);
                                    buttons[x][y].setBackground(Color.green);
                                    takeTheW();                                          // its a number > 0 and not a mine, so just check for win
                                    break;
                            }
                        }    
                    }
                }
        }
        
        
    }
    /**
     * Function creates mines at random positions. Constant mine is 
     * declared at top of file.
     * @param s the size of the board(row or column count)
     */
    
    public void createMines(int s){
    ArrayList<Integer> list = new ArrayList<>();  //Modifiable array to store pos. of mines.
        for(int x = 0; x < s; x++)
        {
            for(int y = 0; y < s; y++)
            {
                list.add(x*100+y);                       // x & y shall be individually retrieved by dividing by 100 and then modulo 100 respectively.
                                                        // Stupid way to do it but it was how i thought first. We'll make it better
                                                         // refer to lines 284 and 285 for implementation
            }
        }
        counts = new int[s][s];                    //resetting back-end array
        
        for(int a = 0; a < (int)(s * 1.5); a++)
        {
            int choice = (int)(Math.random() * list.size());
            counts [list.get(choice) / 100] [list.get(choice) % 100] = MINE;      //Using corollary of before-last comment to set mines as well.
            list.remove(choice);                                                // We don't want two mines in the same pos., so remove that pos. from list.
        }
        /*
        Following segment initializes 'neighbor counts' for each cell. That is, the number of 
        mines that are present in the eight surrounding cells. IF the cell isn't a mine.
        Note : It is done in the back-end array as that contains the numbers (MINE or 1 or 2 or 3 or 4 or 5 or 6 or 7 or 8)
        */
        for(int x = 0; x < s; x++)
        {
           for(int y = 0; y < s; y++)
           {
            if(counts[x][y] != MINE)
            {
                int neighbor = 0;
                if( x > 0 && y > 0 && counts[x-1][y-1] == MINE) //top left
                {
                    neighbor++;
                }
                if( y > 0 && counts[x][y-1] == MINE) //left
                {
                    neighbor++;
                }
                if( y < size - 1 && counts[x][y+1] == MINE) //right
                {
                    neighbor++;
                }
                if( x < size - 1 && y > 0 && counts[x+1][y-1] == MINE) //bottom left
                {
                    neighbor++;
                }
                if( x > 0 && counts[x-1][y] == MINE) //up
                {
                    neighbor++;
                }
                if( x < size - 1 && counts[x+1][y] == MINE)//down
                {
                    neighbor++;
                }
                if( x > 0 && y < size - 1 &&counts[x-1][y+1] == MINE) //top right
                {
                    neighbor++;
                }
                if( x < size - 1 && y < size - 1 && counts[x+1][y+1] == MINE) //bottom right
                {
                    neighbor++;
                }
                counts[x][y] = neighbor;                        //setting value
            }
           }
        }
    }
    

    /**
     * This function, called the domino effect, is an implementation of the idea that,
     * when a cell with no surrounding mines is clicked, there's no point in user clicking
     * all eight surrounding cells, and those eight surrounding cells. Therefore, all surrounding
     * cells' counts will be displayed in corresponding cells. 
     * The above is done recursively.
     * @param toClear the ArrayList which is passed to the function with positions in array
     *                that are zero, and are subsequently clicked.
     * I'll explain this easy only. Ill call once you have this
     * Arrays have definite pre-defined size and cannot have variable length.
     * Array Lists on the other hand, which we use here can be edited and be of variable length
     * So we are using it here.
     */
    
    public void dominoEffect(ArrayList<Integer> toClear){
        if(toClear.isEmpty())
            return;                         //base case
        
        int x = toClear.get(0) / 100;       //getting x pos.
        int y = toClear.get(0) % 100;       //getting y pos.
        toClear.remove(0);                  //remove that element from array to prevent infinite recursion.    
            if(counts[x][y] == 0)
            {                               //similar to neighbor counts, each surrounding cell is filled   
                                            
                if( x > 0 && y > 0 && buttons[x-1][y-1].isEnabled()) //top left
                {
                    buttons[x-1][y-1].setText(counts[x-1][y-1] + "");
                    buttons[x-1][y-1].setEnabled(false);
                    buttons[x-1][y-1].setBackground(Color.green);
                    if(counts[x-1][y-1] == 0)
                    {
                        toClear.add((x-1)*100 + (y-1));     //to recursively implement, each surrounding cell is the new cell,
                                                            // the surrounding cells of which we shall check and so on.
                    }
                }
                if( y > 0 && buttons[x][y-1].isEnabled()) //left
                {
                    buttons[x][y-1].setText(counts[x][y-1] + "");
                    buttons[x][y-1].setEnabled(false);
                    buttons[x][y-1].setBackground(Color.green);
                    if(counts[x][y-1] == 0)
                    {
                        toClear.add(x*100 + (y-1));
                    }
                    
                }
                if( y < size - 1 && buttons[x][y+1].isEnabled()) //right
                {
                    buttons[x][y+1].setText(counts[x][y+1] + "");
                    buttons[x][y+1].setEnabled(false);
                    buttons[x][y+1].setBackground(Color.green);
                    if(counts[x][y+1] == 0)
                    {
                        toClear.add(x*100 + (y+1));
                    }
                    
                }
                if( x < size - 1 && y > 0 && buttons[x+1][y-1].isEnabled()) //bottom left
                {
                    buttons[x+1][y-1].setText(counts[x+1][y-1] + "");
                    buttons[x+1][y-1].setEnabled(false);
                    buttons[x+1][y-1].setBackground(Color.green);
                    if(counts[x+1][y-1] == 0)
                    {
                        toClear.add((x+1)*100 + (y-1));
                    }
                    
                }
                if( x > 0 && buttons[x-1][y].isEnabled()) //up
                {
                    buttons[x-1][y].setText(counts[x-1][y] + "");
                    buttons[x-1][y].setEnabled(false);
                    buttons[x-1][y].setBackground(Color.green);
                    if(counts[x-1][y] == 0)
                    {
                        toClear.add((x-1)*100 + y);
                    }
                    
                }
                if( x < size - 1 && buttons[x+1][y].isEnabled())//down
                {
                    buttons[x+1][y].setText(counts[x+1][y] + "");
                    buttons[x+1][y].setEnabled(false);
                    buttons[x+1][y].setBackground(Color.green);
                    if(counts[x+1][y] == 0)
                    {
                        toClear.add((x+1)*100 + y);
                    }
                   
                }
                if( x > 0 && y < size - 1 && buttons[x-1][y+1].isEnabled()) //top right
                {
                    buttons[x-1][y+1].setText(counts[x-1][y+1] + "");
                    buttons[x-1][y+1].setEnabled(false);
                    buttons[x-1][y+1].setBackground(Color.green);
                    if(counts[x-1][y+1] == 0)
                    {
                        toClear.add((x-1)*100 + (y+1));
                    }
                    
                }
                if( x < size - 1 && y < size - 1 && buttons[x+1][y+1].isEnabled()) //bottom right
                {
                    buttons[x+1][y+1].setText(counts[x+1][y+1] + "");
                    buttons[x+1][y+1].setEnabled(false);
                    buttons[x+1][y+1].setBackground(Color.green);
                    if(counts[x+1][y+1] == 0)
                    {
                        toClear.add((x+1)*100 + (y+1));
                    }
                    
                }
            }
            dominoEffect(toClear);      //recursive call with list containing surrounding cells, for further check-and-clear of THEIR surr. cells.
    }
    
    //Main method.
    public static void main(String[] args){
        new Minesweeper(20);    
   
    
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (SwingUtilities.isRightMouseButton(me)){
            for (int x = 0; x < size; x++)
            {
                for (int y = 0; y < size; y++)
                {
                    if (me.getComponent().equals(buttons[x][y]) && buttons[x][y].isEnabled())
                        buttons[x][y].setBackground(Color.yellow);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
     // Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent me) {
     // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent me) {
       // Do nothing
    }

}
