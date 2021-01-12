
package carrito_de_compras;


public class Producto {
    
    private float precio;
    private String nombre;

    @Override
    public String toString() {
        return nombre;
    }

    public Producto(float precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
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
    
}
