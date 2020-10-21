package clase01_09_20;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener {
    // COMPONENTES
    //Entradas de texto
    public JTextField texto1, texto2;
    //Entrada de texto tipo Password
    public JPasswordField texto3;
    //Boton
    public JButton boton1;
    //Etiquetas en el frame
    public JLabel etiqueta, etiqueta2, etiqueta3;
    
    // Instancia de la otra ventana, esta ventana abrira MenuPrincipal
    // Dado sea el caso, deberian de crear una variable por cada ventana
    public MenuPrincipal menu;


    // VARIABLES para los datos
    public String nombre, username, password;
    
    // Arreglos con los que trabajaremos dentro de esta ventana.
    public String[] arreglo;
    public int contador;
    public Usuario[] usuarios;
    
    // En este caso nuestro constructor le definimos las variables que vamos a utilizar
    // Esto para que cumpla su funcion de recibir los datos
    // En este caso recibe un arreglo de String, un contador y un arreglo de Usuario
    public Ventana(String [] info, int cont, Usuario[] users){
        //setBounds es para la posicion y el tamaño
        // PosX, PosY, Ancho, Altura
        this.setBounds(100, 100, 500, 500);
        //setTitle para colocar el titulo
        this.setTitle("Proyecto 1");
        //setLayout, para que los demas componentes no se pongan 
        //en donde quieran, si no donde nosotros indiquemos
        this.setLayout(null);
        //setVisible, si la ventana es visible
        this.setVisible(true);
        //Para que al cerrar, termine el programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Para que tenga un tamaño
        this.setResizable(false);
        
        //Metodo de CrearComponentes
        CrearComponentes();
        

        // Antes de terminar el constructor, le decimos que
        // En nuestras variables locales, guarde el valor que le mandamos
        // Por medio de los parametros, para crear un "consistencia de datos" entre ventanas
        arreglo = info ;
        contador = cont;
        usuarios = users;
        // RecorrerUsuarios();
    }
    
    public void RecorrerUsuarios(){
        // Este metodo utiliza la variable local, como ya copiamos los datos
        // Desde el metodo constructor, no hay ningun problema
        for(int i = 0; i<usuarios.length; i++){
            System.out.print("Usuarios: " + usuarios[i].getNombre());
            System.out.print(", Username: " + usuarios[i].getUser());
            System.out.print(", Password: " + usuarios[i].getPass());
            System.out.println("");
            
        }
    }
    
    public void CrearComponentes(){
        // Creando la etiqueta - JLabel
        etiqueta = new JLabel("Nombre");
        // Dimension
        etiqueta.setBounds(50, 50, 100, 50);
        // Siempre visible
        etiqueta.setVisible(true);
        // this.add es para agregar el elemento al componente.
        this.add(etiqueta);
        
        // Mas etiquetas
        etiqueta2 = new JLabel("Username");
        etiqueta2.setBounds(50, 150, 100, 50);
        etiqueta2.setVisible(true);
        this.add(etiqueta2);
        
        etiqueta3 = new JLabel("Password");
        etiqueta3.setBounds(50, 250, 100, 50);
        etiqueta3.setVisible(true);
        this.add(etiqueta3);
        
        // Creando una entrada de texto - JTextField
        texto1 = new JTextField();
        texto1.setBounds(150, 60, 100, 30);
        texto1.setVisible(true);
        this.add(texto1);
        
        texto2 = new JTextField();
        texto2.setBounds(150, 160, 100, 30);
        texto2.setVisible(true);
        this.add(texto2);
        
        texto3 = new JPasswordField();
        texto3.setBounds(150, 260, 100, 30);
        texto3.setVisible(true);
        this.add(texto3);
        
        // Creando un boton - JButton
        boton1 = new JButton("Registrar");
        boton1.setBounds(300, 60, 150, 30);
        // Agregar acciones
        boton1.addActionListener(this); 
        boton1.setVisible(true);
        this.add(boton1);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //ae es el ActionEvent y lo igualamos al componente
        //En este caso sera un boton
        if(ae.getSource() == boton1){
            //Para obtener el contenido de un jTextField
            nombre = texto1.getText();
            username = texto2.getText();
            password = texto3.getText();

            // Mensaje emergente con JOptionPane
            JOptionPane.showMessageDialog(this, "Bienvenido " + nombre);

            //Creamos la instancia de la ventana, esta ventana no es la
            //misma que creamos anteriormente, es un objeto diferente
            //Por lo tanto, todos los datos que tenemos en la ventana anterior
            //Se perderan.

            //En este caso, estamos trabajando con variables globales que ya tienen
            //Los datos que se trabajaron en la ventana anterior.
            //Por lo tanto, debemos de trabajar con las variables locales
            //De tal manera que tengamos el control de los mismos datos
            //En variables diferentes por cada ventana.

            //En este caso, tenemos un arreglo llamado usuario y solo lo agregaremos
            //Al arreglo como tal, sin ninguna condicion
            usuarios[contador] = new Usuario(nombre, username, password);
            // aumentamos el contador, es como un metodo de insertar
            contador++;


            // Mandamos los datos por medio del constructor,
            // Este es el constructor de la clase MenuPrincipal
            // Con esto se crea un "Persistencia de datos"
            menu = new MenuPrincipal(arreglo, contador, usuarios);
            
            //El dispose, es para cerrar la ventana
            this.dispose();
        }
    }

    
}
