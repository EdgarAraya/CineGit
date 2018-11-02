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
        Scanner reader= new Scanner(System.in);
        String nombreCine= new String();
        String nombreSala= new String();
        ArrayList<String> nombresSala= new ArrayList();
        Sala sala;
        int numeroSalas;
        int valorEntrada;
        int numeroFilas;
        int numeroColumnas;
        
        
        do {
            System.out.println("Ingrese nombre del cine:");
            nombreCine= reader.nextLine();
            
        } while (nombreCine!=null && nombreCine.trim().isEmpty());
         
        Cine cine = new Cine(nombreCine);
        
        do{
            System.out.println("El numero maximo de salas que puede tener el cine es 9.");
            System.out.println("Ingrese numero de salas del cine:");
            numeroSalas= Integer.parseInt(reader.nextLine());
        } while(numeroSalas<=0 || numeroSalas>10);
        
        
        for (int i = 0 ; i< numeroSalas;i++){
            do{
                System.out.println("Ingrese nombre de sala "+(i+1));
                nombreSala= reader.nextLine();

            }while(nombreSala!=null && nombreSala.trim().isEmpty() || nombresSala.contains(nombreSala));
        
            nombresSala.add(nombreSala); 
            do {
                System.out.println("Ingrese valor de entrada de sala "+nombreSala);
                valorEntrada= Integer.parseInt(reader.nextLine());
            }while(valorEntrada<1000 || valorEntrada >32767);
            
            do{
                System.out.println("Ingrese numero de filas de la sala "+nombreSala);
                numeroFilas= Integer.parseInt(reader.nextLine());
            } while(numeroFilas<3 || numeroFilas>15);
            
            do{
                System.out.println("Advertencia: Debido a especificaciones del diseno del programa,");
                System.out.println("la cantidad de asientos no puede superar 127 (valor maximo de byte),");
                System.out.println("por lo que dado el numero actual de filas, SE RECOMIENDA como");
                System.out.print("valor maximo de columnas : ");
                if (127/numeroFilas>15){
                    System.out.print("15");
                }else{
                    System.out.print((int)(127/numeroFilas));
                }
                System.out.println("\nIngrese numero de columnas de la sala "+nombreSala);
                numeroColumnas=Integer.parseInt(reader.nextLine());
            }while (numeroColumnas<5 && numeroColumnas>12);
            
            sala = new Sala(nombreSala,(byte) numeroFilas,(byte) numeroColumnas,(short) valorEntrada);
            cine.agregarSala(sala);
            
            
            
        }
        
        
        
        
        
        
        return cine;
        
    }
    
    
    
    
}