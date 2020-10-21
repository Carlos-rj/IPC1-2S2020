package clase22_09_20;

// El hilo para el cronometro
// Siempre que trabajemos con hilos, hacemos un extendes a Thread
public class Cronometro extends Thread {
    // Declaramos las variables necesarias
    int segundos = 0;
    int milesimas = 0;
    
    // El constructor, esto indica que se hara cuando se inicializa el objeto
    public Cronometro() {
        // Le decimos que llame su metodo start, que este metodo llama al metodo run
        this.start();
    }
    

    public void run(){
        while(true)
        {
            // Sera un metodo que siempre esta corriendo
            try{
                // Se hace un Sleep de ese proceso, pero ese proceso no esta haciendo nada
                // visual por lo tanto no afecta en nada
                // Guardamos las milesimas que van transcurriendo
            Thread.sleep(5);
            milesimas += 5;
            
            // Antes de repetir el ciclo verificamos,
            // RECUERDEN: 1000 milesimas -> 1 segundo
            if(milesimas == 1000)
               {
                   segundos++;
                   milesimas = 0;
               }
            // Imprimimos el tiempo que va corriendo
            System.out.println("Segundos: " + segundos +" Milesimas: " + milesimas);    
            }catch(Exception e)
            {
                
            }
            
        }
    }
    
}
