package pruebahilos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Ventana extends JFrame implements Runnable, ActionListener {
    public double [] numeros;
    JButton empezar = new JButton("Empezar");
    DefaultCategoryDataset datos;
    JFreeChart grafico_barras;
    JPanel jPanel1;
    ChartPanel panel;
    Thread hilo1, hilo2;
    int segundos;
    int pasos;
    
    public Ventana(double [] arreglo) throws HeadlessException {
    
        
        empezar.addActionListener(this);
        this.add(empezar, BorderLayout.NORTH);
        
        
        this.setTitle("El grafico");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(new FlowLayout());
        this.setSize(1500,750);  
        this.setVisible(true);
        this.setResizable(false);
        numeros = arreglo;
        datos = new DefaultCategoryDataset();
        for(int i = 0; i<numeros.length; i++){
            String valor = String.valueOf(numeros[i]);
            datos.setValue(numeros[i], "Numeros", valor);
        }

        jPanel1 = new JPanel();
        this.add(jPanel1,BorderLayout.CENTER);

        
        grafico_barras = ChartFactory.createBarChart3D("Calificaciones Java","Estudiantes", "Promedios",datos, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel CP = new ChartPanel(grafico_barras);
        CP.setPreferredSize(new Dimension(1400,650) );
        jPanel1.add(CP,BorderLayout.CENTER);
        jPanel1.validate();

        
    }

    public void AgregarGrafico(){
        datos.clear();
        for(int i = 0; i<numeros.length; i++){
            String valor = String.valueOf(numeros[i]);
            datos.setValue(numeros[i], "Numeros", valor);
        }
        
        //Se crea el gráfico y se asignan algunas caracteristicas
        grafico_barras = ChartFactory.createBarChart3D("Calificaciones Java","Estudiantes", "Promedios",datos, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel CP = new ChartPanel(grafico_barras);
        CP.setPreferredSize(new Dimension(1400,650) );
        
        jPanel1.removeAll();
        jPanel1.add(CP,BorderLayout.CENTER);
        jPanel1.validate();
        //System.out.println("Cantidad de pasos: " + pasos);
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
 
        while( ct == hilo2)
        {
            try {
                Thread.sleep(1000);
                segundos = segundos + 1;
            } catch (InterruptedException ex) {

            }
            
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == empezar)
         {
             Contador ctr = new Contador(numeros, this);
             
             hilo1 = new Thread(ctr);
             hilo1.start();
             
             
             hilo2 = new Thread(this);
             hilo2.start();
             
         }
     }
}
