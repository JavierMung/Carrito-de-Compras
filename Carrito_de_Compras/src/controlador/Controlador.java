
package controlador;

import Ventanas.Ventana;
import Ventanas.Ventana2;
import Ventanas.VentanaCarrito;
import carrito_de_compras.Carrito;
import carrito_de_compras.Cliente;
import carrito_de_compras.Producto;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

//En esta clase se hará la conexion de la parte logica con la parte visual
public class Controlador implements ActionListener {
    private Ventana ventana;
    private ArrayList <Carrito> carritos;
    private ArrayList <Cliente> clientes; 
    private ArrayList <Producto> productos; 
    DefaultListModel modelo;
    private Ventana2 ventana2;
    private VentanaCarrito ventanaC;
    private Cliente usuario ;

    public Controlador(Ventana ventana, ArrayList<Carrito> carritos, ArrayList<Cliente> clientes, ArrayList<Producto> productos, Ventana2 ventana2, VentanaCarrito ventanaC) {
        this.ventana = ventana;
        this.carritos = carritos;
        this.clientes = clientes;
        this.productos = productos;
        this.ventana2 = ventana2;
        this.ventanaC = ventanaC;
        
        
    }
    
   
    
    public void iniciar(){
        ventana.setTitle("Carrito de Compras");
        ventana.setLocationRelativeTo(null);
        modelo = new DefaultListModel();
        ventana.setLocationRelativeTo(null);
        iniciarBotones();
        ventana.setVisible(true);
        
        
    }
    
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("entra1");
        if(ventana.boton_IniciarSesion == e.getSource()){
            System.out.println("Entra");
            comprobarUsuario();
        }else if(e.getSource() == ventana2.boton_ver_carrito ){
            verCarrito();
        }
    }
    
    private void asignarProductos (){
    for(Producto e: productos){
        modelo.addElement(e.toString());
    }
    }
    
    
    private void comprobarUsuario(){
        int i= 0;
        
      
        for(Cliente e: clientes){
        if(ventana.text_Usuario.getText().equals(e.getNombre()) && ventana.tex_contraseña.getText().equals(e.getContraseña())){
            usuario = e;
            i=1;           
            }
        }
        
        if(i == 1){
            iniciarSesion(usuario);
        }else {
            JOptionPane.showMessageDialog(null, "Error al iniciar Sesion");
        }
        
     
       
        
    }
    
     private void iniciarSesion(Cliente e){
     ventana.setVisible(false);
     asignarProductos();
     ventana2.setLocationRelativeTo(null);
     ventana2.jList1.setModel(modelo);   
     ventana2.etiqueta_usuario.setText(e.getNombre());
     ventana2.setVisible(true);
     
     }
     
     private void iniciarBotones(){
         ventana.boton_IniciarSesion.addActionListener(this);
         ventana2.boton_agregar_carrito.addActionListener(this);
         ventana2.boton_menos.addActionListener(this);
         ventana2.boton_mas.addActionListener(this);
         ventana2.boton_ver_carrito.addActionListener(this);
     }
     
     private void verCarrito(){
         ventanaC.etiqueta_usuarioCarrito.setText(usuario.getNombre());
         ventanaC.setVisible(true);
     }
     
     
    
    
}
