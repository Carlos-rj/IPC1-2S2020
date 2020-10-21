package clase18_08_20;

public class Persona {
    // ATRIBUTOS DE UNA PERSONA
    // Estamos usando encapsulamiento por lo tanto es recomendable
    // aplicar un tipo de acceso, en este caso usaremos private
    protected String nombre;
    private int edad;
    private char genero;
    private double altura;
    
    // METODOS
    // A la hora de seleccionar un atributo (variable)
    // Con click derecho -> refactor -> encapsulate fields
    // Obtenemos los metodos get y set de cada atributo
    // Considerado como una buena practica y es recomendable.
    // get -> obtengo el valor
    // set -> coloco el valor
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Creamos un metodo para "Presentarnos"
    // Estamos utilizando las variables de esta clase, a la hora
    // De hacer una instancia de una clase, ese objeto obtiene
    // Todos los atributos y metodos, por lo tanto, podemos
    // hacer metodos que trabajen con estos valores y funcionara de
    // igual manera
    public void Presentarse(){
        // Si declaramos una variable que ya fue declarada en el ambito global
        // El metodo reconocera su variable mas cercana, es decir la que esta
        // en el mismo ambito, para diferenciarla entre el ambito global y local
        // Utilizamos el prefijo "this.nombre_variable"
        // Para hacer referencia a ella, si en dado caso existiara
        // de lo contrario, podemos trabajar la variable normal.
        String nombre = "Variable de la Clase";
        System.out.println("Hola, mi nombre es: " + this.nombre);
        System.out.println("Tengo " + edad + " años");
        System.out.println("Mido " + altura);
        System.out.println("Mi genero es: " + genero);
    }
}
