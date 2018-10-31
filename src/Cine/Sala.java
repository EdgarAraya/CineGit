/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

import java.util.ArrayList;

/**
 *
 * @author Edgar-pc
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
        
        
    }
    
    public short getValorEntrada() {
        return valorEntrada;
    }
    
    public void setValorEntrada(short valorEntrada) {
        this.valorEntrada = valorEntrada;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public byte getTotalFilas() {
        return totalFilas;
    }

    public void setTotalFilas(byte totalFilas) {
        this.totalFilas = totalFilas;
    }

    public byte getTotalColumnas() {
        return totalColumnas;
    }

    public void setTotalColumnas(byte totalColumnas) {
        this.totalColumnas = totalColumnas;
    }
    //D
    public String mostrarOcupacion(int filaInicial, int filaFinal){
        
    }
    
    public String mostrarOcupacion(){
        
    }
    
    public byte totalAsientosLibres(){
        
        
    }
    
    public ArrayList<Asiento> obtenerAsientosOcupados(){
        
    }
    
    public String mostrarDatos(){
        
    }
    public boolean estaDisponible(Asiento a){
        
    }
    public boolean ocuparAsiento(Asiento a){
        
    }
    

    

    
    
    
    
}
