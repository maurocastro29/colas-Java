/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Castro
 */
public class Cola {
    private Nodo primero;
    private Nodo ultimo;
    
    public Cola(){
        this.primero = null;
        this.ultimo = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
    
    public boolean isVacia(){
        return this.getPrimero() == null;
    }
    
    public Nodo buscarNodo(int dato){
        Nodo aux = null;
        Nodo aux2 = null;
        if(!this.isVacia()){
            Cola c = new Cola();
            while(!this.isVacia()){
                aux = this.desEncolar();
                c.encolar(aux);
                if(aux.getDato() == dato){
                    aux2 = aux;
                    break;
                }
            }
            while(!c.isVacia()){
                aux = c.desEncolar();
                this.encolar(aux);
            }
        }
        return aux2;
    }
    
    public void encolar(Nodo nodo){
        if(this.isVacia()){
            this.setPrimero(nodo);
            this.setUltimo(nodo);
        }else{
            this.getUltimo().setSgt(nodo);
            this.setUltimo(nodo);
        }
    }
    
    public Nodo desEncolar(){
        if(!this.isVacia()){
            Nodo aux = null;
            if(this.getPrimero() == this.getUltimo()){
                aux = this.getPrimero();
                this.setPrimero(null);
                this.setUltimo(null);
            }else{
                aux = this.getPrimero();
                this.setPrimero(this.getPrimero().getSgt());
            }
            return aux;
        }
        return null;
    }
    
    public int getTamanioCola(){
        int i=0;
        Nodo aux = null;
        Nodo aux2 = null;
        Cola c = new Cola();
        while(!this.isVacia()){
            aux = this.desEncolar();
            c.encolar(aux);
            i++;
        }
        while(!c.isVacia()){
            aux2 = c.desEncolar();
            this.encolar(aux2);
        }
        return i;
    }
    
    public void verPrimero(){
        if(!this.isVacia()){
            JOptionPane.showMessageDialog(null, this.getPrimero().getDato());
        }else{
            JOptionPane.showMessageDialog(null, "Cola vacia");
        }
    }
    
    public void mostrarCola(){
        if(!this.isVacia()){
            Nodo aux = this.getPrimero();
            String datos = "";
            while(aux!=null){
                datos += aux.getDato() + "->";
                aux = aux.getSgt();
            }
            datos += "||";
            JOptionPane.showMessageDialog(null, datos);
        }else{
            JOptionPane.showMessageDialog(null, "Cola vacia");
        }
    }
    
    public void vaciarCola(){
        if(!this.isVacia()){
            while(!this.isVacia()){
                this.desEncolar();
            }
        }
        JOptionPane.showMessageDialog(null, "Cola vacia");
    }
}
