package pkEscenarioRio.pkSujeto;

public class Lobo extends Pasajero {
    
    public Lobo() {
        super();
    }

    public boolean comerCaperucita(Caperucita caperucita) {
        System.out.println("El Lobo se ha comido a Caperucita... Game over");
        return true;
    }
    
}
