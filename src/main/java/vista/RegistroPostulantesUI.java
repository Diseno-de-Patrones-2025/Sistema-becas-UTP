package vista;

import controlador.GestorPostulantes;
import modelo.Postulante;
import java.util.Scanner;

/**
 * La clase RegistroPostulantesUI es responsable de interactuar con el usuario
 * para registrar a un postulante en el sistema de becas.
 * 
 * Este clase permite ingresar los datos del postulante, como nombre,
 * apellido y correo electrónico, y luego utiliza el gestor de postulantes
 * para registrar esta información en el sistema.
 */

public class RegistroPostulantesUI {
    private GestorPostulantes gestorPostulantes;
    
    /**
     * Constructor de la clase RegistroPostulantesUI.
     * 
     * @param gestorPostulantes El objeto gestor de postulantes utilizado
     *                          para registrar a los postulantes en el sistema.
     */
    
    public RegistroPostulantesUI(GestorPostulantes gestorPostulantes) {
        this.gestorPostulantes = gestorPostulantes;
    }

    /**
     * Método que muestra el menú para registrar a un postulante en el sistema.
     * Este método solicita al usuario que ingrese los datos del postulante,
     * y luego utiliza el gestor de postulantes para registrar la información
     * en el sistema.
     */
    
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del postulante: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido del postulante: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese el correo del postulante: ");
        String correo = sc.nextLine();
        
        //Crea un objeto Postulante con los datos ingresados
        Postulante postulante = new Postulante(nombre, apellido, correo);
        
        //Llama al gestor para registrar al postulante en el sistema
        gestorPostulantes.registrarPostulante(postulante);
        
        System.out.println("Postulante registrado exitosamente.");
    }
}
