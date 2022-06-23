package Interface;


import java.awt.event.*;

public class ecouteurBoutonConnection implements ActionListener {

    
    /** 
     * @param e
     * 
     * Action pour le bouton connexion sur la page de login
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Connexion de l'utilisateur");     
    }
    
}
