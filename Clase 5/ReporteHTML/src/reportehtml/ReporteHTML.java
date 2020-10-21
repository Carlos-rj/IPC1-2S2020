package reportehtml;

import java.io.PrintWriter;

/**
 *
 * @author carlo
 */
public class ReporteHTML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Llenando una matriz de 3x3");
        int [][] matriz = new int[3][3];
        for(int i = 0; i<3;i++)
        {
            for(int j=0;j<3;j++){
                matriz[i][j] = (i+1)*j;
            }
        }
       try {
            String ruta = "Reporte.html";
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            writer.println("<HTML>");
            writer.println("<link rel=\"stylesheet\" href=\"Reportes/assets/css/main.css\"/>");
            writer.println("<BODY>");
            writer.println("<h1> REPORTE DE CIFRADO </h1>");
            writer.println("<h3> SE INGRESO LA MATRIZ... </h3>");
            
            
            writer.println("<article id=\"first\" class=\"container box style1 right\">");
            writer.println("<header align=\"center\">");
            writer.println("<h2>Matriz mensaje</h2>");
            writer.println("</header>");
            
            writer.println("<table>");
            	
            for(int i = 0; i<3;i++)
            {
                writer.println("<tr>");
                for(int j=0;j<3;j++){
                    writer.print("<th>");
                    writer.print(matriz[i][j]);
                    writer.print("</th>");
                    
                }
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("</article>");  
            writer.println("</BODY>");
            writer.println("</HTML>");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
