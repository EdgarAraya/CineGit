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
       
        System.out.println(""+testAsiento.getFila());
        System.out.println(""+testAsiento.getColumna());
        System.out.println(""+testAsiento.mostrarDatos());
       
        
        
        
        
    }
    
   // public static boolean validaAsiento(Sala s, String a){
    
    //}
    
    
}