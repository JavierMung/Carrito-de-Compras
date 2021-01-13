
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
       ArrayList <Producto> catalogo = new ArrayList<Producto>();
       VentanaCarrito ventanaC = new VentanaCarrito(ventana, true);
       
       carritos.add(new Carrito());
       carritos.add(new Carrito());
       carritos.add(new Carrito());
       catalogo.add(new Producto (25, "Chetos"));
       catalogo.add(new Producto (275, "Playera"));
       catalogo.add(new Producto (300, "Pantalon"));
       catalogo.add(new Producto (10, "Agua"));
       catalogo.add(new Producto (40, "Cerveza"));
       catalogo.add(new Producto (24, "Pan"));
       catalogo.add(new Producto (15, "Refresco"));
       
       clientes.add(new Cliente("Jose Perez", carritos.get(0), "123"));
       clientes.add(new Cliente("1", carritos.get(1),"1"));
       clientes.add(new Cliente("Javier Munguia", carritos.get(2),"789"));
       
       Controlador controlador = new Controlador(ventana, carritos, clientes, catalogo, ventana2, ventanaC);
       
       controlador.iniciar();
        
    }
    
}
