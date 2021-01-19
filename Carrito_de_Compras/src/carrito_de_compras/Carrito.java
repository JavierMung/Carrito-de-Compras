
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
    private ArrayList <Item> item = new ArrayList<Item>();
    private ArrayList <Producto> productos = new ArrayList<Producto>();

    public Carrito() {
        asignarCarrito();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public ArrayList<Item> getItems(){
        return item;
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
    
    public void AgregarProducto(Producto producto, int cantidad){
        for(Item e: item){
            if(e.getProductos().toString().equals(producto.toString())){
                e.setCantidad(cantidad);
                return;
            }
        }
        Item i = new Item (this,producto,cantidad);
        item.add(i);
        
    }
    
    public void Eliminar(Producto producto, int cantidad){
        for(Item e: item){
            if(e.getProductos().toString().equals(producto.toString())){
                e.disminuirCantidad(cantidad);
                return;
            }
        }
    }
    
}
