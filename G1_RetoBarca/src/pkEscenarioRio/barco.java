package pkEscenarioRio;

import pkEscenarioRio.pkSujeto.Pasajero;
import pkEscenarioRio.pkSujeto.Vikingo;

public class Barco {
    

    private final int capacidadBarco;

    
    private String direccionViaje;

   
    public Barco() {
        this.capacidadBarco = 2; 
        this.direccionViaje = "En la orilla de inicio";
    }

    public void llevarObjeto(Vikingo vikingo, Pasajero pasajero) {
        
        
        if (vikingo == null) {
            System.out.println("Viaje Imposible: El Vikingo es obligatorio para navegar.");
            return;
        }

        String nombrePasajero = (pasajero != null) ? pasajero.toString() : "nadie";
        
        System.out.printf(" El barco comienza el viaje. El Vikingo rema llevando a %s.\n", nombrePasajero);
        
       
        if (this.direccionViaje.equals("De Derecha a Izquierda")) {
             this.direccionViaje = "De Izquierda a Derecha";
        } else {
             this.direccionViaje = "De Derecha a Izquierda";
        }

      
        System.out.printf(" Viaje completado. Nuevo estado de la dirección del barco: %s.\n", this.direccionViaje);
    }

   
    public void dejarpasajero(Pasajero pasajero) {
        if (pasajero != null) {
            System.out.printf("⬇️ %s ha desembarcado del barco.\n", pasajero.toString());
        } else {
            System.out.println("⬇️ Nadie desembarcó.");
        }
    }
    
    
    public int getCapacidadBarco() {
        return capacidadBarco;
    }

    public String getDireccionViaje() {
        return direccionViaje;
    }
}

 