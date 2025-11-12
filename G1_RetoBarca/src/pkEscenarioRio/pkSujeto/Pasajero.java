package pkEscenarioRio.pkSujeto;

public abstract class Pasajero {
   
    private boolean subioAlBarco;

    public Pasajero() {
        this.subioAlBarco = false;
    }

    
    public boolean getSubioAlBarco() {
        return subioAlBarco;
    }

    
    public void setSubioAlBarco(boolean subioAlBarco) {
        this.subioAlBarco = subioAlBarco;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
