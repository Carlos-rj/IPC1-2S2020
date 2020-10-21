
package clase14_04_20;
// IMPORTANDO LAS LIBRERIAS
// java.io funciona para la lectura de archivos
import java.io.*;
import java.util.Scanner;

public class Clase14_04_20 {

    public static void main(String[] args) {
        // Convirtiendo un char a su valor ASCII
        char caracter = 'a';
        int valor_ascii = (int) caracter;
        System.out.println("Valor caracter: " + caracter + " Valor ASCII: " + valor_ascii);

        // Convirtiendo un ASCII a char
        int numero = 97;
        char letra = (char) numero;
        System.out.println("Valor numero (ASCII): " +numero+ " Valor char: " + letra);
        
        // Casteo implicito
        // ( tipo dato a castear ) variable
        // Esto no implica para Strings, solo para los tipos primitivos
        leer_archivos();
        
    }
    
     public static void leer_archivos(){
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         String direccion = "C:\\Users\\carlo\\Desktop\\Calificacion IPC1 Practica 1\\Calificacion IPC1 Practica 1\\Descifrado\\avanzado.txt";
         File archivo = new File (direccion);
         FileReader fr = new FileReader (archivo);
         BufferedReader br = new BufferedReader(fr);

         // Lectura del archivo
         String linea;
         // Matriz para guardar lo que viene en el archivo.txt
         int [][] matriz;
         int filas = 0;
         int columnas = 0;
         // Variable para guardar la cadena como tal
         String cadena_archivo = "";
         // La matriz va a tener la misma cantidad de columnas por fila.
         // Con un split podemos separar un string por un caracter 
         // en especifico, en este caso sabemo que vienen con ","
         while((linea=br.readLine())!=null){
            String [] fila = linea.split(",");
            // Ahora fila es un vector de tipo String
            // Separados por comas.
            // En esta variable se esta replicando el contenido
            // Del archivo y en mi caso utilizare un salto de linea
            cadena_archivo += linea + "\n";
            // Si imprimimos este vector tendremos la fila separada por comas
            for(int i = 0; i<fila.length;i++){
                System.out.print(fila[i] + " ");
            }
            // Luego de imprimir la fila, podemos darnos cuenta que
            // El tamaño del arreglo es igual a la cantidad de columnas
            // entonces
            columnas = fila.length;
            // En este caso estaremos leyendo linea por linea
            // Por cada linea, la fila aumenta en 1 y al terminar
            // de leer el archivo, filas tendira la cantidad total
            // de filas en el archivo, justo para la matriz.
            filas = filas + 1;
         }
      fr.close();
      // Con las dimensiones que encontramos, podemos definir nuestra matriz
      matriz = new int[filas][columnas];
          System.out.println("");
          System.out.println(filas);
          System.out.println(columnas);
      // Hasta este punto tenemos la matriz del tamaño del archivo
      // Y tambien tenemos una variable con el contenido del archivo
          //System.out.println(cadena_archivo);
      // El salto de linea, se puede representar con un \n
      // Si en este caso hago un split por el caracter \n me devolvera
      // fila por fila
          System.out.println("-------------------------------");
      String [] lineas_archivos = cadena_archivo.split("\n");
      for(int i = 0; i < lineas_archivos.length; i++){
          //System.out.println(lineas_archivos[i]);
          // Ya que tenemos liena por linea, podemos hacer un split por comas;
          // Guardamos la linea en otra variable
          String linea_actual = lineas_archivos[i];
          String [] numeros = linea_actual.split(",");
          // Tenemos dos vectores entonces.
          // Si recorremos este vector, tendremos caracter por caracter
          for(int j = 0; j< numeros.length; j++)
          {
              matriz[i][j] = Integer.parseInt(numeros[j]);
              //System.out.println("El valor en la fila " + i + " en la posicion " + j + " es: " + numeros[j]);
          }
      }
          for(int i = 0; i < filas; i++){
              for (int j = 0; j < columnas; j++)
                    {
                        System.out.print(matriz[i][j]+ " ");
                    }
                    System.out.println("");
                }
      }
      
      catch(Exception e){
         e.printStackTrace();
      }         
     }
     
     public static void llenar_matriz(){
         // Nuestro escaner para obtener valores de consola
        Scanner sc = new Scanner(System.in);
        String mensaje;
        // Vector donde guardaremos los caracteres
        char [] vector;
        // Guardamos la frase
        System.out.println("Ingrese la frase a cifrar");
        mensaje = sc.nextLine();
        // string.toCharArray() convierte un String en un arreglo de caracteres
        vector = mensaje.toCharArray();
        int tamaño = vector.length;
        int [][] matriz_mensaje;
        // Tomando por ejemplo que el vector sea de multiplo 4
        // El mensaje era "hola estudiantes"
        if(vector.length % 4 == 0)
            {
                int columnas = tamaño / 4;
                // FILAS = Multiplo
                // COLUMNAS = Cantidad / Multiplo
                matriz_mensaje = new int[4][columnas];
                // Variables que utilizo como iterador
                // Esta no es la unica forma
                // Hay bastantes formas de hacerlo, pero en mi caso
                // Utilizare dos variables como iteradores para las posiciones
                int fila = 0;
                int columna = 0;
                // Un recorrido para recorrer el vector de caracteres
                for(int i = 0; i < vector.length; i++)
                {
                    // Guardare la posicion i en las posiciones iterador
                    // Que estoy manejando
                    matriz_mensaje[fila][columna] = vector[i];
                    // Luego de guardar aumentare mi columna en 1
                    // Ya que ya guarde una posicion
                    columna++; 
                    
                    // Verifico si la columna que llene es multiplo
                    // De los indices de la matriz
                    // Esto me va a decir que ya llene una fila
                    // Tomando por ejemplo si fueran 16 caracter
                    // Sabemos que sus multiplos son 4,8,12
                    // Del 1 al 4 son la primera fila
                    // Del 5 al 8 son la segunda fila
                    // Y asi sucesivamente
                    if(columna % columnas == 0){
                        // Si esa condicion se cumple es decir
                        // Si ya llegue a la posicion multiplo
                        // Es porque debo de cambiar de fila
                        // fila++ es equivalente a fila = fila + 1;
                        fila++;
                        // Como es nueva fila, vuelvo 0 el valor
                        // columna, pues es mi iterador para la matriz
                        columna = 0;
                    }
                }
                
                // Al terminar este recorrido, tendremos la matriz llena 
                // con el mensaje
                
                // Solo para comprobar, imprimimos el valor de cada posicion de la matriz
                // Recuerden que para acceder a una matriz tenemos dos dimensiones
                for(int i = 0; i < 4; i++){
                    for (int j = 0; j < columnas; j++)
                    {
                        System.out.print(matriz_mensaje[i][j]+ " ");
                    }
                    System.out.println("");
                }
            }
     }
 }

