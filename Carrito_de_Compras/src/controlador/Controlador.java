
package controlador;

import Ventanas.Ventana;
import Ventanas.Ventana2;
import Ventanas.VentanaCarrito;
import Ventanas.VentanaInformacion;
import carrito_de_compras.Carrito;
import carrito_de_compras.Cliente;
import carrito_de_compras.Item;
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
    private VentanaInformacion informacion;
    private Carrito Carro;
    private ArrayList <Carrito> carritos;
    private ArrayList <Cliente> clientes; 
    private ArrayList <Producto> productos; 
    private Ventana2 ventana2;
    private VentanaCarrito ventanaC;
    private Cliente usuario ;
    private Sumar suma;
    private int contador = 1;
    ImageIcon ipn;
    ImageIcon escom;
    ImageIcon carrito; 
    ImageIcon refresco;
    ImageIcon pantalon;
    ImageIcon cerveza;
    ImageIcon pan;
    ImageIcon agua;
    ImageIcon chetos;
    ImageIcon playera;
    DefaultListModel modelo;
    DefaultListModel ModeCarrito;
    DefaultListModel limpiar = new DefaultListModel();     
    
    public Controlador(Ventana ventana, ArrayList<Carrito> carritos, ArrayList<Cliente> clientes, ArrayList<Producto> productos, Ventana2 ventana2, VentanaCarrito ventanaC, VentanaInformacion informacion) {
        this.ventana = ventana;
        this.carritos = carritos;
        this.clientes = clientes;
        this.productos = productos;
        this.ventana2 = ventana2;
        this.ventanaC = ventanaC;
        this.informacion= informacion;
    }
   
    
    public void iniciar(){          //INICIA TODOS LOS COMPONENTES DE LA VENTANA PRINCIPAL
        ventana.setTitle("Carrito de Compras");
        ventana.setLocationRelativeTo(null);
        modelo = new DefaultListModel();
        ModeCarrito = new DefaultListModel();
        ventana.setLocationRelativeTo(null);
        iniciarBotones();
        iniciarImagenes();
        ventana.setVisible(true);
    }
    
    private void iniciarImagenes(){ //METODO PARA INSERTAR LAS IMAGENES DE LOS MENUS
        ipn = new ImageIcon(getClass().getResource("/Imagenes/ipn.png"));
        escom = new ImageIcon(getClass().getResource("/Imagenes/escom.png"));
        carrito = new ImageIcon(getClass().getResource("/Imagenes/carrito.png"));
        refresco = new ImageIcon(getClass().getResource("/Imagenes/refresco.png"));
        pantalon = new ImageIcon(getClass().getResource("/Imagenes/pantalon.png"));
        cerveza = new ImageIcon(getClass().getResource("/Imagenes/cerveza.png"));
        pan = new ImageIcon(getClass().getResource("/Imagenes/pan.png"));
        agua = new ImageIcon(getClass().getResource("/Imagenes/agua.png"));
        chetos = new ImageIcon(getClass().getResource("/Imagenes/chetos.png"));
        playera = new ImageIcon(getClass().getResource("/Imagenes/playera.png"));
        ventana.imagen_ipn.setIcon(new ImageIcon(ipn.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        ventana.imagen_escom.setIcon(new ImageIcon(escom.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        ventana2.imagen_Carrito.setIcon(new ImageIcon(carrito.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH)));
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ventana.boton_IniciarSesion == e.getSource()){
            comprobarUsuario();
        }else if(e.getSource() == ventana2.boton_ver_carrito ){
            verCarrito();
        }else if(e.getSource() == ventanaC.boton_regresar){
            ventana2.etiqueta_total_ventana2.setText("0");
            suma.setAux(0);
            contador=1;
            ventanaC.Lista_Ventana_Carrito.setModel(limpiar);
            ventanaC.setVisible(false);     
        }else if(e.getSource() == ventana2.boton_agregar_carrito){
            agregarCarrito(); //AgrCarrito();
        }else if(e.getSource() == ventana2.boton_mas){
            aumentar();
        }else if(e.getSource() == ventana2.boton_menos){
            disminuir();
        }else if(e.getSource() == ventana2.menu_salir){
            salir();
        }else if(e.getSource() == ventana2.boton_ver_informacion){
            verInformacion();
        }else if(e.getSource() == ventanaC.boton_eliminar){
            eliminar();
           //eliminarProducto();
        }
    }
    
    private void asignarProductos (){ //METODO PARA ASIGNAR LOS PRODUCTOS A LA VENTANA 2
        modelo.clear();
        for(Producto e: productos){
            modelo.addElement(e.toString());
        }
    }
     
    private void asignarProductosCarr (){ //METODO PARA ASIGNAR LOS PRODUCTOS DEL CARRITO A LA LISTA
       
        for(Item e: usuario.getCarroCliente().getItems()){
            ModeCarrito.addElement(e.toString());
        }
    }
    
    private void comprobarUsuario(){        //FUNCION PARA VERIFICAR EL USUARIO Y CONTRASENNA 
        int i = 0;
      
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
         ventana2.boton_ver_informacion.addActionListener(this);
         ventanaC.boton_eliminar.addActionListener(this);
     }
     
     private void verCarrito(){     //FUNCION PARA DESPLEGAR LA VENTANA DEL CARRITO
         ModeCarrito.clear();
         asignarProductosCarr();
         suma.sumar();
         resultado();
         ventanaC.Lista_Ventana_Carrito.setModel(ModeCarrito); 
         ventanaC.setLocationRelativeTo(null);
         ventanaC.etiqueta_usuarioCarrito.setText(usuario.getNombre());
         ventanaC.setVisible(true);
     }
     
   
     private void resultado(){ //FUNCION PARA REALIZAR LA SUMA DE LOS PRODUCTOS
         
         ventanaC.etiqueta_total.setText(String.valueOf(suma.getResultado()));
         
     }
     
     private void aumentar(){ //FUNCION PARA AUMENTAR EL CONTADOR DE LOS PRODUCTOS
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
    
    private void verInformacion(){ //METODO PARA VER LA INFORMACION DE LOS PRODUCTOS
        
        for (int i = 0;i < productos.size(); i ++) {
            if(ventana2.jList1.getSelectedValue().equals(productos.get(i).getNombre())){
                
                informacion.infomacion_stock.setText(Integer.toString(productos.get(i).getCantidad()));
                informacion.informacion_precio.setText(Float.toString(productos.get(i).getPrecio()));
                informacion.informacion_producto.setText(productos.get(i).getNombre());
                System.out.println(productos.get(i));
                if(productos.get(i).getNombre().equals("Chetos")){
                    informacion.imagen_producto.setIcon(new ImageIcon(chetos.getImage().getScaledInstance(120,150,Image.SCALE_SMOOTH)));
                }else if(productos.get(i).getNombre().equals("Playera")){
                    informacion.imagen_producto.setIcon(new ImageIcon(playera.getImage().getScaledInstance(120,150,Image.SCALE_SMOOTH)));
                }else if(productos.get(i).getNombre().equals("Pantalon")){
                    informacion.imagen_producto.setIcon(new ImageIcon(pantalon.getImage().getScaledInstance(120,150,Image.SCALE_SMOOTH)));
                }else if(productos.get(i).getNombre().equals("Agua")){
                    informacion.imagen_producto.setIcon(new ImageIcon(agua.getImage().getScaledInstance(120,150,Image.SCALE_SMOOTH)));
                }else if(productos.get(i).getNombre().equals("Cerveza")){
                    informacion.imagen_producto.setIcon(new ImageIcon(cerveza.getImage().getScaledInstance(120,150,Image.SCALE_SMOOTH)));
                }else if(productos.get(i).getNombre().equals("Pan")){
                    informacion.imagen_producto.setIcon(new ImageIcon(pan.getImage().getScaledInstance(120,150,Image.SCALE_SMOOTH)));
                }else if(productos.get(i).getNombre().equals("Refresco")){
                    informacion.imagen_producto.setIcon(new ImageIcon(refresco.getImage().getScaledInstance(120,150,Image.SCALE_SMOOTH)));
                }
            }
        }
        
        ventanaInformacion();
    }
     
    private Producto buscar(String comparar){ //METODO PARA BUSCAR ALGUN PRODUCTO
        Producto producto = null;
        for (Producto e: productos){
            if (e.getNombre().equals(comparar)){
                producto = e;
                return producto;
            }
        }
        
       return null;
    }
    
    private void ventanaInformacion(){ //METODO PARA VER LA VENTANA DE LA INFORMACION
        informacion.setLocationRelativeTo(null);
        informacion.setVisible(true);
    }
    
    private void actualizar(){ //METODO PARA ACTUALIZAR EL CARRITO DESPUES DE BORRAR ALGUN PRODUCTO
        ModeCarrito = limpiar;
        verCarrito();
    }
    
    private void agregarCarrito(){ //METODO PARA AGREGAR ALGUN PRODUCTO AL CARRITO
        int aux = Integer.parseInt(ventana2.numero_producto.getText());
        Producto product = buscar(ventana2.jList1.getSelectedValue());
        product.disminuir(aux);
        usuario.getCarroCliente().AgregarProducto(product,aux);
        suma.sumarVentana2(product,aux);
        ventana2.etiqueta_total_ventana2.setText(String.valueOf(suma.getAux()));
        ventana2.numero_producto.setText("1");
        
    }
    
    private void eliminar(){
        
        int aux = Integer.parseInt(ventanaC.CanProd.getText());
        Producto product = buscar(ventanaC.Lista_Ventana_Carrito.getSelectedValue());
        usuario.getCarroCliente().Eliminar(product, aux);
        actualizar();
        suma.setResultado(0);
        suma.sumar();
        System.out.println(suma.getResultado());
        resultado();
        
        
    }
}
