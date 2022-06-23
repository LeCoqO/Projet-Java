package Interface;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import Connection.ConnectionBDD;
import Connection.ConnectorMySQL;
import DAO.DAOCampagne;
import DAO.DAOCampagneLocataire;
import DAO.DAOLocataire;
import Entity.Campagne;
import Entity.Campagne_Locataire;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class destParCamp extends JFrame {

    // Connexion à la base
    Connection connection = ConnectionBDD.getInstance(new ConnectorMySQL());
    DAOCampagne camp = new DAOCampagne(connection);
    DAOCampagneLocataire campLoc = new DAOCampagneLocataire(connection);
    DAOLocataire loc = new DAOLocataire(connection);

    public destParCamp() {

        initUI(); // On initaialise l'interface utilisateur
    }

    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset); // On créer le graphique
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        add(chartPanel);

        pack();
        setTitle("Diagramme en barre");
        setLocationRelativeTo(null);
        setBounds(0, 0, 150, 150);
    }

    
    /** 
     * @return CategoryDataset
     * 
     * Pour toutes les campagnes on lit le nombre de destinataires
     * 
     * Dataset sert à mettre les valeurs dans le graphique
     */
    private CategoryDataset createDataset() {

        List<Campagne> allCampagne = new ArrayList<>(camp.getAll()); // On récupère les campagnes depuis la base

        List<Campagne_Locataire> allCampagneLocataire = new ArrayList<>(campLoc.getAll());


        var dataset = new DefaultCategoryDataset();

        int nombreLocataire = 0;

        for (Campagne t : allCampagne) {
            nombreLocataire = 0;
            for (int i = 0; i < allCampagneLocataire.size(); i++) {
                if (t.getId() == allCampagneLocataire.get(i).getIdCampagne()) {
                    nombreLocataire++;
                }
            }
            dataset.setValue(nombreLocataire, "Destinataires", t.getTitre());
        }

        return dataset;
    }

    
    /** 
     * @param dataset
     * @return JFreeChart
     * 
     * On créer le diagramme avec ses informations
     */
    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "Nombre de destinataires par campagne",
                "",
                "Destinataires",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }
}