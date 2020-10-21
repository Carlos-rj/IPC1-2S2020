package clase22_09_20;

// METODO DEL THREATH
// Primero hacemos un extends a un Thread para heredar sus atributos.
public class Tortuga extends Thread {

    // Metodo constructor que se ejecuta al inicializar un objeto
    public Tortuga() {
        // Esto es opcional, pero desde el contructor le estamos diciendo
        // que empiece el hilo
        // el this.start(); hace el llamado al metodo run
     this.start();
    }
    
    // METODO RUN, metodo que llama el metodo start()
    // Este metodo es el cuerpo del hilo, son las sentencias que va a hacer
    // Cuando se le indique que empiece
    public void run(){
        // Porque estamos trabajando con el Thread.sleep hay que poner un try-catch si o si.
            try {
                // Sentencias varias para demostrar la ejecucion
            System.out.println("SOY UNA TORTUGA");
            int i = 0;
            while(i < 10){
                if(i == 5){
                    Saludar();
                }
                System.out.println("Paso de tortuga: " + (i+1));
            // LO MAS IMPORTANTE ES DARLES LAS PAUSAS PARA QUE VEAMOS EN EJECUCION QUE PASA
            // En si, los programas funcionan tan rapido, en cuestion de milesimas que no
            // es facil verlo para nosotros, pero si usamos el Thread.sleep()
            // Le daremos una pausa a la ejecucion actual en milesimas de segundos
            // RECUERDEN = 1000 milesimas = 1 seg
                Thread.sleep(2500);
                i++;
               }
                System.out.println("TERMINO LA TORTUGA");
            } catch (InterruptedException ex) {
                System.out.println(ex.getStackTrace());
            }
    }
    
    public void Saludar()
    {
        try{
        System.out.println("Aaah");
        Thread.sleep(5000);
        System.out.println("Termino saludo");
        }catch(Exception e)
        {
            
        }
    }
    
}
