package controlador;

import vista.*;
import java.util.Scanner;

/**
 * La clase SistemaBecas es el punto de entrada y gestión principal para todo el sistema de becas
 * para traslados internacionales. Gestiona los postulantes, las solicitudes, las visitas y la documentación
 * a través de diversas interfaces de usuario (UI).
 * 
 * El sistema permite realizar registros, consultar información, actualizar el estado de solicitudes,
 * procesar solicitudes, registrar visitas, y mostrar el historial y estado de las solicitudes y documentos.
 */

public class SistemaBecas {
    private GestorPostulantes gestorPostulantes;
    private GestorSolicitudes gestorSolicitudes;
    private GestorVisitas gestorVisitas;
    private GestorDocumentos gestorDocumentaciones;

    /**
     * Constructor de la clase SistemaBecas. Inicializa los gestores correspondientes para
     * postulantes, solicitudes, visitas y documentación.
     * 
     * Asigna una capacidad para cada estructura que gestiona las solicitudes y visitas
     */
    
    public SistemaBecas() {
        this.gestorPostulantes = new GestorPostulantes();
        this.gestorSolicitudes = new GestorSolicitudes(10); //Cola circular con capacidad 10
        this.gestorVisitas = new GestorVisitas(5); //Lista circular con capacidad 5
        this.gestorDocumentaciones = new GestorDocumentos();
    }

    /**
     * Método principal para iniciar el sistema. Este método presenta un menú interactivo que
     * permite al usuario seleccionar diferentes opciones relacionadas con el registro de postulantes,
     * solicitudes, visitas y documentación, entre otras funcionalidades.
     * El menú se mantiene activo hasta que el usuario decida salir (opción 13).
     */
    
    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        
        //Bucle que muestra el menú y permite interactuar con el sistema
        while (true) {
            System.out.println("\n--- Sistema de Becas para Traslados Internacionales ---");
            System.out.println("1. Registro de Postulante");
            System.out.println("2. Registro de Documentos");
            System.out.println("3. Registro de Solicitud");
            System.out.println("4. Actualizar Estado de Solicitud");
            System.out.println("5. Procesar Solicitud");
            System.out.println("6. Registrar Visitas");
            System.out.println("7. Mostrar Visitas");
            System.out.println("8. Buscar Postulante");
            System.out.println("9. Mostrar Postulantes");
            System.out.println("10. Consultar Estado de Solicitudes");
            System.out.println("11. Mostrar Historial de Solicitudes");
            System.out.println("12. Mostrar Documentacion");
            System.out.println("13. Generar Reporte");
            System.out.println("14. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            
            //El switch case ejecuta las acciones basadas en la opción seleccionada por el usuario
            switch (opcion) {
                //Opción que registra un postulante
                case 1 -> {
                    RegistroPostulantesUI registroPostulanteUI = new RegistroPostulantesUI(gestorPostulantes);
                    registroPostulanteUI.mostrarMenu();
                }
                //Opción que registra los documentos de un postulante
                case 2 -> {
                    RegistroDocumentosUI registroDocumentoUI = new RegistroDocumentosUI(gestorDocumentaciones);
                    registroDocumentoUI.mostrarMenu();
                }
                //Opción que registra una solicitud de beca
                case 3 -> {
                    RegistroSolicitudUI registroSolicitudUI = new RegistroSolicitudUI(gestorSolicitudes);
                    registroSolicitudUI.mostrarMenu();
                }
                //Opción que actualiza el estado de una solicitud (pendiente, aprobada, rechazada)
                case 4 -> {
                    sc.nextLine(); //Consume el salto de línea
                    System.out.print("Ingrese el nombre del postulante que se actualizará su estado: ");
                    String nombrePostulante=sc.nextLine();
                    System.out.print("Ingrese el nuevo estado (Pendiente, Aprobada, Rechazada): ");
                    String nuevoEstado=sc.nextLine();
                    gestorSolicitudes.actualizarEstado(nombrePostulante,nuevoEstado);
                    break;
                }
                case 5 -> gestorSolicitudes.procesarSolicitud();
                case 6 -> gestorVisitas.registrarVisita();
                case 7 -> gestorVisitas.mostrarVisitas();
                //Opción que busca un postulante por su nombre
                case 8 -> {
                    sc.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nombre del postulante a buscar: ");
                    String nombre = sc.nextLine();
                    gestorPostulantes.buscarPostulante(nombre);
                }
                case 9 -> gestorPostulantes.mostrarPostulantes();
                case 10 -> gestorSolicitudes.consultarEstado();
                case 11 -> gestorSolicitudes.mostrarHistorial();
                //Opción que muestra la documentación de un postulante por su nombre
                case 12 -> {
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del postulante a consultar");
                    String nombre=sc.nextLine();
                    gestorDocumentaciones.mostrarDocumentos(nombre);
                }
                //Opción que genera reportes del sistema con todas las mejoras implementadas
                case 13 -> {
                    GeneradorReportes generador = new GeneradorReportes(gestorPostulantes, gestorSolicitudes, gestorVisitas);
                    generador.generarReporteCompleto();
                }
                //Opción que finaliza el programa
                case 14 -> {
                    System.out.println("Gracias por usar el Sistema de Becas. ¡Hasta luego!");
                    sc.close(); //Cierra el Scanner al concluir el programa
                    return; //Retorna fuera del bucle, finalizando el programa
                }
                //Se visualiza en caso de haber ingresado una opción no válida
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
