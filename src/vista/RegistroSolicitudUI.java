package vista;

import controlador.GestorSolicitudes;
import modelo.Solicitud;
import modelo.Postulante;
import java.util.Scanner;
import Factory.RegistroFactory;

/**
 * La clase RegistroSolicitudUI es responsable de interactuar con el usuario
 * para registrar una nueva solicitud en el sistema de becas.
 * 
 * Este clase permite ingresar los detalles de la solicitud, como el nombre,
 * apellido, correo del postulante y el estado de la solicitud, y luego utiliza
 * el gestor de solicitudes para registrar esta información en el sistema.
 */

public class RegistroSolicitudUI {
    private GestorSolicitudes gestorSolicitudes; //Gestor que maneja las solicitudes

    /**
     * Constructor de la clase RegistroSolicitudUI.
     * 
     * @param gestorSolicitudes El objeto gestor de solicitudes se utiliza
     *                          para registrar las solicitudes en el sistema.
     */
    
    public RegistroSolicitudUI(GestorSolicitudes gestorSolicitudes) {
        this.gestorSolicitudes = gestorSolicitudes;
    }

    /**
     * Método que muestra el menú para registrar una solicitud en el sistema.
     * Este método solicita al usuario que ingrese los datos del postulante
     * y el estado de la solicitud, y luego utiliza el gestor de solicitudes
     * para registrar la solicitud en el sistema.
     */
    
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);

        // Ingresamos los datos de la solicitud
        System.out.println("Ingrese los detalles de la solicitud:");
        System.out.print("Ingrese el nombre del postulante: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido del postulante: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese el correo del postulante: ");
        String correo = sc.nextLine();
        System.out.print("Ingrese el estado de la solicitud (Pendiente, Aprobada, Rechazada): ");
        String estado = sc.nextLine();

        //Genera el postulante con los datos ingresados
        Postulante postulante = RegistroFactory.crearPostulante(nombre, apellido, correo);
        
        //Genera la solicitud con el postulante y el estado
        Solicitud solicitud = RegistroFactory.crearSolicitud(postulante);

        //Registra la solicitud en el gestor
        gestorSolicitudes.registrarSolicitud(solicitud);

        System.out.println("Solicitud registrada exitosamente.");
    }
}
