package practica1_2s2020;
import java.util.*;

public class Menu {

    int opcion = 0;
    Scanner sc = new Scanner(System.in);

    
    
    public void LlamarMenu(){
        do{
        System.out.println("Bienvenido a la practica 1");
        System.out.println("1. Cifrado");
        System.out.println("2. Descifrado");
        System.out.println("3. Gauss-Jordan");
        System.out.println("4. Salir");
            System.out.print("Opcion escogida: ");
            opcion = sc.nextInt();
            switch(opcion)
            {
                case 1:
                    Cifrado cifrado = new Cifrado();
                    cifrado.Metodo_Cifrado();
                    break;
                case 2:
                    System.out.println("METODO DESCIFRADO");
                    break;
                case 3:
                    GaussJordan gauss = new GaussJordan();
                    gauss.GaussJordan();
                    break;
                case 4:
                    System.out.println("Gracias por utilizar nuestro programa");
                    break;
            }
        }while(opcion != 4);
        
        
    }
}
