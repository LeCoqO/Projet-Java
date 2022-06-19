package projetjava.Sources.Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestionUser extends JFrame implements ActionListener {

    private JButton btnRetour = new JButton();
    private JButton btnDeco = new JButton();
    private JButton btnQuitter = new JButton();
    private JButton btnModifMdp = new JButton("Modifer le mdp");
    private JButton btnValider = new JButton("Valider");
    private JButton btnSupprCompte = new JButton("Supprimer le compte");
    private JButton btnCreer = new JButton("Créer");
    private JPanel panneauGestionUser = new JPanel();
    private JList<String> liste1 = new JList<>();
    private JComboBox<String> choixTypeCamp = new JComboBox<>();
    private JComboBox<String> choixTypeCat = new JComboBox<>();
    private JCheckBox check1 = new JCheckBox("Droit planification / lancement campagne"); 
    private JLabel gestionUser = new JLabel("Gestion des utilisateurs");
    private JLabel creaUSer = new JLabel("Création d'un utilisateur");
    private JTextField nomUser = new JTextField("Nom de l'utilisateur");
    private JTextField prenomUser = new JTextField("Prenom de l'utilisateur");
    private JTextField loginUser = new JTextField("Login de l'utilisateur");
    private JTextField mdpUser = new JTextField("Mdp de l'utilisateur");
    private JTextField newMdp = new JTextField("Nouveau mot de passe");

    public gestionUser() throws IOException {
        super("Gestion des utilisateurs"); 

        BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\coren\\Documents\\NetBeansProjects\\Projet-Java\\src\\retour.png"));
        Image image = bufferedImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        btnRetour.setIcon(icon);

        BufferedImage bufferedImage2 = ImageIO.read(new File("C:\\Users\\coren\\Documents\\NetBeansProjects\\Projet-Java\\src\\deconnexion.png"));
        Image image2 = bufferedImage2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image2);
        btnDeco.setIcon(icon2);

        BufferedImage bufferedImage3 = ImageIO.read(new File("C:\\Users\\coren\\Documents\\NetBeansProjects\\Projet-Java\\src\\shutdown.png"));
        Image image3 = bufferedImage3.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(image3);
        btnQuitter.setIcon(icon3);

        btnRetour.setBounds(10,60,50,50);
        btnDeco.setBounds(10,360,50,50);
        btnQuitter.setBounds(10,720,50,50);
        btnModifMdp.setBounds(200,650,200,50);
        btnValider.setBounds(200,400,250,50);
        btnSupprCompte.setBounds(200,750,200,50);
        btnCreer.setBounds(900,450,150,50);
        btnRetour.addActionListener(this);
        btnDeco.addActionListener(this);
        btnQuitter.addActionListener(this);
        btnValider.addActionListener(this);
        btnCreer.addActionListener(this);
        btnModifMdp.addActionListener(this);

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

        //créer la liste des langages
        liste1 = new JList<>(model);
        liste1.setBounds(200,120,250,150);

        choixTypeCamp.setBounds(200, 300, 250, 25);
        String tabCamp[] = { "Type de campagne" };

        for (String string : tabCamp) {
            choixTypeCamp.addItem(string);
        }
        choixTypeCat.setBounds(900, 320, 250, 25);
        String tabCat[] = { "Catégorie" };

        for (String string2 : tabCat) {
            choixTypeCat.addItem(string2);
        }

        check1.setBounds(200, 350, 350, 25);

        gestionUser.setBounds(200,50,550,35);
        gestionUser.setFont(new Font("Sans-Serif", Font.BOLD, 40));
        creaUSer.setBounds(900,50,550,35);
        creaUSer.setFont(new Font("Sans-Serif", Font.BOLD, 40));

        nomUser.setBounds(900,120,400,25);
        mdpUser.setBounds(900,220,400,25);
        newMdp.setBounds(200,550,400,25);
        prenomUser.setBounds(900,180,400,25);
        loginUser.setBounds(900,150,400,25);

        panneauGestionUser.setLayout(null);
        
        this.getContentPane().add(this.panneauGestionUser);

        panneauGestionUser.add(this.btnRetour);
        panneauGestionUser.add(this.btnDeco);
        panneauGestionUser.add(this.btnQuitter);
        panneauGestionUser.add(this.liste1);
        panneauGestionUser.add(this.choixTypeCamp);
        panneauGestionUser.add(this.check1);
        panneauGestionUser.add(this.gestionUser);
        panneauGestionUser.add(this.creaUSer);
        panneauGestionUser.add(this.nomUser);
        panneauGestionUser.add(this.mdpUser);
        panneauGestionUser.add(this.newMdp);
        panneauGestionUser.add(this.choixTypeCat);
        panneauGestionUser.add(this.btnModifMdp);
        panneauGestionUser.add(this.btnSupprCompte);
        panneauGestionUser.add(this.btnValider);
        panneauGestionUser.add(btnCreer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRetour) {
            this.dispose();
            menu monMenu = new menu();
            monMenu.setBounds(650,350,300,150);
            monMenu.setVisible(true);
            monMenu.setResizable(false);
        } else if(e.getSource() == btnDeco) {
            this.dispose();
            login maPageLogin = new login();
            maPageLogin.setBounds(650,350,300,150);
            maPageLogin.setVisible(true);
            maPageLogin.setResizable(false);
        } else if(e.getSource() == btnQuitter){
            this.dispose();
        } else if(e.getSource() == btnValider) {
            JOptionPane.showMessageDialog(panneauGestionUser, "Informations modifiées");
        } else if(e.getSource() == btnCreer) {
            JOptionPane.showMessageDialog(panneauGestionUser, "Utilisateur créé");
        } else if(e.getSource() == btnModifMdp) {
            JOptionPane.showMessageDialog(panneauGestionUser, "Mot de passe modifié");
        }
        
    }
    
}