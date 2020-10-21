package clase01_09_20;

import java.awt.Color;

public class Clase01_09_20 {
    
    // Datos que vamos a trabajar globalmente
    
    // Con estas variables trabajaremos en todo el flujo del proyecto
    public static String[] datos = new String[10];
    public static int contador = 1;
    // Recordemos que cada arreglo tendra su propio contador
    public static Usuario[] usuarios = new Usuario[10];
    public static Clientes[] clientes = new Clientes[100];
    
    public static void main(String[] args) {
        // Antes de empezar, vamos a declarar un usuario administrador
        usuarios[0] = new Usuario("Carlos Jimenez","Admin","Admin");
        // Luego de eso, vamos a inicializar las demas posicion
        // Indicando que cada posicion del arreglo es un objeto del tipo usuairo
        for(int i = 1; i<10; i++){
            usuarios[i] = new Usuario();
        }
        
        // Hariamos lo mismo con los demas arreglos, en este caso
        // Clientes, Productos, Ventas, etc.
        
        //Lo que estamos haciendo es mandar los datos por medio del metodo
        //Constructor, en el metodo de la otra clase, le damos este valor
        //A variables que trabajaremos como globales dentro de cada clase
        Ventana ventanita = new Ventana(datos, contador, usuarios);
    }
    
}
