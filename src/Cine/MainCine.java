/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Edgar-pc
 */
public class MainCine {

    
    public static void main(String[] args) {
      
        Cine cine= new Cine("Sin Nombre");
        
        System.out.println("El siguiente programa intenta emular un sistema de ventas de un cine.");
        
        
        
        
        System.out.println("1.Crear cine");
        System.out.println("2.Vender entradas");
        System.out.println("3.Ver ocupacion de sala");
        System.out.println("4.Ver ocupacion de sala por rango de filas");
        System.out.println("5.Obtener informe de recaudacion");
        System.out.println("6.Mostrar datos de cine");
        System.out.println("7.Agregar nueva sala");
        System.out.println("9.Salir del programa");
        
        cine = setupCine();
        System.out.println("El cine se llama: "+cine.getNombre());
        
        
        
        
   
    }
    
   // public static boolean validaAsiento(Sala s, String a){
    
    //}
    
    public static Cine setupCine(){
        String nombreCine= new String();
        Scanner reader= new Scanner(System.in);
        
        do {
            System.out.println("Ingrese nombre del cine:\n");
            nombreCine= reader.nextLine();
            
        } while (nombreCine!=null && nombreCine.trim().isEmpty());
        
        
            
        
        
        
        
        Cine cine = new Cine(nombreCine);
        
        return cine;
        
    }
    
    
    
    
}