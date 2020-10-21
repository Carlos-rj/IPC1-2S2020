package clase08_09_20;

public class Clase08_09_20 {

    public static void main(String[] args) {
        // Dos objetos llamado estudiantes, recuerden que cada objeto es diferente, vienen de la clase Estudiante
        Estudiante estudiante1 = new Estudiante("201504143","Ciencias y Sistemas","Carlos",22,1.78);
        Estudiante estudiante2 = new Estudiante("123454556","Industrial","Paco",21,1.68);
        
        // Objeto llamado bato, que viene de la clase de Hombre
        Hombre bato1 = new Hombre();
        bato1.setNombre("Bato");
        bato1.setEdad(20);
        bato1.setAltura(1.73);
        
        // Metodos
        estudiante1.dormir();
        System.out.println("");
        estudiante2.dormir();
        System.out.println("");
        bato1.dormir();
    }
    
}
