/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

import java.util.ArrayList;

/**
 * Cine.java - Atributos y metodos que controlan un cine
 * @author Edgar Araya
 * @version 1.0
 */
public class Cine {
    private ArrayList<Sala> salas;
    private String nombre; 
    
    
    
    /**
     * Constructor, crea un cine con el nombre del parametro
     * @param nombre String con nombre del cine
     */
    
    public Cine(String nombre){
        this.nombre = nombre;
        this.salas = new ArrayList();
    }

    
    
    /**
     * Obtiene las salas del cine
     * @return ArrayList de salas del cine
     */
    public ArrayList<Sala> getSalas() {
        return salas;
    }
    /**
     * Obtiene nombre del cine
     * @return String con nombre del cine
     */
    
    public String getNombre() {
        return nombre;
    }
      
    /**
     * Cambia nombre del cine
     * @param nombre String con nuevo nombre del cine
     */
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    /**
     * Agrega una sala al cine, la sala no debe existir en el cine
     * @param s Sala a agregar al cine
     * @return Retorna si se agrego con exito la sala al cine ,de tipo boolean
     */
    
    public boolean agregarSala(Sala s){
        
        for (Sala sala:salas){
            if (sala.getNombre().equalsIgnoreCase(s.getNombre())){
                return false;
            } 
        }
        salas.add(s);
        return true; 
    }
    
    /**
     * Vende un asiento de la sala del argumento, retorna falso si el asiento ya esta ocupado o no existe en la sala
     * @param s Sala en la que se vendera asiento
     * @param a Asiento a vender
     * @return Retorna si el asiento pudo ser vendido, tipo boolean
     */
    
    
    public boolean venderAsiento(Sala s, Asiento a){
        
        return s.ocuparAsiento(a);
 
    }
    
    /**
     * Obtiene cadena de caracteres con el informe de recaudacion de todas las salas
     * @return String con informe de recaudacion
     */
    
    public String obtenerInformeRecaudacion(){
        String informe = new String();
        ArrayList<Integer> total = new ArrayList();
        int totalRecaudado=0;
        int size ;
        
        for(Sala sala:salas){
            size= sala.obtenerAsientosOcupados().size();
            total.add(size*sala.getValorEntrada());
            totalRecaudado+=size*sala.getValorEntrada();
        }
        informe = informe.concat("Sala\tRecaudado");
        for (int i =0; i < salas.size();i++){
            informe= informe.concat("\n"+salas.get(i).getNombre()+"\t"+total.get(i));
        }
        
        informe= informe.concat("\nTotal:\t"+totalRecaudado);
        
        return informe;
    }
    
    /**
     * Obtiene la sala del argumento
     * @param nombreSala - Nombre de sala a buscar en el cine
     * @return Retorna la sala buscada, si no existe retorna null
     */
    
    
    
    public Sala buscarSalaPorNombre(String nombreSala){
        
        for(Sala sala:salas){
            if (sala.getNombre().equalsIgnoreCase(nombreSala)){
                return sala;
            }
        }
        return null;
    }
    
    /**
     * Obtiene cadena de caracteres con la informacion completa del cine
     * @return String con los datos del cine
     */
    
    
    
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
