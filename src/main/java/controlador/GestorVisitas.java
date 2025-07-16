package controlador;

import modelo.ListaCircularVisitas;
import modelo.Visita;
import java.util.Scanner;

/**
 * Gestor para el manejo de visitas en el sistema.
 */
public class GestorVisitas {
    private ListaCircularVisitas listaVisitas;
    
    /**
     * Constructor que inicializa el gestor con una capacidad específica.
     * 
     * @param capacidad La capacidad máxima de visitas.
     */
    public GestorVisitas(int capacidad) {
        this.listaVisitas = new ListaCircularVisitas(capacidad);
    }
    
    /**
     * Registra una nueva visita.
     */
    public void registrarVisita() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del visitante: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el motivo de la visita: ");
        String motivo = sc.nextLine();
        
        Visita visita = new Visita(nombre, motivo);
        
        if (listaVisitas.agregar(visita)) {
            System.out.println("Visita registrada exitosamente.");
        } else {
            System.out.println("No se pudo registrar la visita. Lista llena.");
        }
    }
    
    /**
     * Muestra todas las visitas registradas.
     */
    public void mostrarVisitas() {
        if (listaVisitas.estaVacia()) {
            System.out.println("No hay visitas registradas.");
            return;
        }
        
        System.out.println("Visitas registradas:");
        Visita[] visitas = listaVisitas.obtenerVisitas();
        for (int i = 0; i < visitas.length; i++) {
            System.out.println((i + 1) + ". " + visitas[i].getNombreVisitante() + 
                             " - " + visitas[i].getMotivo() + 
                             " - " + visitas[i].getFecha());
        }
    }
}
