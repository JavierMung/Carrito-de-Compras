
package carrito_de_compras;

import javax.swing.JOptionPane;


public class Item {
    private Carrito carrito;
    private Producto productos;
    private int cantidad = 0;

    public Item(Carrito carrito, Producto productos, int cantidad) {
        this.carrito = carrito;
        this.productos = productos;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad += cantidad;
    }
    public void disminuirCantidad(int cantidad){ //ESTE METODO DISMINUYE LA CANTIDAD DE PRODUCTOS QUE HAY EN EL CARRO
        if(this.cantidad-cantidad>=0){
            this.cantidad -= cantidad;
        }else
            JOptionPane.showMessageDialog(null, "No se pudo completar la accion");
        
    }
    
    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) { //ASIGANA UN CARRO AL ITEM
        this.carrito = carrito;
    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {//LE DICE QUE PRODUCTO VA A GUARDAR
        this.productos = productos;
    }

    @Override
    public String toString() {
        return productos.getNombre();
    }
    
    
    
}
