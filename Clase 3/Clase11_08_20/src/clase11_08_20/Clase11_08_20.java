package clase11_08_20;
import java.util.Scanner;

// METODO FILE WRITER
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

// METODO PRINT WRITER
import java.io.PrintWriter;

public class Clase11_08_20 {

    public static void main(String[] args) {
            //Arreglos();
            //Ejercicio();
            //Metodo1();
            //Metodo2();
    }
    
    public static void Arreglos(){
        Scanner sc = new Scanner(System.in);
        // DECLARAR VECTORES DE TAMAÑO FIJO
        int [] Numeros = new int[10];
        int [] Numeros2;
        
        // ASIGNANDO VALOR A UN ARREGLO
        // Nombre_Variable [ indice ] = VALOR
        // # de Elemento no es lo mismo que el indice
        Numeros[0] = 25;
        Numeros[1] = 15;
        // Guardar el numero 50 en el # de elemento 7
        Numeros[6] = 50;
        // Guardar el numero 100 en la posicion 10
        Numeros[9] = 100;
        // ERROR POR QUE EL VECTOR NO TIENE ESA POSICION
        // PORQUE POSICION 10 -> ELEMENTO 11
        // Numeros[10] = 2000;
        
        // METODO PARA ASIGNAR UN VALOR A UN ARREGLO A UNA POSICION 
        // EN ESPECIFICO EN EL VECTOR Numeros2
        int tamaño;
        System.out.print("Ingresar el tamaño del arreglo: ");
        tamaño = sc.nextInt();
        Numeros2 = new int[tamaño];
        int posicion, valor;
        System.out.print("En que posicion del arreglo quiere guardar el dato: ");
        posicion = sc.nextInt();
        System.out.print("Que valor quiere guardar en el arreglo: ");
        valor = sc.nextInt();
        if(posicion < tamaño){
                Numeros2[posicion] = valor;
        }else{
            System.out.println("La posicion no es valida");
        }

        // OBTENER VALORES DEL ARREGLO
        // Se le pide obtener un valor de Numeros2
        // en una posicion en especifico por medio de consola
        int posicion2;
        System.out.print("Cual es la posicion a consultar: ");
        posicion2 = sc.nextInt();
        int valor2 = Numeros2[posicion2];
        System.out.println("El valor en la posicion " + posicion2 + " es: " + valor2);
        // System.out.println(Numeros2[posicion2]);
        
        // RECORRIENDO UN ARREGLO
        // Se le solicita que obtenga todos los valores del vector
        // Numeros y que se muestren en consola con su indice
        // Nombre del Vector.length = Cantidad de elementos para ese vector
        int tamaño2 = Numeros.length;
        // Condicion = i < Numeros.length
        for(int i = 0; i < tamaño2; i++){
            // PARA GUARDAR UN DATO
            // Numeros[i] = sc.nextInt();
            System.out.println("Valor: " + Numeros[i] + " - Indice: " + i);
        }
    }
    
    public static void Ejercicio(){
        //Se le solicita al estudiante que haga una aplicación 
        //en consola que pueda registrar 5 notas (Un numero del 1 al 100)
        //y luego mostrar el índice y el valor de las notas que son arriba de 61.
        int [] Notas = new int[5];
        
        // ARREGLO DE CHARS
        // Si a un char le agregan un numero
        // Este guardara su valor en en representacion ASCII
        // Para un char se guarda con comilla simple
        char [] Vocales = new char[5];
        Vocales[0] = 65;
        Vocales[1] = 66;
        Vocales[2] = 67;
        Vocales[3] = 68;
        Vocales[4] = 69;
        
        // ARREGLO DE STRINGS
        // El string es una cadena de texto, en este
        // Si se utilizan comillas dobles
        String [] Palabras = new String[5];
        Palabras[0] = "Hola";
        Palabras[1] = "Mundo";
        Palabras[2] = "-----";
        Palabras[3] = "Si sale";
        Palabras[4] = "IPC1";
        
        
        Scanner sc = new Scanner(System.in);
        // Guardando las notas
        for(int i = 0; i<Notas.length; i++)
        {
            System.out.print("Ingrese la nota: ");
            int nota = sc.nextInt();
            if(nota>0 && nota<=100){
                Notas[i] = nota;            
            }
        }
        // Recorriendo las notas
        for(int i = 0; i<Notas.length; i++)
        {
            if(Notas[i] > 60){
    System.out.println("El indice: " + i + " tiene una nota de: " + Notas[i]);
            }
        }
        
        // Recorriendo las vocales
        for(int i = 0; i<Vocales.length; i++)
        {
        System.out.println("El indice: " + i + " tiene la letra: " + Vocales[i]);
        }
        
        // Recorriendo las palabras
        for(int i = 0; i<Palabras.length; i++)
        {
        System.out.println("El indice: " + i + " tiene la palabra: " + Palabras[i]);
        }
        
        // Como se guardaria una matriz, con posicion por posicion
        // para eso se utilizan los fors, para llenar de manera
        // mas sencilla las posiciones y no estar escribiendo estas
        // lineas de codigo, ver la clase anterior
        /*
        int [][] Matriz = new int [10][10];
        Matriz[0][0] = 1;
        Matriz[0][1] = 2;
        Matriz[0][2] = 3;
        Matriz[0][3] = 4;
        Matriz[0][4] = 5;
        Matriz[10][10] = 100;
        */

    }
    
    // Metodo BufferedWriter
    public static void Metodo1(){
        try {
            // ASEGURENSE QUE LA RUTA EXISTA
            String ruta = "Archivos/Texto.txt";
            // Eviten a toda costa = "C:\Users\nombre equis\Documents\NetBeansProjects\Clase11_08_20"
            String contenido = "Texto a guardar";
            String contenido2 = "Hoy si sale IPC1";
            File file = new File(ruta);
            // File file = new File("Archivos/Texto.txt");

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            // Librerias fileWriteer y BufferedWriter
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.write("\n");
            bw.write(contenido2);
            bw.write("\n");
            bw.write("CUALQUIER COSA");
            bw.write("\n");
            bw.write("xd");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Metodo PrintWriter
    public static void Metodo2(){
        // Ejemplo de un archivo HTML desde consola
        try {
            String ruta = "Archivos/Reporte.html";
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            writer.println("<HTML>");
            writer.println("<BODY>");
            writer.println("<h1> REPORTE DE CIFRADO </h1>");
            writer.println("<h3> SE INGRESO LA MATRIZ... </h3>");
            for(int i = 0; i < 3; i++){
            writer.println("<table class=\"egt\">");
            writer.println("<tr>");
            writer.println("<td>Celda 1</td>");
            writer.println("<td>Celda 2</td>");
            writer.println("<td>Celda 3</td>");
            writer.println("</tr>");
            writer.println("<tr>");
            writer.println("<td>Celda 4</td>");
            writer.println("<td>Celda 5</td>");
            writer.println("<td>Celda 6</td>");
            writer.println("</tr>");
            writer.println("</table>");
                
            }
            writer.println("</BODY>");
            writer.println("</HTML>");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
