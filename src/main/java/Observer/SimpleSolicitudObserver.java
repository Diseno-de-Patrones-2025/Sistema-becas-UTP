package Observer;

import modelo.Solicitud;

/**
 * Observador estilo simple (como Mathias).
 * Solo necesita saber que algo cambió en la solicitud.
 */
public class SimpleSolicitudObserver implements HybridSolicitudObserver {
    
    private final String nombre;
    
    public SimpleSolicitudObserver(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void actualizar(ObservableSolicitud solicitud, String estadoAnterior, String estadoNuevo) {
        // Implementación simple que ignora los detalles del cambio
        actualizarSimple(solicitud);
    }
    
    @Override
    public void actualizarSimple(Solicitud solicitud) {
        System.out.println("[" + nombre + "] Solicitud actualizada: " + 
                          solicitud.getPostulante().getNombre() + " - " + 
                          solicitud.getEstado());
        
        // Lógica simple basada solo en el estado actual
        switch (solicitud.getEstado().toLowerCase()) {
            case "aprobada":
                System.out.println("  → Enviando email de felicitación");
                break;
            case "rechazada":
                System.out.println("  → Enviando email de notificación");
                break;
            case "procesada":
                System.out.println("  → Actualizando base de datos");
                break;
            default:
                System.out.println("  → Estado: " + solicitud.getEstado());
        }
    }
}
