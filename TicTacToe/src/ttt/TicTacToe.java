/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

import java.awt.Color;
import javax.swing.JOptionPane;
/**
 *
 * @author Director
 */
public class TicTacToe extends javax.swing.JFrame {
private String whoseTurn = "X";
private String PlayerOne = "Player One";
private String PlayerTwo = "Player Two";
private int P1Score =0;
private int P2Score =0;
private String turn = PlayerOne;
    /**
     * Creates new form TicTacToe
     */
    public TicTacToe() {
        initComponents();
        setSize(600,600);
        setLocationRelativeTo(null);
        getNames();
        SetPlayerNames();
        setScore();
    }
    
    private void tie(){
   String one = jButton1.getText();
   String two = jButton2.getText();
   String three = jButton3.getText();
   String four = jButton4.getText();
   String five = jButton5.getText();
   String six = jButton6.getText();
   String seven = jButton7.getText();
   String eight = jButton8.getText();
   String nine = jButton9.getText();
   
   if(one != "" && two != "" && three != "" && four != "" && five != "" && six != "" && seven != "" && eight != "" && nine != ""){
   JOptionPane.showMessageDialog(this,"The game has ended in a Tie.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
   reset();
   }
    }
    
    
   private void setScore(){

       
       jLabel1.setText(PlayerOne + "'s Score is: " + String.valueOf(P1Score) + "\t         " + turn +"'s Move. " + "         " + PlayerTwo + "'s Score is: " + String.valueOf(P2Score) + "\t");
   } 
private void SetPlayerNames(){
   String turn;
   if(whoseTurn.equalsIgnoreCase("X"))
   { turn = PlayerOne;}
   else { turn = PlayerTwo; }
   jLabel1.setText(PlayerOne + "'s Score is: " + String.valueOf(P1Score) + "\t         " + turn +"'s Move. " + "         " + PlayerTwo + "'s Score is: " + String.valueOf(P2Score) + "\t");
}

   
   private void determineWhoseTurn() {
if(whoseTurn.equalsIgnoreCase("X"))
    whoseTurn = "O";
else whoseTurn = "X";
}

private void getNames(){
 if (PlayerOne == "") {PlayerOne = "Player One"; } if(PlayerTwo == "") { PlayerTwo = "Player Two"; }
    PlayerOne = JOptionPane.showInputDialog(this,"Enter Player One:","Player Name",JOptionPane.INFORMATION_MESSAGE);
 PlayerTwo = JOptionPane.showInputDialog(this,"Enter Player Two:", "Player Name",JOptionPane.INFORMATION_MESSAGE);

}

private void xWins(){
JOptionPane.showMessageDialog(this,PlayerOne + " Wins!","Game Over",JOptionPane.INFORMATION_MESSAGE);
 P1Score++; reset(); }

private void oWins() {
JOptionPane.showMessageDialog(this,PlayerTwo + " Wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
 P2Score++; reset(); }

private void determineIfWin(){
   String one = jButton1.getText();
   String two = jButton2.getText();
   String three = jButton3.getText();
   String four = jButton4.getText();
   String five = jButton5.getText();
   String six = jButton6.getText();
   String seven = jButton7.getText();
   String eight = jButton8.getText();
   String nine = jButton9.getText();
   //winning Conditions
   //for x win
   if(one == "X" && two == "X" && three == "X")
   {
       xWins();
   }
      if(one == "X" && four == "X" && seven == "X")
   {
       xWins();
   }
         if(one == "X" && five == "X" && nine == "X")
   {
       xWins();
   }
            if(two == "X" && five == "X" && eight == "X")
   {
       xWins();
   }
               if(three == "X" && five == "X" && seven == "X")
   {
       xWins();
   }
                  if(three == "X" && six == "X" && nine == "X")
   {
       xWins();
   }
                     if(four == "X" && five == "X" && six == "X")
   {
       xWins();
   }
                        if(seven == "X" && eight == "X" && nine == "X")
   {
       xWins();
   }
   //for o win;
      if(one == "O" && two == "O" && three == "O")
   {
       oWins();
   }
      if(one == "O" && four == "O" && seven == "O")
   {
       oWins();
   }
         if(one == "O" && five == "O" && nine == "O")
   {
       oWins();
   }
            if(two == "O" && five == "O" && eight == "O")
   {
       oWins();
   }
               if(three == "O" && five == "O" && seven == "O")
   {
       oWins();
   }
                  if(three == "O" && six == "O" && nine == "O")
   {
       oWins();
   }
                     if(four == "O" && five == "O" && six == "O")
   {
       oWins();
   }
                        if(seven == "O" && eight == "O" && nine == "O")
   {
       oWins();
   }
}
private void reset(){
jButton1.setText("");jButton2.setText("");jButton3.setText("");jButton4.setText("");jButton5.setText("");jButton7.setText("");jButton6.setText("");
jButton8.setText("");jButton9.setText(""); setScore();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelGrid = new javax.swing.JPanel();
        Panel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Panel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        Panel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        Panel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        Panel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        Panel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        Panel7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        Panel8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        Panel9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Place Holder for Scores");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        jPanelGrid.setBackground(new java.awt.Color(204, 204, 204));
        jPanelGrid.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        Panel1.setBackground(new java.awt.Color(255, 255, 255));
        Panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel1.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Panel1.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanelGrid.add(Panel1);

        Panel2.setBackground(new java.awt.Color(255, 255, 255));
        Panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel2.setLayout(new java.awt.BorderLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Panel2.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanelGrid.add(Panel2);

        Panel3.setBackground(new java.awt.Color(255, 255, 255));
        Panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel3.setLayout(new java.awt.BorderLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Panel3.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanelGrid.add(Panel3);

        Panel4.setBackground(new java.awt.Color(255, 255, 255));
        Panel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel4.setLayout(new java.awt.BorderLayout());

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Panel4.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanelGrid.add(Panel4);

        Panel5.setBackground(new java.awt.Color(255, 255, 255));
        Panel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel5.setLayout(new java.awt.BorderLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Panel5.add(jButton5, java.awt.BorderLayout.CENTER);

        jPanelGrid.add(Panel5);

        Panel6.setBackground(new java.awt.Color(255, 255, 255));
        Panel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel6.setLayout(new java.awt.BorderLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Panel6.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanelGrid.add(Panel6);

        Panel7.setBackground(new java.awt.Color(255, 255, 255));
        Panel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel7.setLayout(new java.awt.BorderLayout());

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Panel7.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanelGrid.add(Panel7);

        Panel8.setBackground(new java.awt.Color(255, 255, 255));
        Panel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel8.setLayout(new java.awt.BorderLayout());

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Panel8.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanelGrid.add(Panel8);

        Panel9.setBackground(new java.awt.Color(255, 255, 255));
        Panel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel9.setLayout(new java.awt.BorderLayout());

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        Panel9.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanelGrid.add(Panel9);

        jPanel1.add(jPanelGrid, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X"))
            jButton1.setForeground(Color.red);
        else jButton1.setForeground(Color.blue);
        determineWhoseTurn();
        determineIfWin();
        tie();
        SetPlayerNames();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton2.setText(whoseTurn);
                if(whoseTurn.equalsIgnoreCase("X"))
            jButton2.setForeground(Color.red);
        else jButton2.setForeground(Color.blue);
        determineWhoseTurn();
        determineIfWin();
        tie();
        SetPlayerNames();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setText(whoseTurn);
                if(whoseTurn.equalsIgnoreCase("X"))
            jButton3.setForeground(Color.red);
        else jButton3.setForeground(Color.blue);
        determineWhoseTurn();
        determineIfWin();
        tie();
        SetPlayerNames();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setText(whoseTurn);
                if(whoseTurn.equalsIgnoreCase("X"))
            jButton4.setForeground(Color.red);
        else jButton4.setForeground(Color.blue);
        determineWhoseTurn();
        determineIfWin();
        tie();
        SetPlayerNames();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.setText(whoseTurn);
                if(whoseTurn.equalsIgnoreCase("X"))
            jButton5.setForeground(Color.red);
        else jButton5.setForeground(Color.blue);
        determineWhoseTurn();
        determineIfWin();
        tie();
        SetPlayerNames();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6.setText(whoseTurn);
                if(whoseTurn.equalsIgnoreCase("X"))
            jButton6.setForeground(Color.red);
        else jButton6.setForeground(Color.blue);
        determineWhoseTurn();
        determineIfWin();
        tie();
        SetPlayerNames();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setText(whoseTurn);
                if(whoseTurn.equalsIgnoreCase("X"))
            jButton7.setForeground(Color.red);
        else jButton7.setForeground(Color.blue);
        determineWhoseTurn();
        determineIfWin();
        tie();
        SetPlayerNames();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setText(whoseTurn);
                if(whoseTurn.equalsIgnoreCase("X"))
            jButton8.setForeground(Color.red);
        else jButton8.setForeground(Color.blue);
        determineWhoseTurn();
        determineIfWin();
        tie();
        SetPlayerNames();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setText(whoseTurn);
                if(whoseTurn.equalsIgnoreCase("X"))
            jButton9.setForeground(Color.red);
        else jButton9.setForeground(Color.blue);
        determineWhoseTurn();
        determineIfWin();
        tie();
        SetPlayerNames();
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JPanel Panel5;
    private javax.swing.JPanel Panel6;
    private javax.swing.JPanel Panel7;
    private javax.swing.JPanel Panel8;
    private javax.swing.JPanel Panel9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGrid;
    // End of variables declaration//GEN-END:variables
}
