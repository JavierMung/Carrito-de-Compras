/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito_de_compras;

/**
 *
 * @author Marco
 */
public class Cliente {
    private String Nombre;
    private Carrito CarroCliente;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Carrito getCarroCliente() {
        return CarroCliente;
    }

    public void setCarroCliente(Carrito CarroCliente) {
        this.CarroCliente = CarroCliente;
    }
    
    public void AgrItem(){
    }
}
