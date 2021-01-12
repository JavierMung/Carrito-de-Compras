
package controlador;

import Ventanas.Ventana;
import carrito_de_compras.Carrito;
import carrito_de_compras.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener {
    private Ventana ventana;
    private Cliente cliente;
    private Carrito carrito;

    public Controlador(Ventana ventana, Cliente cliente, Carrito carrito) {
        this.ventana = ventana;
        this.cliente = cliente;
        this.carrito = carrito;
        ventana.setVisible(true);
    }
    
    public void iniciar(){
        ventana.setTitle("Carrito de Compras");
        ventana.setLocationRelativeTo(null);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
}
