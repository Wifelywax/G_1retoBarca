package pkEscenarioRio.pkSujeto;

public abstract class Pasajero {
    private boolean sabeNavegar;

    public boolean getSabeNavegar(){ 
        return sabeNavegar;
    }
    public void setSabeNavegar(boolean sabeNavegar) {
        this.sabeNavegar = sabeNavegar;
    }
    public abstract boolean esPeligroso(Pasajero otro);
    
    @Override
        public String toString() {
        return this.getClass().getSimpleName();
    }
}
