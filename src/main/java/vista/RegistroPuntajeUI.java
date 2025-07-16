package vista;

import controlador.GestorPostulantes;
import controlador.GestorDocumentos;
import java.util.Scanner;

/**
 * Permite registrar el puntaje de un postulante que ya tiene documentos registrados.
 */
public class RegistroPuntajeUI {
    private final GestorPostulantes gestorPostulantes;
    private final GestorDocumentos gestorDocumentos;

    public RegistroPuntajeUI(GestorPostulantes gestorPostulantes, GestorDocumentos gestorDocumentos) {
        this.gestorPostulantes = gestorPostulantes;
        this.gestorDocumentos = gestorDocumentos;
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del postulante: ");
        String nombre = sc.nextLine();
        
        // Validar existencia y documentos
        if (!gestorPostulantes.existePostulante(nombre)) {
            System.out.println("El postulante no está registrado.");
            return;
        }
        if (!gestorDocumentos.tieneDocumentos(nombre)) {
            System.out.println("El postulante no tiene documentos registrados.");
            return;
        }
        
        System.out.print("Ingrese el puntaje a asignar: ");
        double puntaje = sc.nextDouble();
        
        boolean ok = gestorPostulantes.asignarPuntaje(nombre, puntaje);
        if (ok) {
            System.out.println("Puntaje registrado exitosamente.");
        } else {
            System.out.println("No se pudo asignar el puntaje.");
        }
    }
}
