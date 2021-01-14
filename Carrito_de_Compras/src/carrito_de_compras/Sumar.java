
package carrito_de_compras;


public class Sumar {
    private Carrito carrito;
    private float resultado;

    public Sumar(Carrito carrito) {
        this.carrito = carrito;
        resultado = 0;
    }
    
    public float sumar(){
        for(int i=0 ; i<carrito.getProductos().size();i++){
             resultado += carrito.getProductos().get(i).getPrecio();
        }
       return resultado;
    }
    
    public float sumarVentana2(Producto producto, int i){
        return resultado += (producto.getPrecio()*i);
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
    
}
