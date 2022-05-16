package projetjava;

import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {

    private JButton boutonConnexion = new JButton("Connexion");
    private JLabel etiquette_user = new JLabel("Username ");
    private JTextField champTexte_user = new JTextField("", 20);
    private JLabel etiquette_pswd = new JLabel("Password ");
    private JTextField champTexte_pswd = new JTextField("", 20);
    private JPanel panneau = new JPanel();


    public login() {
        super("Interface connexion");
        this.setBounds(100, 100, 960, 640);
        panneau.add(this.etiquette_user);
        panneau.add(this.champTexte_user);
        panneau.add(this.etiquette_pswd);
        panneau.add(this.champTexte_pswd);
        panneau.add(this.boutonConnexion);
        
        this.boutonConnexion.addActionListener(this);
        this.getContentPane().add(this.panneau);
        boutonConnexion.setBounds(100, 100, 200, 300);

        champTexte_user.addKeyListener(new EcouteurChampTexte());
        champTexte_pswd.addKeyListener(new EcouteurChampTexte());
        this.boutonConnexion.setEnabled(false);

        this.getRootPane().setDefaultButton(boutonConnexion);

        this.getContentPane().add(this.panneau);
    }

    public void actionPerformed(ActionEvent e) {
        // Si mdp correct passer à une autre interface sinon message erreur 
        JOptionPane.showMessageDialog(panneau, "Identifiant / Mot de passe incorrect !");
    }
      

    class EcouteurChampTexte implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            boutonConnexion.setEnabled(!champTexte_user.getText().isEmpty() && !champTexte_pswd.getText().isEmpty());
        }
    }
}