package clase25_08_20;


public class Persona {
    // ATRIBUTOS DE LA CLASE PERSONA
    private String nombre;
    private int edad;
    private double altura;

      // METODO CONSTRUCTOR POR DEFECTO
      // HAY QUE ESCRIBIRLO SI QUEREMOS MODIFICAR ALGO EN EL
    public Persona() {
        System.out.println("Hola, soy un humano");
    }

    // POLIMORFISMO
    // METODO CONSTRUCTOR CON PARAMETROS
    public Persona(String nombre)
    {
        this.nombre = nombre;
        System.out.println("Los demas datos no fueron otorgados");
    }
 
    // CUANDO MANDAMOS A LLAMAR UN METODO TIENEN QUE VENIR EN EL MISMO ORDEN 
    // PARA QUE NO HAYA CONFUSION A LA HORA GUARDARLOS
    // COMO LES EXPLIQUE EL VALOR MANDANDO ES EL QUE SE "REEMPLAZA"
    // EN EJECUCION
    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        System.out.println("Creaste un humano con datos");
    }
    // EJEMPLO DEL REEMPLAZO
    /* Persona("Paco",18,1.79){
        this.nombre = "Paco";
        this.edad = 18;
        this.altura = 1.79;
        sout("Creaste un humano con datos");
    */

    //Metodo con 2 parametros, mostrando la diferencia entre el this. y la variable local
    public Persona(String nom, int edd){
        //En este caso las variables nom y edd, al momento de declarar el metodo
        //Es como si las estuvieramos declarando aqui adentro y que lo primero
        //Que va a hacer es declarar estas varaibles, es decir
        //String nom = ""
        //in edd = ""
        // Como en este caso, no hay otra variable que se llame igual que la variable
        // Global, no es necesario utilizar el this.
        nombre = nom;
        edad = edd;
    }

    // FUNCION
       //La funcion tiene un tipo de dato que retornar puede ser cualquier
       //Tipo de dato, incluso pueden ser objetos y tiene un return
        //Este return debe de ser del mismo tipo
    public String getNombre() {
        return nombre;
    }
    
    // METODO
        // Un metodo es un metodo "void" y esto significa que no retorna nada
        // Si es valido usar un return pero no serviria de nada, solo para 
        // Terminar el metodo, pero en este caso no es necesario
        // Como ven le mandamos un parametro con el mismo nombre
    public void setNombre(String nombre) {
        //Es como que lo primero por hacer es esto
        //String nombre;
        //A la hora de llamarlo setNombre("Carlos");
        //Lo primero que hace el codigo es.
        //String nombre = "Carlos";
        //Como ya hay una variable local llamada nombre, usamos el this.
        //Para decirle que usaremos una variable de tipo global.
        this.nombre = nombre;
    }

    // LOS DEMAS METODOS DEL ENCAPSULAMIENOT
    // Recordemos, Click derechos + Refactor + Encapsulate Fields
    // Para generar estos metodos automaticamente
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    //En este caso hicimos un metodo, que recibe como parametro
    //Un arreglo de objetos del tipo Persona
    public void LeerNombres(Persona[] personas)
    {
        for(int i = 0; i<personas.length; i++)
        {
            System.out.println("Nombre es: " + personas[i].getNombre());
        }
    }
}
