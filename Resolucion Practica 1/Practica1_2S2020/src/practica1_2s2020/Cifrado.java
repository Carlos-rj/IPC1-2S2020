package practica1_2s2020;
import java.io.BufferedReader;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Cifrado {
    Scanner sc = new Scanner(System.in);
    String frase;
    String direccion;
    char[] frase_char;
    int multiplo;
    int[][] matriz_mensaje;
    int[][] matriz_llave;
    // LEER
    File file;
    FileReader fr;
    BufferedReader br;
    
    // REPORTE
    File reporte;
    FileWriter fw;
    BufferedWriter bw;
        
    public void Metodo_Cifrado(){
        try{
        CrearReporte();
        System.out.println("Ingrese una frase: ");
        frase = sc.nextLine();
        bw.write("LA FRASE QUE SE INGRESO FUE\n");
        bw.write(frase);
        bw.write("<br>");
        int cantidad = frase.length();
        multiplo = Multiplo(cantidad);
        // System.out.println(multiplo);
        int columnas = cantidad/multiplo;
        matriz_mensaje = new int[multiplo][columnas];
        matriz_llave = new int[multiplo][multiplo];
        //Llenar la matriz mensaje
        System.out.println("MATRIZ DEL MENSAJE");
        MatrizMensaje(frase,multiplo,columnas);
        System.out.println("MATRIZ DEL ARCHIVO");
        MatrizLlave();
        System.out.println("MULTIPLICACION DE MATRICES");
        int [][] resultado = Multiplicacion(matriz_llave, matriz_mensaje);
        System.out.println("");
        System.out.println("");
        System.out.println("CODIGO CIFRADO");
        MostrarMatriz(resultado);
        CerrarReporte();            
        }catch(Exception e){
            
        }
    }
    
    public void CrearReporte(){
            try {
            String ruta = "Cifrado.html";
            reporte = new File(ruta);

            // Si el archivo no existe es creado
            if (!reporte.exists()) {
                reporte.createNewFile();
            }
            fw = new FileWriter(reporte);
            bw = new BufferedWriter(fw);
            bw.write("<HTML>\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void CerrarReporte(){
        try{
           bw.write("\n</HTML>");
            bw.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void MatrizMensaje(String frase, int mult, int col){
        frase_char = frase.toCharArray();
        // frase.charAt(i) -> Es una posicion
        int indice = 0;
        try{
            bw.write("LA MATRIZ EN SUS VALORES ASCII ES: \n\n");
            bw.write("<table>\n");
            for(int i = 0; i<mult; i++){
                bw.write("<tr>\n");
                for(int j = 0; j<col; j++){
                    matriz_mensaje[i][j] = frase_char[indice];
                    bw.write("<th>" + matriz_mensaje[i][j] + "</th>");                    
                    indice++;
                }
                bw.write("</tr>\n");
            }
            bw.write("\n</table>");
        }catch(Exception e){
                    
                }
    }
    
    public void MatrizLlave(){
        System.out.println("Ingrese la direccion del archivo: ");
        direccion = sc.nextLine();
        try{
            file = new File (direccion);
            fr = new FileReader (file);
            br = new BufferedReader(fr);
            bw.write("LA MATRIZ DEL ARCHIVO ES: \n\n");
            bw.write("<br>\n\n");
            int cont_fila = 0;
            String linea;
            
            // LLENANDO LA MATRIZ
            bw.write("<table>\n");
            while((linea=br.readLine())!=null){
                // 22019,37757,23754,12900,41475,44639,6020
            String [] valores = linea.split(",");
            // valores[0] = 22019
            // valores[1] =  37757
            // valores[n] = 6020
              bw.write("<tr>\n");
            for(int i = 0; i<valores.length; i++){
               
                matriz_llave[cont_fila][i] = Integer.parseInt(valores[i]);
                // Double -> Double.parseDouble(valores[i]);
                bw.write("<th>" + matriz_llave[cont_fila][i] + "</th>");
            }
                bw.write("\n\n");
                cont_fila++;
                bw.write("</tr>\n");
            }
             bw.write("</table>");
        }catch(Exception e){
           // System.out.println("Ocurrio un error");    
            System.out.println(e.toString());
            e.printStackTrace();

         }
    }
    
    public int[][] Multiplicacion(int[][] a, int[][] b){
        // int[][] a = matriz_llave
        // int[][] b = matriz_mensaje
       int[][] producto = new int[a.length][b[0].length];
        
        if (a[0].length == b.length) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    producto[i][j] += a[i][k] * b[k][j];
                    try{
                        bw.write(a[i][k] + " * " + b[k][j] + " = " + producto[i][j]);
                        bw.write("<br>");
                    }catch(Exception e){
                        
                    }
                }
              
            }
             
        }
    }
        return producto;
    } 
    
    public void MostrarMatriz(int[][] matriz){
        try{
            bw.write("<table>\n");
            for(int i = 0; i<matriz.length;i++)
            {
                bw.write("<tr>\n");
            for(int j = 0; j<matriz[0].length; j++)
            {
                bw.write("<th>" + matriz[i][j] + "</th>");
            }
            bw.write("</tr>\n");
        }
        bw.write("</table>\n");
        }catch(Exception e){
            
        }
    }
            
    public int Multiplo(int cantidad){
        if(cantidad%3==0){
            return 3;
        }else if(cantidad%4==0){
            return 4;
        }else if(cantidad%5==0){
            return 5;
        }else if(cantidad%7==0){
            return 7;
        }else if(cantidad%11==0){
            return 11;
        }else if(cantidad%13==0){
            return 13;
        }else if(cantidad%17==0){
            return 17;
        }else{
            return 0;
        }
    }
}
