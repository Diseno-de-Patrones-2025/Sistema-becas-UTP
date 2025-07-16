package Factory;

import modelo.Solicitud;
import modelo.Postulante;
import java.util.Date;

/**
 * Factory concreto para la creación de objetos Solicitud
 */
public class SolicitudFactory implements EntidadFactory<Solicitud> {
    
    @Override
    public Solicitud crearEntidad() {
        return new Solicitud();
    }
    
    public Solicitud crearSolicitud(Postulante postulante, String programa, Date fecha) {
        return new Solicitud(postulante, programa, fecha);
    }
    
    public Solicitud crearSolicitudConEstado(Postulante postulante, String programa, Date fecha, String estado) {
        return new Solicitud(postulante, programa, fecha, estado);
    }
}
