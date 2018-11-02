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
       Asiento testAsiento2 = new Asiento('b',(byte)3);
       Asiento testAsiento3= new Asiento('c',(byte)4);
       Sala sala = new Sala("test",(byte) 9, (byte) 9, (short) 1000);
       ArrayList<Asiento> ocupados= new ArrayList();
       
       Cine cine = new Cine("test");
       
       cine.agregarSala(sala);
       
       
       
       
       sala.ocuparAsiento(testAsiento);
       sala.ocuparAsiento(testAsiento2);
       sala.ocuparAsiento(testAsiento3);
       //testAsiento.setLibre(false);
        
        System.out.println("Libres:"+sala.totalAsientosLibres());
        
        ocupados= sala.obtenerAsientosOcupados();
        
        for(Asiento asiento:ocupados){
            System.out.println("t"+asiento.mostrarDatos());
        }
        
        System.out.println(""+sala.estaDisponible(testAsiento2));
        System.out.println(""+cine.obtenerInformeRecaudacion());
        
        System.out.println(""+cine.mostrarDatos());
    }
    
   // public static boolean validaAsiento(Sala s, String a){
    
    //}
    
    
}