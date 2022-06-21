package Interface;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;

public class destParCamp extends JFrame {

    public destParCamp() {

        initUI();
    }

    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        
        add(chartPanel);

        pack();
        setTitle("Diagramme en barre");
        setLocationRelativeTo(null);
        setBounds(0,0,150,150);
    }

    private CategoryDataset createDataset() {

        var dataset = new DefaultCategoryDataset();
        dataset.setValue(46, "Destinataires", "Campagne 1");
        dataset.setValue(19, "Destinataires", "Campagne 2");
        dataset.setValue(29, "Destinataires", "Campagne 3");
        dataset.setValue(22, "Destinataires", "Campagne 4");
        dataset.setValue(40, "Destinataires", "Campagne 5");
        dataset.setValue(56, "Destinataires", "Campagne 6");

        return dataset;
    }

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