package clase01_09_20;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPrincipal extends JFrame implements ActionListener {

    // Componenetes
    public JButton boton1;
    public JButton boton2;
    public JButton boton3;
    public JButton boton4;
    
    // Objeto que usaremos para regresar a la otra ventana
    // Esta ventana es un objeto diferente al que tenemos en el main.
    public Ventana ventanita;
    
    // Arreglo para traer los datos
    public String[] arreglo;
    public int contador;
    public Usuario[] usuarios;

    // Este constructor maneja los arreglos para simular la traida de datos
    public MenuPrincipal(String [] datos, int cont, Usuario[] users){
        this.setBounds(100, 100, 400, 500);
        this.setTitle("Menu Principal");
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        
        boton1 = new JButton("Regresar");
        boton1.setBounds(100, 60, 150, 30);
        boton1.addActionListener(this); 
        this.add(boton1);
        
        boton2 = new JButton("Mostrar");
        boton2.setBounds(100, 160, 150, 30);
        boton2.addActionListener(this); 
        this.add(boton2);
        
        boton3 = new JButton("Presioname 3");
        boton3.setBounds(100, 260, 150, 30);
        boton3.addActionListener(this); 
        this.add(boton3);
        
        boton4 = new JButton("Presioname 4");
        boton4.setBounds(100, 360, 150, 30);
        boton4.addActionListener(this); 
        this.add(boton4);
        
        // Justo antes de terminar, a las variables locales les agregamos
        // Los datos que mandamos desde el constructor asi guardamos los datos anteriores.
        arreglo = datos;
        contador = cont;
        usuarios = users;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource() == boton1)
      {
          // Creamos el nuevo objeto, por lo tanto esta ventana
          // Se mostrara, por los metodos del constructor.
          ventanita = new Ventana(arreglo, contador, usuarios);
          // En este caso no estamos agregando ningun dato,
          // Pero si quisieramos modificar los datos lo hariamos con la clase
          // anterior, la cuestion es pasar los datos de clase en clase.
          Clase01_09_20.datos = arreglo;
          this.dispose();
      }
      else if(ae.getSource() == boton2)
      {
          // En este caso solo mostramos el arreglo que tenemos en el main
          // guardado en una variable llamada arreglo
          System.out.println("LOS USUARIOS QUE ESTAN DESDE EL MAIN SON");
          for(int i = 0; i<10; i++){
              System.out.print(usuarios[i].getNombre());
              System.out.print("-" + usuarios[i].getUser());
              System.out.print("-" + usuarios[i].getPass());
              System.out.println("");
          }
      }
    }
    
}
