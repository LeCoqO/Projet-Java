package Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Connection.*;
import DAO.DAOCampagne;
import Entity.Campagne;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestionCampagne extends JFrame implements ActionListener {

    private JButton btnRetour = new JButton();
    private JButton btnDeco = new JButton();
    private JButton btnRePlanif = new JButton("(Re)Planifier");
    private JButton btnSuppr = new JButton("Supprimer");
    private JButton btnCrea = new JButton("Créer");
    private JButton btnQuitter = new JButton();
    private JLabel label1 = new JLabel("Management/Planification");
    private JLabel label2 = new JLabel("Création");
    private JLabel label3 = new JLabel("Campagne a selectionner");
    private JTextField titreSelection = new JTextField("Titre");
    private JTextField titreCreation = new JTextField("Titre");
    private JTextField messageCampagne = new JTextField("Contenu du message");
    private JLabel label4 = new JLabel("Date déploiement initial :");
    private JList<String> listeGraphiqueCampagne = new JList<>();
    private JComboBox<String> choixTypeCampagne = new JComboBox<>();
    private UtilDateModel model = new UtilDateModel();
    private Properties p = new Properties();
    private JDatePanelImpl datePanelModification = new JDatePanelImpl(model, p);
    private JDatePickerImpl datePickerModification = new JDatePickerImpl(datePanelModification, new DateLabelFormatter());

    private UtilDateModel model2 = new UtilDateModel();
    private Properties p2 = new Properties();
    private JDatePanelImpl datePanelCreation = new JDatePanelImpl(model2, p2);
    private JDatePickerImpl datePickerCreation = new JDatePickerImpl(datePanelCreation, new DateLabelFormatter());
    private JPanel panneauGestionCampagne = new JPanel();

    private ArrayList<Campagne> listeCampagne;
    private int idCampagne;
    // Connection à la base pour la tabble Campagne
    Connection connection = ConnectionBDD.getInstance(new ConnectorMariaDB());
    DAOCampagne campagne = new DAOCampagne(connection);

    public gestionCampagne() throws IOException {
        super("Gestion des campagnes");

        // BufferedImage bufferedImage = ImageIO.read(new File("retour.png"));
        // Image image = bufferedImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        // ImageIcon icon = new ImageIcon(image);
        // btnRetour.setIcon(icon);

        // BufferedImage bufferedImage2 = ImageIO.read(new File("deconnexion.png"));
        // Image image2 = bufferedImage2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        // ImageIcon icon2 = new ImageIcon(image2);
        // btnDeco.setIcon(icon2);

        // BufferedImage bufferedImage3 = ImageIO.read(new File("shutdown.png"));
        // Image image3 = bufferedImage3.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        // ImageIcon icon3 = new ImageIcon(image3);
        // btnQuitter.setIcon(icon3);

        btnRetour.setBounds(10, 60, 50, 50);
        btnDeco.setBounds(10, 360, 50, 50);
        btnQuitter.setBounds(10, 720, 50, 50);
        btnRePlanif.setBounds(200, 600, 150, 50);
        btnSuppr.setBounds(500, 600, 150, 50);
        btnCrea.setBounds(900, 450, 150, 50);
        btnCrea.addActionListener(this);
        btnSuppr.addActionListener(this);
        btnRePlanif.addActionListener(this);
        btnRetour.addActionListener(this);
        btnDeco.addActionListener(this);
        btnQuitter.addActionListener(this);

        label1.setBounds(200, 10, 500, 50);
        label1.setFont(new Font("Sans-Serif", Font.BOLD, 40));
        label2.setBounds(1080, 10, 250, 50);
        label2.setFont(new Font("Sans-Serif", Font.BOLD, 40));
        label3.setBounds(200, 60, 250, 50);
        label3.setFont(new Font("Sans-Serif", Font.CENTER_BASELINE, 15));
        label4.setBounds(200, 300, 300, 20);
        label4.setFont(new Font("Sans-Serif", Font.CENTER_BASELINE, 15));

        DefaultListModel<String> model = new DefaultListModel<>();

        // Affichage des campagnes
        listeCampagne = new ArrayList<Campagne>(campagne.getAll());

        for (Campagne camp : listeCampagne) {
            model.addElement(camp.getTitre());
        }

        DefaultListModel<String> modelU = new DefaultListModel<>();
        modelU.addElement("Catégorie utilisateurs");

        // Créer la liste des langages
        listeGraphiqueCampagne = new JList<>(model);
        listeGraphiqueCampagne.setBounds(200, 120, 250, 150);

        titreSelection.setBounds(500, 120, 150, 20);
        titreCreation.setBounds(900, 120, 250, 20);
        messageCampagne.setBounds(900, 160, 250, 150);

        choixTypeCampagne.setBounds(1200, 120, 200, 25);

        String typeCampagne[] = { "Information", "Marketing", "Urgence" };

        listeGraphiqueCampagne.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });

        for (String type : typeCampagne) {
            choixTypeCampagne.addItem(type);
        }

        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        datePickerModification.setBounds(200, 500, 150, 50);
        datePickerCreation.setBounds(900, 350, 250, 50);

        panneauGestionCampagne.add(datePickerModification);
        panneauGestionCampagne.add(datePickerCreation);
        panneauGestionCampagne.add(this.label1);
        panneauGestionCampagne.add(this.label2);
        panneauGestionCampagne.add(this.label3);
        panneauGestionCampagne.add(this.listeGraphiqueCampagne);
        panneauGestionCampagne.add(this.titreSelection);
        panneauGestionCampagne.add(this.titreCreation);
        panneauGestionCampagne.add(this.messageCampagne);
        panneauGestionCampagne.add(this.label4);
        panneauGestionCampagne.add(choixTypeCampagne);
        panneauGestionCampagne.add(this.btnRetour);
        panneauGestionCampagne.add(this.btnDeco);
        panneauGestionCampagne.add(this.btnQuitter);
        panneauGestionCampagne.add(this.btnRePlanif);
        panneauGestionCampagne.add(this.btnSuppr);
        panneauGestionCampagne.add(this.btnCrea);

        panneauGestionCampagne.setLayout(null);

        this.getContentPane().add(this.panneauGestionCampagne);
    }

    
    /** 
     * @param evt
     * 
     * On regarde si on sélectionne une valeur dans la JList
     */
    private void jList1ValueChanged(ListSelectionEvent evt) {
        if (!listeGraphiqueCampagne.getValueIsAdjusting()) {
            int index = listeGraphiqueCampagne.getSelectedIndex();
            String titre = listeCampagne.get(index).getTitre();
            idCampagne = listeCampagne.get(index).getId();
            titreSelection.setText((String) titre);
        }
    }

    
    /** 
     * @param e
     * 
     * Si le bouton retour est appuyé on revient au menu 
     * 
     * Si le bouton déconnexion est appuyé on arrive sur la page de login 
     * 
     * Si le bouton quitter est appuyé cela quitte l'application
     */
    @Override
    public void actionPerformed(ActionEvent e) {
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
        } else if(e.getSource() == btnSuppr){
            Campagne campagneASupprimer = campagne.selectById(idCampagne);
            campagne.delete(campagneASupprimer);
            this.dispose();

            // Mise à jour de la fenetre
            menu monMenu = new menu();
            monMenu.setBounds(650, 350, 300, 150);
            monMenu.setVisible(true);
            monMenu.setResizable(false);
        }else if (e.getSource() == btnCrea) {
            // Création d'une campagne

            // Formatage de la date en string
            Date dateCreation = (Date) datePickerCreation.getModel().getValue();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = dateFormat.format(dateCreation);

            // Création d'un objet campagne
            Campagne CampagneCree = new Campagne(0, messageCampagne.getText(),
                    choixTypeCampagne.getSelectedItem().toString(), titreCreation.getText(), stringDate);
            
            // Création en base d'une nouvelle campagne
            campagne.create(CampagneCree);

            // Mise à jour de la fenetre
            this.dispose();
            menu monMenu = new menu();
            monMenu.setBounds(650, 350, 300, 150);
            monMenu.setVisible(true);
            monMenu.setResizable(false);
        }else if (e.getSource() == btnRePlanif){
            // Formatage de la date en string
            Date dateCreation = (Date) datePickerModification.getModel().getValue();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = dateFormat.format(dateCreation);

            // Modification de la date de la campagne
            Campagne campagneAPlannifier = campagne.selectById(idCampagne);
            campagneAPlannifier.setDate(stringDate);
            campagne.update(campagneAPlannifier);

            // Mise à jour de la fenetre
            this.dispose();
            menu monMenu = new menu();
            monMenu.setBounds(650, 350, 300, 150);
            monMenu.setVisible(true);
            monMenu.setResizable(false);
        }

    }

}
