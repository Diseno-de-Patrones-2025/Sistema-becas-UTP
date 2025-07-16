package controlador;

import modelo.*;
import Adapter.*;
import Observer.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Generador de reportes integrado que utiliza todas las mejoras implementadas
 * basadas en las diferencias encontradas con los otros sistemas.
 * 
 * Esta clase se integra como opción 14 del menú principal.
 */
public class GeneradorReportes {
    private GestorPostulantes gestorPostulantes;
    private GestorSolicitudes gestorSolicitudes;
    private GestorVisitas gestorVisitas;
    
    public GeneradorReportes(GestorPostulantes gestorPostulantes, 
                           GestorSolicitudes gestorSolicitudes, 
                           GestorVisitas gestorVisitas) {
        this.gestorPostulantes = gestorPostulantes;
        this.gestorSolicitudes = gestorSolicitudes;
        this.gestorVisitas = gestorVisitas;
    }
    
    /**
     * Genera un reporte completo del sistema mostrando todas las mejoras implementadas.
     */
    public void generarReporteCompleto() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("    REPORTE COMPLETO DEL SISTEMA DE BECAS PARA TRASLADOS INTERNACIONALES");
        System.out.println("    Generado el: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("=".repeat(80));
        
        generarReporteFactoryPattern();
        generarReporteAdapterPattern();
        generarReporteObserverPattern();
        generarEstadisticasGenerales();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("    FIN DEL REPORTE COMPLETO");
        System.out.println("=".repeat(80) + "\n");
    }
    
    /**
     * Genera reporte del Factory Pattern implementado.
     */
    private void generarReporteFactoryPattern() {
        System.out.println("\n--- REPORTE DEL FACTORY PATTERN ---");
        System.out.println("(Inspirado en las mejores prácticas encontradas)\n");
        
        System.out.println("✓ FACTORIES IMPLEMENTADAS:");
        System.out.println("  • PostulanteFactory - Creación centralizada de postulantes");
        System.out.println("  • SolicitudFactory - Creación validada de solicitudes");
        System.out.println("  • EntidadFactory - Factory abstracta general");
        
        System.out.println("\n BENEFICIOS IMPLEMENTADOS:");
        System.out.println("  • Creación centralizada y consistente");
        System.out.println("  • Validación automática en el proceso de creación");
        System.out.println("  • Facilita mantenimiento y extensión del código");
    }
    
    /**
     * Genera reporte del Adapter Pattern implementado.
     */
    private void generarReporteAdapterPattern() {
        System.out.println("\n--- REPORTE DEL ADAPTER PATTERN ---");
        System.out.println("\n");
        
        System.out.println("✓ ADAPTERS IMPLEMENTADOS:");
        System.out.println("  • ABBAdapter - Permite iteración sobre árbol binario");
        System.out.println("  • ColaCircularAdapter - Permite iteración sobre cola circular");
        
        try {
            System.out.println("\n ESTADÍSTICAS A TRAVÉS DE ADAPTERS:");
            
            // Contar postulantes usando ABBAdapter
            ABBAdapter abbAdapter = new ABBAdapter(gestorPostulantes.getAbb());
            int contadorPostulantes = 0;
            for (@SuppressWarnings("unused") Postulante p : abbAdapter) {
                contadorPostulantes++;
            }
            System.out.println("  • Postulantes registrados (via ABBAdapter): " + contadorPostulantes);
            
            // Contar solicitudes usando ColaCircularAdapter
            ColaCircularAdapter colaAdapter = new ColaCircularAdapter(gestorSolicitudes.getColaSolicitudes());
            int contadorSolicitudes = 0;
            for (@SuppressWarnings("unused") Solicitud s : colaAdapter) {
                contadorSolicitudes++;
            }
            System.out.println("  • Solicitudes pendientes (via ColaAdapter): " + contadorSolicitudes);
            
        } catch (Exception e) {
            System.out.println("  Error accediendo a datos via adapters: " + e.getMessage());
        }
        
        System.out.println("\n✓ BENEFICIOS DEL ADAPTER PATTERN:");
        System.out.println("  • Interfaz unificada para diferentes estructuras");
        System.out.println("  • Facilita iteración y procesamiento");
        System.out.println("  • Reutilización de estructuras existentes");
    }
    
    /**
     * Genera reporte del Observer Pattern implementado.
     */
    private void generarReporteObserverPattern() {
        System.out.println("\n--- REPORTE DEL OBSERVER PATTERN ---");
        
        System.out.println("✓ OBSERVER PATTERN IMPLEMENTADO:");
        System.out.println("  • ObservableSolicitud - Solicitudes observables");
        System.out.println("  • SolicitudObserver - Interfaz para observadores");
        System.out.println("  • Sistema de notificaciones automáticas");
        
        try {
            System.out.println("\n DEMOSTRACIÓN DEL OBSERVER:");
            
            // Crear observador de ejemplo
            SolicitudObserver observer = new SolicitudObserver() {
                @Override
                public void actualizar(ObservableSolicitud solicitud, String estadoAnterior, String estadoNuevo) {
                    System.out.println("  → Observer notificado: Estado cambió de '" + estadoAnterior + "' a '" + estadoNuevo + "'");
                }
            };
            
            // Crear postulante y solicitud observable para demo
            Postulante postulanteDemo = new Postulante("Demo", "Test", "12345678", "demo@test.com");
            ObservableSolicitud solicitudDemo = new ObservableSolicitud(postulanteDemo, "Beca Demo", new java.util.Date(), "Pendiente");
            solicitudDemo.agregarObservador(observer);
            
            System.out.println("  • Solicitud observable creada para: " + postulanteDemo.getNombre());
            System.out.println("  • Cambiando estado para demostrar notificación:");
            solicitudDemo.setEstado("Aprobada");
            
        } catch (Exception e) {
            System.out.println("  Error en demostración del observer: " + e.getMessage());
        }
        
        System.out.println("\n✓ BENEFICIOS DEL OBSERVER PATTERN:");
        System.out.println("  • Notificaciones automáticas de cambios");
        System.out.println("  • Bajo acoplamiento entre componentes");
        System.out.println("  • Extensibilidad para múltiples observadores");
    }
    
    /**
     * Genera estadísticas generales del sistema.
     */
    private void generarEstadisticasGenerales() {
        System.out.println("\n--- ESTADÍSTICAS GENERALES DEL SISTEMA ---\n");
        
        try {
            // Estadísticas de postulantes
            ABBAdapter abbAdapter = new ABBAdapter(gestorPostulantes.getAbb());
            int totalPostulantes = 0;
            for (@SuppressWarnings("unused") Postulante p : abbAdapter) {
                totalPostulantes++;
            }
            
            // Estadísticas de solicitudes
            ColaCircularAdapter colaAdapter = new ColaCircularAdapter(gestorSolicitudes.getColaSolicitudes());
            int solicitudesPendientes = 0;
            for (@SuppressWarnings("unused") Solicitud s : colaAdapter) {
                solicitudesPendientes++;
            }
            
            int solicitudesHistorial = gestorSolicitudes.getHistorialSolicitudes().size();
            
            System.out.println(" RESUMEN NUMÉRICO:");
            System.out.println("  • Total de postulantes: " + totalPostulantes);
            System.out.println("  • Solicitudes pendientes: " + solicitudesPendientes);
            System.out.println("  • Solicitudes procesadas: " + solicitudesHistorial);
            System.out.println("  • Total de solicitudes: " + (solicitudesPendientes + solicitudesHistorial));
            
            System.out.println("\n PATRONES IMPLEMENTADOS EXITOSAMENTE:");
            System.out.println("  ✓ Factory Pattern - Creación centralizada y validada");
            System.out.println("  ✓ Adapter Pattern - Interfaz unificada para estructuras");
            System.out.println("  ✓ Observer Pattern - Notificaciones automáticas");
            System.out.println("  ✓ MVC Architecture - Separación clara de responsabilidades");
            
            System.out.println("\n MEJORAS IMPLEMENTADAS:");
            System.out.println("  • Sistema de reportes integrado");
            System.out.println("  • Validaciones mejoradas");
            System.out.println("  • Mejor organización de código");
            System.out.println("  • Facilidad de mantenimiento y extensión");
            
        } catch (Exception e) {
            System.out.println("  Error generando estadísticas: " + e.getMessage());
        }
    }
}
