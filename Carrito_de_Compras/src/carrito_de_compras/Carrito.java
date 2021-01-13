
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
    private ArrayList <Producto> productos = new ArrayList<Producto>();

    public Carrito() {
        asignarCarrito();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
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
    
    public void AgrProd(Producto Pord){
        productos.add(Pord);
    }
    
}
