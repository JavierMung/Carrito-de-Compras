
package carrito_de_compras;

// 
public class Cliente {
    private String Nombre;
    private Carrito CarroCliente;

    public Cliente(String Nombre, Carrito carro) {
        this.Nombre = Nombre;
        this.CarroCliente = carro;
    }

    public Cliente() {
    }
    
    
    public String getNombre() {
        return Nombre;
    }

    

    public int getCarroCliente() {
        return CarroCliente.getNumero();
    }

   
    
    public void AgrItem(){
    }
   
    
}
