/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku_game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
/**
 *
 * @author Director
 */
public class GUIforSudoku extends JFrame
{
        static int[][] boardx = new int[][] 
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
    //MAKE TWO MORE BOARDS AND CHOOSE BY USING UTIL.RANDOM
    
    Sudoku_Game p = new Sudoku_Game();
   final int rows=9,columns = 9;
   
       JButton startGame = new JButton("Start Game");;
    JButton giveUp = new JButton("Give Up"); 
    JButton reset = new JButton("Reset Grid");
    JButton Finish = new JButton("Check");
    
    
   
    public GUIforSudoku(){
        
        super("Sudoku");
        

      
        final JPanel grid = new JPanel(new GridLayout(rows,columns));
        setSize(550,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(grid);
        setLocationRelativeTo(null);
        
        javax.swing.border.Border outerBorder = BorderFactory.createLineBorder(Color.black,3);
        javax.swing.border.Border innerBorder = BorderFactory.createLineBorder(Color.BLUE,1);
        javax.swing.border.Border rowBorder = BorderFactory.createMatteBorder(1,1,4,1,Color.BLUE);
        javax.swing.border.Border colBorder = BorderFactory.createMatteBorder(1,1,1,4,Color.BLUE);
        
        final JTextField[][] cells = new JTextField[rows][columns];
        grid.setBorder(outerBorder);
        for(int r = 0; r < rows; ++r)
        {
            for(int c = 0; c < columns; ++c)
            {
               cells[r][c] = new JTextField("");
               cells[r][c].setHorizontalAlignment(JTextField.CENTER);
                cells[r][c].setBorder(innerBorder);
                if(r%3 == 2)
                {
                    cells[r][c].setBorder(rowBorder);
                }
                if(c%3 == 2)
                {
                    if(r %3== 2 && c%3 == 2)
                    {
                        cells[r][c].setBorder(BorderFactory.createMatteBorder(1,1,4,4,Color.BLUE));
                    }
                    else
                    {
                        cells[r][c].setBorder(colBorder);
                    }
                }
                cells[r][c].setBackground(Color.WHITE);
                grid.add(cells[r][c]);

            }
        }
        setVisible(true);
         
                startGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               for(int r=0 ;r<rows;++r)
               {
                   for(int c=0;c<columns;++c)
                   {
                       if(boardx[r][c] != 0)
                            cells[r][c].setText( boardx[r][c]+"");
                       else
                            cells[r][c].setText("");
                   }   
               }

            }
            
        });
                
             giveUp.addActionListener(new ActionListener()
            {
             @Override
            public void actionPerformed(ActionEvent ae)
            {
                int[][] solution =  p.giveSol(p.board,p.board.length);
                JOptionPane.showMessageDialog(null,"Here is the Solved Board", "You gave up", JOptionPane.INFORMATION_MESSAGE);
                if(p.Solve(p.board,p.board.length))
                {
                  
                    for(int r=0;r<rows;r++)
                    {
                        for(int c=0;c<columns;++c)
                        {
                          cells[r][c].setText(solution[r][c]+"");  
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"This board is unsolvable","Oops!",JOptionPane.ERROR_MESSAGE);
                }
            }
 
            }); 
             
             reset.addActionListener(new ActionListener()
             {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                for(int r=0;r<rows;++r)
                {
                    for(int c=0;c< columns;++c)
                    {
                       if(boardx[r][c] != 0)
                            cells[r][c].setText( boardx[r][c]+"");
                       else
                            cells[r][c].setText("");
                    }
                }

            }
             
             });
             
             Finish.addActionListener(new ActionListener()
            {
                int[][] solution =  p.giveSol(p.board,p.board.length);
            @Override
                public void actionPerformed(ActionEvent ae)
                {
                    int ctr=0;
                     for(int r=0;r<rows;++r)
                    {
                        for(int c = 0; c < columns; ++c)
                        {
                            if(Integer.parseInt(cells[r][c].getText()) == solution[r][c])
                            {
                              ctr++;                                  
                            }
                        }
                    }
                    
                     if(ctr==81)
                     {
                         JOptionPane.showMessageDialog(null,"Congrats! You have solved the puzzle", "Success!", JOptionPane.INFORMATION_MESSAGE);
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(null,"Wrong! Please check your grid", "Oops!", JOptionPane.ERROR_MESSAGE);
                     }
                }
             
            });
        
                final JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        ButtonPanel.setLayout(new BorderLayout());
        ButtonPanel.add(startGame);
        ButtonPanel.add(giveUp);
        ButtonPanel.add(reset);
        ButtonPanel.add(Finish);
         
        LineBorder LineBorder = new LineBorder(Color.lightGray);
        ButtonPanel.setBorder(LineBorder);
        BoxLayout horizontal = new BoxLayout(ButtonPanel, BoxLayout.X_AXIS);
        ButtonPanel.setLayout(horizontal);
        FlowLayout flow = new FlowLayout();
        ButtonPanel.setLayout(flow);
        add(ButtonPanel, BorderLayout.SOUTH);
        

    }
    

public static void main(String[] args){
GUIforSudoku Sudoku = new GUIforSudoku();


}
}
