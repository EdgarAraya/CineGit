/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

/**
 *
 * @author Edgar-pc
 */
public class Asiento {
    
    private char fila;
    private byte columna;
    private boolean libre;
    
    
    public Asiento(char fila, byte columna){
        this.fila=fila;
        this.columna= columna;
    }
    public Asiento(){}
    
    
    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public byte getColumna() {
        return columna;
    }

    public void setColumna(byte columna) {
        this.columna = columna;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
    
    public String mostrarDatos(){
        String datos;
        datos = new String();
        
        datos = datos.concat(""+Character.toUpperCase(this.getFila())+""+this.getColumna());
        
        return datos;
    }
    
    
    
    
    
    
    
}
