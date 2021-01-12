
package controlador;

import Ventanas.Ventana;
import Ventanas.Ventana2;
import carrito_de_compras.Carrito;
import carrito_de_compras.Cliente;
import carrito_de_compras.Producto;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

//En esta clase se hará la conexion de la parte logica con la parte visual
public class Controlador implements ActionListener {
    private Ventana ventana;
    private ArrayList <Carrito> carritos;
    private ArrayList <Cliente> clientes; 
    private ArrayList <Producto> productos; 
    DefaultListModel modelo;
    private Ventana2 ventana2;

    public Controlador(Ventana ventana, ArrayList<Carrito> carritos, ArrayList<Cliente> clientes, ArrayList<Producto> productos, Ventana2 ventana2) {
        this.ventana = ventana;
        this.carritos = carritos;
        this.clientes = clientes;
        this.productos = productos;
        this.ventana2 = ventana2;
        
        
    }
    
   
    
    public void iniciar(){
        ventana.setTitle("Carrito de Compras");
        ventana.setLocationRelativeTo(null);
         modelo = new DefaultListModel();
        asignarProductos();
        //ventana.setVisible(false);
        ventana2.setVisible(true);
        ventana2.jList1.setModel(modelo);
    }
    
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    private void asignarProductos (){
    for(Producto e: productos){
        modelo.addElement(e.toString());
    }
    }
    
    
    
}
