package projetjava;

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
    private JPanel panneauGestionUser = new JPanel();

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

        panneauGestionUser.add(this.btnRetour);
        panneauGestionUser.add(this.btnDeco);
        panneauGestionUser.add(this.btnQuitter);

        btnRetour.setBounds(10,60,50,50);
        btnDeco.setBounds(10,360,50,50);
        btnQuitter.setBounds(10,720,50,50);
        btnRetour.addActionListener(this);
        btnDeco.addActionListener(this);
        btnQuitter.addActionListener(this);

        panneauGestionUser.setLayout(null);
        
        this.getContentPane().add(this.panneauGestionUser);
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
        }
        
    }
    
}