
package carrito_de_compras;

import javax.swing.JOptionPane;


public class Carrito_de_Compras {

    
    public static void main(String[] args) {
       Cliente C1, C2, C3;
       PanelsCarrito Panels;
       String Opc;
       
       Panels = new PanelsCarrito();
       C1 = new Cliente();
       C2 = new Cliente();
       C3 = new Cliente();
       
       C1.setNombre("Javier");
       C2.setNombre("Julia");
       C3.setNombre("sdfdsdf");
       
       do{
            Opc = JOptionPane.showInputDialog("Bienvenido a Escomazon\nEliga un cliente: \n1.- " 
                + C1.getNombre() + "Carrito " + "\n2.- "
                + C2.getNombre() + "Carrito "+ C2.getCarroCliente()+ "\n3.- " 
                + C3.getNombre() + "\n");
        }while (Opc == null || Opc.equals(""));
       
       
        
    }
    
}
