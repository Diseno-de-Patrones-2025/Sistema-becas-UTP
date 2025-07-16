package vista;

import controlador.GestorSolicitudes;
import modelo.Postulante;
import java.util.Scanner;
import java.util.Date;

/**
 * Interfaz de usuario para registrar solicitudes
 */
public class RegistroSolicitudUI {
    private final GestorSolicitudes gestorSolicitudes;

    public RegistroSolicitudUI(GestorSolicitudes gestorSolicitudes) {
        this.gestorSolicitudes = gestorSolicitudes;
    }
    
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del postulante: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido del postulante: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese el DNI del postulante: ");
        String dni = sc.nextLine();
        System.out.print("Ingrese el correo del postulante: ");
        String correo = sc.nextLine();
        System.out.print("Ingrese el programa de beca solicitado: ");
        String programa = sc.nextLine();
        
        Postulante postulante = new Postulante(nombre, apellido, dni, correo);
        Date fecha = new Date();
        
        gestorSolicitudes.registrarSolicitud(postulante, programa, fecha);
        System.out.println("Solicitud registrada exitosamente.");
    }
}
