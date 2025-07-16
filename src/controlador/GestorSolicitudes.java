package controlador;

import modelo.ColaCircular;
import modelo.Solicitud;
import java.util.LinkedList;

/**
 * La clase GestorSolicitudes se encarga de gestionar las solicitudes dentro del sistema de becas.
 * Permite registrar, actualizar el estado de las solicitudes, procesarlas, evaluarlas, realizar entrevistas
 * y mantener un historial de solicitudes procesadas.
 */

public class GestorSolicitudes {
    private final ColaCircular colaSolicitudes;
    private final LinkedList<Solicitud> historialSolicitudes;

    /**
     * Constructor que inicializa el gestor de solicitudes con una cola de solicitudes de la capacidad especificada.
     * 
     * @param capacidad La capacidad máxima de la cola circular de solicitudes.
     */
    
    public GestorSolicitudes(int capacidad) {
        colaSolicitudes = new ColaCircular(capacidad);
        historialSolicitudes = new LinkedList<>();
    }
    
    /**
     * Registra una nueva solicitud en la cola de solicitudes.
     * 
     * @param solicitud La solicitud a registrar.
     */
    
    public void registrarSolicitud(Solicitud solicitud) {
        colaSolicitudes.encolar(solicitud);
    }
    
    /**
     * Actualiza el estado de una solicitud, si la solicitud no se encuentra procesada.
     * 
     * @param nombrePostulante El nombre del postulante cuya solicitud se actualizará.
     * @param nuevoEstado El nuevo estado que se asignará a la solicitud.
     */
    
    public void actualizarEstado(String nombrePostulante, String nuevoEstado) {
        boolean solicitudEncontrada = false;
        //Recorre la cola para encontrar la solicitud
        for (Solicitud solicitud : colaSolicitudes.getSolicitudes()) {  //Si colaSolicitudes tiene el método getSolicitudes()
            if (solicitud.getPostulante().getNombre().equals(nombrePostulante)) {
                solicitudEncontrada = true;
                //Verifica si la solicitud ha sido procesada
                if (solicitud.estaProcesada()) {
                    System.out.println("No se puede actualizar el estado. La solicitud ya ha sido procesada.");
                } else {
                    //Actualiza el estado, si no se encuentra procesada
                    solicitud.setEstado(nuevoEstado);
                    System.out.println("El estado de la solicitud de " + nombrePostulante + " ha sido actualizado a: " + nuevoEstado);
                }
                break;
            }
        }
        if (!solicitudEncontrada) {
            System.out.println("No se encontró una solicitud para el postulante " + nombrePostulante);
        }
    }
    
    /**
     * Procesa la solicitud del postulante en la parte frontal de la cola, actualizando su estado a "Procesada".
     * Luego la agrega al historial de solicitudes procesadas.
     * @exception UnsupportedOperationException Si la operación solicitada en una colección no es soportada
     */
    
    public void procesarSolicitud() {
        Solicitud solicitud = colaSolicitudes.desencolar();
        if (solicitud != null){
            try{
                solicitud.setEstado("Procesada");
                historialSolicitudes.add(solicitud);
                System.out.println("Solicitud de " + solicitud.getPostulante().getNombre() + " procesada.");
            }catch(UnsupportedOperationException e){
                System.out.println("Error al procesar la solicitud: " + e.getMessage());
            }
        }
    }

    /**
     * Realiza una entrevista al postulante cuya solicitud está al frente de la cola de solicitudes.
     */
    
    public void realizarEntrevista() {
        Solicitud solicitud = colaSolicitudes.obtenerFrente();
        if (solicitud != null) {
            System.out.println("Entrevista realizada a " + solicitud.getPostulante().getNombre());
        }
    }

    /**
     * Evalúa la solicitud del postulante que está al frente de la cola de solicitudes,
     * cambiando su estado a "Evaluada".
     */
    
    public void evaluarSolicitud() {
        Solicitud solicitud = colaSolicitudes.obtenerFrente();
        if (solicitud != null) {
            System.out.println("Evaluando solicitud de " + solicitud.getPostulante().getNombre());
            solicitud.setEstado("Evaluada");
        }
    }

    /**
     * Muestra el estado de todas las solicitudes en la cola de solicitudes.
     */
    
    public void consultarEstado() {
        colaSolicitudes.mostrar();
    }

    /**
     * Muestra el historial de solicitudes procesadas, incluyendo el nombre del postulante y su estado.
     */
    
    public void mostrarHistorial() {
        System.out.println("Historial de solicitudes procesadas:");
        for (Solicitud solicitud : historialSolicitudes) {
            System.out.println(solicitud.getPostulante().getNombre() + " - Estado: " + solicitud.getEstado());
        }
    }
    
    /**
     * Obtiene la cola circular de solicitudes.
     * Método agregado para soporte del GeneradorReportes y UnifiedSystemAdapter.
     * 
     * @return La cola circular que contiene todas las solicitudes
     */
    public ColaCircular getColaSolicitudes() {
        return colaSolicitudes;
    }
    
    /**
     * Obtiene el historial de solicitudes procesadas.
     * Método agregado para facilitar el análisis y reportes.
     * 
     * @return Lista del historial de solicitudes procesadas
     */
    public LinkedList<Solicitud> getHistorialSolicitudes() {
        return historialSolicitudes;
    }
    
    /**
     * Obtiene una lista de todas las solicitudes (pendientes y procesadas).
     * Método agregado para facilitar el análisis y reportes.
     * 
     * @return Lista completa de solicitudes del sistema
     */
    public java.util.List<Solicitud> obtenerTodasLasSolicitudes() {
        java.util.List<Solicitud> lista = new java.util.ArrayList<>();
        
        // Agregar solicitudes pendientes de la cola
        Adapter.ColaCircularAdapter adapter = new Adapter.ColaCircularAdapter(colaSolicitudes);
        for (Solicitud s : adapter) {
            lista.add(s);
        }
        
        // Agregar solicitudes del historial
        lista.addAll(historialSolicitudes);
        
        return lista;
    }
}
