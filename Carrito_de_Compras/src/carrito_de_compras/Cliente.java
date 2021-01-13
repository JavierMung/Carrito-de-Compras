
package carrito_de_compras;

// 
public class Cliente {
    private String Nombre;
    private Carrito CarroCliente;
    private String contraseña;
    
    public Cliente(String Nombre, Carrito carro, String contraseña) {
        this.Nombre = Nombre;
        this.CarroCliente = carro;
        this.contraseña= contraseña;
    }

    public Cliente() {
    }
    
    
    public String getNombre() {
        return Nombre;
    }

    public Carrito getCarroCliente() {
        return CarroCliente;
    }
    
    public void AgrItem(){
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
   
}
