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
public class Sala {
    
    private byte totalFilas;
    private byte totalColumnas;
    private Asiento[][] asientos;
    private short valorEntrada;
    private String nombre;
    private static ArrayList<Character> nombreFilas;    
    
    public Sala(String nombre, byte totalFilas, byte totalColumnas, short valorEntrada){
        this.nombre = nombre;
        this.totalFilas= totalFilas;
        this.totalColumnas = totalColumnas;
        this.valorEntrada = valorEntrada;
        this.nombreFilas = new ArrayList();
        this.asientos = new Asiento[totalFilas][totalColumnas];
        
        
        for(int i = 0; i < this.totalFilas ; i++){
            for (int j = 0; j < this.totalColumnas;j++){
                Asiento asiento= new Asiento((char)('a'+i), ((byte) (j+1)));
                asientos[i][j] = asiento;
                
              //asientos[i][j]= new Asiento((char)('a'+i),(byte) (j+1); 
            }
        } 
    }
    
    public short getValorEntrada() {
        return valorEntrada;
    }
    
    public void setValorEntrada(short valorEntrada) {
        if (valorEntrada>=1000){
            this.valorEntrada = valorEntrada;
        }
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public byte getTotalFilas() {
        return totalFilas;
    }

    public void setTotalFilas(byte totalFilas) {
        if (totalFilas>=3 && totalFilas<=15){
            this.totalFilas = totalFilas;
        }
    }

    public byte getTotalColumnas() {
        return totalColumnas;
    }

    public void setTotalColumnas(byte totalColumnas) {
        if (totalColumnas>=5 && totalColumnas<=12){
            this.totalColumnas = totalColumnas;
        }
    }
    //D
    public String mostrarOcupacion(int filaInicial, int filaFinal){
        String matriz;
        matriz = new String();
        for (int i=filaInicial; i <= filaFinal;i++){
            for(int j=0; j < this.totalColumnas;j++){
                if(this.asientos[i][j].isLibre()){
                    matriz = matriz.concat("["+this.asientos[i][j].mostrarDatos()+"]  ");
                } else {
                    matriz = matriz.concat("["+"X "+"]  ");
                }
            }
            matriz = matriz.concat("\n");
        }
        return matriz;
        
    }
    
    public String mostrarOcupacion(){
        String matriz;
        matriz = new String();
        
        for (int i=0; i < this.totalFilas;i++){
            
            for(int j=0; j < this.totalColumnas;j++){
                if(this.estaDisponible(asientos[i][j])){
                    matriz = matriz.concat("["+this.asientos[i][j].mostrarDatos()+"] ");
                } else {
                    matriz = matriz.concat("["+"X "+"] ");
                }
            }
            matriz = matriz.concat("\n");
        }
        matriz = matriz.concat("Asientos Ocupados: "+this.obtenerAsientosOcupados().size());
        return matriz;
    }
    
    public byte totalAsientosLibres(){
        byte libres=0;
         for (int i=0; i < this.totalFilas;i++){
            for(int j=0; j < this.totalColumnas;j++){
                if(this.asientos[i][j].isLibre()){
                    libres++;
                }
            }
        }
        return libres; 
    }
    
    public ArrayList<Asiento> obtenerAsientosOcupados(){
        ArrayList<Asiento> ocupados = new ArrayList();
        
        for(int i=0; i < this.totalFilas;i++){
            for(int j=0;j < this.totalColumnas;j++){
                if(!this.estaDisponible(asientos[i][j])){
                    ocupados.add(asientos[i][j]);
                }
            }
        }
        return ocupados;
    }
    
    public String mostrarDatos(){
        String datos = new String();
        
        datos= datos.concat("Sala: "+this.getNombre()+"\nValor Entrada: ["+this.getValorEntrada()+"]");
        return datos;
    }
    public boolean estaDisponible(Asiento a){
       int i = (int) (a.getFila()-'a');
       int j = (int) (a.getColumna()-1);
       return (asientos[i][j].isLibre());
        
    }
    public boolean ocuparAsiento(Asiento a){//Fix later
        
       int i = (int) (a.getFila()-'a');
       int j = (int) (a.getColumna()-1);
       
       if (estaDisponible(asientos[i][j])){
            asientos[i][j].setLibre(false); 
            return true; 
       } 
       return false;
       
    }
    

    

    
    
    
    
}
