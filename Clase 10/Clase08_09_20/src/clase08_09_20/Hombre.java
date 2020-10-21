package clase08_09_20;

public class Hombre extends Persona implements AccionesPersonas {

    @Override
    public void saludar() {
        System.out.println("Hola, soy un bato");
    }

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
        System.out.println("Duermo mis 8 horas diaras");
    }

    @Override
    public void hacer_tareas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
