package Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class stats extends JFrame implements ActionListener{

    private JButton btnRetour = new JButton();
    private JButton btnDeco = new JButton();
    private JButton btnQuitter = new JButton();
    private JButton btnStats = new JButton("Stats");
    private JPanel panneauMenu = new JPanel();
    private JRadioButton btnRadCamp = new JRadioButton("Recherche par campagne");
    private JRadioButton btnRadDest = new JRadioButton("Recherche par destinataire");
    private JComboBox<String> choixListeCamp = new JComboBox<>();
    private JComboBox<String> choixListeDest = new JComboBox<>();
    
    public stats() throws IOException {
        super("Statistiques"); 

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

        String tabCamp[] = {"Liste des campagnes"}; 
        String tabDest[] = {"Liste des destinataires"};

        for (String string : tabDest) {
            choixListeDest.addItem(string);
        }
        for (String string2 : tabCamp) {
            choixListeCamp.addItem(string2);
        }   

        panneauMenu.add(this.btnRetour);
        panneauMenu.add(this.btnDeco);
        panneauMenu.add(this.btnQuitter);
        panneauMenu.add(this.btnStats);
        panneauMenu.add(btnRadCamp);
        panneauMenu.add(btnRadDest);
        panneauMenu.add(choixListeCamp);
        panneauMenu.add(choixListeDest);

        btnRetour.setBounds(10,60,50,50);
        btnDeco.setBounds(10,360,50,50);
        btnQuitter.setBounds(10,720,50,50);
        btnRetour.addActionListener(this);
        btnDeco.addActionListener(this);
        btnQuitter.addActionListener(this);
        
        btnStats.setBounds(1000,60,150,50);
        btnStats.addActionListener(this);

        btnRadCamp.setBounds(400, 20, 175, 20);
        btnRadDest.setBounds(600, 20, 180, 20);
        btnRadCamp.setSelected(true);
        btnRadDest.addActionListener(this);
        btnRadCamp.addActionListener(this);
        
        choixListeCamp.setBounds(150, 20, 175, 20);
        choixListeDest.setBounds(150, 20, 175, 20);
        choixListeDest.setVisible(false);

        ButtonGroup bg = new ButtonGroup();  
        bg.add(btnRadCamp);
        bg.add(btnRadDest);  

        panneauMenu.setLayout(null);
        
        this.getContentPane().add(this.panneauMenu);

    }

    public void actionPerformed(ActionEvent e) {
        if(btnRadCamp.isSelected()) {
            choixListeCamp.setVisible(true);
            choixListeDest.setVisible(false);
        } else if(btnRadDest.isSelected()) {
            choixListeCamp.setVisible(false);
            choixListeDest.setVisible(true);
        }

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
        } else if(e.getSource() == btnStats) {
            this.dispose();
            destParCamp maPageStats = new destParCamp();
            maPageStats.setBounds(0,0,1920,1080);
            maPageStats.setVisible(true);
            maPageStats.setResizable(false);
            maPageStats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }
}
