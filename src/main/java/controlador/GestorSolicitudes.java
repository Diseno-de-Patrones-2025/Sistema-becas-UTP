package controlador;

import modelo.ColaCircular;
import modelo.Solicitud;
import modelo.Postulante;
import java.util.LinkedList;

import Adapter.ColaCircularAdapter;
import Factory.SolicitudFactory;

import java.util.Date;

public class GestorSolicitudes {
    private final ColaCircular colaSolicitudes;
    private final LinkedList<Solicitud> historialSolicitudes;
    private final SolicitudFactory solicitudFactory;

    public GestorSolicitudes(int capacidad) {
        this.colaSolicitudes = new ColaCircular(capacidad);
        this.historialSolicitudes = new LinkedList<>();
        this.solicitudFactory = new SolicitudFactory();
    }

    // Método para obtener un iterable de solicitudes
    public Iterable<Solicitud> obtenerSolicitudes() {
        return new ColaCircularAdapter(colaSolicitudes);
    }

    // Registra una nueva solicitud
    public void registrarSolicitud(Postulante postulante, String programa, Date fecha) {
        Solicitud solicitud = solicitudFactory.crearSolicitud(postulante, programa, fecha);
        if (colaSolicitudes.encolar(solicitud)) {
            System.out.println("Solicitud registrada exitosamente para " + postulante.getNombre());
        } else {
            System.out.println("No se pudo registrar la solicitud. Cola llena.");
        }
    }

    // Procesa la siguiente solicitud en la cola
    public void procesarSolicitud() {
        Solicitud solicitud = colaSolicitudes.desencolar();
        if (solicitud != null) {
            historialSolicitudes.add(solicitud);
            System.out.println("Solicitud procesada: " + solicitud.getPostulante().getNombre());
        } else {
            System.out.println("No hay solicitudes para procesar.");
        }
    }

    // Actualiza el estado de una solicitud
    public void actualizarEstado(String nombrePostulante, String nuevoEstado) {
        boolean encontrado = false;
        for (Solicitud solicitud : obtenerSolicitudes()) {
            if (solicitud.getPostulante().getNombre().equals(nombrePostulante)) {
                solicitud.setEstado(nuevoEstado);
                System.out.println("Estado actualizado para " + nombrePostulante + ": " + nuevoEstado);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Solicitud no encontrada para " + nombrePostulante);
        }
    }

    // Consulta el estado de las solicitudes
    public void consultarEstado() {
        System.out.println("Estado de solicitudes activas:");
        for (Solicitud solicitud : obtenerSolicitudes()) {
            System.out.println(solicitud.getPostulante().getNombre() + " - " + solicitud.getEstado());
        }
    }

    // Muestra el historial de solicitudes procesadas
    public void mostrarHistorial() {
        System.out.println("Historial de solicitudes procesadas:");
        for (Solicitud solicitud : historialSolicitudes) {
            System.out.println(solicitud.getPostulante().getNombre() + " - " + solicitud.getPrograma() + " - " + solicitud.getEstado());
        }
    }
    
    /**
     * Obtiene la cola circular de solicitudes.
     * Método agregado para soporte del GeneradorReportes.
     * 
     * @return La cola circular que contiene todas las solicitudes pendientes
     */
    public ColaCircular getColaSolicitudes() {
        return colaSolicitudes;
    }
    
    /**
     * Obtiene el historial de solicitudes procesadas.
     * Método agregado para soporte del GeneradorReportes.
     * 
     * @return Lista del historial de solicitudes procesadas
     */
    public LinkedList<Solicitud> getHistorialSolicitudes() {
        return historialSolicitudes;
    }
}
