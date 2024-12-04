package vista;

import controlador.GestorSolicitudes;
import java.util.Scanner;

/**
 * La clase ConsultarEstadoSolicitudUI es responsable de interactuar con el usuario
 * para consultar el estado de las solicitudes registradas en el sistema.
 * 
 * Esta clase muestra un menú para que el usuario pueda consultar el estado de las solicitudes
 * que están siendo gestionadas, y utiliza el gestor de solicitudes para obtener la información
 * relevante sobre el estado actual de cada solicitud.
 */

public class ConsultarEstadoSolicitudUI {
    private GestorSolicitudes gestorSolicitudes; //Gestor que maneja las solicitudes

    /**
     * Constructor de la clase ConsultarEstadoSolicitudUI.
     * 
     * @param gestorSolicitudes El objeto gestor de solicitudes que se utiliza
     *                          para acceder a las funcionalidades relacionadas con las solicitudes.
     */
    
    public ConsultarEstadoSolicitudUI(GestorSolicitudes gestorSolicitudes) {
        this.gestorSolicitudes = gestorSolicitudes;
    }

    /**
     * Método que muestra el menú para consultar el estado de las solicitudes.
     * Este método solicita al gestor de solicitudes que consulte y muestre el estado
     * de las solicitudes registradas en el sistema.
     */
    
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Consultar Estado de Solicitudes");
        
        //Llama al método del gestor para consultar y mostrar el estado de las solicitudes
        gestorSolicitudes.consultarEstado();
    }
}
