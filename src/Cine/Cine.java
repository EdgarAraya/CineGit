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
public class Cine {
    private ArrayList<Sala> salas;
    private String nombre;
    
    public Cine(String nombre){
        this.nombre = nombre;
        this.salas = new ArrayList();
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }
    
    public String getNombre() {
        return nombre;
    }
      
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //D
    public boolean agregarSala(Sala S){
        
    }
    
    public boolean venderAsiento(Sala s, Asiento a){
        
    }
    public String obtenerInformeRecaudacion(){
        
    }
    public Sala buscarSalaPorNombre(String nombreSala){
        
        
    }
    
    public String mostrarDatos(){
        
    }
   
  

    
    
    
    
}
