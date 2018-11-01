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
public class MainCine {

    
    public static void main(String[] args) {
       Asiento testAsiento = new Asiento('a',(byte)3);
       Sala sala = new Sala("test",(byte) 9, (byte) 9, (short) 1000);
       
       
        System.out.println(""+testAsiento.getFila());
        System.out.println(""+testAsiento.getColumna());
        System.out.println(""+testAsiento.mostrarDatos());
       
        System.out.println(""+testAsiento.isLibre());
        
        System.out.println(""+sala.mostrarOcupacion());
        
    }
    
   // public static boolean validaAsiento(Sala s, String a){
    
    //}
    
    
}