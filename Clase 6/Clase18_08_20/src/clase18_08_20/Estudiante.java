package clase18_08_20;

// HERENCIA DE PERSONA
// En este caso queremos que Estudiante obtenga todos los atributos y metodos
// De la clase Persona, entonces hacemos un extends para obtener esa informacion
// E indicarle que Estudiante va a tener todas estas propiedades
public class Estudiante extends Persona {
    // Atributos propios de un estudiante, mas no de una persona
    // Los atributos de persona se pueden utilizar sin ningun problema
    // Vease en el main.
    private int carnet;
    private String carrera;
    private int nota;
    private String practica;


    // Trabajamos el mismo encapsulamiento para obtener sus metodos
    // get y set.
    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getPractica() {
        return practica;
    }

    public void setPractica(String practica) {
        this.practica = practica;
    }
    
    // E igual aqui, creamos un metodo para obtener la informacion de esta clase
    // No podemos agregar la informacion de la clase que heredamos a este metodo, porque
    // Estamos con variables privates, pero si cambiamos a protected, si se podria
    // Este cambio es reflejado desde la clase Persona, todo depende del nivel
    // de seguridad que tengamos (ver presentacion).
    public void ComprobarPractica(){
        if(practica.equals("Si")){
            System.out.println("Felicidades " + nombre + ", ya vas mas cerca");
        }else{
            System.out.println("Animo, echale ganas para la siguiente");
        }
    }
    
}
