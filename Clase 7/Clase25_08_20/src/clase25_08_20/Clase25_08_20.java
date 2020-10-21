package clase25_08_20;
import java.util.Scanner;
public class Clase25_08_20 {

    public static void main(String[] args) {
        //El scanner de toda la vida
        Scanner sc = new Scanner(System.in);
        Scanner numeros = new Scanner(System.in);
        
        // Variables para almacenar en el main
        String nombre;
        int edad;
        double altura;
        
        // CREANDO UN OBJETO
        // En este caso si se inicializa automaticamente
        // Usamos el constructor que trae por defecto
        Persona humano = new Persona();
        
        //En este caso usamos el constructor con los datos para que lo inicialice directamente
        Persona auxiliar = new Persona("Carlos",22,1.78);
        
        //Recordemos que humano y auxiliar son dos objetos distintos, cada uno tiene sus propios valores
        //Y El hecho de obtener la informacion de auxiliar no es lo mismo que humano
        
        // ESTOY CREANDO EL ARREGLO
        // Hay que inicializar cad uno de sus posiciones
        Persona [] personas = new Persona [3];
        // PARA ACCEDER A SUS METODOS, este es unicamente para acceder a los metodos
        // Se peude llamar como ustedes quieran.
        Persona clase_persona = new Persona();
        
        for(int i=0; i<personas.length; i++)
        {
            System.out.println("Ingresar el nombre: ");
            nombre = sc.nextLine();
            System.out.println("Ingresar la edad");
            edad = numeros.nextInt();
            System.out.println("Ingresar la altura");
            altura = numeros.nextDouble();
            //En este caso hacemos uso del constructor
            //Para inicializar que esa posicion es una persona y 
            //Que se construye con los datos que recolectamos
            //Esta informacion "viaja" por medio de los parametros
            personas[i] = new Persona(nombre,edad,altura);
        }
        
        //El objeto que creamos para llamar sus metodos, llamamos el metodo de LeerNombres
        //Este hay que mandarle un parametro de un arreeglo de objetos tipo Persona
        clase_persona.LeerNombres(personas);
        
        
    }
        
}
