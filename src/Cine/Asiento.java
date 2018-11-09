/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

/**
 *Asiento.java - Metodos y atributos que controlan un asiento del cine
 * @author Edgar Araya
 * @author Luis Benitez
 * @version 1.0
 */
public class Asiento {
    
    private char fila;
    private byte columna;
    private boolean libre;
    
    
    
    /**
     * Constructor que inicializa en asiento con los argumentos ingresados, se inicializa libre por defecto
     * @param fila Letra de la fila del asiento
     * @param columna Numero de columna del asiento en byte
     */
    
    
    public Asiento(char fila, byte columna){
        this.fila= fila;
        this.columna=columna;
        this.libre= true;
    }
    
    /**
     * Constructor por defecto
     */
    public Asiento(){}
    
    /**
     * Obtiene la fila del asiento
     * @return Retorna la fila del asiento de tipo char
     */
    
    
    
    
    public char getFila() {
        return fila;
    }

    /**
     * Cambia la fila del asiento
     * @param fila fila a cambiar de tipo char
     */
    public void setFila(char fila) {
        fila=Character.toLowerCase(fila);
        this.fila = fila;
    }

    
    /**
     * Obtiene la columna del asiento
     * @return Retorna la columna del asiento en tipo byte
     */
    public byte getColumna() {
        return columna;
    }

    /**
     * Cambia la columna del asiento
     * @param columna columna a cambiar de tipo byte
     */
    
    public void setColumna(byte columna) {
        this.columna = columna;
    }

    
    /**
     * Obtiene el estado del asiento
     * @return Si el asiento esta libre o no, tipo boolean
     */
    public boolean isLibre() {
        return libre;
    }
/**
 * Cambia la ocupacion del asiento
 * @param libre Estado a utilizar en el asiento de tipo boolean
 */
    public void setLibre(boolean libre) {
        this.libre = libre;
    }
    
    /**
     * Obtiene cadena de caracteres con los datos del asiento
     * @return String con datos del asiento
     */
    
    public String mostrarDatos(){
        String datos;
        datos = new String();
        
        datos = datos.concat(""+Character.toUpperCase(this.getFila())+""+this.getColumna());
        
        return datos;
    }
    
    
    
    
    
    
    
}
