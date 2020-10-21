package clase22_09_20;

// CLASE RUNNABLE
// Este caso es muy parecido al Thread solo que no extendemos una clase del tipo Thread
// Si no que solo obtenemos sus metodos
// Agregamos el implements Runnable para que funciones
public class Liebre implements Runnable {
    // Declaramos los atributos necesarios
    String nombre;
    String color;

    // Ctrl + Barra Espaciadora para sacar el atajo de contructores
    public Liebre(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }
    
    // Como estamos usando una interfaz, se nos genera el metodo run
    // Que funciona exactamente igual como el del metodo Thread Tortuga
    @Override
    // ESTE METODO FUNCIONA EXACTAMENTE IGUAL QUE EL DE TORTUGA
    // A diferencia que aqui estamos usando atributos de nuestra
    // Clase para agregarle mas detalle a lo que estamos haciendo
    public void run() {
        try {
            System.out.println("SOY UNA LIEBRE Y ME LLAMO: " + nombre);
            int i = 0;
            while(i < 25){
                System.out.println("Salto de conejo: " + (i+1));
                Thread.sleep(500);
                i++;
               }
            System.out.println("TERMINO LA LIEBRE DE COLOR: " + color);
            } catch (InterruptedException ex) {
                System.out.println(ex.getStackTrace());
            }
    }
    
}
