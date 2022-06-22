package Interface;

import javax.swing.*;
import Util.*;
import Connection.*;
import DAO.*;
import Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.transform.Source;

public class gestionUser extends JFrame implements ActionListener {

    private JButton btnRetour = new JButton();
    private JButton btnDeco = new JButton();
    private JButton btnQuitter = new JButton();
    private JButton btnModifMdp = new JButton("Modifer le mdp");
    private JButton btnValider = new JButton("Valider");
    private JButton btnSupprCompte = new JButton("Supprimer le compte");
    private JButton btnCreer = new JButton("Créer");
    private JPanel panneauGestionUser = new JPanel();
    private DefaultListModel<String> model = new DefaultListModel<>();
    private DefaultListModel<String> modelU = new DefaultListModel<>();
    private JList<String> liste1 = new JList<>(model);
    private JComboBox<ComboItem> choixTypeCamp = new JComboBox<>();
    private JComboBox<String> choixTypeCat = new JComboBox<>();
    private JCheckBox check1 = new JCheckBox("Droit planification / lancement campagne");
    private JLabel label1 = new JLabel("Gestion des utilisateurs");
    private JLabel label2 = new JLabel("Création d'un utilisateur");
    private JTextField field1 = new JTextField("Nom de l'utilisateur");
    private JTextField field2 = new JTextField("Mdp de l'utilisateur");
    private JTextField field3 = new JTextField("Nouveau mot de passe");

    Connection connection = ConnectionBDD.getInstance(new ConnectorMySQL()); // Connexion avec la base
    DAOEmploye employe = new DAOEmploye(connection);
    List<Employe> listEmploye = employe.getAll();
    DAOCampagne campagne = new DAOCampagne(connection);
    List<Campagne> listCampagne = campagne.getAll();
    DAOEmployeCampagne employeCampagne = new DAOEmployeCampagne(connection);
    List<Employe> listUtilisateurs = new ArrayList();

    public gestionUser() throws IOException {
        super("Gestion des utilisateurs");

        for (Employe t : listEmploye) {
            if (t.getFonction().equals("Utilisateur")) {
                listUtilisateurs.add(t);
            }
        }

        ListSelectionListener listSelectionListener = new ListSelectionListener() { /// LISTENER POUR JLIST (moche mais
            /// fonctionnel);
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                System.out.println(listUtilisateurs.get(liste1.getSelectedIndex()).getPrenom());
                System.out.println("test");
                checkUpdateDroit();
            }
        };

        if (connection != null) {
            System.out.println("Connexion réussi !");

        }

        /*
         * BufferedImage bufferedImage = ImageIO.read(new File(
         * "C:\\Users\\coren\\Documents\\NetBeansProjects\\Projet-Java\\src\\retour.png"
         * ));
         * Image image = bufferedImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
         * ImageIcon icon = new ImageIcon(image);
         * btnRetour.setIcon(icon);
         * 
         * BufferedImage bufferedImage2 = ImageIO.read(new File(
         * "C:\\Users\\coren\\Documents\\NetBeansProjects\\Projet-Java\\src\\deconnexion.png"
         * ));
         * Image image2 = bufferedImage2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
         * ImageIcon icon2 = new ImageIcon(image2);
         * btnDeco.setIcon(icon2);
         * 
         * BufferedImage bufferedImage3 = ImageIO.read(new File(
         * "C:\\Users\\coren\\Documents\\NetBeansProjects\\Projet-Java\\src\\shutdown.png"
         * ));
         * Image image3 = bufferedImage3.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
         * ImageIcon icon3 = new ImageIcon(image3);
         * btnQuitter.setIcon(icon3);
         */
        btnRetour.setBounds(10, 60, 50, 50);
        btnDeco.setBounds(10, 360, 50, 50);
        btnQuitter.setBounds(10, 720, 50, 50);
        btnModifMdp.setBounds(200, 650, 200, 50);
        btnValider.setBounds(200, 400, 250, 50);
        btnSupprCompte.setBounds(200, 750, 200, 50);
        btnCreer.setBounds(900, 450, 150, 50);
        btnRetour.addActionListener(this);
        btnDeco.addActionListener(this);
        btnQuitter.addActionListener(this);
        btnValider.addActionListener(this);
        btnCreer.addActionListener(this);
        btnModifMdp.addActionListener(this);

        int nbUser = 0;
        for (Employe t : listEmploye) {
            if (t.getFonction().equals("Utilisateur")) {
                model.add(nbUser, t.getNom() + " " + t.getPrenom());
                nbUser++;
            }
        }

        modelU.addElement("Catégorie utilisateurs");

        // créer la liste des langages
        liste1.setBounds(200, 120, 250, 150);

        // liste1.addListSelectionListener(new ListSelectionListener() {
        // public void valueChanged(ListSelectionEvent evt) {
        // Boolean checked = false;
        // if

        // check1.setSelected (checked));
        // }
        // });

        choixTypeCamp.setBounds(200, 300, 250, 25);
        for (Campagne t : listCampagne) {
            choixTypeCamp.addItem(new ComboItem(t.getId(), t.getTitre()));
        }

        choixTypeCat.setBounds(900, 320, 250, 25);
        String tabCat[] = { "Catégorie" };

        for (String string2 : tabCat) {
            choixTypeCat.addItem(string2);
        }

        choixTypeCamp.addActionListener(this);

        liste1.addListSelectionListener(listSelectionListener);

        check1.setBounds(200, 350, 350, 25);

        label1.setBounds(200, 50, 550, 35);
        label1.setFont(new Font("Sans-Serif", Font.BOLD, 40));
        label2.setBounds(900, 50, 550, 35);
        label2.setFont(new Font("Sans-Serif", Font.BOLD, 40));

        field1.setBounds(900, 120, 400, 25);
        field2.setBounds(900, 220, 400, 25);
        field3.setBounds(200, 550, 400, 25);

        panneauGestionUser.setLayout(null);

        this.getContentPane().add(this.panneauGestionUser);

        panneauGestionUser.add(this.btnRetour);
        panneauGestionUser.add(this.btnDeco);
        panneauGestionUser.add(this.btnQuitter);
        panneauGestionUser.add(this.liste1);
        panneauGestionUser.add(this.choixTypeCamp);
        panneauGestionUser.add(this.check1);
        panneauGestionUser.add(this.label1);
        panneauGestionUser.add(this.label2);
        panneauGestionUser.add(this.field1);
        panneauGestionUser.add(this.field2);
        panneauGestionUser.add(this.field3);
        panneauGestionUser.add(this.choixTypeCat);
        panneauGestionUser.add(this.btnModifMdp);
        panneauGestionUser.add(this.btnSupprCompte);
        panneauGestionUser.add(this.btnValider);
        panneauGestionUser.add(btnCreer);
    }

    public void checkUpdateDroit() {
        int indexList = liste1.getSelectedIndex();
        int indexCamp = ((ComboItem) choixTypeCamp.getSelectedItem()).getValue();
        try {
            EmployeCampagne leDroit = employeCampagne.selectById(indexCamp, listUtilisateurs.get(indexList).getId());
            check1.setSelected(leDroit.isDroitCampagne());
        } catch (Exception e) {
            check1.setSelected(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if (list.getSelectedIndex() == -1) {
        // //No selection, disable fire button.
        // fireButton.setEnabled(false);
        if (e.getSource() == choixTypeCamp || e.getSource() == liste1) {
            checkUpdateDroit();
        }
        if (e.getSource() == btnRetour) {
            this.dispose();
            menu monMenu = new menu();
            monMenu.setBounds(650, 350, 300, 150);
            monMenu.setVisible(true);
            monMenu.setResizable(false);
        } else if (e.getSource() == btnDeco) {
            this.dispose();
            login maPageLogin = new login();
            maPageLogin.setBounds(650, 350, 300, 150);
            maPageLogin.setVisible(true);
            maPageLogin.setResizable(false);
        } else if (e.getSource() == btnQuitter) {
            this.dispose();
        } else if (e.getSource() == btnValider) {

            int indexList = liste1.getSelectedIndex();
            int indexCamp = ((ComboItem) choixTypeCamp.getSelectedItem()).getValue();
            try {
                if (employeCampagne.selectById(indexCamp, listUtilisateurs.get(indexList).getId()).equals(null)) {
                    employeCampagne.create(
                            new EmployeCampagne(indexCamp, listUtilisateurs.get(indexList).getId(),
                                    check1.isSelected()));
                } else {
                    employeCampagne.update(
                            new EmployeCampagne(indexCamp, listUtilisateurs.get(indexList).getId(),
                                    check1.isSelected()));
                }
            } catch (Exception ex) {
                employeCampagne.create(
                        new EmployeCampagne(indexCamp, listUtilisateurs.get(indexList).getId(),
                                check1.isSelected()));
            }

            System.out.println("Index Selected: " + indexList);
            System.out.println(
                    listUtilisateurs.get(indexList).getNom() + " " + listUtilisateurs.get(indexList).getPrenom());
            ComboItem choix = (ComboItem) choixTypeCamp.getSelectedItem();
            System.out.println(((ComboItem) choixTypeCamp.getSelectedItem()).getValue());

            JOptionPane.showMessageDialog(panneauGestionUser, "Informations modifiées");
        } else if (e.getSource() == btnCreer) {
            JOptionPane.showMessageDialog(panneauGestionUser, "Utilisateur créé");
        } else if (e.getSource() == btnModifMdp) {
            JOptionPane.showMessageDialog(panneauGestionUser, "Mot de passe modifié");
        }

    }

}
