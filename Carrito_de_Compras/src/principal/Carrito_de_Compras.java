
package principal;

import Ventanas.*;
import carrito_de_compras.*;
import controlador.Controlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//Este es el main donde todo se instanciara
public class Carrito_de_Compras {

    
    public static void main(String[] args) {
       
       Ventana ventana = new Ventana();
       Ventana2 ventana2 = new Ventana2();
       ArrayList <Carrito> carritos = new ArrayList<Carrito>();
       ArrayList <Cliente> clientes = new ArrayList<Cliente>(); 
       ArrayList <Producto> productos = new ArrayList<Producto>();
       
        System.out.println("Hola");
       productos.add(new Producto (25, "Chetos"));
       productos.add(new Producto (275, "Playera"));
       productos.add(new Producto (300, "Pantalon"));
       productos.add(new Producto (10, "Agua"));
       
       Controlador controlador = new Controlador(ventana,carritos,clientes,productos,ventana2);
       
       controlador.iniciar();
        
        
        
    }
    
}
