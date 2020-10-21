package clase06_09_20;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author carlo
 */
//Recuerden siempre extends JFrame implements ActionListener
public class Menu extends JFrame implements ActionListener {
    //Tenemos dos botoncitos
    JButton boton1, boton2;
    // Un arreglo de tipo persona que tendra 100 posiciones.
    Persona[] usuarios = new Persona[100];
    // Un contador global, que nos indica cuantas posiciones van llenas del contador
    int contador_usuarios = 0;
    // Este posY fue para demostrar el ejemplo de Tabla
    int posY = 50;
    // Esta matriz de Objetos nos la pide la tabla, vease la referencia en el material de apoyo
    // Object significa que puede ser cualquier cosa.
    Object[][] tabla;
    
    public Menu(){
        // CREAR UN BOTON
        boton1 = new JButton("Cargar Masiva");
        boton1.setBounds(50,50,200,50);
        boton1.setVisible(true);
        boton1.addActionListener(this);
        this.add(boton1);
        
        boton2 = new JButton("Mostrar Datos");
        boton2.setBounds(50,150,200,50);
        boton2.setVisible(true);
        boton2.addActionListener(this);
        this.add(boton2);
        
        // FORMULARIO
        this.setTitle("Ejemplo del FileChooser");
        this.setBounds(100,100,900,1000);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Lectura del archivo desde un CSV
        if(ae.getSource() == boton1)
        {
            // JFileChooser para abrir un archivo
        JFileChooser fc = new JFileChooser();
            // op es para guardar la seleccion del filechooser, si acepta o cancela
        int op = fc.showOpenDialog(this);
            // Si el usuario acepta, entonces...
        if(op == JFileChooser.APPROVE_OPTION)
        {
            try {
            // Para guardar la ruta del archivo que seleccionamos, usamos un toString()
            String ruta = fc.getSelectedFile().toString();
            
            // Usamos un getSelectedFile(), es un metodo propio del JFileChooser y sirve para
            // Obtener el File que seleccionamos.
            File archivo = fc.getSelectedFile();
            // Variables para hacer la lectura del archivo
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
         
            // Este metodo ya se lo sabe, leer linea por linea
             String linea;
             while((linea=br.readLine())!=null)
             {
                String [] datos = linea.split(",");
                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                double altura = Double.parseDouble(datos[2]);
                // Las diferentes formsa de agregar a un arreglo de usuarios
             
                // METODO 1 -> Guardar un objeto de ese tipo y guardarlo en la posicion
                //Persona nuevo = new Persona(nombre,edad,altura);
                //usuarios[contador_usuarios] = nuevo;
                
                // METODO 2 -> Guardar un objeto vacio de ese tipo y agregarle la informacion
                // con los metodos set
                //usuarios[contador_usuarios] = new Persona();
                //usuarios[contador_usuarios].setNombre(nombre);
                //usuarios[contador_usuarios].setEdad(edad);
                //usuarios[contador_usuarios].setAltura(altura);
                
                // METODO 3 -> Inicializar la posicion con el objeto como tal
                usuarios[contador_usuarios] = new Persona(nombre,edad,altura);
                
                // Como tenemos un contador global, cada vez que guardamos hay que agregar
                // Un ++ a nuestro contador, aplica con todos los vectores (En este caso)
                contador_usuarios++;
             }
         }
      catch(Exception e){
         e.printStackTrace();
      }   
        }
    }
    
    if(ae.getSource() == boton2)
    {
        // Mostrando los datos en una tabla
        // Nos guiamos en el ejemplo de los pfd, lo que hacemos aca es declarar la matriz con las posiciones
        // Donde fila es la cantidad de usuarios ingresados
        // Donde columna es la cantidad de datos que queremos mostrar en la tabla
        tabla = new Object[contador_usuarios][3];
        // Hacemos un for, para recorrer nuestro vector de usuarios
        for(int i = 0; i<contador_usuarios;i++)
        {
            // Como es para la tabla, guardamos las posiciones segun las columnas que queremos guardar
            // En este caso como son 3 columnas, pero esto depende de que datos quieran mostrar en su table
            tabla[i][0] = usuarios[i].getNombre();
            tabla[i][1] = usuarios[i].getEdad();
            tabla[i][2] = usuarios[i].getAltura();
        }
        // Este string es para agregar la columna a la tabla, referencia de los pdfs
        String[] columnas = {"Nombre","Edad","Altura"};
        
        // Segun el pdf, solo necesitamos crear una tabla y mandarle la matriz de los datos y el vector columna
        JTable table = new JTable(tabla, columnas);
        
        // Segun el pdf, creamos un ScrollPane para agregar la tabla
        JScrollPane sp = new JScrollPane(table);
        
        // En este caso, como trabajamos con un layout null, le aplicamos un setBounds al ScrollPane (Panel con scroll)
        sp.setBounds(300, posY, 500, 100);
        posY += 200;
        // El posY solo para que vean que se crean n objetos de estos por cada vez que se apacha el boton
        // Agregamos el sp a la ventana.
        this.add(sp);
        
    }
        
    }
    
}
