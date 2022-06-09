package Interface;


import javax.swing.*;

public class FenetreA {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                login fenetreLog = new login();
                fenetreLog.setBounds(650,350,300,150);
                fenetreLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fenetreLog.setVisible(true);
                fenetreLog.setResizable(false);

                menu fenetreMenu = new menu();
                fenetreMenu.setBounds(650,350,300,150);
                fenetreMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fenetreMenu.setVisible(true);
                fenetreMenu.setResizable(false);       
            }
        });
    }
}