package projetjava;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class FenetreA {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Frame fenetre = new Frame();
                fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                fenetre.setVisible(true);
            }
        });
    }
}