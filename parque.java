
import java.util.ArrayList;

/**
 * Write a description of class ParqueAtracciones here.
 *
 * @author (Juan Carlos Amor Gutierrez)
 * @version (1.0 5/5/19)
 */

public class parque {

    public ArrayList<Cliente> clientes;
    public ArrayList<Empleado> empleados;
    public ArrayList<Atracciones> atracciones;

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        ArrayList<Atracciones> atracciones = new ArrayList<Atracciones>();
        Menu menu = new Menu(clientes, empleados, atracciones);
        menu.menuPrincipal();
        System.out.println(clientes);
    }
}
