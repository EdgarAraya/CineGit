/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *MainCine.java- Clase principal y de implementacion de las clases que forman el cine
 * @author Edgar Araya
 * @version 1.0
 */
public class MainCine {

    
    public static void main(String[] args) {
      
        Scanner reader = new Scanner(System.in);
        int answer ;
        boolean exit = true;
        Cine cine= new Cine("Sin Nombre");
        Sala test= new Sala("Test", (byte) 3,(byte)5, (short) 1000);
        Sala salaActual= new Sala("Sin Nombre", (byte) 3, (byte) 5 ,(short) 1000);
        
        
                
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
            System.out.println("Seleccione una opcion : ");
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
                    System.out.println("Error: No existe cine");
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
                if (creado){
                System.out.println(""+cine.mostrarDatos());
                }else{
                System.out.println("Error: No existe cine.");
                }
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
                
            case 9:
                cine.agregarSala(test);
                break;
            default:
                System.out.println("Opcion invalida");
                break;
                
            }
        }

    }
    
    /**
     * Valida si es posible o no comprar un asiento en la sala designada segun el nombre del asiento en formato letra-numero
     * @param s Sala en la que se quiere verificar que el asiento existe o esta disponible
     * @param a String con los datos del asiento
     * @return Retorna si el asiento existe dentro de la sala y si esta desponible, tipo boolean
     */
    
    
    public static boolean validaAsiento(Sala s, String a){ 
        Scanner reader= new Scanner(System.in);
        int fila;
        char answer;
        int columna;
        
        Asiento asiento;
        answer= Character.toLowerCase(a.charAt(0));

        fila = (int) (answer-'a');
        columna = Integer.parseInt(a.substring(1));
        if (columna>=127 || Character.isDigit(a.charAt(0))){
            return false;
        }
        
        
        char filaC = a.charAt(0);
        byte columnaB = (byte) Byte.parseByte(a.substring(1));
        
        asiento = new Asiento(filaC, columnaB);        
        if (fila < s.getTotalFilas() && columna<=s.getTotalColumnas() && s.estaDisponible(asiento)){
            return true;
        }
     
        return false;
  
           
  
       
        
        
}
    
    /**
     * Configura un cine y sus salas segun las elecciones del usuario 
     * @return Retorna un cine con las especificaciones del usuario
     */
    
    
    
    public static Cine setupCine(){
        Scanner reader= new Scanner(System.in);
        String nombreCine= new String();
        do {
            System.out.println("Ingrese nombre del cine:");
            nombreCine= reader.nextLine();
            
        } while (nombreCine!=null && nombreCine.trim().isEmpty());
         
        Cine cine = new Cine(nombreCine);
        
        agregarSalaCine(cine);
        return cine;
        
    }
    
    /**
     * Maneja las salas del cine y el sistema de ventas para comprar asientos con sus restricciones correspondientes , si una sala esta llena no se pueden comprar asientos
     * @param cine Cine en el que se venderar asientos 
     */
    
    
    
    public static void ventas(Cine cine){
        Scanner reader= new Scanner(System.in);
        String nombreSala = new String();
        String answer= new String();
        int numeroAsientos;
        Sala sala;
        sala = salaActual(cine);
        Asiento asiento;
        
        if (!estaLlena(sala)){
            
        
        
        
            do{
                System.out.println("La sala tiene "+(sala.getTotalColumnas()*sala.getTotalFilas()-sala.obtenerAsientosOcupados().size())+" asientos disponibles");
                System.out.print("Numero de asientos a comprar: ");
                numeroAsientos= Integer.parseInt(reader.nextLine());

            } while (numeroAsientos<=0 || sala.obtenerAsientosOcupados().size()+numeroAsientos>sala.getTotalColumnas()*sala.getTotalFilas());// agregar mas restricciones de limite superior

            for (int i=0; i < numeroAsientos; i++){

                do{
                    System.out.println(""+sala.mostrarOcupacion());
                    System.out.println("Ingrese asiento a comprar:");
                    answer= reader.nextLine();
                    if (!validaAsiento(sala,answer)) System.out.println("Asiento no valido");

                } while (!validaAsiento(sala,answer));

                char fila;
                byte columna;

                fila = answer.charAt(0);
                columna = (byte) Byte.parseByte(answer.substring(1));


                asiento = new Asiento(fila, columna);

                cine.venderAsiento(sala, asiento);

            }

            }
            else{
                System.out.println("La sala esta llena");
            }
        
    }
    
    /**
     * Muestra al usuario las salas disponibles al usuario y controla el ingreso del nombre de la sala para verificar que existe una sala con ese nombre
     * @param cine Cine que contiene las salas a elegir
     * @return Retorna la sala elegida por el usuario
     */
    
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
        
    
    /**
     * Configura el ingreso de salas al cine segun la especificaciones del usuario, cada sala con su numero de filas y columnas validadas y el costo del asiento- El numero maximo de salas es 9
     * @param cine Cine en el que se quieren agregar salas
     */
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
        int limiteSalas = 9;
        do{
            System.out.println("Numero de salas actual: "+cine.getSalas().size());
            System.out.println("El numero maximo de salas que puede tener el cine es "+limiteSalas+".");
            System.out.println("Ingrese numero de salas a agregar al cine:");
            numeroSalas= Integer.parseInt(reader.nextLine());
            
            
            if (numeroSalas+cine.getSalas().size()>limiteSalas ){
                System.out.println("Error: El numero de salas a agregar excede al limite de salas (maximo"+" "+limiteSalas+")");
                
            }
        } while(numeroSalas<=0 || numeroSalas+cine.getSalas().size()>limiteSalas);
        
        
        for (int i = 0 ; i< numeroSalas;i++){
            do{
                System.out.println("Ingrese nombre de sala "+(1+cine.getSalas().size()));
                nombreSala= reader.nextLine();

            }while(nombreSala!=null && nombreSala.trim().isEmpty() || containsIgnoreCase(nombreSala,nombresSala));
        
            nombresSala.add(nombreSala); 
            do {
                System.out.println("Valor minimo: 1000, Valor Maximo: 32767");
                System.out.println("Ingrese valor de entrada de sala "+nombreSala);
                valorEntrada= Integer.parseInt(reader.nextLine());
            }while(valorEntrada<1000 || valorEntrada >32767);
            
            do{
                System.out.println("Minimo de Filas: 3, Maximo de filas: 15");
                System.out.println("Ingrese numero de filas de la sala "+nombreSala);
                numeroFilas= Integer.parseInt(reader.nextLine());
            } while(numeroFilas<3 || numeroFilas>15);
            
            do{
                System.out.println("Advertencia: Debido a especificaciones del diseno del programa,");
                System.out.println("la cantidad de asientos no puede superar 127 (valor maximo de byte),");
                System.out.println("por lo que dado el numero actual de filas, SE RECOMIENDA como");
                System.out.print("valor maximo de columnas : ");
                if (127/numeroFilas>12){
                    System.out.print("12");
                }else{
                    System.out.print((int)(127/numeroFilas));
                }
                System.out.println("\nValor minimo de columnas: 5, Valor maximo de columnas: 12");
                System.out.println("\nIngrese numero de columnas de la sala "+nombreSala);
                numeroColumnas=Integer.parseInt(reader.nextLine());
            }while (numeroColumnas<5 || numeroColumnas>12);
            
            sala = new Sala(nombreSala,(byte) numeroFilas,(byte) numeroColumnas,(short) valorEntrada);
            cine.agregarSala(sala);
   
        }
        
         
    }
        
    /**
     * Controla y valida el ingreso de filas a mostrar ingresado por el usuario
     * @param sala Sala en la que se quiere mostrar un rango de filas
     * @return String con la ocupacion del cine segun el rango ingresado
     */
    
    
    
    public static String salaRangoFilas(Sala sala){
         
        Scanner reader = new Scanner(System.in);
        int filaInicial;
        char inicial;
        String answer = new String();
        int filaFinal;
        char fin;
        int limiteFinal= sala.getTotalFilas()-1;
        do{
            do {
                
                System.out.println("Sala "+sala.getNombre()+" contiene "+sala.getTotalFilas()+" filas");
                System.out.println("Desde A hasta "+numAChar((int)sala.getTotalFilas()));
                System.out.println("Ingrese desde que fila mostrar:");
                answer= reader.nextLine();
            } while (answer.length()!=1 || !Character.isLetter(answer.charAt(0)) );
            inicial = Character.toLowerCase(answer.charAt(0));
            
            filaInicial= (int) (inicial -'a');

        } while(filaInicial>limiteFinal);
        
        do{
            do {
                System.out.println("Sala "+sala.getNombre()+" contiene "+sala.getTotalFilas()+" filas");
                System.out.println("Fila inicial: "+Character.toUpperCase(inicial));
                System.out.println("Es posible mostrar hasta la fila: "+numAChar((int)sala.getTotalFilas()));
                System.out.println("Ingrese hasta que fila mostrar:");
                answer= reader.nextLine();
            } while (answer.length()!=1 || !Character.isLetter(answer.charAt(0)) );
            fin = Character.toLowerCase(answer.charAt(0));
            filaFinal= (int) (fin -'a');
            
        } while(filaFinal>limiteFinal || filaFinal<filaInicial);
        

        return sala.mostrarOcupacion(filaInicial, filaFinal);
         
     }   
        
        
       /**
        * Convierte un numero a su caracter correspondiente , siendo A = 0
        * @param i Numero a transformar a un caracter
        * @return Caracter al cual fue convertido el numero, null en caso de que el int ingresado este fuera del rango
        */ 
     public static String numAChar(int i) {
        return (i > 0 && i < 27) ? String.valueOf((char)(i + 'A' - 1)) : null;
}
        
     
     /**
      * Analiza una lista y verifica si un string pertenece o no a la lista, ignorando las mayusculas y minusculas
      * @param s String a buscar en el ArrayList de String
      * @param l ArrayList de String que se quiere analizar
      * @return Retorna true en caso de que el string se encuentre en el ArrayList, caso contrario false
      */
     
    public static boolean containsIgnoreCase(String s, ArrayList<String> l){
     for (String string : l){
        if (string.equalsIgnoreCase(s)){
            return true;
         }
     }
    return false;
  }  
        
    
    /**
     * Comprueba si la sala tiene todos los asientos vendidos o no
     * @param s Sala a validar
     * @return True en caso de que la sala tiene todos sus asientos vendidos, false en caso contrario
     */
    public static boolean estaLlena(Sala s){
        
        return (s.obtenerAsientosOcupados().size()>=s.getTotalColumnas()*s.getTotalFilas());
        
        
    }
   
    
}