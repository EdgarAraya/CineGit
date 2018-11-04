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
      
        Scanner reader = new Scanner(System.in);
        int answer ;
        boolean exit = true;
        Cine cine= new Cine("Sin Nombre");
        Sala salaActual;
        
        System.out.println("El siguiente programa intenta emular un sistema de ventas de un cine.");
        
        
        
        
       
        
        while (exit){
            System.out.println("1.Crear cine");
            System.out.println("2.Vender entradas");
            System.out.println("3.Ver ocupacion de sala");
            System.out.println("4.Ver ocupacion de sala por rango de filas");
            System.out.println("5.Obtener informe de recaudacion");
            System.out.println("6.Mostrar datos de cine");
            System.out.println("7.Agregar nueva sala");
            System.out.println("8.Salir del programa");
            
            answer = Integer.parseInt(reader.nextLine());
            boolean creado= (cine.getSalas().size()>0);
            
            switch (answer){

            case 1: 
                cine = setupCine();
                break;
            case 2:
                if (creado){
                    ventas(cine);

                }
                else{
                    System.out.println("Error");
                }
                break;
            case 3:
                if (creado){
                    salaActual =salaActual(cine);
                    System.out.println(""+salaActual.mostrarDatos());
                    System.out.println(""+salaActual.mostrarOcupacion());
                } else{
                    System.out.println("Error: No existe cine");

                }
                    break;
            case 4:
                if(creado){
                    salaActual= salaActual(cine);
                    System.out.println(""+salaRangoFilas(salaActual)); 
                } else{
                    System.out.println("Error: No existe cine.");
                }
                
                break;
            case 5:
                System.out.println(""+cine.obtenerInformeRecaudacion());
                break;
            case 6:
                System.out.println(""+cine.mostrarDatos());
                break;
            case 7:
                if (creado && cine.getSalas().size()<9){
                    agregarSalaCine(cine);
                  
                }else if(!creado ){
                    System.out.println("Error: No existe cine al que agregar salas");
                   
                } else{
                    System.out.println("Error: El cine ya tiene el numero maximo de salas");
                   
                    
                }
                break;
            case 8:
                exit= false;
                break;
            default:
                System.out.println("Opcion invalida");
                break;
                
            }
        }
        
        
        
        
        
        
        /*
        cine = setupCine();
        System.out.println("El cine se llama: "+cine.getNombre());
        
        
        System.out.println(""+cine.mostrarDatos());
        
        ventas(cine);
        */
   
    }
    
    public static boolean validaAsiento(Sala s, String a){ //Revisar
        int fila;
        int columna;

       if (a.length()==2 || a.length()==3 ){
           
           fila= (int) Character.toLowerCase(a.charAt(0))-'a';
           columna= Integer.parseInt(a.substring(1));
           if (fila <s.getTotalFilas() && columna< s.getTotalColumnas()){
               
              // if (s.estaDisponible(s.asientos[fila][columna])){
              //     ;
              // }
               
               
               return true;
  
           }
  
       }
        
        return false;
    }
    
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
        
        agregarSalaCine(cine);
        return cine;
        
    }
    
    public static void ventas(Cine cine){
        Scanner reader= new Scanner(System.in);
        String nombreSala = new String();
        String answer= new String();
        int numeroAsientos;
        Sala sala;
        do{
            System.out.println("Salas disponibles:");
            
            for(Sala sal:cine.getSalas()){
                System.out.println(""+sal.getNombre());  
            }
            
            do{
                System.out.print("Ingrese nombre de sala: ");
                nombreSala= reader.nextLine();
                
            } while (nombreSala!=null && nombreSala.trim().isEmpty());
            
            sala =cine.buscarSalaPorNombre(nombreSala);
 
        } while(sala==null);
        
        do{
            System.out.print("Numero de asientos a comprar: ");
            numeroAsientos= Integer.parseInt(reader.nextLine());
        
        } while (numeroAsientos<=0);// agregar mas restricciones de limite superior
        
        for (int i=0; i < numeroAsientos; i++){
            
            do{
                System.out.println(""+sala.mostrarOcupacion());
                System.out.println("Ingrese asiento a comprar");
                answer= reader.nextLine();
                if (!validaAsiento(sala,answer)) System.out.println("No valido");
                
            } while (!validaAsiento(sala,answer));
            
            
            
            
        }
        
        
        
    }
    
    public static Sala salaActual(Cine cine){
        Scanner reader = new Scanner(System.in);
        Sala sala ;
        String nombreSala ;
        do{
            System.out.println("Salas disponibles:");
            
            for(Sala sal:cine.getSalas()){
                System.out.println(""+sal.getNombre());  
            }
            do{
                System.out.print("Ingrese nombre de sala: ");
                nombreSala= reader.nextLine();
                
            } while (nombreSala!=null && nombreSala.trim().isEmpty());
            
            sala =cine.buscarSalaPorNombre(nombreSala);
 
        } while(sala==null);
        
        return sala;
    }
        
    public static void agregarSalaCine(Cine cine){
        Scanner reader= new Scanner(System.in);
        String nombreCine= new String();
        String nombreSala= new String();
        ArrayList<String> nombresSala= new ArrayList();
        Sala sala;
        int numeroSalas;
        int valorEntrada;
        int numeroFilas;
        int numeroColumnas;

        do{
            System.out.println("Numero de salas actual: "+cine.getSalas().size());
            System.out.println("El numero maximo de salas que puede tener el cine es 9.");
            System.out.println("Ingrese numero de salas a agregar al cine:");
            numeroSalas= Integer.parseInt(reader.nextLine());
        } while(numeroSalas<=0 || numeroSalas+cine.getSalas().size()>9);
        
        
        for (int i = 0 ; i< numeroSalas;i++){
            //Revisar restriccion de nombre en cuanto a mayuscula y minuscula
            do{
                System.out.println("Ingrese nombre de sala "+(i+1+cine.getSalas().size()));
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
        
         
    }
        
    public static String salaRangoFilas(Sala sala){
         
        Scanner reader = new Scanner(System.in);
        
        int filaInicial;
        char inicial;
        String answer = new String();
        int filaFinal;
        char fin;
        int limiteFinal= sala.getTotalColumnas();
        
        
        do{
            do {
                System.out.println("Ingrese desde que fila mostrar:");
                answer= reader.nextLine();
            } while (answer.length()!=1 || !Character.isLetter(answer.charAt(0)) );
            inicial = Character.toLowerCase(answer.charAt(0));
            filaInicial= (int) (inicial -'a');
            
        } while(filaInicial>limiteFinal);
        
        do{
            do {
                System.out.println("Ingrese hasta que fila mostrar:");
                answer= reader.nextLine();
            } while (answer.length()!=1 || !Character.isLetter(answer.charAt(0)) );
            fin = Character.toLowerCase(answer.charAt(0));
            filaFinal= (int) (fin -'a');
            
        } while(filaFinal>limiteFinal || filaFinal<filaInicial);
        

        return sala.mostrarOcupacion(filaInicial, filaFinal);
         
     }   
        
        
        
        
        
        
        
    
   
    
}