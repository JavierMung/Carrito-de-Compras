
package carrito_de_compras;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Carrito {
    private static int numeroR = 1; 
    private int numero;
    private int NoProductos;
    private ArrayList <Item> productos;    

    public Carrito() {
        asignarCarrito();
    }
    
    
    public int getNoProductos() {
        return NoProductos;
    }

    public void setNoProductos(int NoProductos) {
        this.NoProductos = NoProductos;
    }
    
    private void asignarCarrito(){
        
       numero = numeroR;
        numeroR++;
        
    }
    
    public int getNumero(){
        return numero;
    }
    
    
    
}
