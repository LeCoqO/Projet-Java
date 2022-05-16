package projetjava;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.AreaRendererEndType;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtils;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

public class stats extends JFrame implements ActionListener{

    private JButton btnRetour = new JButton();
    private JButton btnDeco = new JButton();
    private JButton btnQuitter = new JButton();
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
        panneauMenu.add(btnRadCamp);
        panneauMenu.add(btnRadDest);
        panneauMenu.add(choixListeCamp);
        panneauMenu.add(choixListeDest);

        btnRetour.setBounds(10,10,50,50);
        btnDeco.setBounds(10,150,50,50);
        btnQuitter.setBounds(10,290,50,50);
        btnRetour.addActionListener(this);
        btnDeco.addActionListener(this);
        btnQuitter.addActionListener(this);
        
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
        setTitle("Area chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset createDataset() {

        double[][] data = new double[][]{
                {82502, 84026, 85007, 86216, 85559, 84491, 87672,
                        88575, 89837, 90701}
        };

        CategoryDataset dataset = DatasetUtils.createCategoryDataset(
                new String[]{"Oil"}, new String[]{"2004", "2005", "2006",
                        "2007", "2008", "2009", "2010", "2011", "2012", "2013"},
                data
        );

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart chart = ChartFactory.createAreaChart(
                "Oil consumption",
                "Time",
                "Thousands bbl/day",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                true
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setForegroundAlpha(0.3f);

        AreaRenderer renderer = (AreaRenderer) plot.getRenderer();
        renderer.setEndType(AreaRendererEndType.LEVEL);

        chart.setTitle(new TextTitle("Oil consumption",
                new Font("Serif", java.awt.Font.BOLD, 18))
        );

        return chart;
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
