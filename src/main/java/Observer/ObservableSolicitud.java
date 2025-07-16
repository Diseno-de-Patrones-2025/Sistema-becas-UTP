package Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Postulante;
import modelo.Solicitud;

/**
 * Extensión de Solicitud que implementa el patrón Observer.
 * Permite notificar a los observadores cuando cambia el estado de la solicitud.
 */
public class ObservableSolicitud extends Solicitud {
    private List<SolicitudObserver> observadores;
    
    /**
     * Constructor vacío que inicializa la lista de observadores.
     */
    public ObservableSolicitud() {
        super();
        this.observadores = new ArrayList<>();
    }
    
    /**
     * Constructor con parámetros que inicializa la solicitud y la lista de observadores.
     * 
     * @param postulante El postulante de la solicitud.
     * @param programa El programa solicitado.
     * @param fecha La fecha de la solicitud.
     */
    public ObservableSolicitud(Postulante postulante, String programa, Date fecha) {
        super(postulante, programa, fecha);
        this.observadores = new ArrayList<>();
    }
    
    /**
     * Constructor completo que inicializa todos los campos y la lista de observadores.
     * 
     * @param postulante El postulante de la solicitud.
     * @param programa El programa solicitado.
     * @param fecha La fecha de la solicitud.
     * @param estado El estado inicial de la solicitud.
     */
    public ObservableSolicitud(Postulante postulante, String programa, Date fecha, String estado) {
        super(postulante, programa, fecha, estado);
        this.observadores = new ArrayList<>();
    }
    
    /**
     * Agrega un observador a la lista.
     * 
     * @param observador El observador a agregar.
     */
    public void agregarObservador(SolicitudObserver observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }
    
    /**
     * Remueve un observador de la lista.
     * 
     * @param observador El observador a remover.
     */
    public void removerObservador(SolicitudObserver observador) {
        observadores.remove(observador);
    }
    
    /**
     * Notifica a todos los observadores sobre el cambio de estado.
     * 
     * @param estadoAnterior El estado anterior.
     * @param estadoNuevo El nuevo estado.
     */
    private void notificarObservadores(String estadoAnterior, String estadoNuevo) {
        for (SolicitudObserver observador : observadores) {
            observador.actualizar(this, estadoAnterior, estadoNuevo);
        }
    }
    
    /**
     * Sobrescribe el método setEstado para notificar a los observadores.
     * 
     * @param nuevoEstado El nuevo estado a establecer.
     */
    @Override
    public void setEstado(String nuevoEstado) {
        String estadoAnterior = getEstado();
        super.setEstado(nuevoEstado);
        notificarObservadores(estadoAnterior, nuevoEstado);
    }
}
