package Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.List;
import Connection.ConnectionBDD;
import Connection.ConnectorMySQL;
import DAO.DAOCampagne;
import DAO.DAOCampagneLocataire;
import DAO.DAOLocataire;
import Entity.Campagne;
import Entity.Campagne_Locataire;


public class stats extends JFrame implements ActionListener {

    // Connexion à la base
    Connection connection = ConnectionBDD.getInstance(new ConnectorMySQL());
    DAOCampagneLocataire campLoc = new DAOCampagneLocataire(connection);
    DAOCampagne camp = new DAOCampagne(connection);
    DAOLocataire loc = new DAOLocataire(connection);

    private JButton btnRetour = new JButton();
    private JButton btnDeco = new JButton();
    private JButton btnQuitter = new JButton();
    private JButton btnDestParCamp = new JButton("Destinataire par campagne");
    private JButton btnNbCampParType = new JButton("Nombre de campagne par type");
    private JPanel panneauMenu = new JPanel();
    private JRadioButton btnRadCamp = new JRadioButton("Recherche par campagne");
    private JRadioButton btnRadDest = new JRadioButton("Recherche par destinataire");
    private JComboBox<String> choixListeCamp = new JComboBox<>();
    private JComboBox<String> choixListeDest = new JComboBox<>();
    private JList<String> listeCamp = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    DefaultListModel<String> model2 = new DefaultListModel<>();
    private JList<String> listeDest = new JList<>();

    public stats() throws IOException {
        super("Statistiques");

        BufferedImage bufferedImage = ImageIO
                .read(new File("C:\\Users\\coren\\Documents\\NetBeansProjects\\Projet-Java\\src\\retour.png"));
        Image image = bufferedImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        btnRetour.setIcon(icon);

        BufferedImage bufferedImage2 = ImageIO
                .read(new File("C:\\Users\\coren\\Documents\\NetBeansProjects\\Projet-Java\\src\\deconnexion.png"));
        Image image2 = bufferedImage2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image2);
        btnDeco.setIcon(icon2);

        BufferedImage bufferedImage3 = ImageIO
                .read(new File("C:\\Users\\coren\\Documents\\NetBeansProjects\\Projet-Java\\src\\shutdown.png"));
        Image image3 = bufferedImage3.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(image3);
        btnQuitter.setIcon(icon3);

        String tabCamp[] = { "Liste des campagnes" };
        String tabDest[] = { "Liste des destinataires" };

        for (String string : tabDest) {
            choixListeDest.addItem(string);
        }
        for (String string2 : tabCamp) {
            choixListeCamp.addItem(string2);
        }

        btnRetour.setBounds(10, 60, 50, 50);
        btnDeco.setBounds(10, 360, 50, 50);
        btnQuitter.setBounds(10, 720, 50, 50);
        btnRetour.addActionListener(this);
        btnDeco.addActionListener(this);
        btnQuitter.addActionListener(this);

        btnDestParCamp.setBounds(850, 60, 350, 50);
        btnDestParCamp.addActionListener(this);

        btnNbCampParType.setBounds(850, 120, 350, 50);
        btnNbCampParType.addActionListener(this);

        btnRadCamp.setBounds(400, 20, 175, 20);
        btnRadDest.setBounds(600, 20, 180, 20);
        btnRadCamp.setSelected(true);
        btnRadDest.addActionListener(this);
        btnRadCamp.addActionListener(this);

        choixListeCamp.setBounds(150, 20, 175, 20);
        choixListeDest.setBounds(150, 20, 175, 20);
        choixListeDest.setVisible(false);



        listeCamp = new JList<>(model);
        listeCamp.setBounds(150, 200, 250, 150);
        listeDest.setBounds(550, 200, 250, 150);

        ListSelectionListener listSelectionListener = new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                updateListe();

            }
        };

        listeCamp.addListSelectionListener(listSelectionListener);

        ButtonGroup bg = new ButtonGroup();
        bg.add(btnRadCamp);
        bg.add(btnRadDest);

        List<Campagne> allCampagne = new ArrayList<>(camp.getAll());

        for (int i = 0; i < allCampagne.size(); i++) {
            model.add(i, allCampagne.get(i).getTitre());
        }

        panneauMenu.add(this.btnRetour);
        panneauMenu.add(this.btnDeco);
        panneauMenu.add(this.btnQuitter);
        panneauMenu.add(this.btnDestParCamp);
        panneauMenu.add(this.btnNbCampParType);
        panneauMenu.add(this.btnRadCamp);
        panneauMenu.add(this.btnRadDest);
        panneauMenu.add(this.choixListeCamp);
        panneauMenu.add(this.choixListeDest);
        panneauMenu.add(this.listeCamp);
        panneauMenu.add(this.listeDest);

        panneauMenu.setLayout(null);

        this.getContentPane().add(this.panneauMenu);

    }

    
    /** 
     * @param (btnRadCamp.isSelected()
     * 
     * Si btnRadCamp est selectionné on affiche la liste des campagnes
     * Si btnRadDest est selectionné on affiche la liste des destinataires
     */
    public void actionPerformed(ActionEvent e) { 
        if (btnRadCamp.isSelected()) {
            choixListeCamp.setVisible(true);
            choixListeDest.setVisible(false);
        } else if (btnRadDest.isSelected()) { 
            choixListeCamp.setVisible(false);
            choixListeDest.setVisible(true);
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
        } else if (e.getSource() == btnDestParCamp) {
            destParCamp maPageStats = new destParCamp();
            maPageStats.setBounds(0, 0, 1920, 1080);
            maPageStats.setVisible(true);
            maPageStats.setResizable(false);
            maPageStats.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getSource() == btnNbCampParType) {
            NbCampParType campParType = new NbCampParType();
            campParType.setBounds(0, 0, 1920, 1080);
            campParType.setVisible(true);
            campParType.setResizable(false);
            campParType.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

    }

    public void updateListe() {
        List<Campagne> allCampagne = new ArrayList<>(camp.getAll());
        List<Campagne_Locataire> allCampagneLocataire = new ArrayList<>(campLoc.getAll());

        model2 = new DefaultListModel<>();

        int indexList = listeCamp.getSelectedIndex();
        System.out.println(indexList);
        for (Campagne_Locataire t : allCampagneLocataire) {
            System.out.println("t id : "+t.getIdCampagne()+" / all campagne id by index list : "+allCampagne.get(indexList).getId());
            if (t.getIdCampagne() == allCampagne.get(indexList).getId()) {
                System.out.println("Comparaison ok");
                model2.addElement(loc.selectById(t.getIdLocataire()).getNom());
            }

        }
        listeDest.setModel(model2);
    }

}
