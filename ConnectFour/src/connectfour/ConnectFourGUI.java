
package connectfour;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ConnectFourGUI extends JFrame implements ActionListener,MouseListener{
    public final int WIDTH = 6;
    public final int HEIGHT = 7;
    public int redCtr = 0, blueCtr = 0;
    public boolean whoseTurn = false;
    
    JFrame frame = new JFrame();
    JPanel ButtonPanel = new JPanel();
    JButton newGameBtn = new JButton("New Game");
    JLabel redScore = new JLabel();
    JLabel blueScore = new JLabel();
    
    
    Container grid = new Container();
    Container moveMakingPlace = new Container();
    boolean[][] board = new boolean[WIDTH][HEIGHT];
    JLabel[][] unplayable = new JLabel[WIDTH][HEIGHT];
    JButton[] moveActions = new JButton[WIDTH];     
    
    public ConnectFourGUI(){
        super ("ConnectFour");
        frame.setSize(900,900);
        frame.setLayout(new BorderLayout());
        frame.add(ButtonPanel, BorderLayout.SOUTH);
        newGameBtn.addActionListener(this);
        
        grid.setLayout(new GridLayout());
        moveMakingPlace.setLayout(new BorderLayout());
        
        for (int a = 0; a < WIDTH; a++)
        {
            moveActions[a] = new JButton();
            moveActions[a].setBackground(Color.black);
            
            moveMakingPlace.add(moveActions[a]);
            
        }
        for (int a = 1; a < WIDTH; a++)
        {
            for (int b = 0; b < HEIGHT; b++)
            {
                unplayable[a][b] = new JLabel("");
                unplayable[a][b].setBackground(Color.gray);
                grid.add(unplayable[a][b]);
            }
        }
        newGameBtn.setSize(10, 15);
        ButtonPanel.add(newGameBtn);
        frame.add(moveMakingPlace, BorderLayout.NORTH);
        frame.add(grid, BorderLayout.CENTER);
        
             frame.setLocationRelativeTo(null);      
     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);     //Setting basic things which make the frame visible and movable.
     frame.setVisible(true);
    
    }
    public static void main(String ar[]){
        new ConnectFourGUI();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
