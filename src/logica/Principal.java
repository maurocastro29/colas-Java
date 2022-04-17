/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Castro
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        Cola cola = new Cola();
        int dato;
        int op = -1;
        boolean sw = true;
        while(sw == true){
            try{
                op = new Integer(
                    JOptionPane.showInputDialog(""
                            + "MENU DE OPCIONES\n\n"
                            + "1. Encolar\n"
                            + "2. Desencolar\n"
                            + "3. Mostrar cola\n"
                            + "4. Ver primer dato\n"
                            + "5. Buscar\n"
                            + "6. Ver tamaño cola\n"
                            + "7. Vaciar cola\n"
                            + "8. Salir\n"));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error en la informacion suministrada, debe digitar un numero");
            }
            switch(op){
                case 1:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el dato a insertar"));
                    Nodo n = new Nodo(dato);
                    cola.encolar(n);
                    break;
                }
                case 2:{
                    Nodo n = cola.desEncolar();
                    if(n!=null){
                        JOptionPane.showMessageDialog(null, "Dato desencolado: " + n.getDato());
                    }else{
                        JOptionPane.showMessageDialog(null, "Cola vacia");
                    }
                    break;
                }
                case 3:{
                    cola.mostrarCola();
                    break;
                }
                case 4:{
                    cola.verPrimero();
                    break;
                }
                case 5:{
                    int datoBuscar = new Integer(JOptionPane.showInputDialog("Digite el dato a buscar"));
                    Nodo aux = cola.buscarNodo(datoBuscar);
                    if(aux == null){
                        JOptionPane.showMessageDialog(null, "No se encontro el dato en la cola ");
                    }else{
                        JOptionPane.showMessageDialog(null, "Dato encontrado");
                    }
                    break;
                }
                case 6:{
                    int tam = cola.getTamanioCola();
                    JOptionPane.showMessageDialog(null, "El tamaño de la cola es: "+tam);
                    break;
                }
                case 7:{
                    cola.vaciarCola();
                    break;
                }
                case 8:{
                    int salir = JOptionPane.showConfirmDialog(null, "Realmente desea salir?");
                    if(salir == 0){
                        sw = false;
                    }
                    break;
                }
                default:{
                    
                    break;
                }
            }
        }
    }
}
