package clase22_09_20;

public class Clase22_09_20 {

    // CLASE DE MANEJO DE HILOS EN JAVA
    // No corran todos juntos, no funciona xd
    public static void main(String[] args) {
        // Hilo por medio del Runnable
        // Es un objeto que tiene todos los metodos de un hilo
      //Liebre lb = new Liebre("Carlos","Negro");
        // Declaramos un objeto tipo Thread y le mandamos como 
        // Parametro el objeto que tiene los metodos del hilo
        // El objeto tiene que ser implements Runnable para que funcione
     // Thread hilo_liebre = new Thread(lb);
        // Hacemos el .start() para darle inicio al hilo.
     // hilo_liebre.start();
        
        // Hilo por medio de la clase Thread
     // Tortuga tg = new Tortuga();
        // Metodo para que empiece a funcionar el hilo, pero en 
        // el constructor de Tortuga lo declaramos para que iniciara
        // automaticamente

        //tg.start();
      
        // Llamamos a una clase JFrame como Interfaz, para
        // Interactuar los hilos con los componentes graficos
      Interfaz ventana = new Interfaz();
      
    }
    
}
