package Observer;

import modelo.Solicitud;

/**
 * Interfaz híbrida para observadores de solicitudes.
 * 
 * Los observadores pueden implementar cualquiera de los dos métodos
 * según sus necesidades específicas.
 */
public interface HybridSolicitudObserver {
    
    /**
     * Método de actualización detallado.
     * Proporciona información completa sobre el cambio de estado.
     * 
     * @param solicitud La solicitud que cambió
     * @param estadoAnterior El estado previo de la solicitud
     * @param estadoNuevo El nuevo estado de la solicitud
     */
    default void actualizarDetallado(ObservableSolicitud solicitud, String estadoAnterior, String estadoNuevo) {
        // Implementación por defecto que delega al método simple
        actualizarSimple(solicitud);
    }
    
    /**
     * Método de actualización simple (estilo Mathias).
     * Para observadores que solo necesitan saber que cambió algo.
     * 
     * @param solicitud La solicitud que cambió
     */
    default void actualizarSimple(Solicitud solicitud) {
        // Implementación por defecto que delega al método detallado
        if (solicitud instanceof ObservableSolicitud) {
            ObservableSolicitud obs = (ObservableSolicitud) solicitud;
            actualizarDetallado(obs, obs.getEstado(), obs.getEstado());
        }
    }
    
    /**
     * Método principal que debe ser implementado por al menos uno de los anteriores.
     * Se recomienda implementar el que mejor se adapte a las necesidades específicas.
     * 
     * @param solicitud La solicitud que cambió
     * @param estadoAnterior El estado anterior (puede ser igual al nuevo en implementaciones simples)
     * @param estadoNuevo El nuevo estado
     */
    void actualizar(ObservableSolicitud solicitud, String estadoAnterior, String estadoNuevo);
}
