package clase22_09_20;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Para este caso vamos a usar la ventana como siempre
// Extends de un JFrame e Implemets de ActionListener
public class Interfaz extends JFrame implements ActionListener {

    // Declaramos todo lo necesario para hacer nuestra interfaz
    // Label que simulan al conejo y a la tortuga
    JLabel conejo = new JLabel("Conejo");
    JLabel tortuga = new JLabel("Tortuga");
    // Un boton para empezar la "carrera"
    JButton comenzar = new JButton("Comenzar");
    // Posiciones iniciales, puesto que queremos que se muevan de su posicion
    int posConejo = 10;
    int posTortuga = 10;
    
    // Metodo constructor, aqui armaremos nuestra interfaz
    public Interfaz(){
        // Recordemos que el this esta haciendo referencia a
        // este objeto como tal, por eso usamos el this
        // y como sabemos que es una ventana, nos provee todos los metodos de un JFrame
        
        // Quitarle el acomodamiento de componentes, es opcional
        // Como ustedes sientan mejor
        this.setLayout(null);
        // Agregamos las dimensiones
        this.setBounds(100,100,1000,400);
        // Dimensiones de los objetos
        conejo.setBounds(posConejo, 100, 50, 50);
        tortuga.setBounds(posTortuga, 200, 50, 50);
        comenzar.setBounds(10,0,100,50);
        
        // Agregamos los visible para que se vean en la interfaz
        conejo.setVisible(true);
        tortuga.setVisible(true);
        comenzar.setVisible(true);
        // Agregamos el ActionListener para que tome la accion del click
        comenzar.addActionListener(this);
        
        // Agregamos nuestros componentes
        this.add(conejo);
        this.add(tortuga);
        this.add(comenzar);
        
        // Hacemos visible nuestra ventana
        this.setVisible(true);
        // La opcion para que se cierre el programa cuando cerremos la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    // Este metodo nos sirve para mover la tortuga "un paso"
    // Esto es mero de este ejemplo y queremos que cada paso
    // La tortuga se mueva 10 a la derecha
    public void MoverTortuga()
    {
        // Aumentamos la variable global en 10
        posTortuga += 10;
        // Repintamos nuestro label, hay varias formas de hacerlo
        tortuga.setBounds(posTortuga, 200, 50, 50);
    }
    
    // Lo mismo sucede con conejo, a diferencia que el conejo se
    // Movera en 50, para simular que sus pasos son mas grandes
    public void MoverConejo()
    {
        posConejo += 50;
        conejo.setBounds(posConejo, 100, 50, 50);
    }

    // Metodo generado por el actionListener
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Este metodo captura el objeto que se le hizo un evento, en este caso
        // Es el boton llamado comenzar
    if(ae.getSource() == comenzar)
    {
        System.out.println("LA CARRERA HA EMPEZADO");
        // Carrera es un objeto de tipo Thread y aqui
        // Declaramos lo necesario para hacer que se simule
        // Una carrera, en este caso le mandamos el limite
        // y la ventana actual es decir el this, esto para
        // Poder llamar los metodos que simulan una "animacion"
        // dentro del objeto tipo hilo
        // Manden los datos que ustedes necesiten y sientan
        // Necesarios, pero no se les olvide mandar la ventana
        
        Carrera carrera = new Carrera(400, this);
    }
    }
    

    
    
    
    
}
