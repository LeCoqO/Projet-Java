package projetjava;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestionCampagne extends JFrame implements ActionListener {

    private JButton btnRetour = new JButton();
    private JButton btnDeco = new JButton();
    private JButton btnQuitter = new JButton();
    private JPanel panneauGestionCampagne = new JPanel();

    public gestionCampagne() throws IOException {
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

        panneauGestionCampagne.add(this.btnRetour);
        panneauGestionCampagne.add(this.btnDeco);
        panneauGestionCampagne.add(this.btnQuitter);

        btnRetour.setBounds(10,10,50,50);
        btnDeco.setBounds(10,150,50,50);
        btnQuitter.setBounds(10,290,50,50);
        btnRetour.addActionListener(this);
        btnDeco.addActionListener(this);
        btnQuitter.addActionListener(this);

        panneauGestionCampagne.setLayout(null);

        this.getContentPane().add(this.panneauGestionCampagne);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRetour) {
            this.dispose();
            menu monMenu = new menu();
            monMenu.setBounds(0,0,300,150);
            monMenu.setVisible(true);
        } else if(e.getSource() == btnDeco) {
            this.dispose();
            login maPageLogin = new login();
            maPageLogin.setBounds(0,0,300,200);
            maPageLogin.setVisible(true);
        } else if(e.getSource() == btnQuitter){
            this.dispose();
        }
        
    }
    
}