package projetjava;

import javax.swing.*;

public class FenetreA {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Frame fenetre = new Frame();
                fenetre.setSize(300,200);
                fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                fenetre.setVisible(true);
            }
        });
    }
}