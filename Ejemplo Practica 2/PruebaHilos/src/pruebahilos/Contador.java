package pruebahilos;

import javax.swing.JOptionPane;

public class Contador implements Runnable {
    
    double [] numeros;
    Ventana vent;
    int pasos = 0;

    public Contador(double[] arreglo, Ventana vent) {
        this.numeros = arreglo;
        this.vent = vent;
    }
    
        
    @Override
    public void run() {
     try{
            double auxiliar;
            for(int i = 1; i < numeros.length; i++){
                for(int j = 0;j < numeros.length-i;j++){
                    if(numeros[j] > numeros[j+1])
                    {
                        auxiliar = numeros[j];
                        numeros[j] = numeros[j+1];
                        numeros[j+1] = auxiliar;
                        pasos++;
                    }
                Thread.sleep(50);
                vent.AgregarGrafico();
                System.out.println("Cantidad de pasos: " + pasos);
                //for(int k = 0; k < numeros.length; k++)
                //{
                    //System.out.print(numeros[k] + " ");
                //}
                    System.out.println("");
                //AgregarGrafico();
                }
            }
            System.out.println("SE TERMINO");

        }catch(Exception e){
            
        } 
    }    
}
