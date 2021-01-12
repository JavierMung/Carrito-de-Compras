
package carrito_de_compras;

import javax.swing.JOptionPane;


public class Carrito_de_Compras {

    
    public static void main(String[] args) {
       Cliente C1, C2, C3;
       PanelsCarrito Panels;
       String Opc;
       Carrito carro = new Carrito();
       Carrito carro2 = new Carrito();
       Carrito carro3 = new Carrito();
       Panels = new PanelsCarrito();
       C1 = new Cliente("Javier",carro);
       C2 = new Cliente("Julia",carro2);
       C3 = new Cliente("Julia",carro3);
       
       
      
       
      /* System.out.println(C1.getCarroCliente().getNumero());     
       System.out.println(C2.getCarroCliente().getNumero());
       System.out.println(C3.getCarroCliente().getNumero());
     */
      /* do{
            Opc = JOptionPane.showInputDialog("Bienvenido a Escomazon\nEliga un cliente: \n1.- " 
                + C1.getNombre() + "Carrito " + C1.getCarroCliente().getNumero()
                + C2.getNombre() + "Carrito "+ C2.getCarroCliente().getNumero()+ "\n3.- " 
                + C3.getCarroCliente().getNumero() + "\n");
        }while (Opc == null || Opc.equals(""));
       */
       
        
    }
    
}
