package vista;

import controlador.GestorPostulantes;
import java.util.Scanner;

/**
 * Interfaz de usuario para registrar postulantes
 */
public class RegistroPostulantesUI {
    private GestorPostulantes gestorPostulantes;
    
    public RegistroPostulantesUI(GestorPostulantes gestorPostulantes) {
        this.gestorPostulantes = gestorPostulantes;
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
        
        gestorPostulantes.registrarPostulante(nombre, apellido, dni, correo);
        System.out.println("Postulante registrado exitosamente.");
    }
}
