
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
       VentanaCarrito ventanaC = new VentanaCarrito(ventana, true);
       
       carritos.add(new Carrito());
       carritos.add(new Carrito());
       carritos.add(new Carrito());
       productos.add(new Producto (25, "Chetos"));
       productos.add(new Producto (275, "Playera"));
       productos.add(new Producto (300, "Pantalon"));
       productos.add(new Producto (10, "Agua"));
       clientes.add(new Cliente("Jose Perez", carritos.get(0), "123"));
       clientes.add(new Cliente("Marco Ortega", carritos.get(1),"456"));
       clientes.add(new Cliente("Javier Munguia", carritos.get(2),"789"));
       Controlador controlador = new Controlador(ventana,carritos,clientes,productos,ventana2, ventanaC);
       
       controlador.iniciar();
        
        
        
    }
    
}
