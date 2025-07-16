package modelo;

/**
 * Representa una lista circular de visitas realizadas por postulantes en el sistema de becas.
 * La lista tiene una capacidad fija y almacena visitas en orden circular. 
 * Cuando la lista está llena, la visita más antigua se sobrescribe por la nueva.
 */

public class ListaCircularVisitas {
    private Visita[] visitas;
    private int capacidad;
    private int inicio;
    private int fin;
    private int tamaño;

    /**
     * Constructor que inicializa la lista circular de visitas con una capacidad específica.
     * La lista está inicialmente vacía.
     * 
     * @param capacidad La capacidad máxima de la lista de visitas.
     */
    
    public ListaCircularVisitas(int capacidad) {
        this.capacidad = capacidad;
        this.visitas = new Visita[capacidad];
        this.inicio = 0;
        this.fin = -1;
        this.tamaño = 0;
    }
    
    /**
     * Verifica si la lista de visitas está vacía.
     * 
     * @return true si la lista está vacía, false si está llena.
     */
    
    public boolean estaVacia() {
        return tamaño == 0;
    }

    /**
     * Verifica si la lista de visitas está llena.
     * 
     * @return true si la lista está llena, false si está vacía.
     */
    
    public boolean estaLlena() {
        return tamaño == capacidad;
    }
    
    /**
     * Agrega una nueva visita a la lista de visitas. Si la lista está llena, 
     * sobrescribe la visita más antigua (la primera en la lista).
     * 
     * @param visita La visita que se va a agregar a la lista.
     */
    
    public void agregarVisita(Visita visita) {
        if (estaLlena()) {
            System.out.println("Lista de visitas llena. Sobrescribiendo la visita más antigua.");
            inicio = (inicio + 1) % capacidad; //El inicio pasa al siguiente índice
            tamaño--; //Reduce el tamaño de la lista, debido a que la visita más antigua se sobrescribe
        }
        fin = (fin + 1) % capacidad; //El fin pasa al siguiente índice
        visitas[fin] = visita; //Asigna la nueva visita
        tamaño++; //Aumenta el tamaño de la lista
    }
    
    /**
     * Muestra todas las visitas registradas en la lista.
     * Si la lista está vacía, muestra un mensaje indicando que no hay visitas registradas.
     */
    
    public void mostrarVisitas() {
        if (estaVacia()) {
            System.out.println("No hay visitas registradas.");
            return;
        }
        System.out.println("Visitas registradas:");
        for (int i = 0; i < tamaño; i++) {
            int index = (inicio + i) % capacidad;
            Visita visita = visitas[index];
            System.out.println("Postulante: " + visita.getPostulante().getNombre() +
                               " | Fecha: " + visita.getFecha() +
                               " | Observaciones: " + visita.getObservaciones());
        }
    }
}
