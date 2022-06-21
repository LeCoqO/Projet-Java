package Interface;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private JTextField text1 = new JTextField("Titre");
    private JTextField text2 = new JTextField("Titre");
    private JTextField text3 = new JTextField("Contenu du message");
    private JLabel label4 = new JLabel("Date déploiement initial :");
    private JList<String> liste1 = new JList<>();
    private JList<String> liste2 = new JList<>();
    private JComboBox<String> choixTypeCamp = new JComboBox<>();
    private JComboBox<String> choixTypeCamp2 = new JComboBox<>();
    private UtilDateModel model = new UtilDateModel();
    private Properties p = new Properties();
    private JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

    private UtilDateModel model2 = new UtilDateModel();
    private Properties p2 = new Properties();
    private JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
    private JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
    private JPanel panneauGestionCampagne = new JPanel();

    public gestionCampagne() throws IOException {
        super("Gestion des campagnes");

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

        btnRetour.setBounds(10, 60, 50, 50);
        btnDeco.setBounds(10, 360, 50, 50);
        btnQuitter.setBounds(10, 720, 50, 50);
        btnRePlanif.setBounds(200, 600, 150, 50);
        btnSuppr.setBounds(500, 600, 150, 50);
        btnCrea.setBounds(900, 450, 150, 50);
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
        model.addElement("Java");
        model.addElement("PHP");
        model.addElement("Python");
        model.addElement("C++");
        model.addElement("Perl");
        model.addElement("Pascal");
        model.addElement("Ruby");

        DefaultListModel<String> modelU = new DefaultListModel<>();
        modelU.addElement("Catégorie utilisateurs");

        liste1 = new JList<>(model);
        liste1.setBounds(200, 120, 250, 150);

        liste2 = new JList<>(modelU);
        liste2.setBounds(1200, 300, 150, 200);

        text1.setBounds(500, 120, 150, 20);
        text2.setBounds(900, 120, 250, 20);
        text3.setBounds(900, 160, 250, 150);

        choixTypeCamp.setBounds(500, 500, 250, 25);
        choixTypeCamp2.setBounds(1200, 120, 200, 25);
        String tabCamp[] = { "Type de campagne" };

        for (String string : tabCamp) { 
            choixTypeCamp.addItem(string);
            choixTypeCamp2.addItem(string);
        }

        liste1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
   
        // Ajout des valeurs pour le calendrier
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        datePicker.setBounds(200, 500, 150, 50);
        datePicker2.setBounds(900, 350, 250, 50);

        panneauGestionCampagne.add(datePicker);
        panneauGestionCampagne.add(datePicker2);
        panneauGestionCampagne.add(this.label1);
        panneauGestionCampagne.add(this.label2);
        panneauGestionCampagne.add(this.label3);
        panneauGestionCampagne.add(this.liste1);
        panneauGestionCampagne.add(this.liste2);
        panneauGestionCampagne.add(this.text1);
        panneauGestionCampagne.add(this.text2);
        panneauGestionCampagne.add(this.text3);
        panneauGestionCampagne.add(this.label4);
        panneauGestionCampagne.add(choixTypeCamp);
        panneauGestionCampagne.add(choixTypeCamp2);
        panneauGestionCampagne.add(this.btnRetour);
        panneauGestionCampagne.add(this.btnDeco);
        panneauGestionCampagne.add(this.btnQuitter);
        panneauGestionCampagne.add(this.btnRePlanif);
        panneauGestionCampagne.add(this.btnSuppr);
        panneauGestionCampagne.add(this.btnCrea);

        panneauGestionCampagne.setLayout(null);

        this.getContentPane().add(this.panneauGestionCampagne);
    }

    private void jList1ValueChanged(ListSelectionEvent evt) {
        if (!liste1.getValueIsAdjusting()) {
            text1.setText((String) liste1.getSelectedValue());
        }
    }

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
        }

    }

}
