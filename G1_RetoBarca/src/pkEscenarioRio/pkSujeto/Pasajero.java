package pkEscenarioRio.pkSujeto;

public abstract class Pasajero {
   
    private boolean subioAlBarco;
    private boolean cruzoAlOtroLado;

    


    public Pasajero() {
        this.subioAlBarco = false;
        this.cruzoAlOtroLado = false;
    }


    public boolean getCruzoAlOtroLado() {
        return cruzoAlOtroLado;
    }


    public void setCruzoAlOtroLado(boolean cruzoAlOtroLado) {
        this.cruzoAlOtroLado = cruzoAlOtroLado;
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
