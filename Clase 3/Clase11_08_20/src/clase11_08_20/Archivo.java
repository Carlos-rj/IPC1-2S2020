
package clase11_08_20;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author carlo
 */
public class Archivo {
    
    public void Metodo1(){
            try {
            String ruta = "Archivos/Texto.txt";
            String contenido = "Texto a guardar";
            File file = new File(ruta);

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.write("Linea 2");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Metodo2(){
        try {
            PrintWriter writer = new PrintWriter("Archivos/Texto.txt", "UTF-8");
            writer.println("Primera línea");
            writer.println("Segunda línea");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    

