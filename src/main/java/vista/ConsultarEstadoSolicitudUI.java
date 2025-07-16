package vista;

import controlador.GestorSolicitudes;
import modelo.Solicitud;
import java.util.Scanner;

/**
 * Interfaz de usuario para consultar el estado de solicitudes.
 * Proporciona diferentes opciones para consultar solicitudes activas y procesadas.
 */
public class ConsultarEstadoSolicitudUI {
    private final GestorSolicitudes gestorSolicitudes;
    
    /**
     * Constructor que inicializa la UI con el gestor de solicitudes.
     * 
     * @param gestorSolicitudes El gestor de solicitudes del sistema.
     */
    public ConsultarEstadoSolicitudUI(GestorSolicitudes gestorSolicitudes) {
        this.gestorSolicitudes = gestorSolicitudes;
    }
    
    /**
     * Muestra el menú de opciones para consultar solicitudes.
     */
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n--- Consultar Estado de Solicitudes ---");
        System.out.println("1. Ver todas las solicitudes activas");
        System.out.println("2. Buscar solicitud por nombre de postulante");
        System.out.println("3. Ver historial de solicitudes procesadas");
        System.out.println("4. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        
        int opcion = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        
        switch (opcion) {
            case 1 -> mostrarSolicitudesActivas();
            case 2 -> buscarSolicitudPorNombre(sc);
            case 3 -> mostrarHistorialSolicitudes();
            case 4 -> System.out.println("Volviendo al menú principal...");
            default -> System.out.println("Opción no válida.");
        }
    }
    
    /**
     * Muestra todas las solicitudes activas en el sistema.
     */
    private void mostrarSolicitudesActivas() {
        System.out.println("\n=== SOLICITUDES ACTIVAS ===");
        gestorSolicitudes.consultarEstado();
    }
    
    /**
     * Busca una solicitud específica por nombre del postulante.
     * 
     * @param sc Scanner para leer la entrada del usuario.
     */
    private void buscarSolicitudPorNombre(Scanner sc) {
        System.out.print("Ingrese el nombre del postulante: ");
        String nombre = sc.nextLine();
        
        boolean encontrado = false;
        System.out.println("\n=== RESULTADO DE BÚSQUEDA ===");
        
        for (Solicitud solicitud : gestorSolicitudes.obtenerSolicitudes()) {
            if (solicitud.getPostulante().getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Postulante: " + solicitud.getPostulante().getNombre() + 
                                 " " + solicitud.getPostulante().getApellido());
                System.out.println("Programa: " + solicitud.getPrograma());
                System.out.println("Estado: " + solicitud.getEstado());
                System.out.println("Fecha: " + solicitud.getFecha());
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontró ninguna solicitud activa para: " + nombre);
        }
    }
    
    /**
     * Muestra el historial de solicitudes procesadas.
     */
    private void mostrarHistorialSolicitudes() {
        System.out.println("\n=== HISTORIAL DE SOLICITUDES ===");
        gestorSolicitudes.mostrarHistorial();
    }
}
