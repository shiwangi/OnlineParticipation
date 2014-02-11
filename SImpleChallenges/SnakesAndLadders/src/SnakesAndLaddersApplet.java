/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakesAndLadders;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author utkarshjaiswal
 */
public class SnakesAndLaddersApplet extends javax.swing.JApplet {

    /**
     * Initializes the applet SnakesAndLaddersApplet
     */

    private ImageIcon snake = new ImageIcon("./snake1.jpg");
    private ImageIcon ladder = new ImageIcon("./ladder1.jpg");; 
    
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(SnakesAndLaddersApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SnakesAndLaddersApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SnakesAndLaddersApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SnakesAndLaddersApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    initComponents();
                  
                    while(true){
                    try{
                        String result = JOptionPane.showInputDialog(null, "Enter board dimensions:", "Initialize", JOptionPane.OK_OPTION);
                        if(result == null || result.isEmpty()) break;
                        dim = Integer.parseInt(result);
                        if(dim < 5 || dim > 12) {
                            throw new java.lang.NumberFormatException();
                        }
                        break;
                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Board dimension should be between 5-12", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                    }
                    
                    while(true){
                        try{
                            numplayers = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of players", "Initialize", JOptionPane.OK_OPTION));
                            if(numplayers < 2 || numplayers > 3) {
                                throw new java.lang.NumberFormatException();
                            }
                            break;
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "Number of players should be between 2-3", "Error!!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    InitializeBoard();
                    InitializePlayers();
                    StartGame();
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in loading application!!", "Error!!", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getCause());
            
        }
    }
    
    /**
     * My own methods.
     */
    private void InitializeBoard(){
        setPositions();
        
        Font font = new java.awt.Font("Times New Roman", 1, 18);
        cells = new JLabel[size];
        board.setLayout(new java.awt.GridLayout(dim, dim, 2, 2));
        
        for(int i = size-1 ; i > -1 ; i--){
            String s = chechIndex(i);
            if (s.equals("snake")) {
                if (get(i)) {
                    cells[i] = new JLabel(String.valueOf(i + 1), snake, javax.swing.SwingConstants.CENTER);
                } else {
                    cells[i] = new JLabel(String.valueOf(i + 1), javax.swing.SwingConstants.CENTER);
                }

            } else if (s.equals("ladder")) {
                if (get(i)) {
                    cells[i] = new JLabel(String.valueOf(i + 1), ladder, javax.swing.SwingConstants.CENTER);
                } else {
                    cells[i] = new JLabel(String.valueOf(i + 1), javax.swing.SwingConstants.CENTER);
                }

            } else {
                cells[i] = new JLabel(String.valueOf(i + 1), javax.swing.SwingConstants.CENTER);

            }
            
            cells[i].setFont(font);
            cells[i].setOpaque(true);
            cells[i].setBackground(Color.white);
            cells[i].setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED, Color.BLACK, Color.LIGHT_GRAY));
            cells[i].setVisible(true);
            board.add(cells[i]);
        }
        
        dice.setLayout(new java.awt.GridLayout(1, numplayers + 1));
    }
    
    private void setPositions(){
        size = dim*dim;
        chkpos = new boolean[size];
        
        pos = (dim - 1)/2;
        snakepos = new int[pos][2];
        ladderpos = new int[pos][2];
        
        Random gen = new Random();
        int a = showRandomInteger(1, size-2 , gen);
        
        chkpos[a] = true;
        
        int b = showRandomInteger(1, size-2 , gen);
        while(chkpos[b]){
            b = showRandomInteger(1, size-2 , gen);
        }
        chkpos[b] = true;
        
        if(a < b){
            snakepos[0][0] = a;
            snakepos[0][1] = b;
        }
        else{
            snakepos[0][0] = b;
            snakepos[0][1] = a;
        }
        
        
        for(int i = 1; i < pos ; i++){
            a = showRandomInteger(1, size-2 , gen);
            b = showRandomInteger(1, size-2 , gen);
            
            while(chkpos[a]){
            a = showRandomInteger(1, size-2 , gen);
            }
            chkpos[a] = true;
            
            while(chkpos[b]){
            b = showRandomInteger(1, size-2 , gen);
            }
            chkpos[b] = true;
            
            if(a < b){
                snakepos[i][0] = a;
                snakepos[i][1] = b;
            }
            else{
                snakepos[i][0] = b;
                snakepos[i][1] = a;
            }
            
        }
        
        for(int i = 0; i < pos ; i++){
            a = showRandomInteger(1, size-2 , gen);
            b = showRandomInteger(1, size-2 , gen);
            
            while(chkpos[a]){
            a = showRandomInteger(1, size-2 , gen);
            }
            chkpos[a] = true;
            
            while(chkpos[b]){
            b = showRandomInteger(1, size-2 , gen);
            }
            chkpos[b] = true;
            
            if(a < b){
                ladderpos[i][0] = a;
                ladderpos[i][1] = b;
            }
            else{
                ladderpos[i][0] = b;
                ladderpos[i][1] = a;
            }
            
            
        }
    }
    
    private String chechIndex(int ind){
        for(int i = 0; i < pos ; i++){
            if(snakepos[i][0] == ind || snakepos[i][1] == ind){
                return "snake";
            }
        }
        for(int i = 0; i < pos ; i++){
            if(ladderpos[i][0] == ind || ladderpos[i][1] == ind){
                return "ladder";
            }
        }
        
        return null;
    }
    
    private boolean get(int ind){
        for(int i = 0; i < pos ; i++){
            if(snakepos[i][1] == ind){
                nextpos = snakepos[i][0];
                return true;
            }
        }
        for(int i = 0; i < pos ; i++){
            if(ladderpos[i][0] == ind){
                nextpos = ladderpos[i][1];
                return true;
            }
        }
        
        return false;
    }
    
    private static int showRandomInteger(int aStart, int aEnd, Random aRandom){
    //get the range, casting to long to avoid overflow problems
    long range = (long)aEnd - (long)aStart + 1;
    // compute a fraction of the range, 0 <= frac < range
    long fraction = (long)(range * aRandom.nextDouble());
    return  (int)(fraction + aStart);    
  }
    private void InitializePlayers(){
        players = new JLabel[numplayers];
        maxscore = new int[numplayers];
        curscore = new int[numplayers];
        remain = new int[numplayers];
        
        Font font = new java.awt.Font("Times New Roman", 1, 18);
        
        for(int i = 0; i < numplayers; i++){
            players[i] = new JLabel();
            players[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            players[i].setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED, Color.BLACK, Color.LIGHT_GRAY));
            players[i].setFont(font);
            players[i].setOpaque(true);
            players[i].setText(JOptionPane.showInputDialog(null, "Enter name of player" + (i+1), "Initialize", JOptionPane.OK_OPTION));
            players[i].setVisible(true);
            
            remain[i] = size - 1;
        }
        
        players[0].setBackground(Color.yellow);
        players[1].setBackground(Color.red);
        if(numplayers == 3){
            players[2].setBackground(Color.green);
        }
        
        for(int i = 0; i < numplayers; i++){
            dice.add(players[i]);
        }
    }
    
    private void MovePlayer(int d){
        int chk = size - 1 - remain[count];
        
        curscore[count]++;
        if(remain[count] < d){
            JOptionPane.showMessageDialog(null, "You need " + remain[count] + " to win.", "Info",JOptionPane.INFORMATION_MESSAGE);
            count = (count + 1)%numplayers;
            return;
        }
        
        
        cells[chk].setBackground(Color.white);
        
        chk += d;
        cells[chk].setBackground(players[count].getBackground());
        
        if("snake".equals(chechIndex(chk))){
                if(get(chk)){                    
                    JOptionPane.showMessageDialog(null, "You were caught by snake at " + (chk + 1) + "\nGo to " + (nextpos + 1), "Info",JOptionPane.INFORMATION_MESSAGE);
                    cells[chk].setBackground(Color.white);
                    cells[nextpos].setBackground(players[count].getBackground());
                    remain[count] = size - 1 - nextpos;
                }
                else{
                    remain[count] = size - 1 - chk;
                }
            }
        else if("ladder".equals(chechIndex(chk))){
            if(get(chk)){
                cells[chk].setBackground(Color.white);
                JOptionPane.showMessageDialog(null, "You discovered a ladder at " + (chk + 1) + "\nGo to " + (nextpos + 1), "Info",JOptionPane.INFORMATION_MESSAGE);
                cells[nextpos].setBackground(players[count].getBackground());
                remain[count] = size - 1 - nextpos;
            }
            else{
                remain[count] = size - 1 - chk;
            }
        }
        else{
            remain[count] = size - 1 - chk;
        }
        
        if(remain[count] == 0){
            JOptionPane.showMessageDialog(null, "Congratulations " + players[count].getText() + "!! You won", "Info",JOptionPane.INFORMATION_MESSAGE);
            if(maxscore[count] == 0 || curscore[count] < maxscore[count]){
                maxscore[count] = curscore[count];
                JOptionPane.showMessageDialog(null, "Your new highscore is: " + maxscore[count] + " steps.", "Info",JOptionPane.INFORMATION_MESSAGE);
            }
            
            int result = JOptionPane.showConfirmDialog(null, "Do you want to restart?", "Info",JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                Restart();
                return;
            }
            else{
                Button_dice.setEnabled(false);
                System.exit(0);
            }
        }
        
        count = (count + 1)%numplayers;
        chk = size - 1 - remain[count];

        cells[chk].setBackground(players[count].getBackground());
        JOptionPane.showMessageDialog(null, players[count].getText() + "! It's your turn.", "Info", JOptionPane.OK_OPTION);
    }
    private void StartGame(){
        
        cells[0].setBackground(Color.yellow);
        JOptionPane.showMessageDialog(null, players[count].getText() + "! It's your turn.", "Info", JOptionPane.OK_OPTION);
    }
    
    private void Restart(){
        int chk;
        count = 0;
        for(int i = 0; i < numplayers; i++){
            chk = size - 1 - remain[i];
            cells[chk].setBackground(Color.white);
            curscore[i] = 0;
            remain[i] = size - 1;
        }
        StartGame();
    }
    
    /**
     * End.
     */

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        board = new javax.swing.JPanel();
        dice = new javax.swing.JPanel();
        Button_dice = new javax.swing.JButton();
        Label_dice = new javax.swing.JLabel();

        board.setLayout(new java.awt.GridLayout(1, 0));

        dice.setLayout(new java.awt.GridLayout(1, 0));

        Button_dice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Button_dice.setText("Roll Dice");
        Button_dice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_diceActionPerformed(evt);
            }
        });
        dice.add(Button_dice);

        Label_dice.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Label_dice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_dice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, null, java.awt.Color.lightGray));
        dice.add(Label_dice);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dice, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dice, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Button_diceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_diceActionPerformed
        Random gen = new Random();
        int d = showRandomInteger(1, 6, gen);
        Label_dice.setText(String.valueOf(d));
        MovePlayer(d);
    }//GEN-LAST:event_Button_diceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_dice;
    private javax.swing.JLabel Label_dice;
    private javax.swing.JPanel board;
    private javax.swing.JPanel dice;
    // End of variables declaration//GEN-END:variables

    private int numplayers, dim = 8, pos,size, count = 0, nextpos;
    private javax.swing.JLabel[] cells;
    private int[][] snakepos, ladderpos;
    private boolean[] chkpos;
    
    private JLabel[] players;
    private int maxscore[];
    private int curscore[];
    private int remain[];
    
    public static void main(String[] args) {
    java.applet.Applet MyApplet = new SnakesAndLaddersApplet();
    MyApplet.init();
    JFrame frame = new JFrame("Snakes and Ladders");
    frame.getContentPane().add(MyApplet);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    MyApplet.start();
}
}
