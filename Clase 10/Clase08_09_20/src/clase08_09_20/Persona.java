package clase08_09_20;

// Declaramos el metodo Persona como un metodo abstracto, agregando abstract antes del class
public abstract class Persona {

    // DEFINICIONES
    private String nombre;
    private int edad;
    private double altura;
    
    // En este caso solo definimos el metodo sin darle un cuerpo, para que las clases que sean de esta clase, puedan usarlo
    public abstract void saludar();
    
    // Constructor vacio
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.altura = 0;
    }

    // Constructor con parametros
    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }


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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
}
