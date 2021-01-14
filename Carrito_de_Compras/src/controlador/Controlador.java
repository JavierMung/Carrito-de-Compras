
package controlador;

import Ventanas.Ventana;
import Ventanas.Ventana2;
import Ventanas.VentanaCarrito;
import carrito_de_compras.Carrito;
import carrito_de_compras.Cliente;
import carrito_de_compras.Producto;
import carrito_de_compras.Sumar;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
    DefaultListModel limpiar = new DefaultListModel(); 
    private Ventana2 ventana2;
    private VentanaCarrito ventanaC;
    private Cliente usuario ;
    ImageIcon ipn;
    ImageIcon escom;
    ImageIcon carrito;
    private Sumar suma;
    private int contador = 1;
  
    
    public Controlador(Ventana ventana, ArrayList<Carrito> carritos, ArrayList<Cliente> clientes, ArrayList<Producto> productos, Ventana2 ventana2, VentanaCarrito ventanaC) {
        this.ventana = ventana;
        this.carritos = carritos;
        this.clientes = clientes;
        this.productos = productos;
        this.ventana2 = ventana2;
        this.ventanaC = ventanaC;
    }
   
    
    public void iniciar(){          //INICIA TODOS LOS COMPONENTES DE LA VENTANA PRINCIPAL
        ventana.setTitle("Carrito de Compras");
        ventana.setLocationRelativeTo(null);
        modelo = new DefaultListModel();
        ModeCarrito = new DefaultListModel();
        ventana.setLocationRelativeTo(null);
        iniciarBotones();
        ipn = new ImageIcon(getClass().getResource("/Imagenes/ipn.png"));
        escom = new ImageIcon(getClass().getResource("/Imagenes/escom.png"));
        carrito = new ImageIcon(getClass().getResource("/Imagenes/carrito.png"));
        ventana.imagen_ipn.setIcon(new ImageIcon(ipn.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        ventana.imagen_escom.setIcon(new ImageIcon(escom.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        ventana2.imagen_Carrito.setIcon(new ImageIcon(carrito.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH)));
        
        ventana.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ventana.boton_IniciarSesion == e.getSource()){
            comprobarUsuario();
        }else if(e.getSource() == ventana2.boton_ver_carrito ){
            verCarrito();
        }else if(e.getSource() == ventanaC.boton_regresar){
            contador=1;
            ventanaC.Lista_Ventana_Carrito.setModel(limpiar);
            ventanaC.setVisible(false);     
        }else if(e.getSource() == ventana2.boton_agregar_carrito){
            AgrCarrito();
        }else if(e.getSource() == ventana2.boton_mas){
            aumentar();
        }else if(e.getSource() == ventana2.boton_menos){
            disminuir();
        }else if(e.getSource() == ventana2.menu_salir){
            salir();
        }
    }
    
    private void asignarProductos (){
        modelo.clear();
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
        contador =1;
        ventana.setVisible(false);
        System.out.println(ventana2.numero_producto.getText());
        ventana2.etiqueta_total_ventana2.setText("0");
        asignarProductos();
        ventana2.setLocationRelativeTo(null);
        ventana2.jList1.setModel(modelo);   
        ventana2.etiqueta_usuario.setText(e.getNombre());
        suma = new Sumar (usuario.getCarroCliente());
        ventana2.setVisible(true);
        
     
     }
     
     private void iniciarBotones(){     //FUNCION PARA INICIALIZAR LOS BTONES DE LAS VENTANAS
         ventana.boton_IniciarSesion.addActionListener(this);
         ventana2.boton_agregar_carrito.addActionListener(this);
         ventana2.boton_menos.addActionListener(this);
         ventana2.boton_mas.addActionListener(this);
         ventana2.boton_ver_carrito.addActionListener(this);
         ventanaC.boton_regresar.addActionListener(this);
         ventana2.menu_salir.addActionListener(this);
         
     }
     
     private void verCarrito(){     //FUNCION PARA DESPLEGAR LA VENTANA DEL CARRITO
         ModeCarrito.clear();
         asignarProductosCarr();
         resultado();
         System.out.println(usuario.getNombre());
         ventanaC.Lista_Ventana_Carrito.setModel(ModeCarrito); 
         ventanaC.setLocationRelativeTo(null);
         ventanaC.etiqueta_usuarioCarrito.setText(usuario.getNombre());
         ventanaC.setVisible(true);
         System.out.println(usuario.getNombre());
     }
     
     private void AgrCarrito(){     //FUNCION PARA AGREGAR LOS ITEMS AL CARRITO DEL USUARIO
         int i =0;
         
         for (i = 0;i < productos.size(); i ++) {
            if(ventana2.jList1.getSelectedValue().equals(productos.get(i).getNombre())){
                 System.out.println(productos.get(i).getNombre());
                 if(Integer.parseInt(ventana2.numero_producto.getText()) <= 0 ){
                     JOptionPane.showMessageDialog(ventana, "Seleccione más de un producto");
                 }else{
                    
                    for(int j=0;j< Integer.parseInt(ventana2.numero_producto.getText()) ;j++){
                    usuario.getCarroCliente().AgrProd(productos.get(i));
                    
                 }
                    ventana2.etiqueta_total_ventana2.setText(Float.toString(suma.sumarVentana2(productos.get(i), Integer.parseInt(ventana2.numero_producto.getText()))));
                 
            }
          }
         
        }
         System.out.println("numero"+ventana2.numero_producto.getText());
         ventana2.numero_producto.setText("1");
         contador=1;
     }
     
     private void resultado(){ //FUNCION PARA REALIZAR LA SUMA DE LOS PRODUCTOS
         suma.setResultado(0);
         ventanaC.etiqueta_total.setText(Float.toString(suma.sumar()));
     }
     
     private void aumentar(){ //fUNCION PARA AUMENTAR EL CONTADOR DE LOS PRODUCTOS
         System.out.println("entra");
         System.out.println(contador);
         contador++;
         ventana2.numero_producto.setText(Integer.toString(contador));
     }
     
     private void disminuir(){ //FUNCION PARA DISMINUIR EL CONTADOR DE LOS PRODUCTOS
         if(contador>0){
             System.out.println(contador);
             contador--;
             ventana2.numero_producto.setText(Integer.toString(contador));
         }
        
     }
     
     private void salir(){
         ventana2.setVisible(false);
         ventana.setVisible(true);
         usuario = null;
         limpiar();
         
     }

    private void limpiar() {
        
        ModeCarrito.clear();
        ventana.text_Usuario.setText("");
        ventana.tex_contraseña.setText("");
        suma.setResultado(0);
        
        
        
    }
     
}
