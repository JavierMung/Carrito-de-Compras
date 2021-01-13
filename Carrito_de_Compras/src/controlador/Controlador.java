
package controlador;

import Ventanas.Ventana;
import Ventanas.Ventana2;
import Ventanas.VentanaCarrito;
import carrito_de_compras.Carrito;
import carrito_de_compras.Cliente;
import carrito_de_compras.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

//En esta clase se hará la conexion de la parte logica con la parte visual
public class Controlador implements ActionListener {
    private Ventana ventana;
    private Carrito Carro;
    private ArrayList <Carrito> carritos;
    private ArrayList <Cliente> clientes; 
    private ArrayList <Producto> productos; 
    DefaultListModel modelo;
    DefaultListModel ModeCarrito;
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
   
    
    public void iniciar(){          //
        ventana.setTitle("Carrito de Compras");
        ventana.setLocationRelativeTo(null);
        modelo = new DefaultListModel();
        ModeCarrito = new DefaultListModel();
        ventana.setLocationRelativeTo(null);
        iniciarBotones();
        ventana.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("entra1");
        
        if(ventana.boton_IniciarSesion == e.getSource()){
            //System.out.println("Entra");
            comprobarUsuario();
        }else if(e.getSource() == ventana2.boton_ver_carrito ){
            verCarrito();
        }else if(e.getSource() == ventanaC.boton_regresar){
            comprobarUsuario();
        }else if(e.getSource() == ventana2.boton_agregar_carrito){
            AgrCarrito();
        }
    }
    
    private void asignarProductos (){
        for(Producto e: productos){
            modelo.addElement(e.toString());
        }
    }
     
    private void asignarProductosCarr (){
        for(Producto e: usuario.getCarroCliente().getProductos()){
            ModeCarrito.addElement(e.toString());
        }
    }
    
    private void comprobarUsuario(){        //FUNCION PARA VERIFICAR EL USUARIO Y CONTRASENNA 
        int i= 0;
      
        for(Cliente e: clientes){
            if(ventana.text_Usuario.getText().equals(e.getNombre()) && ventana.tex_contraseña.getText().equals(e.getContraseña())){
                usuario = e;
                i = 1;
            }
        }
        
        if(i == 1){
            iniciarSesion(usuario);
        }else {
            JOptionPane.showMessageDialog(null, "Error al iniciar Sesion");
        }
    }
    
     private void iniciarSesion(Cliente e){     //FUNCION QUE MUESTRA LA PANTALLA DE 
        ventana.setVisible(false);
        asignarProductos();
        ventana2.setLocationRelativeTo(null);
        ventana2.jList1.setModel(modelo);   
        ventana2.etiqueta_usuario.setText(e.getNombre());
        ventana2.setVisible(true);
     
     }
     
     private void iniciarBotones(){     //FUNCION PARA INICIALIZAR LOS BTONES DE LAS VENTANAS
         ventana.boton_IniciarSesion.addActionListener(this);
         ventana2.boton_agregar_carrito.addActionListener(this);
         ventana2.boton_menos.addActionListener(this);
         ventana2.boton_mas.addActionListener(this);
         ventana2.boton_ver_carrito.addActionListener(this);
         ventanaC.boton_regresar.addActionListener(this);
     }
     
     private void verCarrito(){     //FUNCION PARA DESPLEGAR LA VENTANA DEL CARRITO
         asignarProductosCarr();
         ventanaC.Lista_Ventana_Carrito.setModel(ModeCarrito); 
         ventanaC.setVisible(true);
         ventanaC.etiqueta_usuarioCarrito.setText(usuario.getNombre());
         
     }
     
     private void AgrCarrito(){     //FUNCION PARA AGREGAR LOS ITEMS AL CARRITO DEL USUARIO
         int i =0;
         
         for (i = 0;i < productos.size(); i ++) {
            if(ventana2.jList1.getSelectedValue().equals(productos.get(i).getNombre())){
                 System.out.println(productos.get(i).getNombre());
                 usuario.getCarroCliente().AgrProd(productos.get(i));
            }
        }
     }
     
}
