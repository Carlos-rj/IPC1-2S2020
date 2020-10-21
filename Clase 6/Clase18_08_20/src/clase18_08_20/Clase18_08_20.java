package clase18_08_20;
import java.util.*;
/**
 *
 * @author carlo
 */
public class Clase18_08_20 {

    public static void main(String[] args) {
        // CASTEO IMPLICITO
        char caracter = 'A';
        int numero = caracter;
        System.out.println(numero);
        
        // CASTEO EXPLICITO
        int numero2 = 65;
        char caracter2 = (char) numero2;
        System.out.println(caracter2);
        
        
        // INSTANCIA DE UNA CLASE
        Persona Carlos = new Persona();
        
        // INFORMACION SETTEADA
        Carlos.setNombre("Carlos Jimenez");
        Carlos.setEdad(22);
        Carlos.setGenero('M');
        Carlos.setAltura(1.78);
        
         //MOSTRAR LA INFORMACION
        System.out.println("El nombre de la persona es: " + Carlos.getNombre());
        System.out.println("La edad de " + Carlos.getNombre() + " es: " +Carlos.getEdad());
        
        // USANDO UN METODO DECLARADO EN SU PROPIA CLASE
        Carlos.Presentarse();
        
        // CLASES HEREDADAS
        // Estudiante hereda los atributos y metodos de Persona
        Estudiante estudiante = new Estudiante();
        
        // CLASE PERSONA, USADA EN ESTUDIANTE
        estudiante.setNombre("Carlos Jimenez");
        estudiante.setEdad(22);
        estudiante.setGenero('M');
        estudiante.setAltura(1.78);
        estudiante.Presentarse();
        
        // PROPIEDADES DE LA CLASE ESTUDIANTE
        estudiante.setCarnet(201504143);
        estudiante.setCarrera("Sistemas :D");
        estudiante.setNota(99);
        // Solo valores Si y No
        estudiante.setPractica("Si");
        estudiante.ComprobarPractica();

        // Scanner para obtener valores dentro del teclado
        Scanner sc = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        
        // Declarando un vector de objetos.
        Persona [] personas = new Persona[3];
 
        // A la hora de declarar un vector de objetos, hay que hacer
        // La instancia de cada uno de los objetos, en este caso
        // Unicamente estamos reservando el espacio que sera un arreglo de 3
        // posiciones, mi recomendacion es que se haga un recorrido antes de
        // todo, para inicializar los valores.

        // INICIALIZANDO LOS VALORES
        for(int i = 0; i<3; i++)
        {
            // Cada posicion del vector, es una nueva instancia de Persona
            personas[i] = new Persona();
        }
        
        // LLENANDO EL VECTOR CON INFORMACION POR MEDIO DE UN RECORRIDO
        for(int i = 0; i<3; i++)
        {
            //Accedemos a la posicion del vector y con los metodos
            //Que creamos al encapsular, podemos darle un valor

            System.out.print("Ingrese el nombre de la persona: ");
            personas[i].setNombre(sc.nextLine());

            System.out.println("Ingrese la edad de la persona: ");
            personas[i].setEdad(num.nextInt());
        }

        // RECORRIDO PARA OBTENER LA INFORMACION OBTENIDA
        for(int i = 0; i<3; i++){
            // Tenemos un metodo que muestra la informacion
            // Segun lo obtenido anteriormente
            personas[i].Presentarse();
        }
    }
    
}
