package Adapter;

import java.util.List;
import modelo.Postulante;
import modelo.Solicitud;
import modelo.Visita;
import modelo.Documentacion;

/**
 * Interfaz unificada para sistemas externos.
 * Proporciona una API limpia para consultas complejas al sistema de becas.
 * Inspirada en los diseños de Jose y Mathias, pero adaptada a la arquitectura de Bruno.
 */
public interface SystemQueryInterface {
    
    /**
     * Obtiene todos los postulantes ordenados alfabéticamente.
     * @return Lista de postulantes ordenados
     */
    List<Postulante> obtenerPostulantesOrdenados();
    
    /**
     * Obtiene solo las solicitudes que están pendientes de procesamiento.
     * @return Lista de solicitudes no procesadas
     */
    List<Solicitud> obtenerSolicitudesPendientes();
    
    /**
     * Obtiene solicitudes filtradas por estado específico.
     * @param estado Estado a filtrar (ej: "Pendiente", "Aprobada", "Rechazada")
     * @return Lista de solicitudes con el estado especificado
     */
    List<Solicitud> obtenerSolicitudesPorEstado(String estado);
    
    /**
     * Obtiene postulantes que tienen un puntaje mínimo específico.
     * @param puntajeMinimo Puntaje mínimo requerido
     * @return Lista de postulantes con puntaje >= al mínimo
     */
    List<Postulante> obtenerPostulantesPorPuntaje(double puntajeMinimo);
    
    /**
     * Obtiene la documentación asociada a un postulante específico.
     * @param postulante Postulante del que se quiere obtener documentación
     * @return Lista de nombres de documentos
     */
    List<String> obtenerDocumentosDe(Postulante postulante);
    
    /**
     * Obtiene las visitas realizadas por un postulante específico.
     * @param postulante Postulante del que se quieren obtener las visitas
     * @return Lista de visitas del postulante
     */
    List<Visita> obtenerVisitasDe(Postulante postulante);
    
    /**
     * Procesa una solicitud específica de un postulante.
     * @param postulante Postulante cuya solicitud se quiere procesar
     * @return true si se procesó exitosamente, false si no se encontró la solicitud
     */
    boolean procesarSolicitudDe(Postulante postulante);
    
    /**
     * Obtiene estadísticas generales del sistema.
     * @return Array con [total_postulantes, solicitudes_pendientes, solicitudes_procesadas]
     */
    int[] obtenerEstadisticasGenerales();
    
    /**
     * Busca postulantes por nombre (búsqueda parcial).
     * @param nombreParcial Parte del nombre a buscar
     * @return Lista de postulantes que contienen el texto en su nombre
     */
    List<Postulante> buscarPostulantesPorNombre(String nombreParcial);
}
