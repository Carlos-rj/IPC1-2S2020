package clase08_09_20;


// Agregamos extends para heredar de la clase abstracta
// Agregamos implements para utilizar la interface
public class Estudiante extends Persona implements AccionesPersonas {
    // Atributos de estudiante
    private String carnet;
    private String carrera;
    // Como hereda Persona, tambien tenemos sus atributos

    public Estudiante(String carnet, String carrera, String nombre, int edad, double altura) {
        super(nombre, edad, altura);
        this.carnet = carnet;
        this.carrera = carrera;
    }



    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    // Luego de usar la sugerencia de NetBeans se nos agregan los metodos abstractos
    @Override
    // Aqui ya definimos el cuerpo segun el objeto, en este caso un Estudiante saluda diferente a un Hombre
    public void saludar() {
        System.out.println("Hola, estoy cansado, no duermo");
    }
    
    // Los demas metodos solo se declaran, pero no tienen ninguna funcion.
    @Override
    public void comer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void programar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dormir() {
        if(carrera.equals("Ciencias y Sistemas"))
                {
                    System.out.println("Yo no duermo");
                }
        else{
            System.out.println("Dormir 10 horas");
        }
    }

    @Override
    public void hacer_tareas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
