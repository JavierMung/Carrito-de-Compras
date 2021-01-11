/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito_de_compras;

import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */
public class PanelsCarrito {
    public String PanInic(String NomC1, String NomC2, String NomC3){
        String value;
        
        value = JOptionPane.showInputDialog("Bienvenido a Escomazon\nEliga un cliente: \n1.- " + NomC1 + "\n2.- "
       + NomC1 + "\n3.- " + NomC1 + "\n");
        
        return value;
    }
}
