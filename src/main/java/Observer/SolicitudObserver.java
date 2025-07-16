package Observer;

/**
 * Interfaz para los observadores de Solicitud.
 * Implementa el patrón Observer para notificar cambios en el estado de las solicitudes.
 */
public interface SolicitudObserver {
    /**
     * Método que se ejecuta cuando cambia el estado de una solicitud.
     * 
     * @param solicitud La solicitud observable que cambió.
     * @param estadoAnterior El estado anterior de la solicitud.
     * @param estadoNuevo El nuevo estado de la solicitud.
     */
    void actualizar(ObservableSolicitud solicitud, String estadoAnterior, String estadoNuevo);
}
