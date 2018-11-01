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
public class MainCine {

    
    public static void main(String[] args) {
       Asiento testAsiento = new Asiento('a',(byte)3);
       Sala sala = new Sala("test",(byte) 9, (byte) 9, (short) 1000);
       ArrayList<Asiento> ocupados= new ArrayList();
       
       sala.ocuparAsiento(testAsiento);
       //testAsiento.setLibre(false);
       
       
        System.out.println(""+testAsiento.getFila());
        System.out.println(""+testAsiento.getColumna());
        System.out.println(""+testAsiento.mostrarDatos());
       
        System.out.println(""+testAsiento.isLibre());
        
        System.out.println(""+sala.mostrarOcupacion());
        
        System.out.println(""+sala.mostrarOcupacion(2, 5));
        
        System.out.println(""+sala.mostrarDatos());
        
        System.out.println("Libres:"+sala.totalAsientosLibres());
        
        ocupados= sala.obtenerAsientosOcupados();
        
        for(Asiento asiento:ocupados){
            System.out.println("t"+asiento.mostrarDatos());
        }
        
        
    }
    
   // public static boolean validaAsiento(Sala s, String a){
    
    //}
    
    
}