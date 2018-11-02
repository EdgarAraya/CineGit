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
    private String nombre; //blabla
    
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
    
    public boolean agregarSala(Sala s){//ver1
        
        for (Sala sala:salas){
            if (sala.getNombre().equalsIgnoreCase(s.getNombre())){
                return false;
            } 
        }
        salas.add(s);
        return true; 
    }
    
    public boolean venderAsiento(Sala s, Asiento a){
        
        return s.ocuparAsiento(a);
 
    }
    public String obtenerInformeRecaudacion(){
        String informe = new String();
        ArrayList<Integer> total = new ArrayList();
        int size ;
        
        for(Sala sala:salas){
            size= sala.obtenerAsientosOcupados().size();
            total.add(size*sala.getValorEntrada());
        }
        informe = informe.concat("Sala\tRecaudado");
        for (int i =0; i < salas.size();i++){
            informe= informe.concat("\n"+salas.get(i).getNombre()+"\t"+total.get(i));
        }
        return informe;
    }
    
    public Sala buscarSalaPorNombre(String nombreSala){
        
        for(Sala sala:salas){
            if (sala.getNombre().equalsIgnoreCase(nombreSala)){
                return sala;
            }
        }
        return null;
    }
    public String mostrarDatos(){
        String datos = new String();
        
        for(Sala sala:salas){
            datos= datos.concat("Cine: "+this.getNombre()+"\n");
            datos= datos.concat(""+sala.mostrarDatos());
            datos = datos.concat("\n"+sala.mostrarOcupacion()+"\n");
        }
        return datos;
    }
}
