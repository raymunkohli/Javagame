/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JLabel;

/**
 *  A class used to display the score board (top board)
 * @author raymu
 */
public class Score extends javax.swing.JPanel {
    Game game;
    /**
     * Creates new form Score
     * @param game the game for the score panel to be implemented
     */
    public Score(Game game) {
        this.game = game;
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setText("Lives:"+game.getLives());

        jLabel3.setText("Time Remaining :"+game.getTime()+"/60");

        jLabel4.setText("Score: "+game.getScore());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(jLabel2)
                .addComponent(jLabel3))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @return the label representing the number of lives
     */
    public JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     *
     * @param s the new number of lives
     */
    public void setjLabel2(String s) {
        jLabel2.setText("Lives: "+ s);
    }

    /**
     *
     * @return a label representing the timer
     */
    public JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     *
     * @param s the new text to go in the place of the timer
     */
    public void setjLabel3(String s) {
        jLabel3.setText(s);
    }

    /**
     *
     * @return the label representing the score panel
     */
    public JLabel getjLabel4() {
        return jLabel4;
    }

    /**
     *
     * @param Score the new score of this game
     */
    public void setjLabel4(String Score) {
        jLabel4.setText("Score: "+Score);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
