
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a description of class Empleado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Empleado {

    // instance variables - replace the example below with your own
    private String dni;
    private String nombre;
    private String puesto;
    private int telefono;
    private String direccion;
    private double sueldoMes;
    final double sueldoBase = 950;
    public ArrayList<Empleado> empleados;

    public Empleado(String dni, String nombre, String puesto, int telefono,
            String direccion, double sueldoMes) {
        this.dni = dni;
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sueldoMes = sueldoMes;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSueldoMes() {
        return sueldoMes;
    }

    public void setSueldoMes(double sueldoMes) {
        this.sueldoMes = sueldoMes;
    }

    public void menuEmpleados() {
        empleados = new ArrayList<Empleado>();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        while (!salir) {
            System.out.println("\n\n\n\n\n\n");
            System.out.println("    MENU EMPLEADOS PARQUE ATRACCIONES");
            System.out.println("    =================================");
            System.out.println("      [1]. Añadir Empleado");
            System.out.println("      [2]. Borrar Empleado");
            System.out.println("      [3]. Listar Empleado");
            System.out.println("      [4]. Salir");

            try {

                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menu");
                System.out.print("    > ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        agregarEmpleado();
                        break;
                    case 2:
                        //borrarEmpleado();
                        break;
                    case 3:
                        //listarEmpleado();
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("\n\n");
                        System.out.println("Solo números entre 1 y 4");
                        System.out.println("\n\n");
                }
            } catch (InputMismatchException e) {

                System.out.println("\n\n");
                System.out.println("Solo números entre 1 y 4");
                System.out.println("\n\n");
                sn.next();
            }
        }
    }

    public void agregarEmpleado() {

        Scanner sn = new Scanner(System.in);
        int opcion; //Guardaremos la opcion del usuario

        try {
            System.out.println();
            System.out.println();
            System.out.println("Introducir datos Empleado");
            System.out.println("=========================");
            System.out.println();

            System.out.print("Dni: ");
            setDni(sn.nextLine());
            System.out.println();

            System.out.print("Nombre: ");
            setNombre(sn.nextLine());
            System.out.println();

            System.out.print("Direccion: ");
            setDireccion(sn.nextLine());
            System.out.println();

            System.out.print("Telefono: ");
            setTelefono(sn.nextInt());
            System.out.println();

            System.out.println("       Puesto de trabajo");
            System.out.println("       =================");
            System.out.println("      [1]. Atencion al Cliente");
            System.out.println("      [2]. Relaciones Publicas");
            System.out.println("      [3]. Responsables de Atraccion");
            System.out.println("      [4]. Ayudante de Atraccion");
            System.out.println();
            System.out.println("    Escribe una de las opciones del puesto");
            System.out.print("    > ");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    setPuesto("Atencion al cliente");
                    setSueldoMes(sueldoBase * 1.10);
                    break;
                case 2:
                    setPuesto("Relaciones Publicas");
                    setSueldoMes(sueldoBase * 1.20);
                    break;
                case 3:
                    setPuesto("Responsables de Atraccion");
                    setSueldoMes(sueldoBase * 1.15);
                    break;
                case 4:
                    setPuesto("Ayudante de Atraccion");
                    setSueldoMes(sueldoBase);
                    break;
                default:
                    System.out.println("\n\n");
                    System.out.println("Solo números entre 1 y 4");
                    System.out.println("\n\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Solo numeros");
            sn.next();
        }
    }
    Empleado emple = new Empleado(dni, nombre, puesto, telefono,
            direccion, sueldoMes);
            empleados.add(emple);
}
