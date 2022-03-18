    
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 *
 * @author Quentin LUSTIERE
 */
public class Frame extends JFrame {

    private JButton boutonConnexion = new JButton("Connexion");
    private JLabel etiquette_user = new JLabel("Username ");
    private JTextField champTexte_user = new JTextField("", 20);
    private JLabel etiquette_pswd = new JLabel("Password ");
    private JTextField champTexte_pswd = new JTextField("", 20);
    private JPanel panneau = new JPanel();
    private BufferedImage image;

    protected void paintComponent(Graphics g) throws IOException {
        image = ImageIO.read(new File("C:\\Users\\chatd\\OneDrive - LECNAM\\Bureau"));
        g.drawImage(image, 0, 0, null);
    }

    public Frame() {
        super("Classe Fenetre");
        this.setBounds(100, 100, 960, 640);
        panneau.add(this.etiquette_user);
        panneau.add(this.champTexte_user);
        panneau.add(this.etiquette_pswd);
        panneau.add(this.champTexte_pswd);
        add(this.boutonConnexion);

        boutonConnexion.setBounds(100, 100, 200, 300);

        champTexte_user.addKeyListener(new EcouteurChampTexte());
        champTexte_pswd.addKeyListener(new EcouteurChampTexte());
        this.boutonConnexion.setEnabled(false);

        this.getRootPane().setDefaultButton(boutonConnexion);

        this.getContentPane().add(this.panneau);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonConnexion) {
            System.out.println(this.champTexte_user.getText() + " | " + this.champTexte_pswd.getText());

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
