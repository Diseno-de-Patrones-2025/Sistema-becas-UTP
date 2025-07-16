package controlador;

import vista.*;
import java.util.Scanner;

/**
 * La clase SistemaBecas es el punto de entrada y gestión principal para todo el sistema de becas
 * para traslados internacionales. Gestiona los postulantes, las solicitudes, las visitas y la documentación
 * a través de diversas interfaces de usuario (UI).
 */
public class SistemaBecas {
    private GestorPostulantes gestorPostulantes;
    private GestorSolicitudes gestorSolicitudes;
    private GestorVisitas gestorVisitas;
    private GestorDocumentos gestorDocumentaciones;

    /**
     * Constructor de la clase SistemaBecas. Inicializa los gestores correspondientes.
     */
    public SistemaBecas() {
        this.gestorPostulantes = new GestorPostulantes();
        this.gestorSolicitudes = new GestorSolicitudes(10); //Cola circular con capacidad 10
        this.gestorVisitas = new GestorVisitas(5); //Lista circular con capacidad 5
        this.gestorDocumentaciones = new GestorDocumentos();
    }

    /**
     * Método principal para iniciar el sistema con menú interactivo.
     */
    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Sistema de Becas para Traslados Internacionales ---");
            System.out.println("1. Registro de Postulante");
            System.out.println("2. Registro de Documentos");
            System.out.println("3. Registro de Puntaje");
            System.out.println("4. Registro de Solicitud");
            System.out.println("5. Actualizar Estado de Solicitud");
            System.out.println("6. Procesar Solicitud");
            System.out.println("7. Registrar Visitas");
            System.out.println("8. Mostrar Visitas");
            System.out.println("9. Buscar Postulante");
            System.out.println("10. Mostrar Postulantes");
            System.out.println("11. Consultar Estado de Solicitudes");
            System.out.println("12. Mostrar Historial de Solicitudes");
            System.out.println("13. Mostrar Documentacion");
            System.out.println("14. Generar Reporte");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    RegistroPostulantesUI registroPostulanteUI = new RegistroPostulantesUI(gestorPostulantes);
                    registroPostulanteUI.mostrarMenu();
                }
                case 2 -> {
                    RegistroDocumentosUI registroDocumentoUI = new RegistroDocumentosUI(gestorDocumentaciones);
                    registroDocumentoUI.mostrarMenu();
                }
                case 3 -> {
                    RegistroPuntajeUI registroPuntajeUI = new RegistroPuntajeUI(gestorPostulantes, gestorDocumentaciones);
                    registroPuntajeUI.mostrarMenu();
                }
                case 4 -> {
                    RegistroSolicitudUI registroSolicitudUI = new RegistroSolicitudUI(gestorSolicitudes);
                    registroSolicitudUI.mostrarMenu();
                }
                case 5 -> {
                    sc.nextLine();
                    System.out.print("Ingrese el nombre del postulante que se actualizará su estado: ");
                    String nombrePostulante=sc.nextLine();
                    System.out.print("Ingrese el nuevo estado (Pendiente, Aprobada, Rechazada): ");
                    String nuevoEstado=sc.nextLine();
                    gestorSolicitudes.actualizarEstado(nombrePostulante,nuevoEstado);
                    break;
                }
                case 6 -> gestorSolicitudes.procesarSolicitud();
                case 7 -> gestorVisitas.registrarVisita();
                case 8 -> gestorVisitas.mostrarVisitas();
                case 9 -> {
                    sc.nextLine();
                    System.out.print("Ingrese el nombre del postulante a buscar: ");
                    String nombre = sc.nextLine();
                    gestorPostulantes.buscarPostulante(nombre);
                }
                case 10 -> gestorPostulantes.mostrarPostulantes();
                case 11 -> gestorSolicitudes.consultarEstado();
                case 12 -> gestorSolicitudes.mostrarHistorial();
                case 13 -> {
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del postulante a consultar");
                    String nombre=sc.nextLine();
                    gestorDocumentaciones.mostrarDocumentos(nombre);
                }
                case 14 -> {
                    GeneradorReportes generador = new GeneradorReportes(gestorPostulantes, gestorSolicitudes, gestorVisitas);
                    generador.generarReporteCompleto();
                }
                case 15 -> {
                    System.out.println("Gracias por usar el Sistema de Becas. ¡Hasta luego!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
