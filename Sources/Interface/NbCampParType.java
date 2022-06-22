package Interface;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import Connection.ConnectionBDD;
import Connection.ConnectorMySQL;
import DAO.DAOCampagne;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.sql.Connection;


public class NbCampParType extends JFrame {

    // Connexion à la base 
    Connection connection = ConnectionBDD.getInstance(new ConnectorMySQL());
    DAOCampagne camp = new DAOCampagne(connection);

    public NbCampParType() {

        initUI();
    }

    private void initUI() {

        DefaultPieDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Pie chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,150,150);
    }

    private DefaultPieDataset createDataset() {

        var dataset = new DefaultPieDataset();
        
        final String urgence = "Urgence";
        final String information = "Information";
        final String marketing = "Marketing"; 

        dataset.setValue(urgence, camp.getNbType(urgence));
        dataset.setValue(information, camp.getNbType(information));
        dataset.setValue(marketing, camp.getNbType(marketing));

        return dataset;
    }

    private JFreeChart createChart(DefaultPieDataset dataset) {

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Nombre de campagne pour chaque type",
                dataset,
                true, true, true);
        
        return pieChart;
    }
}
