package pkEscenarioRio.pkSujeto;

public class Uva extends Pasajero {
    
    public Uva() {
        super();
    }

    public boolean serComida(Caperucita caperucita) {
        System.out.println("La Uva ha sido comida por caperucita... Game over");
        return true;
    }   
    
}
