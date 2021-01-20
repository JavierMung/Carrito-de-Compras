
package carrito_de_compras;


public class Sumar {
    private Carrito carrito;
    private float resultado;
    private float aux=0;

    public Sumar(Carrito carrito) {
        this.carrito = carrito;
        resultado = 0;
    }
    
    public float sumar(){
        for(Item e: carrito.getItems()){
             resultado += (e.getProductos().getPrecio()*e.getCantidad());
        }
       return resultado;
    }
    
    public float sumarVentana2(Producto producto, int i){
        return aux += (producto.getPrecio()*i);
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public float getAux() {
        return aux;
    }

    public void setAux(float aux) {
        this.aux = aux;
    }
    
    
}
