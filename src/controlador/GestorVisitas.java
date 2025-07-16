package controlador;

import modelo.ListaCircularVisitas;
import modelo.Postulante;
import modelo.Visita;

import java.util.Scanner;

/**
 * La clase GestorVisitas gestiona las visitas realizadas a los postulantes dentro del sistema de becas.
 * Permite registrar una visita para un postulante y mostrar todas las visitas registradas.
 */

public class GestorVisitas {
    private ListaCircularVisitas listaVisitas;

    /**
     * Constructor que inicializa el gestor de visitas con una lista circular de visitas
     * con la capacidad especificada.
     * 
     * @param capacidad La capacidad máxima de la lista circular de visitas.
     */
    
    public GestorVisitas(int capacidad) {
        listaVisitas = new ListaCircularVisitas(capacidad);
    }

    /**
     * Registra una nueva visita para un postulante. Se solicita al usuario el nombre del postulante,
     * la fecha de la visita y las observaciones. Luego, genera un objeto Visita y lo inserta a la lista de visitas.
     */
    
    public void registrarVisita() {
        Scanner sc = new Scanner(System.in);
        
        //Solicita la información al usuario
        System.out.print("Ingrese el nombre del postulante: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la fecha de la visita: ");
        String fecha = sc.nextLine();
        System.out.print("Ingrese observaciones: ");
        String observaciones = sc.nextLine();
        
        //Genera un objeto postulante y visita
        Postulante postulante = new Postulante(nombre, "", "");
        Visita visita = new Visita(postulante, fecha, observaciones);
        
        //Inserta la visita a la lista circular
        listaVisitas.agregarVisita(visita);

        System.out.println("Visita registrada exitosamente.");
    }

    /**
     * Muestra todas las visitas registradas en la lista circular de visitas.
     */
    
    public void mostrarVisitas() {
        listaVisitas.mostrarVisitas();
    }
    
    /**
     * Obtiene la lista circular de visitas.
     * Método agregado para soporte del GeneradorReportes y UnifiedSystemAdapter.
     * 
     * @return La lista circular que contiene todas las visitas
     */
    public ListaCircularVisitas getListaVisitas() {
        return listaVisitas;
    }
    
    /**
     * Obtiene una lista de todas las visitas registradas.
     * Método agregado para facilitar el análisis y reportes.
     * 
     * @return Lista de todas las visitas del sistema
     */
    public java.util.List<Visita> obtenerTodasLasVisitas() {
        java.util.List<Visita> lista = new java.util.ArrayList<>();
        // Si ListaCircularVisitas tiene un método para iterar, lo usamos
        // Por ahora, asumimos que tiene un método para obtener todas las visitas
        try {
            // Intentar usar reflexión para acceder a los datos si no hay método público
            java.lang.reflect.Field field = ListaCircularVisitas.class.getDeclaredField("visitas");
            field.setAccessible(true);
            Object[] visitas = (Object[]) field.get(listaVisitas);
            for (Object v : visitas) {
                if (v != null && v instanceof Visita) {
                    lista.add((Visita) v);
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo acceder a las visitas para el reporte");
        }
        return lista;
    }
}
