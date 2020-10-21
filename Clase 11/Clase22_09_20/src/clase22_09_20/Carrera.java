package clase22_09_20;

// Es una clase de tipo Thread
// Aplicamos el extendes Thread para convertirla en un hilo
public class Carrera extends Thread {
    // En este caso necesitamos el limite para el proceso a realizar
    // Y un objeto que tome la ventana anterior, donde se guarde
    // la ventana que mandamos por el constructor
    int limite;
    Interfaz ventana;
    // Este es otro Thread, estamos usando Thread dentro de Threads
    Cronometro reloj;

    // El metodo constructor con sus parametros necesarios
    // Ctrl + barra para obtener todos los posibles constructores
    public Carrera(int limite, Interfaz ventana) {
        this.limite = limite;
        this.ventana = ventana;
        // Agregamos el start para empezar el procesos
        this.start();
        // Iniciamos el hilo del reloj tambien,
        // Este hilo es diferente de el actual
        // Pero los estamos corriendo "juntos"
        reloj = new Cronometro();
        }

    // Metodo Run que ejecuta el metodo start
    public void run(){
        // No olvidemos el try-catch()
        try{
            //En este caso necesitamos las posiciones
            // de los objetos, como en nuestra clase manejamos esa informacion
            // Entonces ventana replica toda esa informacion
        int posConejo = ventana.posConejo;
        int posTortuga = ventana.posTortuga;
        //En este caso lo cambie a un while true, la cuestion es un ciclo
        // Que este corriendo hasta que se cumpla una condicion
        while(true)
        {
            // Si la posicion del conejo es mayor al limite
            // Si la posicion de la tortuga es mayor al limite
            if(posConejo > limite || posTortuga > limite){
                // Paramos nuestro hilo Reloj, no es recomendable
                // Hacer el .stop(), ya que destruye el hilo
                // Pero como cada vez que iniciamos la clase
                // Iniciamos este objeto, entonces no hay problema
                reloj.stop();
                // Break para salir del while.
                break;
            }
            // Llamamos los metodos de la ventana anterior
            // Hagamos de cuenta que el proceso de ventana fue.
            // Del main se creo una variable llamada ventana
            // dentro de esos metodos le dijimos que se mandara a si misma
            // a este objeto, entonces realmente estamos haciendo
            // referencia a la ventana que esta en el main
            // con todos sus objetos como tal
            
            // Por eso podemos llamar los metodos de "Mover"
            // Como no estamos creando un nuevo objeto ni nada
            // Si no que estamos trabajando con el mismo objeto siempre
            // Se logra visualizar el cambio
            ventana.MoverConejo();
            ventana.MoverTortuga();
            
            // Agregamos una pausa, cada paso se dara cada segundo
            Thread.sleep(1000);
            
            // Actualizamos las posiciones para que el while tenga
            // una manera de salir.
            posConejo = ventana.posConejo;
            posTortuga = ventana.posTortuga;
        }
                  
        }catch(Exception e)
        {
        }
    }   
}
