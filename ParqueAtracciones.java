
import java.util.ArrayList;


/**
 * Write a description of class ParqueAtracciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//import java.util.InputMismatchException;
//import java.util.Scanner;
 
public class ParqueAtracciones
{
    private ArrayList<Cliente> clientes;
        
    public static void main(String[] args) 
    {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Menu menu = new Menu(clientes);
        menu.menuPrincipal();
    }
}   