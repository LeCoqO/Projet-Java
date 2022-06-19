package projetjava.Sources.Interface;


import java.awt.event.*;
import javax.swing.*;

import projetjava.Sources.Connection.ConnectionBDD;
import projetjava.Sources.Connection.Connector;
import projetjava.Sources.Connection.ConnectorMySQL;
import projetjava.Sources.DAO.DAOEmploye;
import projetjava.Sources.Entity.Employe;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;

public class login extends JFrame implements ActionListener {

    private JButton boutonConnexion = new JButton("Connexion");
    private JLabel etiquette_user = new JLabel("Username ");
    private JTextField champTexte_user = new JTextField("", 20);
    private JLabel etiquette_pswd = new JLabel("Password ");
    private JTextField champTexte_pswd = new JTextField("", 20);
    private JPanel panneau = new JPanel();

    Connection connection = ConnectionBDD.getInstance(new ConnectorMySQL());
    DAOEmploye emp = new DAOEmploye(connection);
    List<Employe> les_emp = emp.getAll();


    public login() {
        super("Interface connexion");

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

        String login = champTexte_user.getText();
        String psw = champTexte_pswd.getText();

        if (e.getSource() == boutonConnexion) {
            for (Employe employe : les_emp) {
                if (login == employe.getLogin() && psw == employe.getPassword()) {
                    menu fenetreMenu = new menu();
                    fenetreMenu.setBounds(650,350,300,150);
                    fenetreMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    fenetreMenu.setVisible(true);
                    fenetreMenu.setResizable(false);
                    this.dispose();
                } else {
                    // Si mdp correct passer à une autre interface sinon message erreur
                    JOptionPane.showMessageDialog(panneau, "Identifiant / Mot de passe incorrect !");
                }
            }

        }
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