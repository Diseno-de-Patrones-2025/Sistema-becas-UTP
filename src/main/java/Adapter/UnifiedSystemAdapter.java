package Adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelo.ABB;
import modelo.ColaCircular;
import modelo.Postulante;
import modelo.Solicitud;
import modelo.Visita;
import modelo.Documentacion;
import modelo.ListaCircularVisitas;

/**
 * Implementación del Adapter unificado para sistemas externos.
 * Combina múltiples estructuras de datos en una interfaz coherente.
 * 
 * Esta clase adapta las estructuras internas del sistema (ABB, ColaCircular, etc.)
 * para proporcionar una interfaz unificada a sistemas externos.
 */
public class UnifiedSystemAdapter implements SystemQueryInterface {
    
    private final ABBAdapter abbAdapter;
    private final ColaCircularAdapter colaAdapter;
    private final List<Documentacion> listaDocumentaciones;
    private final ListaCircularVisitas listaVisitas;
    
    /**
     * Constructor que recibe todas las estructuras de datos del sistema.
     * 
     * @param arbolPostulantes ABB con los postulantes
     * @param colaSolicitudes Cola circular con las solicitudes
     * @param listaDocumentaciones Lista con documentaciones
     * @param listaVisitas Lista circular con visitas
     */
    public UnifiedSystemAdapter(ABB arbolPostulantes, ColaCircular colaSolicitudes, 
                               List<Documentacion> listaDocumentaciones, 
                               ListaCircularVisitas listaVisitas) {
        this.abbAdapter = new ABBAdapter(arbolPostulantes);
        this.colaAdapter = new ColaCircularAdapter(colaSolicitudes);
        this.listaDocumentaciones = listaDocumentaciones != null ? listaDocumentaciones : new ArrayList<>();
        this.listaVisitas = listaVisitas;
    }
    
    @Override
    public List<Postulante> obtenerPostulantesOrdenados() {
        List<Postulante> postulantes = new ArrayList<>();
        for (Postulante p : abbAdapter) {
            postulantes.add(p);
        }
        return postulantes;
    }
    
    @Override
    public List<Solicitud> obtenerSolicitudesPendientes() {
        return obtenerSolicitudesPorEstado("Pendiente");
    }
    
    @Override
    public List<Solicitud> obtenerSolicitudesPorEstado(String estado) {
        List<Solicitud> solicitudesFiltradas = new ArrayList<>();
        for (Solicitud s : colaAdapter) {
            if (s.getEstado().equalsIgnoreCase(estado)) {
                solicitudesFiltradas.add(s);
            }
        }
        return solicitudesFiltradas;
    }
    
    @Override
    public List<Postulante> obtenerPostulantesPorPuntaje(double puntajeMinimo) {
        return obtenerPostulantesOrdenados().stream()
                .filter(p -> p.getPuntaje() >= puntajeMinimo)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<String> obtenerDocumentosDe(Postulante postulante) {
        for (Documentacion doc : listaDocumentaciones) {
            if (doc.getPostulante().getCorreo().equals(postulante.getCorreo())) {
                return doc.getDocumentos();
            }
        }
        return new ArrayList<>();
    }
    
    @Override
    public List<Visita> obtenerVisitasDe(Postulante postulante) {
        List<Visita> visitas = new ArrayList<>();
        // Por simplicidad, retornamos lista vacía ya que Visita no tiene relación directa con Postulante
        // En una implementación completa, se necesitaría modificar el modelo Visita
        return visitas;
    }
    
    @Override
    public boolean procesarSolicitudDe(Postulante postulante) {
        for (Solicitud s : colaAdapter) {
            if (s.getPostulante().getCorreo().equals(postulante.getCorreo()) && 
                s.getEstado().equalsIgnoreCase("Pendiente")) {
                s.setEstado("Procesada");
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int[] obtenerEstadisticasGenerales() {
        int totalPostulantes = obtenerPostulantesOrdenados().size();
        int solicitudesPendientes = obtenerSolicitudesPendientes().size();
        int solicitudesProcesadas = 0;
        
        for (Solicitud s : colaAdapter) {
            if (s.getEstado().equalsIgnoreCase("Procesada")) {
                solicitudesProcesadas++;
            }
        }
        
        return new int[]{totalPostulantes, solicitudesPendientes, solicitudesProcesadas};
    }
    
    @Override
    public List<Postulante> buscarPostulantesPorNombre(String nombreParcial) {
        return obtenerPostulantesOrdenados().stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nombreParcial.toLowerCase()) ||
                           p.getApellido().toLowerCase().contains(nombreParcial.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Método adicional para obtener todas las solicitudes sin filtro.
     * @return Lista completa de solicitudes
     */
    public List<Solicitud> obtenerTodasLasSolicitudes() {
        List<Solicitud> todasLasSolicitudes = new ArrayList<>();
        for (Solicitud s : colaAdapter) {
            todasLasSolicitudes.add(s);
        }
        return todasLasSolicitudes;
    }
    
    /**
     * Método adicional para obtener un resumen estadístico más detallado.
     * @return String con resumen detallado del sistema
     */
    public String obtenerResumenDetallado() {
        int[] stats = obtenerEstadisticasGenerales();
        StringBuilder resumen = new StringBuilder();
        resumen.append("=== RESUMEN DEL SISTEMA DE BECAS ===\n");
        resumen.append("Total de Postulantes: ").append(stats[0]).append("\n");
        resumen.append("Solicitudes Pendientes: ").append(stats[1]).append("\n");
        resumen.append("Solicitudes Procesadas: ").append(stats[2]).append("\n");
        resumen.append("Total de Documentaciones: ").append(listaDocumentaciones.size()).append("\n");
        
        if (listaVisitas != null) {
            resumen.append("Total de Visitas: ").append(listaVisitas.getTamaño()).append("\n");
        }
        
        resumen.append("=====================================");
        return resumen.toString();
    }
}
