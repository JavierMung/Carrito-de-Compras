
package carrito_de_compras;

import javax.swing.JOptionPane;


public class Producto {
    
    private float precio;
    private String nombre;
    private int cantidad;

    @Override
    public String toString() {
        return nombre;
    }

    public Producto(float precio, String nombre, int cantidad) {
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void aumentar(){
        cantidad++;
    }
    
    public void disminuir(int dis){
        if(cantidad-dis>=0){
            cantidad-=dis;
        }else{
            JOptionPane.showMessageDialog(null, "No existen tantos productos en stock");
        }
    }
    
}
