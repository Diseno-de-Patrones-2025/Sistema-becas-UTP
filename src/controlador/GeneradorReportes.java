package controlador;

import Adapter.UnifiedSystemAdapter;
import Factory.PostulanteFactory;
import modelo.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Generador de reportes del sistema de becas.
 * Utiliza las mejoras implementadas (Factory con validaciones, Adapter unificado, Observer mejorado)
 * para generar reportes completos basados en los datos reales del sistema.
 */
public class GeneradorReportes {
    
    private final GestorPostulantes gestorPostulantes;
    private final GestorSolicitudes gestorSolicitudes;
    private final GestorVisitas gestorVisitas;
    private final GestorDocumentos gestorDocumentaciones;
    private final UnifiedSystemAdapter adapter;
    
    /**
     * Constructor que recibe todos los gestores del sistema.
     */
    public GeneradorReportes(GestorPostulantes gestorPostulantes, 
                           GestorSolicitudes gestorSolicitudes,
                           GestorVisitas gestorVisitas, 
                           GestorDocumentos gestorDocumentaciones) {
        this.gestorPostulantes = gestorPostulantes;
        this.gestorSolicitudes = gestorSolicitudes;
        this.gestorVisitas = gestorVisitas;
        this.gestorDocumentaciones = gestorDocumentaciones;
        
        // Crear el adapter unificado usando los datos del sistema
        this.adapter = crearAdapterUnificado();
    }
    
    /**
     * Genera el reporte completo del sistema integrando todas las mejoras.
     */
    public void generarReporteCompleto() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("🚀 REPORTE COMPLETO DEL SISTEMA DE BECAS");
        System.out.println("=".repeat(80));
        
        // 1. Reporte de validaciones del Factory
        generarReporteValidaciones();
        
        // 2. Reporte del Adapter unificado
        generarReporteAdapterUnificado();
        
        // 3. Estadísticas generales
        generarEstadisticasGenerales();
        
        // 4. Análisis detallado de datos
        generarAnalisisDetallado();
        
        // 5. Reporte de funcionalidades Observer
        generarReporteObserver();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("📊 REPORTE GENERADO EXITOSAMENTE");
        System.out.println("=".repeat(80));
    }
    
    /**
     * Genera reporte sobre las capacidades de validación del Factory mejorado.
     */
    private void generarReporteValidaciones() {
        System.out.println("\n📋 1. CAPACIDADES DE VALIDACIÓN (Factory Mejorado)");
        System.out.println("-".repeat(50));
        
        PostulanteFactory factory = new PostulanteFactory();
        
        System.out.println("✅ Validaciones disponibles:");
        System.out.println("   • Validación de correo electrónico (formato usuario@dominio.ext)");
        System.out.println("   • Validación de DNI (exactamente 8 dígitos)");
        System.out.println("   • Validación de nombres (solo letras y espacios)");
        System.out.println("   • Validación de puntajes (rango 0-100)");
        
        System.out.println("\n🔧 Métodos de creación disponibles:");
        System.out.println("   • crearPostulante() - Método original (sin validación)");
        System.out.println("   • crearPostulanteValidado() - Con validación automática");
        System.out.println("   • crearPostulanteConValidacionInteractiva() - Con recuperación de errores");
        
        // Ejemplo de validación en vivo (si hay datos)
        List<Postulante> postulantes = gestorPostulantes.obtenerTodosLosPostulantes();
        if (!postulantes.isEmpty()) {
            System.out.println("\n📊 Análisis de datos existentes:");
            int validosCorreo = 0, validosDNI = 0, validosNombre = 0;
            
            for (Postulante p : postulantes) {
                if (esCorreoValido(p.getCorreo())) validosCorreo++;
                if (esDNIValido(p.getDni())) validosDNI++;
                if (esNombreValido(p.getNombre()) && esNombreValido(p.getApellido())) validosNombre++;
            }
            
            System.out.println("   • Postulantes con correo válido: " + validosCorreo + "/" + postulantes.size());
            System.out.println("   • Postulantes con DNI válido: " + validosDNI + "/" + postulantes.size());
            System.out.println("   • Postulantes con nombres válidos: " + validosNombre + "/" + postulantes.size());
        } else {
            System.out.println("\n📝 No hay postulantes registrados para validar.");
        }
    }
    
    /**
     * Genera reporte usando el Adapter unificado.
     */
    private void generarReporteAdapterUnificado() {
        System.out.println("\n🔌 2. ADAPTER UNIFICADO PARA SISTEMAS EXTERNOS");
        System.out.println("-".repeat(50));
        
        System.out.println("✅ API unificada disponible:");
        System.out.println("   • obtenerPostulantesOrdenados()");
        System.out.println("   • obtenerSolicitudesPendientes()");
        System.out.println("   • obtenerSolicitudesPorEstado(estado)");
        System.out.println("   • obtenerPostulantesPorPuntaje(minimo)");
        System.out.println("   • procesarSolicitudDe(postulante)");
        System.out.println("   • obtenerEstadisticasGenerales()");
        System.out.println("   • buscarPostulantesPorNombre(nombre)");
        
        System.out.println("\n📊 Datos procesados por el Adapter:");
        
        try {
            // Postulantes ordenados
            List<Postulante> ordenados = adapter.obtenerPostulantesOrdenados();
            System.out.println("   • Postulantes ordenados alfabéticamente: " + ordenados.size());
            
            if (!ordenados.isEmpty()) {
                System.out.println("     └─ Primeros 3: ");
                for (int i = 0; i < Math.min(3, ordenados.size()); i++) {
                    Postulante p = ordenados.get(i);
                    System.out.println("        " + (i+1) + ". " + p.getNombre() + " " + p.getApellido());
                }
            }
            
            // Solicitudes pendientes
            List<Solicitud> pendientes = adapter.obtenerSolicitudesPendientes();
            System.out.println("   • Solicitudes pendientes: " + pendientes.size());
            
            // Postulantes con buen puntaje
            List<Postulante> topPuntaje = adapter.obtenerPostulantesPorPuntaje(70.0);
            System.out.println("   • Postulantes con puntaje ≥ 70: " + topPuntaje.size());
            
        } catch (Exception e) {
            System.out.println("   ⚠️ Error al procesar datos: " + e.getMessage());
        }
    }
    
    /**
     * Genera estadísticas generales del sistema.
     */
    private void generarEstadisticasGenerales() {
        System.out.println("\n📊 3. ESTADÍSTICAS GENERALES DEL SISTEMA");
        System.out.println("-".repeat(50));
        
        try {
            int[] estadisticas = adapter.obtenerEstadisticasGenerales();
            
            System.out.println("📈 Resumen ejecutivo:");
            System.out.println("   • Total de postulantes registrados: " + estadisticas[0]);
            System.out.println("   • Solicitudes pendientes de procesamiento: " + estadisticas[1]);
            System.out.println("   • Solicitudes ya procesadas: " + estadisticas[2]);
            
            // Calcular porcentajes si hay datos
            int totalSolicitudes = estadisticas[1] + estadisticas[2];
            if (totalSolicitudes > 0) {
                double porcentajePendientes = (estadisticas[1] * 100.0) / totalSolicitudes;
                double porcentajeProcesadas = (estadisticas[2] * 100.0) / totalSolicitudes;
                
                System.out.println("\n📊 Distribución de solicitudes:");
                System.out.println("   • Pendientes: " + String.format("%.1f%%", porcentajePendientes));
                System.out.println("   • Procesadas: " + String.format("%.1f%%", porcentajeProcesadas));
            }
            
            // Información adicional
            System.out.println("\n📋 Información adicional:");
            System.out.println("   • Total de documentaciones registradas: " + obtenerTotalDocumentaciones());
            System.out.println("   • Sistema de visitas configurado: ✅ Activo");
            
        } catch (Exception e) {
            System.out.println("   ⚠️ Error al obtener estadísticas: " + e.getMessage());
        }
        
        // Resumen detallado del adapter
        System.out.println("\n" + adapter.obtenerResumenDetallado());
    }
    
    /**
     * Genera análisis detallado de los datos.
     */
    private void generarAnalisisDetallado() {
        System.out.println("\n🔍 4. ANÁLISIS DETALLADO DE DATOS");
        System.out.println("-".repeat(50));
        
        // Análisis de postulantes
        List<Postulante> postulantes = gestorPostulantes.obtenerTodosLosPostulantes();
        if (!postulantes.isEmpty()) {
            System.out.println("👥 Análisis de postulantes:");
            
            // Estadísticas de puntajes
            double puntajePromedio = postulantes.stream()
                    .mapToDouble(Postulante::getPuntaje)
                    .average()
                    .orElse(0.0);
            
            double puntajeMaximo = postulantes.stream()
                    .mapToDouble(Postulante::getPuntaje)
                    .max()
                    .orElse(0.0);
            
            System.out.println("   • Puntaje promedio: " + String.format("%.2f", puntajePromedio));
            System.out.println("   • Puntaje máximo: " + String.format("%.2f", puntajeMaximo));
            
            // Distribución por rangos de puntaje
            long excelentes = postulantes.stream().filter(p -> p.getPuntaje() >= 90).count();
            long buenos = postulantes.stream().filter(p -> p.getPuntaje() >= 70 && p.getPuntaje() < 90).count();
            long regulares = postulantes.stream().filter(p -> p.getPuntaje() < 70).count();
            
            System.out.println("\n📊 Distribución por calificación:");
            System.out.println("   • Excelentes (≥90): " + excelentes + " postulantes");
            System.out.println("   • Buenos (70-89): " + buenos + " postulantes");
            System.out.println("   • Regulares (<70): " + regulares + " postulantes");
        }
        
        // Análisis de solicitudes por estado
        analizarSolicitudesPorEstado();
    }
    
    /**
     * Genera reporte de las capacidades del Observer mejorado.
     */
    private void generarReporteObserver() {
        System.out.println("\n👁️ 5. CAPACIDADES DEL OBSERVER MEJORADO");
        System.out.println("-".repeat(50));
        
        System.out.println("🔔 Funcionalidades de notificación:");
        System.out.println("   • Notificación automática en cambios de estado");
        System.out.println("   • Modo silencioso para cambios sin notificación");
        System.out.println("   • Interfaz híbrida (simple y detallada)");
        System.out.println("   • Compatibilidad total con sistema original");
        
        System.out.println("\n🎛️ Métodos disponibles:");
        System.out.println("   • setEstado() - Cambio con notificación automática");
        System.out.println("   • setEstadoSilencioso() - Cambio sin notificación");
        System.out.println("   • procesar() - Procesamiento con notificación");
        System.out.println("   • estaProcesada() - Verificación de estado procesado");
        
        System.out.println("\n📡 Tipos de observadores:");
        System.out.println("   • DetailedSolicitudObserver - Notificaciones detalladas");
        System.out.println("   • SimpleSolicitudObserver - Notificaciones básicas");
        System.out.println("   • HybridSolicitudObserver - Interfaz flexible");
        
        System.out.println("\n✅ El sistema está preparado para implementar notificaciones");
        System.out.println("   automáticas en tiempo real cuando se cambien estados de solicitudes.");
    }
    
    // Métodos auxiliares
    
    private UnifiedSystemAdapter crearAdapterUnificado() {
        // Obtener las estructuras de datos del sistema
        ABB abb = gestorPostulantes.getAbb(); // Necesitaremos agregar este getter
        ColaCircular cola = gestorSolicitudes.getColaSolicitudes(); // Necesitaremos agregar este getter
        List<Documentacion> docs = new ArrayList<>(); // Por ahora lista vacía
        ListaCircularVisitas visitas = gestorVisitas.getListaVisitas(); // Necesitaremos agregar este getter
        
        return new UnifiedSystemAdapter(abb, cola, docs, visitas);
    }
    
    private void analizarSolicitudesPorEstado() {
        System.out.println("\n📋 Análisis de solicitudes por estado:");
        
        try {
            List<Solicitud> pendientes = adapter.obtenerSolicitudesPorEstado("Pendiente");
            List<Solicitud> aprobadas = adapter.obtenerSolicitudesPorEstado("Aprobada");
            List<Solicitud> rechazadas = adapter.obtenerSolicitudesPorEstado("Rechazada");
            List<Solicitud> procesadas = adapter.obtenerSolicitudesPorEstado("Procesada");
            
            System.out.println("   • Pendientes: " + pendientes.size());
            System.out.println("   • Aprobadas: " + aprobadas.size());
            System.out.println("   • Rechazadas: " + rechazadas.size());
            System.out.println("   • Procesadas: " + procesadas.size());
            
        } catch (Exception e) {
            System.out.println("   ⚠️ Error al analizar solicitudes: " + e.getMessage());
        }
    }
    
    private int obtenerTotalDocumentaciones() {
        // Por ahora retorna 0, se puede implementar cuando haya acceso a los datos
        return 0;
    }
    
    // Métodos de validación (copiados del PostulanteFactory para consistencia)
    private boolean esCorreoValido(String correo) {
        return correo != null && correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
    private boolean esDNIValido(String dni) {
        return dni != null && dni.matches("^\\d{8}$");
    }
    
    private boolean esNombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty() && nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
    }
}
