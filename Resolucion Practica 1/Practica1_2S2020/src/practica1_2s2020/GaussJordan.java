package practica1_2s2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class GaussJordan {
    double [][] Aumentada = new double[3][7];
    double [][] Inversa = new double[3][3];
    
    String direccion;
    // LEER
    File file;
    FileReader fr;
    BufferedReader br;
    Scanner sc = new Scanner(System.in);
    
        // REPORTE
    File reporte;
    FileWriter fw;
    BufferedWriter bw;
    
    public void GaussJordan(){
        CrearReporte();
        LlenarMatriz();
        Identidad();
        MostrarMatriz(Aumentada);
        VolverCero31();
        MostrarMatriz(Aumentada);
        VolverCero21();
        MostrarMatriz(Aumentada);
        VolverCero32();
        MostrarMatriz(Aumentada);
        VolverCero13();
        MostrarMatriz(Aumentada);
        VolverCero23();
        MostrarMatriz(Aumentada);
        VolverCero12();
        MostrarMatriz(Aumentada);
        VolverUno11();
        MostrarMatriz(Aumentada);
        VolverUno22();
        MostrarMatriz(Aumentada);
        VolverUno33();
       
        MostrarMatriz(Aumentada);
        ObtenerInversa();
        MostrarMatriz(Inversa);
        CerrarReporte();
    }
    
     public void CrearReporte(){
            try {
            String ruta = "Gauss.html";
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
    
    
    public void ObtenerInversa(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
              Inversa[i][j] = Aumentada[i][j+4];                
            }
        } 
    }
    
    public void Identidad(){
        for(int i=0; i<3;i++){
            Aumentada[i][i+4] = 1;
        }
    }
    
    /*
    public void HacerUnos(){
        for(int i=0; i<3;i++){
            double posicion = Aumentada[i][i];
            Aumentada[i][i] = 1;
            Aumentada[i][3] = Aumentada[i][3]/posicion;
        }
    }
    */
    public void VolverUno33(){
        double posicion33 = Aumentada[2][2];
                 try{
             bw.write("<h1> POSICION 33 </h1>");             
         }catch(Exception e){
             e.printStackTrace();
         }
        for(int i = 0; i < 7; i++){
             Aumentada[2][i] = Aumentada[2][i]/posicion33;
             //Inversa[2][i] = Aumentada[2][i]/posicion33;
         }
    }    
    
    public void VolverUno22(){
        double posicion22 = Aumentada[1][1];
                 try{
             bw.write("<h1> POSICION 22 </h1>");             
         }catch(Exception e){
             e.printStackTrace();
         }
        for(int i = 0; i < 7; i++){
             Aumentada[1][i] = Aumentada[1][i]/posicion22;
             //Inversa[1][i] = Aumentada[1][i]/posicion22;
         }
    }
    
    public void VolverUno11(){
        double posicion11 = Aumentada[0][0];
                 try{
             bw.write("<h1> POSICION 11 </h1>");             
         }catch(Exception e){
             e.printStackTrace();
         }
        for(int i = 0; i < 7; i++){
             Aumentada[0][i] = Aumentada[0][i]/posicion11;
            // Inversa[0][i] = Aumentada[0][i]/posicion11;
         }
    }
    
    public void VolverCero12(){
        double posicion22 = Aumentada[1][1];
        double posicion12 = Aumentada[0][1];
         
         double[] fila1 = Aumentada[0];
         double[] fila2 = Aumentada[1];
                  try{
             bw.write("<h1> POSICION 12 </h1>");             
         }catch(Exception e){
             e.printStackTrace();
         }
         for(int i = 0; i < 7; i++){
             Aumentada[0][i] = posicion22*fila1[i] - posicion12*fila2[i];
             //Inversa[0][i] = posicion22*fila1[i] - posicion12*fila2[i];
         }
     }   
    
    public void VolverCero23(){
        double posicion23 = Aumentada[1][2];
        double posicion33 = Aumentada[2][2];
         
         double[] fila3 = Aumentada[2];
         double[] fila2 = Aumentada[1];
                  try{
             bw.write("<h1> POSICION 23 </h1>");             
         }catch(Exception e){
             e.printStackTrace();
         }
         for(int i = 0; i < 7; i++){
             Aumentada[1][i] = posicion23*fila3[i] - posicion33*fila2[i];
            // Inversa[1][i] = posicion23*fila3[i] - posicion33*fila2[i];
         }
     }
    
     public void VolverCero13(){
         double posicion13 = Aumentada[0][2];
         double posicion33 = Aumentada[2][2];
                  try{
             bw.write("<h1> POSICION 13 </h1>");             
         }catch(Exception e){
             e.printStackTrace();
         }
         double[] fila3 = Aumentada[2];
         double[] fila1 = Aumentada[0];
         
         for(int i = 0; i < 7; i++){
             Aumentada[0][i] = posicion13*fila3[i] - posicion33*fila1[i];
            // Inversa[0][i] = posicion13*fila3[i] - posicion33*fila1[i];
             
         }
     }
    
     public void VolverCero32(){
         double posicion32 = Aumentada[2][1];
         double posicion22 = Aumentada[1][1];
                  try{
             bw.write("<h1> POSICION 32 </h1>");             
         }catch(Exception e){
             e.printStackTrace();
         }
         double[] fila3 = Aumentada[2];
         double[] fila2 = Aumentada[1];
         
         for(int i = 0; i < 7; i++){
             Aumentada[2][i] = posicion32*fila2[i] - posicion22*fila3[i];
            // Inversa[2][i] = posicion32*fila2[i] - posicion22*fila3[i];
         }
     }
    
     public void VolverCero21(){
         double posicion11 = Aumentada[0][0];
         double posicion21 = Aumentada[1][0];
                  try{
             bw.write("<h1> POSICION 21 </h1>");             
         }catch(Exception e){
             e.printStackTrace();
         }
         double[] fila1 = Aumentada[0];
         double[] fila2 = Aumentada[1];
         
         for(int i = 0; i < 7; i++){
             Aumentada[1][i] = posicion11*fila2[i] - posicion21*fila1[i];
            // Inversa[1][i] = posicion11*fila2[i] - posicion21*fila1[i];
         }
     }
    
     public void VolverCero31(){
         double posicion11 = Aumentada[0][0];
         // -323
         double posicion31 = Aumentada[2][0];
         // 448
         try{
             bw.write("<h1> POSICION 31 </h1>");             
         }catch(Exception e){
             e.printStackTrace();
         }
         double[] fila1 = Aumentada[0];
         //fila1[0] -> Aumentada[0][0]
         //fila1[3] -> Aumentada[0][3]
         // fila1 --- -323, -5482, 8, 48
         double[] fila3 = Aumentada[2];
         // fila3 --- 448, -54, -82, 45
         
         // -323(448) - 448(-323) = 0
         // -323(-5482) - 448(-54) = ...
         // -323(8) - 448(48) = ...
         // -323(48) - 448(45) = ...
         
         for(int i = 0; i < 7; i++){
             // i = 0 -> 0
             //Aumentada[2][0] -> 3,1
             Aumentada[2][i] = posicion11*fila3[i] - posicion31*fila1[i];
            // Inversa[2][i] = posicion11*fila3[i] - posicion31*fila1[i];
         }
     }
    
     public void LlenarMatriz(){
    System.out.println("Ingrese la direccion del archivo: ");
        direccion = sc.nextLine();
        try{
            file = new File (direccion);
            fr = new FileReader (file);
            br = new BufferedReader(fr);

            int cont_fila = 0;
            String linea;
            bw.write("<h1> ESTE ES EL SISTEMA DE ECUACIONES </h1>");
            bw.write("\n<br>\n");
            // LLENANDO LA MATRIZ

            while((linea=br.readLine())!=null){
            String [] valores = linea.split(",");
            for(int i = 0; i<valores.length; i++){               
                Aumentada[cont_fila][i] = Integer.parseInt(valores[i]);
                // Double -> Double.parseDouble(valores[i]);
                //System.out.print(Aumentada[cont_fila][i]);
            }
                cont_fila++;
                //System.out.println("");
            }
        }catch(Exception e){
           // System.out.println("Ocurrio un error");    
            System.out.println(e.toString());
            e.printStackTrace();

         }
    }
    
     public void MostrarMatriz(double[][] matriz){
         System.out.println("---------------------------------\n");
        try{
            bw.write("<table>\n");
            for(int i = 0; i<matriz.length;i++)
            {
                bw.write("<tr>\n");
            for(int j = 0; j<matriz[0].length; j++)
            {
                bw.write("<th>" + matriz[i][j] + "</th>");
                System.out.print(matriz[i][j] + " ");
            }
             bw.write("</tr>\n");
                System.out.println("");
        }
        bw.write("</table>\n");
        bw.write("<br>\n");
        bw.write("<br>\n");
        
        }catch(Exception e){
            
        }
    }
}
