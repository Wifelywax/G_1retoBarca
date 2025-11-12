package pkEscenarioRio.pkSujeto;

public class Caperucita extends Pasajero {
    
    public Caperucita() {
        super();
    }

    public boolean comerUva(Uva uva) {
        System.out.println("Caperucita ha comido la Uva... Game over");
        return true;
    }

    public boolean serComida(Lobo lobo) {
        System.out.println("Caperucita ha sido comida por el Lobo... Game over");
        return true;
    }
    
}
