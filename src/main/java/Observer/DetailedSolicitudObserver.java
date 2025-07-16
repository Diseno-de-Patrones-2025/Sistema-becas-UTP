package Observer;

/**
 * Observador estilo detallado (como Bruno original).
 * Utiliza toda la información disponible sobre el cambio de estado.
 */
public class DetailedSolicitudObserver implements SolicitudObserver {
    
    private final String nombre;
    
    public DetailedSolicitudObserver(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void actualizar(ObservableSolicitud solicitud, String estadoAnterior, String estadoNuevo) {
        System.out.println("=== " + nombre + " - NOTIFICACIÓN DETALLADA ===");
        System.out.println("Postulante: " + solicitud.getPostulante().getNombre() + " " + 
                          solicitud.getPostulante().getApellido());
        System.out.println("Programa: " + solicitud.getPrograma());
        System.out.println("Cambio de estado: " + estadoAnterior + " → " + estadoNuevo);
        System.out.println("Fecha: " + solicitud.getFecha());
        
        // Lógica específica según el tipo de cambio
        if ("Pendiente".equals(estadoAnterior) && "Aprobada".equals(estadoNuevo)) {
            System.out.println("🎉 ¡Solicitud APROBADA! Enviando notificación de felicitación...");
        } else if ("Pendiente".equals(estadoAnterior) && "Rechazada".equals(estadoNuevo)) {
            System.out.println("❌ Solicitud rechazada. Enviando notificación con opciones de mejora...");
        } else if ("Procesada".equals(estadoNuevo)) {
            System.out.println("✅ Solicitud procesada. Archivando en historial...");
        }
        
        System.out.println("============================================\n");
    }
}
