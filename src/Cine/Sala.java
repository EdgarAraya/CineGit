/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

import java.util.ArrayList;

/**
 *Sala.Java - Contiene los atributos y metodos de una sala del cine
 * @author Edgar-pc
 * @version 1.0
 * 
 * 
 */
public class Sala {
    
    private byte totalFilas;
    private byte totalColumnas;
    private Asiento[][] asientos;
    private short valorEntrada;
    private String nombre;
    private static ArrayList<Character> nombreFilas;    
    
    public Sala(String nombre, byte totalFilas, byte totalColumnas, short valorEntrada){
        this.nombre = nombre;
        this.totalFilas= totalFilas;
        this.totalColumnas = totalColumnas;
        this.valorEntrada = valorEntrada;
        this.asientos = new Asiento[totalFilas][totalColumnas];
        
        
        for(int i = 0; i < this.totalFilas ; i++){
            for (int j = 0; j < this.totalColumnas;j++){
                Asiento asiento= new Asiento((char)('a'+i), ((byte) (j+1)));
                asientos[i][j] = asiento;
            }
        } 
    }
    
    
    /**Obtiene el valor de entrada
     */
    public short getValorEntrada() {
        return valorEntrada;
    }
    
    /**
     * Cambia el valor de la entrada
     * @param valorEntrada Variable de tipo short
     */
    
    public void setValorEntrada(short valorEntrada) {
        if (valorEntrada>=1000){
            this.valorEntrada = valorEntrada;
        }
    }
    
    /**
     *Obtiene el nombre de la sala
     */
    
    
    public String getNombre() {
        return nombre;
    }
    
    
    /**
     * Cambia el nombre de la sala
     * @param nombre Variable de tipo String 
     */
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el total de filas de la sala
     * @return Total de filas de tipo byte
     */
    
    
    public byte getTotalFilas() {
        return totalFilas;
    }

    
    /**
     * Cambia el total de filas de la sala
     * @param totalFilas total de filas de tipo byte
     */
    
    
    public void setTotalFilas(byte totalFilas) {
        if (totalFilas>=3 && totalFilas<=15){
            this.totalFilas = totalFilas;
        }
    }

    /**
     * Obtiene la cantidad de columnas de la sala
     * @return total de columnas de tipo byte
     */
    
    
    
    public byte getTotalColumnas() {
        return totalColumnas;
    }

    /**
     * Cambia el total de columnas de la sala, dentro del rango 5 a 12
     * @param totalColumnas total de columnas de tipo byte
     */
    
    
    
    public void setTotalColumnas(byte totalColumnas) {
        if (totalColumnas>=5 && totalColumnas<=12){
            this.totalColumnas = totalColumnas;
        }
    }
    
    /**
     * Metodo sobrecargado, retorna string mostrando ocupacion de la sala segun parametros ingresados
     * @param filaInicial fila inicial en tipo int
     * @param filaFinal fila final en tipo int
     * @return String mostrando la ocupacion de la sala
     */
    
    
    public String mostrarOcupacion(int filaInicial, int filaFinal){
        String matriz;
        matriz = new String();
        for (int i=filaInicial; i <= filaFinal;i++){
            for(int j=0; j < this.totalColumnas;j++){
                if(this.asientos[i][j].isLibre()){
                    matriz = matriz.concat("["+this.asientos[i][j].mostrarDatos()+"]  ");
                } else {
                    matriz = matriz.concat("["+"X "+"]  ");
                }
            }
            matriz = matriz.concat("\n");
        }
        return matriz;
        
    }
    
    
    /**
     * Metodo sobrecargado, retorna String con la ocupacion total de la sala
     * @return String mostrando la ocupacion de la sala
     */
    
    
    
    public String mostrarOcupacion(){
        String matriz;
        matriz = new String();
        
        for (int i=0; i < this.totalFilas;i++){
            
            for(int j=0; j < this.totalColumnas;j++){
                if(this.estaDisponible(asientos[i][j])){
                    matriz = matriz.concat("["+this.asientos[i][j].mostrarDatos()+"] ");
                } else {
                    matriz = matriz.concat("["+"X "+"] ");
                }
            }
            matriz = matriz.concat("\n");
        }
        matriz = matriz.concat("Asientos Ocupados: "+this.obtenerAsientosOcupados().size());
        return matriz;
    }
    
    
    /**
     * Retorna total de asientos libres en la sala 
     * -Se recomienda no utilizar este metodo ya que el numero de asientos libres puede ser mayor a la capacidad maxima de byte
     * @return Numero de asientos libres tipo byte
     */
    
    
    
    public byte totalAsientosLibres(){
        byte libres=0;
         for (int i=0; i < this.totalFilas;i++){
            for(int j=0; j < this.totalColumnas;j++){
                if(this.asientos[i][j].isLibre()){
                    libres++;
                }
            }
        }
        return libres; 
    }
    
    
    /**
     * Obtiene ArrayList de asientos ocupados en la sala
     * @return ArrayList de asientos ocupados
     */
    
    
    public ArrayList<Asiento> obtenerAsientosOcupados(){
        ArrayList<Asiento> ocupados = new ArrayList();
        
        for(int i=0; i < this.totalFilas;i++){
            for(int j=0;j < this.totalColumnas;j++){
                if(!this.estaDisponible(asientos[i][j])){
                    ocupados.add(asientos[i][j]);
                }
            }
        }
        return ocupados;
    }
    
    /**
     * Obtiene cadena de caracteres con los datos de la sala
     * @return String con informacion de la sala
     */
    
    
    public String mostrarDatos(){
        String datos = new String();
        
        datos= datos.concat("Sala: "+this.getNombre()+"\nValor Entrada: ["+this.getValorEntrada()+"]");
        return datos;
    }
    
    
    /**
     * Retorna si un asiento de la sala esta disponible o no
     * @param a - Asiento a consultar
     * @return Disponibilidad del asiento en tipo booleano
     */
    
    
    public boolean estaDisponible(Asiento a){
       int i = (int) (a.getFila()-'a');
       int j = (int) (a.getColumna()-1);
       return (asientos[i][j].isLibre());
        
    }
    
    /**
     * Ocupa un asiento dentro de la sala
     * @param a -Asiento a ocupar
     * @return Si el asiento fue ocupado con exito de tipo booleano
     */
    
    
    public boolean ocuparAsiento(Asiento a){
        
       int i = (int) (a.getFila()-'a');
       int j = (int) (a.getColumna()-1);
       
       if (estaDisponible(asientos[i][j])){
            asientos[i][j].setLibre(false); 
            return true; 
       } 
       return false;
       
    }
    

    

    
    
    
    
}
